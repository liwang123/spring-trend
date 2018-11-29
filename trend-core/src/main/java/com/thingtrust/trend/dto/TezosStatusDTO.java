package com.thingtrust.trend.dto;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author wangli
 * @date 2018-11-14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TezosStatusDTO {
    /**
     *
     */
    private Integer id;
    /**
     * 轮次
     */
    private Integer cycle;
    /**
     * 代理地址
     */
    private String delegatorAddress;

    /**
     * 收入
     */
    private BigDecimal revenue;

    private String status;
    /**
     * 付款时间
     */
    private String payTime;
}