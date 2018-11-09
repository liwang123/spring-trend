package com.thingtrust.trend.entity;

import lombok.*;

import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CycleEntity {
    private Integer level;

    private BigDecimal priority;

    private BigDecimal rewards;

    private BigDecimal deposits;

    private Integer bakeTime;

    private Integer cycle;

    private int status;
}
