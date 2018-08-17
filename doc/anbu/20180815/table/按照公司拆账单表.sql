/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : xinrong

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-07-28 09:24:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ab_bill_bo_fan_ke_ji
-- ----------------------------
DROP TABLE IF EXISTS `ab_bill_bo_fan_ke_ji`;
CREATE TABLE `ab_bill_bo_fan_ke_ji` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` decimal(18,0) DEFAULT NULL COMMENT '序号',
  `tracking_no` varchar(100) DEFAULT NULL COMMENT '运单号',
  `delivery_date` varchar(255) DEFAULT NULL COMMENT '提货日期',
  `arrival_date` varchar(255) DEFAULT NULL COMMENT '到货日期',
  `delivery_addr` varchar(255) DEFAULT NULL COMMENT '提货地点',
  `arrival_addr` varchar(255) DEFAULT NULL COMMENT '到货地点',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '货物名称',
  `loading_model` varchar(255) DEFAULT NULL COMMENT '装载车型',
  `palte_no` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `train_no` varchar(255) DEFAULT NULL COMMENT '车次',
  `shipped_quantity` decimal(20,0) DEFAULT NULL COMMENT '装载数量',
  `weight` decimal(20,2) DEFAULT NULL COMMENT '重量',
  `price` decimal(20,2) DEFAULT NULL COMMENT '单价',
  `pick_up_charge` decimal(20,2) DEFAULT NULL COMMENT '提货费',
  `delivery_fee` decimal(20,2) DEFAULT NULL COMMENT '送货费',
  `total_expenses` decimal(20,2) DEFAULT NULL COMMENT '费用合计',
  `comment` varchar(1000) DEFAULT NULL COMMENT '备注',
  `create_at` timestamp NULL DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `is_delete` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='博帆科技账单表';


/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : xinrong

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-07-28 09:24:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ab_bill_bo_shi
-- ----------------------------
DROP TABLE IF EXISTS `ab_bill_bo_shi`;
CREATE TABLE `ab_bill_bo_shi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` decimal(18,0) DEFAULT NULL COMMENT '序号',
  `tracking_no` varchar(100) DEFAULT NULL COMMENT '运单号',
  `delivery_date` varchar(255) DEFAULT NULL COMMENT '提货日期',
  `arrival_date` varchar(255) DEFAULT NULL COMMENT '到货日期',
  `delivery_addr` varchar(255) DEFAULT NULL COMMENT '提货地点',
  `arrival_addr` varchar(255) DEFAULT NULL COMMENT '到货地点',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '货物名称',
  `loading_model` varchar(255) DEFAULT NULL COMMENT '装载车型',
  `palte_no` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `train_no` varchar(255) DEFAULT NULL COMMENT '车次',
  `shipped_quantity` decimal(20,0) DEFAULT NULL COMMENT '装载数量',
  `weight` decimal(20,2) DEFAULT NULL COMMENT '重量',
  `price` decimal(20,2) DEFAULT NULL COMMENT '单价',
  `pick_up_charge` decimal(20,2) DEFAULT NULL COMMENT '提货费',
  `delivery_fee` decimal(20,2) DEFAULT NULL COMMENT '送货费',
  `total_expenses` decimal(20,2) DEFAULT NULL COMMENT '费用合计',
  `comment` varchar(1000) DEFAULT NULL COMMENT '备注',
  `create_at` timestamp NULL DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `is_delete` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='博世账单表';


/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : xinrong

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-07-28 09:24:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ab_bill_bo_ze
-- ----------------------------
DROP TABLE IF EXISTS `ab_bill_bo_ze`;
CREATE TABLE `ab_bill_bo_ze` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` decimal(18,0) DEFAULT NULL COMMENT '序号',
  `tracking_no` varchar(100) DEFAULT NULL COMMENT '运单号',
  `delivery_date` varchar(255) DEFAULT NULL COMMENT '提货日期',
  `arrival_date` varchar(255) DEFAULT NULL COMMENT '到货日期',
  `delivery_addr` varchar(255) DEFAULT NULL COMMENT '提货地点',
  `arrival_addr` varchar(255) DEFAULT NULL COMMENT '到货地点',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '货物名称',
  `loading_model` varchar(255) DEFAULT NULL COMMENT '装载车型',
  `palte_no` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `train_no` varchar(255) DEFAULT NULL COMMENT '车次',
  `shipped_quantity` decimal(20,0) DEFAULT NULL COMMENT '装载数量',
  `weight` decimal(20,2) DEFAULT NULL COMMENT '重量',
  `price` decimal(20,2) DEFAULT NULL COMMENT '单价',
  `pick_up_charge` decimal(20,2) DEFAULT NULL COMMENT '提货费',
  `delivery_fee` decimal(20,2) DEFAULT NULL COMMENT '送货费',
  `total_expenses` decimal(20,2) DEFAULT NULL COMMENT '费用合计',
  `comment` varchar(1000) DEFAULT NULL COMMENT '备注',
  `create_at` timestamp NULL DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `is_delete` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='博泽账单表';


/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : xinrong

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-07-28 09:24:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ab_bill_cheng_du_hua_zhong
-- ----------------------------
DROP TABLE IF EXISTS `ab_bill_cheng_du_hua_zhong`;
CREATE TABLE `ab_bill_cheng_du_hua_zhong` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` decimal(18,0) DEFAULT NULL COMMENT '序号',
  `tracking_no` varchar(100) DEFAULT NULL COMMENT '运单号',
  `delivery_date` varchar(255) DEFAULT NULL COMMENT '提货日期',
  `arrival_date` varchar(255) DEFAULT NULL COMMENT '到货日期',
  `delivery_addr` varchar(255) DEFAULT NULL COMMENT '提货地点',
  `arrival_addr` varchar(255) DEFAULT NULL COMMENT '到货地点',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '货物名称',
  `loading_model` varchar(255) DEFAULT NULL COMMENT '装载车型',
  `palte_no` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `train_no` varchar(255) DEFAULT NULL COMMENT '车次',
  `shipped_quantity` decimal(20,0) DEFAULT NULL COMMENT '装载数量',
  `weight` decimal(20,2) DEFAULT NULL COMMENT '重量',
  `price` decimal(20,2) DEFAULT NULL COMMENT '单价',
  `pick_up_charge` decimal(20,2) DEFAULT NULL COMMENT '提货费',
  `delivery_fee` decimal(20,2) DEFAULT NULL COMMENT '送货费',
  `total_expenses` decimal(20,2) DEFAULT NULL COMMENT '费用合计',
  `comment` varchar(1000) DEFAULT NULL COMMENT '备注',
  `create_at` timestamp NULL DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `is_delete` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='成都华众账单表';

/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : xinrong

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-07-28 09:24:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ab_bill_min_te
-- ----------------------------
DROP TABLE IF EXISTS `ab_bill_min_te`;
CREATE TABLE `ab_bill_min_te` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` decimal(18,0) DEFAULT NULL COMMENT '序号',
  `tracking_no` varchar(100) DEFAULT NULL COMMENT '运单号',
  `delivery_date` varchar(255) DEFAULT NULL COMMENT '提货日期',
  `arrival_date` varchar(255) DEFAULT NULL COMMENT '到货日期',
  `delivery_addr` varchar(255) DEFAULT NULL COMMENT '提货地点',
  `arrival_addr` varchar(255) DEFAULT NULL COMMENT '到货地点',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '货物名称',
  `loading_model` varchar(255) DEFAULT NULL COMMENT '装载车型',
  `palte_no` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `train_no` varchar(255) DEFAULT NULL COMMENT '车次',
  `shipped_quantity` decimal(20,0) DEFAULT NULL COMMENT '装载数量',
  `weight` decimal(20,2) DEFAULT NULL COMMENT '重量',
  `price` decimal(20,2) DEFAULT NULL COMMENT '单价',
  `pick_up_charge` decimal(20,2) DEFAULT NULL COMMENT '提货费',
  `delivery_fee` decimal(20,2) DEFAULT NULL COMMENT '送货费',
  `total_expenses` decimal(20,2) DEFAULT NULL COMMENT '费用合计',
  `comment` varchar(1000) DEFAULT NULL COMMENT '备注',
  `create_at` timestamp NULL DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `is_delete` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='敏特账单表';


/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : xinrong

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-07-28 09:24:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ab_bill_sa_wei_ao
-- ----------------------------
DROP TABLE IF EXISTS `ab_bill_sa_wei_ao`;
CREATE TABLE `ab_bill_sa_wei_ao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` decimal(18,0) DEFAULT NULL COMMENT '序号',
  `tracking_no` varchar(100) DEFAULT NULL COMMENT '运单号',
  `delivery_date` varchar(255) DEFAULT NULL COMMENT '提货日期',
  `arrival_date` varchar(255) DEFAULT NULL COMMENT '到货日期',
  `delivery_addr` varchar(255) DEFAULT NULL COMMENT '提货地点',
  `arrival_addr` varchar(255) DEFAULT NULL COMMENT '到货地点',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '货物名称',
  `loading_model` varchar(255) DEFAULT NULL COMMENT '装载车型',
  `palte_no` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `train_no` varchar(255) DEFAULT NULL COMMENT '车次',
  `shipped_quantity` decimal(20,0) DEFAULT NULL COMMENT '装载数量',
  `weight` decimal(20,2) DEFAULT NULL COMMENT '重量',
  `price` decimal(20,2) DEFAULT NULL COMMENT '单价',
  `pick_up_charge` decimal(20,2) DEFAULT NULL COMMENT '提货费',
  `delivery_fee` decimal(20,2) DEFAULT NULL COMMENT '送货费',
  `total_expenses` decimal(20,2) DEFAULT NULL COMMENT '费用合计',
  `comment` varchar(1000) DEFAULT NULL COMMENT '备注',
  `create_at` timestamp NULL DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `is_delete` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='萨维奥账单表';


/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : xinrong

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-07-28 09:24:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ab_bill_shang_hai_ming_fang
-- ----------------------------
DROP TABLE IF EXISTS `ab_bill_shang_hai_ming_fang`;
CREATE TABLE `ab_bill_shang_hai_ming_fang` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` decimal(18,0) DEFAULT NULL COMMENT '序号',
  `tracking_no` varchar(100) DEFAULT NULL COMMENT '运单号',
  `delivery_date` varchar(255) DEFAULT NULL COMMENT '提货日期',
  `arrival_date` varchar(255) DEFAULT NULL COMMENT '到货日期',
  `delivery_addr` varchar(255) DEFAULT NULL COMMENT '提货地点',
  `arrival_addr` varchar(255) DEFAULT NULL COMMENT '到货地点',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '货物名称',
  `loading_model` varchar(255) DEFAULT NULL COMMENT '装载车型',
  `palte_no` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `train_no` varchar(255) DEFAULT NULL COMMENT '车次',
  `shipped_quantity` decimal(20,0) DEFAULT NULL COMMENT '装载数量',
  `weight` decimal(20,2) DEFAULT NULL COMMENT '重量',
  `price` decimal(20,2) DEFAULT NULL COMMENT '单价',
  `pick_up_charge` decimal(20,2) DEFAULT NULL COMMENT '提货费',
  `delivery_fee` decimal(20,2) DEFAULT NULL COMMENT '送货费',
  `total_expenses` decimal(20,2) DEFAULT NULL COMMENT '费用合计',
  `comment` varchar(1000) DEFAULT NULL COMMENT '备注',
  `create_at` timestamp NULL DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `is_delete` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='上海明芳账单表';


/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : xinrong

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-07-28 09:24:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ab_bill_si_wei_er
-- ----------------------------
DROP TABLE IF EXISTS `ab_bill_si_wei_er`;
CREATE TABLE `ab_bill_si_wei_er` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` decimal(18,0) DEFAULT NULL COMMENT '序号',
  `tracking_no` varchar(100) DEFAULT NULL COMMENT '运单号',
  `delivery_date` varchar(255) DEFAULT NULL COMMENT '提货日期',
  `arrival_date` varchar(255) DEFAULT NULL COMMENT '到货日期',
  `delivery_addr` varchar(255) DEFAULT NULL COMMENT '提货地点',
  `arrival_addr` varchar(255) DEFAULT NULL COMMENT '到货地点',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '货物名称',
  `loading_model` varchar(255) DEFAULT NULL COMMENT '装载车型',
  `palte_no` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `train_no` varchar(255) DEFAULT NULL COMMENT '车次',
  `shipped_quantity` decimal(20,0) DEFAULT NULL COMMENT '装载数量',
  `weight` decimal(20,2) DEFAULT NULL COMMENT '重量',
  `price` decimal(20,2) DEFAULT NULL COMMENT '单价',
  `pick_up_charge` decimal(20,2) DEFAULT NULL COMMENT '提货费',
  `delivery_fee` decimal(20,2) DEFAULT NULL COMMENT '送货费',
  `total_expenses` decimal(20,2) DEFAULT NULL COMMENT '费用合计',
  `comment` varchar(1000) DEFAULT NULL COMMENT '备注',
  `create_at` timestamp NULL DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `is_delete` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='四维尔账单表';


/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : xinrong

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-07-28 09:24:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ab_bill_xin_si_lu
-- ----------------------------
DROP TABLE IF EXISTS `ab_bill_xin_si_lu`;
CREATE TABLE `ab_bill_xin_si_lu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` decimal(18,0) DEFAULT NULL COMMENT '序号',
  `tracking_no` varchar(100) DEFAULT NULL COMMENT '运单号',
  `delivery_date` varchar(255) DEFAULT NULL COMMENT '提货日期',
  `arrival_date` varchar(255) DEFAULT NULL COMMENT '到货日期',
  `delivery_addr` varchar(255) DEFAULT NULL COMMENT '提货地点',
  `arrival_addr` varchar(255) DEFAULT NULL COMMENT '到货地点',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '货物名称',
  `loading_model` varchar(255) DEFAULT NULL COMMENT '装载车型',
  `palte_no` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `train_no` varchar(255) DEFAULT NULL COMMENT '车次',
  `shipped_quantity` decimal(20,0) DEFAULT NULL COMMENT '装载数量',
  `weight` decimal(20,2) DEFAULT NULL COMMENT '重量',
  `price` decimal(20,2) DEFAULT NULL COMMENT '单价',
  `pick_up_charge` decimal(20,2) DEFAULT NULL COMMENT '提货费',
  `delivery_fee` decimal(20,2) DEFAULT NULL COMMENT '送货费',
  `total_expenses` decimal(20,2) DEFAULT NULL COMMENT '费用合计',
  `comment` varchar(1000) DEFAULT NULL COMMENT '备注',
  `create_at` timestamp NULL DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `is_delete` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='新思路账单表';


/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : xinrong

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-07-28 09:24:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ab_bill_yan_feng
-- ----------------------------
DROP TABLE IF EXISTS `ab_bill_yan_feng`;
CREATE TABLE `ab_bill_yan_feng` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` decimal(18,0) DEFAULT NULL COMMENT '序号',
  `tracking_no` varchar(100) DEFAULT NULL COMMENT '运单号',
  `delivery_date` varchar(255) DEFAULT NULL COMMENT '提货日期',
  `arrival_date` varchar(255) DEFAULT NULL COMMENT '到货日期',
  `delivery_addr` varchar(255) DEFAULT NULL COMMENT '提货地点',
  `arrival_addr` varchar(255) DEFAULT NULL COMMENT '到货地点',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '货物名称',
  `loading_model` varchar(255) DEFAULT NULL COMMENT '装载车型',
  `palte_no` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `train_no` varchar(255) DEFAULT NULL COMMENT '车次',
  `shipped_quantity` decimal(20,0) DEFAULT NULL COMMENT '装载数量',
  `weight` decimal(20,2) DEFAULT NULL COMMENT '重量',
  `price` decimal(20,2) DEFAULT NULL COMMENT '单价',
  `pick_up_charge` decimal(20,2) DEFAULT NULL COMMENT '提货费',
  `delivery_fee` decimal(20,2) DEFAULT NULL COMMENT '送货费',
  `total_expenses` decimal(20,2) DEFAULT NULL COMMENT '费用合计',
  `comment` varchar(1000) DEFAULT NULL COMMENT '备注',
  `create_at` timestamp NULL DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `is_delete` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='延锋账单表';


/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : xinrong

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-07-28 09:24:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ab_bill_yi_qi_si_huan
-- ----------------------------
DROP TABLE IF EXISTS `ab_bill_yi_qi_si_huan`;
CREATE TABLE `ab_bill_yi_qi_si_huan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` decimal(18,0) DEFAULT NULL COMMENT '序号',
  `tracking_no` varchar(100) DEFAULT NULL COMMENT '运单号',
  `delivery_date` varchar(255) DEFAULT NULL COMMENT '提货日期',
  `arrival_date` varchar(255) DEFAULT NULL COMMENT '到货日期',
  `delivery_addr` varchar(255) DEFAULT NULL COMMENT '提货地点',
  `arrival_addr` varchar(255) DEFAULT NULL COMMENT '到货地点',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '货物名称',
  `loading_model` varchar(255) DEFAULT NULL COMMENT '装载车型',
  `palte_no` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `train_no` varchar(255) DEFAULT NULL COMMENT '车次',
  `shipped_quantity` decimal(20,0) DEFAULT NULL COMMENT '装载数量',
  `weight` decimal(20,2) DEFAULT NULL COMMENT '重量',
  `price` decimal(20,2) DEFAULT NULL COMMENT '单价',
  `pick_up_charge` decimal(20,2) DEFAULT NULL COMMENT '提货费',
  `delivery_fee` decimal(20,2) DEFAULT NULL COMMENT '送货费',
  `total_expenses` decimal(20,2) DEFAULT NULL COMMENT '费用合计',
  `comment` varchar(1000) DEFAULT NULL COMMENT '备注',
  `create_at` timestamp NULL DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `is_delete` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='一汽四环账单表';


/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : xinrong

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-07-28 09:24:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ab_bill_chong_qing_yuan_ding
-- ----------------------------
DROP TABLE IF EXISTS `ab_bill_chong_qing_yuan_ding`;
CREATE TABLE `ab_bill_chong_qing_yuan_ding` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_no` decimal(18,0) DEFAULT NULL COMMENT '序号',
  `tracking_no` varchar(100) DEFAULT NULL COMMENT '运单号',
  `delivery_date` varchar(255) DEFAULT NULL COMMENT '提货日期',
  `arrival_date` varchar(255) DEFAULT NULL COMMENT '到货日期',
  `delivery_addr` varchar(255) DEFAULT NULL COMMENT '提货地点',
  `arrival_addr` varchar(255) DEFAULT NULL COMMENT '到货地点',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '货物名称',
  `loading_model` varchar(255) DEFAULT NULL COMMENT '装载车型',
  `palte_no` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `train_no` varchar(255) DEFAULT NULL COMMENT '车次',
  `shipped_quantity` decimal(20,0) DEFAULT NULL COMMENT '装载数量',
  `weight` decimal(20,2) DEFAULT NULL COMMENT '重量',
  `price` decimal(20,2) DEFAULT NULL COMMENT '单价',
  `pick_up_charge` decimal(20,2) DEFAULT NULL COMMENT '提货费',
  `delivery_fee` decimal(20,2) DEFAULT NULL COMMENT '送货费',
  `total_expenses` decimal(20,2) DEFAULT NULL COMMENT '费用合计',
  `comment` varchar(1000) DEFAULT NULL COMMENT '备注',
  `create_at` timestamp NULL DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `is_delete` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='重庆远鼎账单表';


