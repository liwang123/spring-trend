package com.thingtrust.trend.entity;

import lombok.*;

import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EndorsementRihtsEntity {
    private Integer cycle;

    private int slots;

    private String eta;

    private BigDecimal rewards;

    private BigDecimal deposits;
    
    private int level;
}
