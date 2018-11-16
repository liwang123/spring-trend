/*
 Navicat Premium Data Transfer

 Source Server         : 192
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : 10.10.10.192
 Source Database       : trend

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : utf-8

 Date: 11/16/2018 11:07:56 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `about`
-- ----------------------------
DROP TABLE IF EXISTS `about`;
CREATE TABLE `about` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `description` text COMMENT '描述',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` int(10) DEFAULT '1' COMMENT '1:首页2:二级页',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `about`
-- ----------------------------
BEGIN;
INSERT INTO `about` VALUES ('1', 'about', 'ssdd', '2018-10-12 14:26:52', '1', '2018-10-11 16:24:21');
COMMIT;

-- ----------------------------
--  Table structure for `banner`
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `description` text COMMENT '描述',
  `delegate_address` varchar(255) DEFAULT NULL COMMENT '委托地址',
  `stak_bond` varchar(255) DEFAULT NULL,
  `delegate_balance` varchar(255) DEFAULT NULL COMMENT '余额',
  `capacity` varchar(255) DEFAULT NULL COMMENT '产能',
  `computer_image` varchar(255) DEFAULT NULL COMMENT '电脑图片',
  `phone_image` varchar(255) DEFAULT NULL COMMENT '手机图片',
  `sort` int(10) DEFAULT '0' COMMENT '排序',
  `status` int(10) DEFAULT '1' COMMENT '1:首页2:二级页',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `banner`
-- ----------------------------
BEGIN;
INSERT INTO `banner` VALUES ('1', '测试', 'sdasdasdas是的dfdsfdsfdsfdsfdsfds', null, null, null, null, 'http://token-image-1253605028.file.myqcloud.com/1539239020113.jpeg', null, null, '1', '2018-10-11 15:17:21', '2018-10-11 16:22:07'), ('2', 'Delegate with Confidence Baking Never Sleeps', null, 'tz1LmaFsWRkjr7QMCx5PtV6xTUz3AmEpKQiF', '111111', '2222', '33333', 'http://token-image-1253605028.file.myqcloud.com/1539930524769.jpg', 'http://token-image-1253605028.file.myqcloud.com/1539930536561.jpg', null, '2', '2018-10-12 12:00:26', '2018-10-19 14:28:53');
COMMIT;

-- ----------------------------
--  Table structure for `contact`
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `email` varchar(255) DEFAULT NULL COMMENT '联系邮箱',
  `logo` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `link_url` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `sort` int(10) DEFAULT '0' COMMENT '排序',
  `status` int(10) DEFAULT '1' COMMENT '1:首页2:二级页',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `contact`
-- ----------------------------
BEGIN;
INSERT INTO `contact` VALUES ('1', 'sad', 'sadas', 'asdas', 'asdas', '2', '1', '2018-10-12 14:40:39', '2018-10-12 14:41:06'), ('2', 'ccc', 'ccc', 'sdsd', 'ccc', '1', '1', '2018-10-12 14:41:03', '2018-10-12 14:41:08');
COMMIT;

-- ----------------------------
--  Table structure for `portfolio`
-- ----------------------------
DROP TABLE IF EXISTS `portfolio`;
CREATE TABLE `portfolio` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `linkurl` varchar(255) DEFAULT NULL COMMENT '链接',
  `sort` int(10) DEFAULT '0' COMMENT '排序',
  `logourl` varchar(255) DEFAULT NULL COMMENT 'logo地址',
  `status` int(10) DEFAULT NULL COMMENT '1:mainnet2:publictestnet3:privtenet4:testnet',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `portfolio`
-- ----------------------------
BEGIN;
INSERT INTO `portfolio` VALUES ('1', 'Tezos s a new platform for smart contracts and decentralized applications, featuring on-chain governance, we are operating staking service for Tezos.', 'http://www.blockpower.capital/tezos/index.html', '1', 'http://token-image-1253605028.file.myqcloud.com/1539848748654.png', '1', '2018-10-12 15:39:30', '2018-10-18 15:45:54'), ('2', 'Cosmos is a cross-chain protocol featuring interoperability. We are currently participating in the Cosmos testnet and are about to launch our staking service once mainnet launch.', '', '2', 'http://token-image-1253605028.file.myqcloud.com/1539850989966.png', '2', '2018-10-18 16:23:21', '2018-10-18 16:23:21');
COMMIT;

-- ----------------------------
--  Table structure for `question`
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(500) DEFAULT NULL COMMENT '标题',
  `description` text COMMENT '描述',
  `sort` int(10) DEFAULT '0' COMMENT '排序',
  `status` int(10) DEFAULT '1' COMMENT '1:chosu us2:faq',
  `imageurl` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `question`
-- ----------------------------
BEGIN;
INSERT INTO `question` VALUES ('1', null, 'adasda', '1', '1', null, '2018-10-12 14:57:10', '2018-10-12 14:57:10');
COMMIT;

-- ----------------------------
--  Table structure for `tezos`
-- ----------------------------
DROP TABLE IF EXISTS `tezos`;
CREATE TABLE `tezos` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cycle` int(10) DEFAULT NULL COMMENT '轮次',
  `delegator_address` varchar(225) DEFAULT NULL COMMENT '代理地址',
  `delegated_balance` decimal(50,8) DEFAULT NULL COMMENT '代理额度',
  `reward` decimal(50,2) DEFAULT NULL COMMENT '奖励',
  `revenue` decimal(50,2) DEFAULT NULL COMMENT '收入',
  `fee` int(10) DEFAULT NULL COMMENT '扣除费用',
  `pay_in` decimal(50,8) DEFAULT NULL COMMENT '扣除款',
  `pay_out` decimal(50,8) DEFAULT NULL COMMENT '应付款',
  `status` int(10) DEFAULT NULL COMMENT '状态',
  `pay_time` timestamp NULL DEFAULT NULL COMMENT '付款时间',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `tezos`
-- ----------------------------
BEGIN;
INSERT INTO `tezos` VALUES ('1', '51', 'KT1QHHfMDev4A1DYonqdLE9Xb7czKL1MdKR8', '600000.00000000', '414.29', '331.43', '20', null, null, '1', null, '2018-11-15 20:00:53', '2018-11-15 20:00:53'), ('2', '51', 'KT1WKBga77ZxRESviEVgtQ55MLHxauEhtNCz', '405910.38135900', '280.26', '224.21', '20', null, null, '1', null, '2018-11-15 20:00:53', '2018-11-15 20:00:53'), ('3', '51', 'KT1Ks834ucCkeEJef9jZNHRSc2fu5kNk2Xre', '14800.00000000', '10.14', '8.11', '20', null, null, '1', null, '2018-11-15 20:00:53', '2018-11-15 20:00:53'), ('4', '51', 'KT1C6TSVhpaM9wPhHQ315a5FyRwGsd4H9Yvu', '10000.00000000', '6.85', '5.48', '20', null, null, '1', null, '2018-11-15 20:00:53', '2018-11-15 20:00:53'), ('5', '51', 'KT1KDHz4Sya8DEJ7AaBAqYsrbVLQ1D8CTcKs', '3072.99539700', '2.04', '1.63', '20', null, null, '1', null, '2018-11-15 20:00:53', '2018-11-15 20:00:53'), ('6', '51', 'KT1PGm9AuUoVZ8EWPVGPkFnoWfqcbgPVVhCw', '800.00000000', '0.53', '0.42', '20', null, null, '1', null, '2018-11-15 20:00:53', '2018-11-15 20:00:53'), ('7', '51', 'KT1GTRJ6dpbzgHMXaYGncnu11DvdVQvVdXzy', '422.92761900', '0.26', '0.21', '20', null, null, '1', null, '2018-11-15 20:00:54', '2018-11-15 20:00:54'), ('8', '50', 'KT1QHHfMDev4A1DYonqdLE9Xb7czKL1MdKR8', '600000.00000000', '425.83', '361.96', '15', null, null, '1', null, '2018-11-15 20:00:54', '2018-11-15 20:00:54'), ('9', '50', 'KT1WKBga77ZxRESviEVgtQ55MLHxauEhtNCz', '405910.38135900', '288.09', '244.88', '15', null, null, '1', null, '2018-11-15 20:00:54', '2018-11-15 20:00:54'), ('10', '50', 'KT1Ks834ucCkeEJef9jZNHRSc2fu5kNk2Xre', '14800.00000000', '10.41', '8.85', '15', null, null, '1', null, '2018-11-15 20:00:54', '2018-11-15 20:00:54'), ('11', '50', 'KT1C6TSVhpaM9wPhHQ315a5FyRwGsd4H9Yvu', '10000.00000000', '7.03', '5.98', '15', null, null, '1', null, '2018-11-15 20:00:54', '2018-11-15 20:00:54'), ('12', '50', 'KT1KDHz4Sya8DEJ7AaBAqYsrbVLQ1D8CTcKs', '3072.99539700', '2.10', '1.78', '15', null, null, '1', null, '2018-11-15 20:00:54', '2018-11-15 20:00:54'), ('13', '50', 'KT1PGm9AuUoVZ8EWPVGPkFnoWfqcbgPVVhCw', '800.00000000', '0.54', '0.46', '15', null, null, '1', null, '2018-11-15 20:00:54', '2018-11-15 20:00:54'), ('14', '49', 'KT1QHHfMDev4A1DYonqdLE9Xb7czKL1MdKR8', '600000.00000000', '459.46', '390.54', '15', null, null, '1', null, '2018-11-15 20:00:55', '2018-11-15 20:00:55'), ('15', '49', 'KT1WKBga77ZxRESviEVgtQ55MLHxauEhtNCz', '405910.38135900', '310.84', '264.21', '15', null, null, '1', null, '2018-11-15 20:00:55', '2018-11-15 20:00:55'), ('16', '49', 'KT1C6TSVhpaM9wPhHQ315a5FyRwGsd4H9Yvu', '10000.00000000', '7.58', '6.44', '15', null, null, '1', null, '2018-11-15 20:00:55', '2018-11-15 20:00:55'), ('17', '49', 'KT1PGm9AuUoVZ8EWPVGPkFnoWfqcbgPVVhCw', '800.00000000', '0.58', '0.49', '15', null, null, '1', null, '2018-11-15 20:00:55', '2018-11-15 20:00:55'), ('18', '48', 'KT1QHHfMDev4A1DYonqdLE9Xb7czKL1MdKR8', '600000.00000000', '426.55', '362.57', '15', null, null, '1', null, '2018-11-15 20:00:56', '2018-11-15 20:00:56'), ('19', '48', 'KT1WKBga77ZxRESviEVgtQ55MLHxauEhtNCz', '405910.38135900', '288.54', '245.26', '15', null, null, '1', null, '2018-11-15 20:00:56', '2018-11-15 20:00:56'), ('20', '48', 'KT1C6TSVhpaM9wPhHQ315a5FyRwGsd4H9Yvu', '10000.00000000', '7.03', '5.98', '15', null, null, '1', null, '2018-11-15 20:00:56', '2018-11-15 20:00:56'), ('21', '48', 'KT1PGm9AuUoVZ8EWPVGPkFnoWfqcbgPVVhCw', '800.00000000', '0.54', '0.46', '15', null, null, '1', null, '2018-11-15 20:00:56', '2018-11-15 20:00:56'), ('22', '47', 'KT1QHHfMDev4A1DYonqdLE9Xb7czKL1MdKR8', '650000.00000000', '502.23', '426.90', '15', null, null, '1', null, '2018-11-15 20:00:56', '2018-11-15 20:00:56'), ('23', '47', 'KT1C6TSVhpaM9wPhHQ315a5FyRwGsd4H9Yvu', '10000.00000000', '7.72', '6.56', '15', null, null, '1', null, '2018-11-15 20:00:56', '2018-11-15 20:00:56'), ('24', '47', 'KT1PGm9AuUoVZ8EWPVGPkFnoWfqcbgPVVhCw', '800.00000000', '0.59', '0.50', '15', null, null, '1', null, '2018-11-15 20:00:56', '2018-11-15 20:00:56'), ('25', '46', 'KT1QHHfMDev4A1DYonqdLE9Xb7czKL1MdKR8', '650000.00000000', '399.60', '339.66', '15', null, null, '2', null, '2018-11-15 20:00:57', '2018-11-15 20:00:57'), ('26', '46', 'KT1C6TSVhpaM9wPhHQ315a5FyRwGsd4H9Yvu', '10000.00000000', '6.13', '5.21', '15', null, null, '2', null, '2018-11-15 20:00:57', '2018-11-15 20:00:57'), ('27', '45', 'KT1QHHfMDev4A1DYonqdLE9Xb7czKL1MdKR8', '650000.00000000', '436.91', '371.37', '15', null, null, '3', null, '2018-11-15 20:00:57', '2018-11-15 20:00:57'), ('28', '45', 'KT1C6TSVhpaM9wPhHQ315a5FyRwGsd4H9Yvu', '10000.00000000', '6.70', '5.69', '15', null, null, '3', null, '2018-11-15 20:00:58', '2018-11-15 20:00:58'), ('29', '44', 'KT1QHHfMDev4A1DYonqdLE9Xb7czKL1MdKR8', '700000.00000000', '502.66', '427.26', '15', null, null, '3', null, '2018-11-15 20:00:58', '2018-11-15 20:00:58'), ('30', '44', 'KT1C6TSVhpaM9wPhHQ315a5FyRwGsd4H9Yvu', '53500.00000000', '38.37', '32.61', '15', null, null, '3', null, '2018-11-15 20:00:58', '2018-11-15 20:00:58'), ('31', '43', 'KT1QHHfMDev4A1DYonqdLE9Xb7czKL1MdKR8', '700000.00000000', '445.15', '378.38', '15', null, null, '3', null, '2018-11-15 20:00:59', '2018-11-15 20:00:59'), ('32', '43', 'KT1C6TSVhpaM9wPhHQ315a5FyRwGsd4H9Yvu', '53500.00000000', '34.01', '28.91', '15', null, null, '3', null, '2018-11-15 20:00:59', '2018-11-15 20:00:59'), ('33', '42', 'KT1QHHfMDev4A1DYonqdLE9Xb7czKL1MdKR8', '700000.00000000', '458.59', '389.80', '15', null, null, '3', null, '2018-11-15 20:00:59', '2018-11-15 20:00:59'), ('34', '42', 'KT1C6TSVhpaM9wPhHQ315a5FyRwGsd4H9Yvu', '53500.00000000', '35.01', '29.76', '15', null, null, '3', null, '2018-11-15 20:00:59', '2018-11-15 20:00:59'), ('35', '41', 'KT1QHHfMDev4A1DYonqdLE9Xb7czKL1MdKR8', '700000.00000000', '435.02', '369.77', '15', null, null, '3', null, '2018-11-15 20:01:00', '2018-11-15 20:01:00'), ('36', '41', 'KT1C6TSVhpaM9wPhHQ315a5FyRwGsd4H9Yvu', '53500.00000000', '33.23', '28.25', '15', null, null, '3', null, '2018-11-15 20:01:00', '2018-11-15 20:01:00'), ('37', '40', 'KT1QHHfMDev4A1DYonqdLE9Xb7czKL1MdKR8', '700000.00000000', '550.11', '467.59', '15', null, null, '4', null, '2018-11-15 20:01:00', '2018-11-15 20:01:00'), ('38', '40', 'KT1C6TSVhpaM9wPhHQ315a5FyRwGsd4H9Yvu', '53500.00000000', '41.99', '35.69', '15', null, null, '4', null, '2018-11-15 20:01:00', '2018-11-15 20:01:00'), ('39', '39', 'KT1QHHfMDev4A1DYonqdLE9Xb7czKL1MdKR8', '700000.00000000', '635.50', '540.17', '15', null, null, '4', null, '2018-11-15 20:01:01', '2018-11-15 20:01:01'), ('40', '39', 'KT1C6TSVhpaM9wPhHQ315a5FyRwGsd4H9Yvu', '53500.00000000', '48.56', '41.28', '15', null, null, '4', null, '2018-11-15 20:01:01', '2018-11-15 20:01:01'), ('41', '38', 'KT1QHHfMDev4A1DYonqdLE9Xb7czKL1MdKR8', '700000.00000000', '532.97', '453.02', '15', null, null, '4', null, '2018-11-15 20:01:01', '2018-11-15 20:01:01'), ('42', '38', 'KT1C6TSVhpaM9wPhHQ315a5FyRwGsd4H9Yvu', '53500.00000000', '40.68', '34.58', '15', null, null, '4', null, '2018-11-15 20:01:01', '2018-11-15 20:01:01'), ('43', '37', 'KT1QHHfMDev4A1DYonqdLE9Xb7czKL1MdKR8', '700000.00000000', '529.33', '449.93', '15', null, null, '4', null, '2018-11-15 20:01:02', '2018-11-15 20:01:02'), ('44', '37', 'KT1C6TSVhpaM9wPhHQ315a5FyRwGsd4H9Yvu', '53500.00000000', '40.43', '34.37', '15', null, null, '4', null, '2018-11-15 20:01:02', '2018-11-15 20:01:02'), ('45', '36', 'KT1QHHfMDev4A1DYonqdLE9Xb7czKL1MdKR8', '700000.00000000', '595.39', '506.08', '15', null, null, '4', null, '2018-11-15 20:01:02', '2018-11-15 20:01:02'), ('46', '36', 'KT1C6TSVhpaM9wPhHQ315a5FyRwGsd4H9Yvu', '53500.00000000', '45.44', '38.62', '15', null, null, '4', null, '2018-11-15 20:01:02', '2018-11-15 20:01:02'), ('47', '35', 'KT1QHHfMDev4A1DYonqdLE9Xb7czKL1MdKR8', '700000.00000000', '596.21', '506.78', '15', null, null, '4', null, '2018-11-15 20:01:03', '2018-11-15 20:01:03'), ('48', '35', 'KT1C6TSVhpaM9wPhHQ315a5FyRwGsd4H9Yvu', '53500.00000000', '45.51', '38.68', '15', null, null, '4', null, '2018-11-15 20:01:03', '2018-11-15 20:01:03'), ('49', '34', 'KT1QHHfMDev4A1DYonqdLE9Xb7czKL1MdKR8', '700000.00000000', '539.87', '458.89', '15', null, null, '4', null, '2018-11-15 20:01:03', '2018-11-15 20:01:03'), ('50', '34', 'KT1C6TSVhpaM9wPhHQ315a5FyRwGsd4H9Yvu', '44000.00000000', '33.91', '28.82', '15', null, null, '4', null, '2018-11-15 20:01:03', '2018-11-15 20:01:03'), ('51', '33', 'KT1QHHfMDev4A1DYonqdLE9Xb7czKL1MdKR8', '700000.00000000', '515.38', '438.07', '15', null, null, '4', null, '2018-11-15 20:01:04', '2018-11-15 20:01:04'), ('52', '33', 'KT1C6TSVhpaM9wPhHQ315a5FyRwGsd4H9Yvu', '38000.00000000', '27.95', '23.76', '15', null, null, '4', null, '2018-11-15 20:01:04', '2018-11-15 20:01:04'), ('53', '32', 'KT1QHHfMDev4A1DYonqdLE9Xb7czKL1MdKR8', '699999.00000000', '531.70', '451.94', '15', null, null, '4', null, '2018-11-15 20:01:04', '2018-11-15 20:01:04'), ('54', '32', 'KT1C6TSVhpaM9wPhHQ315a5FyRwGsd4H9Yvu', '32000.00000000', '24.26', '20.62', '15', null, null, '4', null, '2018-11-15 20:01:05', '2018-11-15 20:01:05'), ('55', '31', 'KT1QHHfMDev4A1DYonqdLE9Xb7czKL1MdKR8', '699999.00000000', '573.51', '487.48', '15', null, null, '4', null, '2018-11-15 20:01:05', '2018-11-15 20:01:05'), ('56', '31', 'KT1C6TSVhpaM9wPhHQ315a5FyRwGsd4H9Yvu', '25000.00000000', '20.48', '17.41', '15', null, null, '4', null, '2018-11-15 20:01:05', '2018-11-15 20:01:05'), ('57', '30', 'KT1C6TSVhpaM9wPhHQ315a5FyRwGsd4H9Yvu', '20000.00000000', '17.93', '15.24', '15', null, null, '4', null, '2018-11-15 20:01:06', '2018-11-15 20:01:06'), ('58', '29', 'KT1C6TSVhpaM9wPhHQ315a5FyRwGsd4H9Yvu', '20000.00000000', '17.86', '15.18', '15', null, null, '4', null, '2018-11-15 20:01:06', '2018-11-15 20:01:06'), ('59', '28', 'KT1C6TSVhpaM9wPhHQ315a5FyRwGsd4H9Yvu', '20000.00000000', '16.52', '14.04', '15', null, null, '4', null, '2018-11-15 20:01:07', '2018-11-15 20:01:07');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` tinyint(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `creat_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', '1dsa', 'dasdasdas', '2018-10-10 11:56:36', '2018-10-10 11:56:36'), ('2', '18037310248', '63373b41cf913e9f9b3226b4a0452737', '2018-10-10 12:00:42', '2018-11-15 20:10:33'), ('3', '18510869004', '7dd6af0d70340195c48c002ebe5e4aac', '2018-10-12 11:51:58', '2018-11-15 20:12:06');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
