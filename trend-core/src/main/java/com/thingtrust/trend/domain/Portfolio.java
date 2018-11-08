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
public class Portfolio {
		/**
     * 
     */
	 private Integer id; 
		/**
     * 描述
     */
	 private String description; 
		/**
     * 链接
     */
	 private String linkurl; 
		/**
     * 排序
     */
	 private Integer sort; 
		/**
     * logo地址
     */
	 private String logourl; 
		/**
     * 1:mainnet2:publictestnet3:privtenet4:testnet
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