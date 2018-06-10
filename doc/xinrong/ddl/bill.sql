/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : xinrong

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-06-10 09:55:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` bigint(18) DEFAULT NULL COMMENT '序号',
  `tracking_no` bigint(22) DEFAULT NULL COMMENT '运单号',
  `delivery_date` timestamp NULL DEFAULT NULL COMMENT '提货日期',
  `arrival_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '到货日期',
  `delivery_addr` varchar(255) DEFAULT NULL COMMENT '提货地点',
  `arrival_addr` varchar(255) DEFAULT NULL COMMENT '到货地点',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '货物名称',
  `loading_model` varchar(255) DEFAULT NULL COMMENT '装载车型',
  `palte_no` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `train_no` varchar(255) DEFAULT NULL COMMENT '车次',
  `shipped_quantity` bigint(20) DEFAULT NULL COMMENT '装载数量',
  `weight` double(20,2) DEFAULT NULL COMMENT '重量',
  `price` double(20,2) DEFAULT NULL COMMENT '单价',
  `pick_up_charge` double(20,2) DEFAULT NULL COMMENT '提货费',
  `delivery_fee` double(20,2) DEFAULT NULL COMMENT '送货费',
  `total_expenses` double(20,2) DEFAULT NULL COMMENT '费用合计',
  `comment` varchar(1000) DEFAULT NULL COMMENT '备注',
  `create_at` timestamp NULL DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `is_delete` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账单表';
