package com.thingtrust.trend.domain;

import lombok.*;

import java.util.Date;

/**
 * 
 * @author wangli
 * @date 2018-10-09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
		/**
     * 
     */
	 private Integer id; 
		/**
     * 
     */
	 private String username; 
		/**
     * 
     */
	 private String password; 
		/**
     * 
     */
	 private Date creatTime; 
		/**
     * 
     */
	 private Date updateTime; 
	}