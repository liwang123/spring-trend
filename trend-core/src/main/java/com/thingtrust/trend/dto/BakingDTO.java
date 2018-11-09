package com.thingtrust.trend.dto;

import lombok.*;

import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BakingDTO {
    private int nblocks;

    private int cycle;

    private BigDecimal priority;

}
