package com.thingtrust.trend.entity;

import lombok.*;

import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BalanceEmtity {
    private BigDecimal balance;

    private BigDecimal depositsBaking;

    private BigDecimal depositsEndorsement;

    private BigDecimal rewardsBaking;

    private BigDecimal rewardsEndorsement;

    private BigDecimal evaluatedBalance;

    private BigDecimal evaluatedBalancedols;


}
