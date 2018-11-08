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
 * @date 2018-10-12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Question {
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
     * 排序
     */
	 private Integer sort; 
		/**
     * 状态
     */
	 private Integer status; 
		/**
     * 图片地址
     */
	 private String imageurl; 
		/**
     * 
     */
	 private Date createTime; 
		/**
     * 
     */
	 private Date updateTime; 
	}