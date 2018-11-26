package com.thingtrust.trend.entity;

import lombok.*;

import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EndorsementCycleEntity {
    private Integer cycle;

    private String slots;

    private int status;

    private int rewards;

    private BigDecimal deposits;

    private BigDecimal priority;


    private int level;

    private int size;
}
