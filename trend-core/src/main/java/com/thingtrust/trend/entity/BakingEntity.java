package com.thingtrust.trend.entity;

import lombok.*;

import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BakingEntity {
    private Integer cycle;

    private Integer blocks;

    private BigDecimal priority;

    private String missSteal;

    private BigDecimal rewards;

    private BigDecimal deposits;

    private Integer bakeTime;

    private int status;
}
