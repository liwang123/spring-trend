package com.thingtrust.trend.domain;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author wangli
 * @date 2018-11-14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Tezos {
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
     * 扣除款
     */
    private BigDecimal payIn;
    /**
     * 应付款
     */
    private BigDecimal payOut;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 付款时间
     */
    private LocalDateTime payTime;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     *
     */
    private LocalDateTime updatetime;
}