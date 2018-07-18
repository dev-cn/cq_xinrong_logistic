/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : xinrong

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-07-18 11:52:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ab_parameter
-- ----------------------------
DROP TABLE IF EXISTS `ab_parameter`;
CREATE TABLE `ab_parameter` (
  `id` bigint(20) NOT NULL,
  `para_code` varchar(32) NOT NULL,
  `para_desc` varchar(100) DEFAULT NULL,
  `para_parent_code` varchar(32) DEFAULT NULL,
  `seq` int(8) DEFAULT NULL,
  `create_at` timestamp NULL DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `is_delete` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
