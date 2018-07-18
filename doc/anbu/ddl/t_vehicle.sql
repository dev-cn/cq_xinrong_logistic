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
-- Table structure for t_vehicle
-- ----------------------------
DROP TABLE IF EXISTS `t_vehicle`;
CREATE TABLE `t_vehicle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `palte_no` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `driver` varchar(255) DEFAULT NULL COMMENT '驾驶人',
  `loading_model` varchar(255) DEFAULT NULL COMMENT '装载车型',
  `shipped_quantity` decimal(20,2) DEFAULT NULL COMMENT '车载量',
  `belong_area` varchar(255) DEFAULT NULL COMMENT '所属区域',
  `comment` varchar(1000) DEFAULT NULL COMMENT '备注',
  `create_at` datetime DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `is_delete` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='车辆信息表';
