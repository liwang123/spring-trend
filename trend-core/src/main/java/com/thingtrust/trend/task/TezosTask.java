package com.thingtrust.trend.task;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thingtrust.trend.data.MailRepository;
import com.thingtrust.trend.data.TezosRepository;
import com.thingtrust.trend.domain.Tezos;
import com.thingtrust.trend.domain.example.TezosExample;
import com.thingtrust.trend.enume.TezostatesEnum;
import com.thingtrust.trend.util.OkHttpUtils;
import com.thingtrust.trend.util.TezosUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class TezosTask {

    @Autowired
    private TezosRepository tezosRepository;

    @Autowired
    private MailRepository mailRepository;


    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    private final Logger logger = LoggerFactory.getLogger(getClass());


    //    @Scheduled(cron = "0 0 0/5 * * ? ")
    @Scheduled(cron = "0 0/10 * * * ? ")
//    @Scheduled(cron = "0/59 * * * * ? ")
    public void insertTezos() {
        final String url = "tz1LmaFsWRkjr7QMCx5PtV6xTUz3AmEpKQiF";
        final int p = 0;
        final int number = 10000;
        final String apiUrl = TezosUtil.getUrl();
        final String endorHistoryUrl = apiUrl + "/v2/rewards_split_cycles/" + url + "?p=" + p + "&number=" + number;
        final String bakingHistory = OkHttpUtils.get(endorHistoryUrl, null);
        final JSONArray completeArray = (JSONArray) JSONArray.parse(bakingHistory);

        for (int i = 0; i < completeArray.size(); i++) {
            final JSONObject parseObject = completeArray.getJSONObject(i);
            final Integer cycleCount = parseObject.getInteger("cycle");
            final Integer delegators_nb = parseObject.getInteger("delegators_nb");

            if (delegators_nb != 0) {
                final String rewardsUrl = apiUrl + "/v2/rewards_split_fast/" + url + "?p=" + p + "&number=" + number + "&cycle=" + cycleCount;
                final String rewardsResult = OkHttpUtils.get(rewardsUrl, null);
                final JSONArray rewarsArray = (JSONArray) JSONArray.parse(rewardsResult);
                for (int j = 0; j < rewarsArray.size(); j++) {
                    final JSONArray jsonArray = rewarsArray.getJSONArray(j);
                    final JSONObject tz = (JSONObject) jsonArray.get(0);
                    final String address = tz.get("tz").toString();
                    final BigDecimal amount = new BigDecimal(jsonArray.get(1).toString());

                    final JSONObject statusObject = parseObject.getJSONObject("status");
                    final String status = statusObject.get("status").toString();

                    final BigDecimal delegate_staking_balance = parseObject.getBigDecimal("delegate_staking_balance");
                    final BigDecimal blocks_rewards = parseObject.getBigDecimal("blocks_rewards");
                    final BigDecimal endorsements_rewards = parseObject.getBigDecimal("endorsements_rewards");
                    final BigDecimal future_baking_rewards = parseObject.getBigDecimal("future_baking_rewards");
                    final BigDecimal future_endorsing_rewards = parseObject.getBigDecimal("future_endorsing_rewards");
                    final BigDecimal revelation_rewards = parseObject.getBigDecimal("revelation_rewards");

                    final BigDecimal add = blocks_rewards.add(endorsements_rewards).add(future_baking_rewards).add(future_endorsing_rewards);
                    final BigDecimal bigDecimal = amount.divide(delegate_staking_balance, 4, BigDecimal.ROUND_DOWN).setScale(4, BigDecimal.ROUND_UP);
                    final BigDecimal reward = add.multiply(bigDecimal).divide(new BigDecimal(1000000), 2, BigDecimal.ROUND_UP);
                    final BigDecimal revenue = reward.multiply(new BigDecimal(0.85));

                    final TezosExample tezosExample = new TezosExample();
                    tezosExample.createCriteria()
                            .andCycleEqualTo(cycleCount)
                            .andDelegatorAddressEqualTo(address);
                    final Tezos tezosOne = tezosRepository.selectOneByExample(tezosExample);
                    if (tezosOne == null) {
                        final Tezos tezos = Tezos.builder()
                                .cycle(cycleCount)
                                .delegatedBalance(amount.divide(new BigDecimal(1000000)))
                                .delegatorAddress(address)
                                .fee(15)
                                .status(TezosUtil.getStatus(status))
                                .reward(reward)
                                .revenue(revenue)
                                .build();
                        tezosRepository.insert(tezos);
                    } else {
                        if (tezosOne.getStatus() != TezostatesEnum.PAIED.getCode() && tezosOne.getStatus() != TezostatesEnum.PAYING.getCode() && tezosOne.getStatus() != TezostatesEnum.FAILURE.getCode() && tezosOne.getStatus() != TezostatesEnum.FROZEN.getCode()) {
                            tezosOne.setStatus(TezosUtil.getStatus(status));
                            tezosRepository.updateById(tezosOne);
                        }
                    }
                }

            }
        }
    }


    @Scheduled(cron = "0 0/3 * * * ? ")
    public void tezosPay() {
        final int p = 0;
        final int number = 10000;
        final String apiUrl = TezosUtil.getUrl();
        final String addressUrl = "KT1QzXaoMkhqHtUP1gB5hnUsjmFyByWQTmog";
        final TezosExample tezosExample = new TezosExample();
        final Integer[] array = {1, 2, 4, 5};
        final List<Integer> integerList = Arrays.asList(array);
        tezosExample.createCriteria()
                .andStatusNotIn(integerList);
        final List<Tezos> tezosList = tezosRepository.selectByExample(tezosExample);
        tezosList.stream()
                .forEach(tezos -> {
                    tezos.setStatus(TezostatesEnum.PAYING.getCode());
                    tezosRepository.updateById(tezos);
                });
        final Map<String, BigDecimal> stringBigDecimalMap = tezosList.stream()
                .collect(Collectors
                        .toMap(Tezos::getDelegatorAddress, Tezos::getRevenue, (amountA, amountB) -> amountA.add(amountB)));
        stringBigDecimalMap
                .forEach((address, amount) -> {
                    final String url = apiUrl + "/v1/operations/" + address + "?p=" + p + "&number=" + number + "&type=Transaction";
                    final String result = OkHttpUtils.get(url, null);
                    final JSONArray completeArray = (JSONArray) JSONArray.parse(result);
                    logger.info("completeArray SIZE" + completeArray.size());
                    boolean flag = false;
                    for (int i = completeArray.size() - 1; i >= 0; i--) {
                        final JSONObject parseObject = completeArray.getJSONObject(i);
                        logger.info("parseObject------" + parseObject);
                        final JSONObject type = parseObject.getJSONObject("type");
                        final JSONArray operations = type.getJSONArray("operations");

                        for (int j = 0; j < operations.size(); j++) {
                            final JSONObject jsonObject = operations.getJSONObject(j);
                            final JSONObject src = jsonObject.getJSONObject("src");
                            final String tz = src.getString("tz");
                            logger.info("tz------" + tz);
                            if (addressUrl.equals(tz)) {
                                final Timestamp timestamp = jsonObject.getTimestamp("timestamp");
                                final LocalDateTime localDateTime = timestamp.toLocalDateTime();
                                final LocalDateTime now = LocalDateTime.now();
                                logger.info("Timestamp------" + localDateTime);
                                if (localDateTime.plusHours(1).isAfter(now)) {
                                    final BigDecimal amount1 = jsonObject.getBigDecimal("amount");
                                    final BigDecimal divide = amount1.divide(new BigDecimal(1000000));
                                    logger.info(divide + "-------" + amount);
                                    if (divide.compareTo(amount) != -1) {
                                        flag = true;
                                        final TezosExample tezosExample1 = new TezosExample();
                                        tezosExample1.createCriteria()
                                                .andStatusEqualTo(TezostatesEnum.PAYING.getCode())
                                                .andDelegatorAddressEqualTo(address);
                                        final List<Tezos> list = tezosRepository.selectByExample(tezosExample1);
                                        list.stream()
                                                .forEach(tezos -> {
                                                    tezos.setStatus(TezostatesEnum.PAIED.getCode());
                                                    tezos.setPayTime(localDateTime);
                                                    tezosRepository.updateById(tezos);
                                                });
                                    }
                                }

                            }
                        }
                    }
                    if (!flag) {
                        final TezosExample tezosExample1 = new TezosExample();
                        tezosExample1.createCriteria()
                                .andStatusEqualTo(TezostatesEnum.PAYING.getCode())
                                .andDelegatorAddressEqualTo(address);
                        final List<Tezos> list = tezosRepository.selectByExample(tezosExample1);
                        list.stream()
                                .forEach(tezos -> {
                                    tezos.setStatus(TezostatesEnum.FAILURE.getCode());
                                    tezosRepository.updateById(tezos);
                                });
                    }
                });
    }

//    //    @Scheduled(cron = "0 0/10 * * * ? ")
//    public void insertSendMail() {
//        final String apiUrl = TezosUtil.getUrl();
//        final Mail mail = mailRepository.selectOneByExample(null);
//        final Integer cycle = mail.getCycle();
//        for (int j = cycle + 1; j < cycle + 5; j++) {
//            final String URL = apiUrl + "/v1/number_bakings/tz1LmaFsWRkjr7QMCx5PtV6xTUz3AmEpKQiF?cycle=" + j;
//            final String numberHistory = OkHttpUtils.get(URL, null);
//            final JSONArray parse = (JSONArray) JSONArray.parse(numberHistory);
//            final int totalCount = (int) parse.get(0);
//            if (totalCount != 0) {
//                final String endorHistoryUrl = apiUrl + "/v1/bakings/tz1LmaFsWRkjr7QMCx5PtV6xTUz3AmEpKQiF?cycle=" + j + "&p=" + 0 + "&number=" + totalCount;
//                final String bakingHistory = OkHttpUtils.get(endorHistoryUrl, null);
//                final JSONArray completeArray = (JSONArray) JSONArray.parse(bakingHistory);
//                for (int i = 0; i < completeArray.size(); i++) {
//                    final JSONObject parseObject = completeArray.getJSONObject(i);
//                    final Boolean baked = parseObject.getBoolean("baked");
//                    final Integer level = parseObject.getInteger("level");
//                    if (!baked) {
//                        final Mail mail1 = Mail.builder()
//                                .cycle(j)
//                                .level(level)
//                                .build();
//                        mailRepository.insert(mail1);
//                    }
//                }
//            } else {
//                return;
//            }
//        }
//    }
//
//    //    @Scheduled(cron = "0 0/10 * * * ? ")
//    public void sendMail() {
//        final MailExample mailExample = new MailExample();
//        mailExample
//                .createCriteria()
//                .andSendStatusEqualTo(1);
//        final List<Mail> mailList = mailRepository.selectByExample(mailExample);
//        final SimpleMailMessage message = new SimpleMailMessage();
//        mailList.stream()
//                .forEach(mail -> {
//                    logger.info("SEND--------" + from);
//                    final String content = "tezos烘焙出现错误块,轮次:" + mail.getCycle() + ",level:" + mail.getLevel();
//                    message.setFrom(from);
//                    message.setTo("yunchun_liu@163.com");
//                    message.setSubject("主题：tezos邮件");
//                    message.setText(content);
//                    mailSender.send(message);
//                    mail.setSendStatus(2);
//                    mailRepository.updateById(mail);
//                });
//    }


}
