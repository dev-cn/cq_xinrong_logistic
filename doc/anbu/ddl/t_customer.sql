/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : xinrong

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-07-02 19:59:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '客户名',
  `name_en` varchar(255) DEFAULT NULL COMMENT '英文名',
  `name_desc` varchar(100) DEFAULT NULL COMMENT '客户名简称',
  `mobile` varchar(100) DEFAULT NULL COMMENT '联系方式',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `qq` varchar(100) DEFAULT NULL COMMENT 'QQ',
  `wechat` varchar(100) DEFAULT NULL COMMENT '微信',
  `website` varchar(255) DEFAULT NULL COMMENT '网站地址',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `ctime` datetime DEFAULT NULL COMMENT '建档时间',
  `level` varchar(50) DEFAULT NULL COMMENT '级别',
  `comment` varchar(1000) DEFAULT NULL COMMENT '备注',
  `create_at` datetime DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `is_delete` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='客户信息表';
