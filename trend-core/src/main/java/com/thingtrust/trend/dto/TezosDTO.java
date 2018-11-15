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
public class TezosDTO {
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
     * 代理额度
     */
    private BigDecimal delegatedBalance;
    /**
     * 奖励
     */
    private BigDecimal reward;
    /**
     * 收入
     */
    private BigDecimal revenue;
    /**
     * 扣除费用
     */
    private Integer fee;

    /**
     * 状态
     */
    private String status;
    /**
     * 付款时间
     */
    private String payTime;
}