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
 * @date 2018-12-03
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Mail {
		/**
     * 
     */
	 private Integer id; 
		/**
     * 轮次
     */
	 private Integer cycle; 
		/**
     * 级别
     */
	 private Integer level; 
		/**
     * 
     */
	 private Integer status; 
		/**
     * 1:未发送2:已发送
     */
	 private Integer sendStatus; 
		/**
     * 
     */
	 private Date createTime; 
		/**
     * 
     */
	 private Date updateTime; 
	}