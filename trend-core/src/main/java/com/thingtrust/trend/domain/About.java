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
public class About {
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
     *
     */
    private Date updateTime;
    /**
     * 1:首页2:二级页
     */
    private Integer status;
    /**
     *
     */
    private Date createTime;
}