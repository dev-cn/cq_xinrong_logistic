/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : xinrong

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-07-02 20:00:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bill_packing_materials
-- ----------------------------
DROP TABLE IF EXISTS `bill_packing_materials`;
CREATE TABLE `bill_packing_materials` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` bigint(20) DEFAULT NULL COMMENT '序号',
  `address` varchar(255) DEFAULT NULL COMMENT '地点',
  `transpot_supplier` varchar(255) DEFAULT NULL COMMENT '运输供应商',
  `freight_type` varchar(255) DEFAULT NULL COMMENT '运费类型',
  `transpot_no` varchar(255) DEFAULT NULL COMMENT '运输单号',
  `date` varchar(255) DEFAULT NULL COMMENT '日期',
  `line_start` varchar(255) DEFAULT NULL COMMENT '起点',
  `line_end` varchar(255) DEFAULT NULL COMMENT '线路终点',
  `transpot_product` varchar(255) DEFAULT NULL COMMENT '运输产品',
  `transpot_mode` varchar(255) DEFAULT NULL COMMENT '运输方式',
  `motorcycle_type` varchar(255) DEFAULT NULL COMMENT '车型',
  `transpot_price` decimal(20,2) DEFAULT NULL COMMENT '运输单价(含税保险)',
  `carton` decimal(20,0) DEFAULT NULL COMMENT '纸箱',
  `foam_one` decimal(20,0) DEFAULT NULL COMMENT '1#泡棉',
  `foam_two` decimal(20,0) DEFAULT NULL COMMENT '2#泡棉',
  `foam_three` decimal(20,0) DEFAULT NULL COMMENT '3#泡棉',
  `foam_four` decimal(20,0) DEFAULT NULL COMMENT '4#泡棉',
  `paper_brace` decimal(20,0) DEFAULT NULL COMMENT '纸角撑',
  `quantity` decimal(20,0) DEFAULT NULL COMMENT '数量',
  `volune_sum` decimal(20,2) DEFAULT NULL COMMENT '总体积',
  `weight_sum` decimal(20,2) DEFAULT NULL COMMENT '总重量',
  `delivery_fee` decimal(20,2) DEFAULT NULL COMMENT '提送运费',
  `advance_fee_include_tax` decimal(20,2) DEFAULT NULL COMMENT '预提运费合计（含税10%）',
  `advance_fee_no_tax` decimal(20,2) DEFAULT NULL COMMENT '预提运费合计（不含税）',
  `status` tinyint(2) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL COMMENT '备注',
  `reserve_one` varchar(255) DEFAULT NULL COMMENT '预留字段1',
  `reserve_two` varchar(255) DEFAULT NULL COMMENT '预留字段2',
  `create_at` datetime DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `is_delete` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='包材表';
