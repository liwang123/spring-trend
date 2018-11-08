package com.thingtrust.trend.domain;

import lombok.*;

import java.util.Date;

/**
 * @author wangli
 * @date 2018-10-11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Banner {
    /**
     *
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String description;
    /**
     * 委托地址
     */
    private String delegateAddress;
    /**
     *
     */
    private String stakBond;
    /**
     * 余额
     */
    private String delegateBalance;
    /**
     * 产能
     */
    private String capacity;
    /**
     * 电脑图片
     */
    private String computerImage;
    /**
     * 手机图片
     */
    private String phoneImage;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 1:首页2:二级页
     */
    private Integer status;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private Date updateTime;
}