package com.thingtrust.trend.task;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thingtrust.trend.data.TezosRepository;
import com.thingtrust.trend.domain.Tezos;
import com.thingtrust.trend.domain.example.TezosExample;
import com.thingtrust.trend.util.OkHttpUtils;
import com.thingtrust.trend.util.TezosUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TezosTask {

    @Autowired
    private TezosRepository tezosRepository;

    @Scheduled(cron = "0 0/59 * * * ? ")
    public void insertTezos() {
        final String url = "tz1LmaFsWRkjr7QMCx5PtV6xTUz3AmEpKQiF";
        final int p = 0;
        final int number = 1000;
        final String apiUrl = TezosUtil.getUrl();

        final String endorHistoryUrl = apiUrl + "/v2/rewards_split_cycles/" + url + "?p=" + p + "&number=" + 1000;
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
                    final BigDecimal bigDecimal = amount.divide(delegate_staking_balance, 4, BigDecimal.ROUND_DOWN).setScale(4, BigDecimal.ROUND_DOWN);
                    final BigDecimal reward = add.multiply(bigDecimal).divide(new BigDecimal(1000000), 2, BigDecimal.ROUND_DOWN);
                    final BigDecimal revenue = reward.multiply(new BigDecimal(0.85));
                    System.out.println(address + "-------" + reward);
                    final TezosExample tezosExample = new TezosExample();
                    tezosExample.createCriteria()
                            .andCycleEqualTo(cycleCount)
                            .andDelegatorAddressEqualTo(address);
                    final Tezos tezosOne = tezosRepository.selectOneByExample(tezosExample);
                    final Tezos tezos = Tezos.builder()
                            .cycle(cycleCount)
                            .delegatedBalance(amount.divide(new BigDecimal(1000000)))
                            .delegatorAddress(address)
                            .fee(15)
                            .status(TezosUtil.getStatus(status))
                            .reward(reward)
                            .revenue(revenue)
                            .build();
                    if (tezosOne == null) {
                        tezosRepository.insert(tezos);
                    } else {
                        if (tezosOne.getStatus() != 5) {
                            tezosOne.setStatus(TezosUtil.getStatus(status));
                            tezosRepository.updateById(tezosOne);
                        }
                    }

                }


            }
        }
    }
}
