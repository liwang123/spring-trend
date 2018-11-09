package com.thingtrust.trend.entity;

import lombok.*;

import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BakingRightsEntity {
    private Integer level;

    private BigDecimal priority;

    private BigDecimal rewards;

    private BigDecimal deposits;

    private String eta;

    private Integer cycle;
}
