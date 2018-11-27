package com.thingtrust.trend.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.thingtrust.trend.common.mybatis.pager.PageInfo;
import com.thingtrust.trend.data.TezosRepository;
import com.thingtrust.trend.domain.Tezos;
import com.thingtrust.trend.domain.example.TezosExample;
import com.thingtrust.trend.dto.BakingDTO;
import com.thingtrust.trend.dto.TezosDTO;
import com.thingtrust.trend.entity.*;
import com.thingtrust.trend.util.IOUtils;
import com.thingtrust.trend.util.OkHttpUtils;
import com.thingtrust.trend.util.TezosUtil;
import com.thingtrust.trend.util.ssh.ScpClient;
import com.thingtrust.trend.util.ssh.SshUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TezosService {

    @Value("${thingtrust.host}")
    private String hostUrl;

    @Value("${thingtrust.account}")
    private String account;

    @Value("${thingtrust.password}")
    private String password;

    @Value("${thingtrust.command}")
    private String command;

    @Value("${thingtrust.isSudo}")
    private boolean isSudo;

    @Value("${thingtrust.port}")
    private int port;

    @Value("${thingtrust.path}")
    private String path;

    @Value("${thingtrust.remotePath}")
    private String remotePath;

    @Autowired
    private TezosRepository tezosRepository;

    public BalanceEmtity queryBalance(final String nodeUrl) {
        final String apiUrl = TezosUtil.getUrl();
        final String url = apiUrl + "/v1/bonds_rewards/";

        final String balanceUrl = apiUrl + "/v1/node_account/";

        final String marketCupUrl = apiUrl + "/v1/marketcap";

        final String marketCup = OkHttpUtils.get(marketCupUrl, null);
        final JSONArray market = (JSONArray) JSONArray.parse(marketCup);
        final JSONObject parseMatket = (JSONObject) JSONObject.parse(market.get(0).toString());
        final String s = OkHttpUtils.get(url + nodeUrl, null);
        final JSONObject parse = (JSONObject) JSONObject.parse(s);
        final BigDecimal block_rewards = new BigDecimal(parse.get("block_rewards").toString());
        final BigDecimal endorsements_rewards = new BigDecimal(parse.get("endorsements_rewards").toString());
        final BigDecimal block_deposits = new BigDecimal(parse.get("block_deposits").toString());
        final BigDecimal endorsement_deposits = new BigDecimal(parse.get("endorsement_deposits").toString());
        final BigDecimal block_acc_fees = new BigDecimal(parse.get("block_acc_fees").toString());

        final String balance = OkHttpUtils.get(balanceUrl + nodeUrl, null);
        final JSONObject parseBalance = (JSONObject) JSONObject.parse(balance);
        final BigDecimal balance1 = new BigDecimal((String) parseBalance.get("balance"));
        final BigDecimal add = block_rewards.add(endorsements_rewards).add(block_deposits).add(endorsement_deposits).add(block_acc_fees).add(balance1);

        return BalanceEmtity.builder()
                .balance(balance1.divide(new BigDecimal(1000000)))
                .depositsBaking(block_deposits.divide(new BigDecimal(1000000000)))
                .depositsEndorsement(endorsement_deposits.divide(new BigDecimal(1000000000)))
                .rewardsBaking(block_rewards.divide(new BigDecimal(1000000000)))
                .rewardsEndorsement(endorsements_rewards.divide(new BigDecimal(1000000000)))
                .evaluatedBalance(add.divide(new BigDecimal(1000000)))
                .evaluatedBalancedols(add.divide(new BigDecimal(1000000)).multiply(new BigDecimal(parseMatket.get("price_usd").toString())))
                .build();
    }


    public PageInfo bakingHistory(final int page, final int number, final String url) {
        final PageInfo pageInfo = new PageInfo(page, number);
        final List<BakingEntity> arrayList = Lists.newArrayList();
        final String apiUrl = TezosUtil.getUrl();
        final String numberHistoryUrl = apiUrl + "/v1/number_bakings_history/" + url;
        final String numberHistory = OkHttpUtils.get(numberHistoryUrl, null);
        final JSONArray parse = (JSONArray) JSONArray.parse(numberHistory);
        final int totalCount = (int) parse.get(0);

        final int p = page - 1;
        final String bakingHistoryUrl = apiUrl + "/v1/bakings_history/" + url + "?p=" + p + "&number=" + number;
        final String bakingHistory = OkHttpUtils.get(bakingHistoryUrl, null);
        final JSONArray history = (JSONArray) JSONArray.parse(bakingHistory);

        //get(0)
        final String jsonString = JSON.toJSONString(history.get(0));
        final JSONArray jsonArray = JSON.parseArray(jsonString);
        final JSONObject totalRows = (JSONObject) jsonArray.get(0);
        //get(1)
        final String future = JSON.toJSONString(history.get(1));
        if (future.length() == 0) {
        }
        final JSONArray futureArray = JSON.parseArray(future);
        final List<BakingDTO> bakingDTOS = JSONObject.parseArray(futureArray.toJSONString(), BakingDTO.class);
        bakingDTOS.stream()
                .forEach(bakingDTO -> {
                    final BakingEntity bakingEntity = BakingEntity.builder()
                            .bakeTime(null)
                            .blocks(bakingDTO.getNblocks())
                            .cycle(bakingDTO.getCycle())
                            .deposits(null)
                            .priority(bakingDTO.getPriority().setScale(2, BigDecimal.ROUND_HALF_UP))
                            .missSteal(null)
                            .rewards(new BigDecimal(bakingDTO.getNblocks() * 16))
                            .status(0)
                            .build();
                    arrayList.add(bakingEntity);
                });
        //get(2)
        final String complete = JSON.toJSONString(history.get(2));
        final JSONArray completeArray = JSON.parseArray(complete);
        completeArray.add(totalRows);

        for (int i = 0; i < completeArray.size(); i++) {
            final JSONObject total = completeArray.getJSONObject(i);
            Integer bake_time = null;
            if (total.get("bake_time") != null) {
                bake_time = (Integer) total.get("bake_time");

            }
            BigDecimal priority = null;
            if (total.get("priority") != null) {
                priority = new BigDecimal(total.get("priority").toString());
            }


            final int cycle = (int) total.get("cycle");
            final JSONObject count = (JSONObject) total.get("count");
            final int count_steal = (int) count.get("count_steal");
            final int count_miss = (int) count.get("count_miss");
            final int count_all = (int) count.get("count_all");
            final JSONObject tez = (JSONObject) total.get("tez");
            final BigDecimal reward = new BigDecimal(tez.get("reward").toString());
            final BigDecimal fee = new BigDecimal(tez.get("fee").toString());
            final BigDecimal deposit = new BigDecimal(tez.get("deposit").toString());

            final BigDecimal rewards = reward.add(fee).divide(new BigDecimal(1000000));
            final BakingEntity build = BakingEntity.builder()
                    .bakeTime(bake_time)
                    .blocks(count_all)
                    .cycle(cycle)
                    .deposits(deposit.divide(new BigDecimal(1000000)))
                    .priority(priority == null ? priority : priority.setScale(2, BigDecimal.ROUND_HALF_UP))
                    .missSteal(count_miss + "/" + count_steal + "")
                    .rewards(rewards)
                    .status(i > 5 ? 2 : 1)
                    .build();
            if (p != 0) {
                build.setStatus(2);
            }
            arrayList.add(build);

        }
        pageInfo.setListObject(arrayList);
        pageInfo.setTotals(totalCount);
        return pageInfo;

    }


    public PageInfo endorsementHistory(final int page, final int number, final String url) {
        final PageInfo pageInfo = new PageInfo(page, number);
        final String apiUrl = TezosUtil.getUrl();
        final List<EndorsementEntity> arrayList = Lists.newArrayList();
        final String URL = apiUrl + "/v1/number_endorsements_history/" + url;
        final String numberHistory = OkHttpUtils.get(URL, null);
        final JSONArray parse = (JSONArray) JSONArray.parse(numberHistory);
        final int totalCount = (int) parse.get(0);
        final int p = page - 1;
        final String endorHistoryUrl = apiUrl + "/v1/endorsements_history/" + url + "?p=" + p + "&number=" + number;

        final String bakingHistory = OkHttpUtils.get(endorHistoryUrl, null);
        final JSONArray history = (JSONArray) JSONArray.parse(bakingHistory);

        //get(1)
        final String future = JSON.toJSONString(history.get(1));
        if (future.length() == 0) {
        }
        final JSONArray futureArray = JSON.parseArray(future);
        final List<BakingDTO> bakingDTOS = JSONObject.parseArray(futureArray.toJSONString(), BakingDTO.class);
        bakingDTOS.stream()
                .forEach(bakingDTO -> {
                    final EndorsementEntity endorsementEntity = EndorsementEntity.builder()
                            .miss(null)
                            .slots(bakingDTO.getPriority().intValue())
                            .deposits(null)
                            .cycle(bakingDTO.getCycle())
                            .priority(null)
                            .rewards(new BigDecimal(bakingDTO.getPriority().intValue() * 2))
                            .status(0)
                            .build();
                    arrayList.add(endorsementEntity);
                });


        //get(0)
        final String jsonString = JSON.toJSONString(history.get(0));
        final JSONArray jsonArray = JSON.parseArray(jsonString);
        final JSONObject totalRows = (JSONObject) jsonArray.get(0);

        //get(2)
        final String complete = JSON.toJSONString(history.get(2));
        final JSONArray completeArray = JSON.parseArray(complete);
        completeArray.add(totalRows);

        for (int i = 0; i < completeArray.size(); i++) {
            final JSONObject total = completeArray.getJSONObject(i);
            final BigDecimal priority = new BigDecimal(total.get("priority").toString());
            final int cycle = (int) total.get("cycle");
            final JSONObject slots = (JSONObject) total.get("slots");
            final int count_steal = (int) slots.get("count_steal");
            final int count_miss = (int) slots.get("count_miss");
            final int count_all = (int) slots.get("count_all");
            final JSONObject tez = (JSONObject) total.get("tez");
            final BigDecimal reward = new BigDecimal(tez.get("reward").toString());
            final BigDecimal fee = new BigDecimal(tez.get("fee").toString());
            final BigDecimal deposit = new BigDecimal(tez.get("deposit").toString());

            final BigDecimal rewards = reward.add(fee).divide(new BigDecimal(1000000));
            final EndorsementEntity endorsementEntity = EndorsementEntity.builder()
                    .cycle(cycle)
                    .deposits(deposit.divide(new BigDecimal(1000000)))
                    .priority(priority.setScale(2, BigDecimal.ROUND_HALF_UP))
                    .rewards(rewards)
                    .slots(count_all)
                    .status(i > 5 ? 2 : 1)
                    .miss(count_miss)
                    .build();
            if (p != 0) {
                endorsementEntity.setStatus(2);
            }
            arrayList.add(endorsementEntity);

        }
        pageInfo.setTotals(totalCount);
        pageInfo.setListObject(arrayList);
        return pageInfo;
    }

    public PageInfo queryBakingRights(final int page, final int number, final String url, final int cycle) {
        final PageInfo pageInfo = new PageInfo(page, number);
        final String apiUrl = TezosUtil.getUrl();
        final List<BakingRightsEntity> arrayList = Lists.newArrayList();
        final String URL = apiUrl + "/v1/number_baker_rights/" + url + "?cycle=" + cycle;
        final String numberHistory = OkHttpUtils.get(URL, null);
        final JSONArray parse = (JSONArray) JSONArray.parse(numberHistory);
        final int totalCount = (int) parse.get(0);
        final int p = page - 1;


        final String endorHistoryUrl = apiUrl + "/v1/baker_rights/" + url + "?cycle=" + cycle + "&p=" + p + "&number=" + number;

        final String bakingHistory = OkHttpUtils.get(endorHistoryUrl, null);
        final JSONArray completeArray = (JSONArray) JSONArray.parse(bakingHistory);
        for (int i = 0; i < completeArray.size(); i++) {
            final JSONObject total = completeArray.getJSONObject(i);

            final int depth = (int) total.get("depth");
            final int day = depth / 1440;
            final int hours = depth % 1440 / 60;
            final int minutes = depth % 1440 % 60;
            String times = day + "d " + hours + "h " + minutes + "m";
            if (day == 0) {
                times = hours + "h " + minutes + "m";
            }
            final BakingRightsEntity bakingRightsEntity = BakingRightsEntity.builder()
                    .cycle((int) total.get("cycle"))
                    .deposits(null)
                    .eta(times)
                    .level((int) total.get("level"))
                    .priority(new BigDecimal(total.get("priority").toString()))
                    .rewards(new BigDecimal(16))
                    .build();
            arrayList.add(bakingRightsEntity);

        }
        pageInfo.setListObject(arrayList);
        pageInfo.setTotals(totalCount);
        return pageInfo;
    }


    public PageInfo CycleDetails(final int page, final int number, final String url, final int cycle) {
        final PageInfo pageInfo = new PageInfo(page, number);
        final String apiUrl = TezosUtil.getUrl();
        final List<CycleEntity> arrayList = Lists.newArrayList();
        final String URL = apiUrl + "/v1/number_bakings/" + url + "?cycle=" + cycle;
        final String numberHistory = OkHttpUtils.get(URL, null);
        final JSONArray parse = (JSONArray) JSONArray.parse(numberHistory);
        final int totalCount = (int) parse.get(0);
        final int p = page - 1;

        final String endorHistoryUrl = apiUrl + "/v1/bakings/" + url + "?cycle=" + cycle + "&p=" + p + "&number=" + number;

        final String bakingHistory = OkHttpUtils.get(endorHistoryUrl, null);
        final JSONArray completeArray = (JSONArray) JSONArray.parse(bakingHistory);
        for (int i = 0; i < completeArray.size(); i++) {
            final JSONObject parseObject = completeArray.getJSONObject(i);
            final Boolean baked = parseObject.getBoolean("baked");
            final CycleEntity cycleEntity = CycleEntity.builder()
                    .bakeTime(baked == false ? null : parseObject.getInteger("bake_time"))
                    .cycle(parseObject.getInteger("cycle"))
                    .deposits(null)
                    .level(parseObject.getInteger("level"))
                    .priority(parseObject.getBigDecimal("priority"))
                    .status(baked == false ? 2 : 1)
                    .rewards(baked == false ? null : parseObject.getBigDecimal("fees").divide(new BigDecimal(1000000)).add(new BigDecimal(16)))
                    .build();
            if (parseObject.getInteger("distance_level") == -1) {
                cycleEntity.setStatus(3);
                cycleEntity.setBakeTime(null);
                cycleEntity.setDeposits(null);
                cycleEntity.setRewards(null);
            }
            arrayList.add(cycleEntity);


        }
        pageInfo.setListObject(arrayList);
        pageInfo.setTotals(totalCount);
        return pageInfo;
    }


    public PageInfo endorsementRights(final int page, final int number, final String url, final int cycle) {
        final PageInfo pageInfo = new PageInfo(page, number);
        final String apiUrl = TezosUtil.getUrl();
        final List<EndorsementRihtsEntity> arrayList = Lists.newArrayList();
        final String URL = apiUrl + "/v1/number_endorser_rights/" + url + "?cycle=" + cycle;
        final String numberHistory = OkHttpUtils.get(URL, null);
        final JSONArray parse = (JSONArray) JSONArray.parse(numberHistory);
        final int totalCount = (int) parse.get(0);
        final int p = page - 1;


        final String endorHistoryUrl = apiUrl + "/v1/endorser_rights/" + url + "?cycle=" + cycle + "&p=" + p + "&number=" + number;
        final String bakingHistory = OkHttpUtils.get(endorHistoryUrl, null);
        final JSONArray completeArray = (JSONArray) JSONArray.parse(bakingHistory);
        for (int i = 0; i < completeArray.size(); i++) {
            final JSONObject parseObject = completeArray.getJSONObject(i);
            final int depth = (int) parseObject.get("depth");
            final int day = depth / 1440;
            final int hours = depth % 1440 / 60;
            final int minutes = depth % 1440 % 60;
            String times = day + "d " + hours + "h " + minutes + "m";
            if (day == 0) {
                times = hours + "h " + minutes + "m";
            }
            final EndorsementRihtsEntity endorsementRihtsEntity = EndorsementRihtsEntity.builder()
                    .cycle(parseObject.getInteger("cycle"))
                    .deposits(null)
                    .eta(times)
                    .level(parseObject.getInteger("level"))
                    .rewards(new BigDecimal(2))
                    .slots(parseObject.getInteger("nslot"))
                    .build();

            arrayList.add(endorsementRihtsEntity);
        }
        pageInfo.setTotals(totalCount);
        pageInfo.setListObject(arrayList);
        return pageInfo;

    }


    public PageInfo EndorCycle(final int page, final int number, final String url, final int cycle) {
        final PageInfo pageInfo = new PageInfo(page, number);

        final String apiUrl = TezosUtil.getUrl();
        final List<EndorsementCycleEntity> arrayList = Lists.newArrayList();
        final String URL = apiUrl + "/v1/number_bakings_endorsement/" + url + "?cycle=" + cycle;
        final String numberHistory = OkHttpUtils.get(URL, null);
        final JSONArray parse = (JSONArray) JSONArray.parse(numberHistory);
        final int totalCount = (int) parse.get(0);
        final int p = page - 1;
        final String endorHistoryUrl = apiUrl + "/v1/bakings_endorsement/" + url + "?cycle=" + cycle + "&p=" + p + "&number=" + number;

        final String bakingHistory = OkHttpUtils.get(endorHistoryUrl, null);
        final JSONArray completeArray = (JSONArray) JSONArray.parse(bakingHistory);
        for (int i = 0; i < completeArray.size(); i++) {
            final JSONObject parseObject = completeArray.getJSONObject(i);
            final int size = parseObject.size();
            String replace = "";
            JSONArray slots = null;
            String lr_nslot = "";
            if (size != 2) {
                slots = parseObject.getJSONArray("slots");
                replace = slots.toString().replace("[", "").replace("]", "");
            } else {
                lr_nslot = parseObject.getInteger("lr_nslot") + "";
            }
            final EndorsementCycleEntity endorsementCycleEntity = EndorsementCycleEntity.builder()
                    .cycle(size == 2 ? cycle : parseObject.getInteger("cycle"))
                    .deposits(size == 2 ? new BigDecimal(0) : null)
                    .level(parseObject.getInteger("level"))
                    .status(size == 2 ? 2 : 1)
                    .slots(size == 2 ? lr_nslot : replace)
                    .priority(size == 2 ? null : parseObject.getBigDecimal("priority"))
                    .rewards(size == 2 ? 0 : 2 * slots.size())
                    .size(size == 2 ? 0 : slots.size())
                    .build();

            arrayList.add(endorsementCycleEntity);

        }
        pageInfo.setListObject(arrayList);
        pageInfo.setTotals(totalCount);
        return pageInfo;
    }

    public PageInfo listTezos(final int index, final int length, final String address, final Integer cycle, final Integer status) {
        final PageInfo pageInfo = new PageInfo(index, length, "cycle");
        final TezosExample tezosExample = new TezosExample();
        final TezosExample.Criteria criteria = tezosExample.createCriteria();
        if (StringUtils.isNotBlank(address)) {
            criteria.andDelegatorAddressEqualTo(address);
        }
        if (cycle != null) {
            criteria.andCycleEqualTo(cycle);
        }
        if (status != null) {
            criteria.andStatusEqualTo(status);
        }
        final List<Tezos> tezosList = tezosRepository.selectByPager(pageInfo, tezosExample);
        final ArrayList<TezosDTO> tezosDTOArrayList = Lists.newArrayList();
        tezosList.stream()
                .forEach(tezos -> {
                    final TezosDTO tezosDTO = TezosDTO.builder().build();
                    BeanUtils.copyProperties(tezos, tezosDTO);
                    tezosDTO.setStatus(TezosUtil.getStatus(tezos.getStatus()));
                    tezosDTO.setPayTime(tezos.getPayTime() == null ? null : tezos.getPayTime().toString().replaceAll("T", " "));
                    tezosDTOArrayList.add(tezosDTO);
                });
        final int countByExample = tezosRepository.countByExample(tezosExample);
        pageInfo.setTotals(countByExample);
        pageInfo.setListObject(tezosDTOArrayList);
        return pageInfo;

    }

    public void setFee(final int cycle, final int fee) {
        final TezosExample tezosExample = new TezosExample();
        tezosExample.createCriteria()
                .andCycleEqualTo(cycle)
                .andStatusNotEqualTo(4);
        final List<Tezos> tezosList = tezosRepository.selectByExample(tezosExample);
        final BigDecimal feeD = new BigDecimal(100 - fee).divide(new BigDecimal(100));
        tezosList.stream()
                .forEach(tezos -> {
                    final BigDecimal divide = tezos.getReward().multiply(feeD);
                    tezos.setFee(fee);
                    tezos.setRevenue(divide);
                    tezosRepository.updateById(tezos);
                });
    }

    //打币
    public void sendPayment(final Integer[] ids) {
        final List<Integer> integerList = Arrays.asList(ids);
        final TezosExample tezosExample = new TezosExample();
        tezosExample
                .createCriteria()
                .andIdIn(integerList);
        final List<Tezos> tezosList = tezosRepository.selectByExample(tezosExample);
        final Map<String, BigDecimal> stringBigDecimalMap = tezosList.stream()
                .collect(Collectors
                        .toMap(Tezos::getDelegatorAddress, Tezos::getRevenue, (amountA, amountB) -> amountA.add(amountB)));
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("#!/bin/bash\r\n");
        stringBigDecimalMap
                .forEach((address, amount) -> {
                    stringBuffer.append("tezos-client transfer " + amount + " from alice to " + address + " --fee 0.05;\r\n");
                });
        IOUtils.write(stringBuffer);

        final ScpClient instance = ScpClient.getInstance(hostUrl, port, account, password);
        final boolean putFile = instance.putFile(path, remotePath);
        log.info("传输文件" + putFile);
        if (putFile) {
            final String result = SshUtil.sudoExec(hostUrl, port, account, password, command, isSudo);
            log.info("打币结果" + result);
            tezosList.stream()
                    .forEach(tezos -> {
                        tezos.setStatus(3);
                        tezosRepository.updateById(tezos);
                    });
            log.info("SUCCESSFUL...............");
        }
    }
}
