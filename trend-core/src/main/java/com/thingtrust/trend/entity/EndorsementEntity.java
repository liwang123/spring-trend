package com.thingtrust.trend.entity;

import lombok.*;

import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EndorsementEntity {
    private Integer cycle;

    private int slots;

    private BigDecimal priority;


    private Integer miss;

    private BigDecimal rewards;

    private BigDecimal deposits;


    private int status;
}
