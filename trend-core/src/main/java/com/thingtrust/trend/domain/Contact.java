package com.thingtrust.trend.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author wangli
 * @date 2018-10-11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Contact {
		/**
     * 
     */
	 private Integer id; 
		/**
     * 标题
     */
	 private String title; 
		/**
     * 联系邮箱
     */
	 private String email; 
		/**
     * 图片地址
     */
	 private String logo; 
		/**
     * 链接地址
     */
	 private String linkUrl; 
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