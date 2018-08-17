/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : anbu

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2018-08-17 16:38:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', null, null, '0', 'fa fa-cog', '0');
INSERT INTO `sys_menu` VALUES ('2', '1', '管理员列表', 'modules/sys/user.html', null, '1', 'fa fa-user', '1');
INSERT INTO `sys_menu` VALUES ('3', '1', '角色管理', 'modules/sys/role.html', null, '1', 'fa fa-user-secret', '2');
INSERT INTO `sys_menu` VALUES ('4', '1', '菜单管理', 'modules/sys/menu.html', null, '1', 'fa fa-th-list', '3');
INSERT INTO `sys_menu` VALUES ('5', '1', 'SQL监控', 'druid/sql.html', '', '1', 'fa fa-bug', '4');
INSERT INTO `sys_menu` VALUES ('6', '1', '定时任务', 'modules/job/schedule.html', null, '1', 'fa fa-tasks', '5');
INSERT INTO `sys_menu` VALUES ('7', '6', '查看', null, 'sys:schedule:list,sys:schedule:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('8', '6', '新增', null, 'sys:schedule:save', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('9', '6', '修改', null, 'sys:schedule:update', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('10', '6', '删除', null, 'sys:schedule:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('11', '6', '暂停', null, 'sys:schedule:pause', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('12', '6', '恢复', null, 'sys:schedule:resume', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('13', '6', '立即执行', null, 'sys:schedule:run', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('14', '6', '日志列表', null, 'sys:schedule:log', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('15', '2', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('16', '2', '新增', null, 'sys:user:save,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('17', '2', '修改', null, 'sys:user:update,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('18', '2', '删除', null, 'sys:user:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('19', '3', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('20', '3', '新增', null, 'sys:role:save,sys:menu:list', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('21', '3', '修改', null, 'sys:role:update,sys:menu:list', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('22', '3', '删除', null, 'sys:role:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('23', '4', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('24', '4', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('25', '4', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('26', '4', '删除', null, 'sys:menu:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('27', '1', '参数管理', 'modules/sys/config.html', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', '1', 'fa fa-sun-o', '6');
INSERT INTO `sys_menu` VALUES ('29', '1', '系统日志', 'modules/sys/log.html', 'sys:log:list', '1', 'fa fa-file-text-o', '7');
INSERT INTO `sys_menu` VALUES ('30', '1', '文件上传', 'modules/oss/oss.html', 'sys:oss:all', '1', 'fa fa-file-image-o', '6');
INSERT INTO `sys_menu` VALUES ('31', '149', '账单表', 'modules/bill/bill.html', '', '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('32', '31', '查看', null, 'bill:bill:list,bill:bill:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('33', '31', '新增', null, 'bill:bill:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('34', '31', '修改', null, 'bill:bill:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('35', '31', '删除', null, 'bill:bill:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('36', '149', '运费汇总表', 'modules/bill/billcollect.html', '', '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('37', '36', '查看', null, 'bill:billcollect:list,bill:billcollect:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('38', '36', '新增', null, 'bill:billcollect:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('39', '36', '修改', null, 'bill:billcollect:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('40', '36', '删除', null, 'bill:billcollect:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('41', '0', '数据管理', null, null, '0', null, '0');
INSERT INTO `sys_menu` VALUES ('42', '149', '包材表', 'modules/bill/billpackingmaterials.html', '', '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('43', '42', '查看', null, 'bill:billpackingmaterials:list,bill:billpackingmaterials:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('44', '42', '新增', null, 'bill:billpackingmaterials:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('45', '42', '修改', null, 'bill:billpackingmaterials:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('46', '42', '删除', null, 'bill:billpackingmaterials:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('52', '1', '字典', 'modules/baseinfo/abparameter.html', '', '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('53', '52', '查看', null, 'baseinfo:abparameter:list,baseinfo:abparameter:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('54', '52', '新增', null, 'baseinfo:abparameter:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('55', '52', '修改', null, 'baseinfo:abparameter:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('56', '52', '删除', null, 'baseinfo:abparameter:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('88', '148', '博帆科技账单表', 'modules/bill/bofankeji.html', '', '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('89', '88', '查看', null, 'bill:bofankeji:list,bill:bofankeji:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('90', '88', '新增', null, 'bill:bofankeji:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('91', '88', '修改', null, 'bill:bofankeji:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('92', '88', '删除', null, 'bill:bofankeji:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('93', '148', '博世账单表', 'modules/bill/boshi.html', '', '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('94', '93', '查看', null, 'bill:boshi:list,bill:boshi:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('95', '93', '新增', null, 'bill:boshi:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('96', '93', '修改', null, 'bill:boshi:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('97', '93', '删除', null, 'bill:boshi:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('98', '148', '博泽账单表', 'modules/bill/boze.html', '', '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('99', '98', '查看', null, 'bill:boze:list,bill:boze:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('100', '98', '新增', null, 'bill:boze:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('101', '98', '修改', null, 'bill:boze:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('102', '98', '删除', null, 'bill:boze:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('103', '148', '成都华众账单表', 'modules/bill/chengduhuazhong.html', '', '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('104', '103', '查看', null, 'bill:chengduhuazhong:list,bill:chengduhuazhong:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('105', '103', '新增', null, 'bill:chengduhuazhong:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('106', '103', '修改', null, 'bill:chengduhuazhong:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('107', '103', '删除', null, 'bill:chengduhuazhong:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('108', '148', '重庆远鼎账单表', 'modules/bill/chongqingyuanding.html', '', '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('109', '108', '查看', null, 'bill:chongqingyuanding:list,bill:chongqingyuanding:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('110', '108', '新增', null, 'bill:chongqingyuanding:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('111', '108', '修改', null, 'bill:chongqingyuanding:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('112', '108', '删除', null, 'bill:chongqingyuanding:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('113', '148', '敏特账单表', 'modules/bill/minte.html', '', '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('114', '113', '查看', null, 'bill:minte:list,bill:minte:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('115', '113', '新增', null, 'bill:minte:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('116', '113', '修改', null, 'bill:minte:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('117', '113', '删除', null, 'bill:minte:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('118', '148', '萨维奥账单表', 'modules/bill/saweiao.html', '', '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('119', '118', '查看', null, 'bill:saweiao:list,bill:saweiao:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('120', '118', '新增', null, 'bill:saweiao:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('121', '118', '修改', null, 'bill:saweiao:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('122', '118', '删除', null, 'bill:saweiao:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('123', '148', '上海明芳账单表', 'modules/bill/shanghaimingfang.html', '', '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('124', '123', '查看', null, 'bill:shanghaimingfang:list,bill:shanghaimingfang:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('125', '123', '新增', null, 'bill:shanghaimingfang:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('126', '123', '修改', null, 'bill:shanghaimingfang:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('127', '123', '删除', null, 'bill:shanghaimingfang:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('128', '148', '新思路账单表', 'modules/bill/xinsilu.html', '', '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('129', '128', '查看', null, 'bill:xinsilu:list,bill:xinsilu:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('130', '128', '新增', null, 'bill:xinsilu:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('131', '128', '修改', null, 'bill:xinsilu:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('132', '128', '删除', null, 'bill:xinsilu:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('133', '148', '延锋账单表', 'modules/bill/yanfeng.html', '', '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('134', '133', '查看', null, 'bill:yanfeng:list,bill:yanfeng:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('135', '133', '新增', null, 'bill:yanfeng:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('136', '133', '修改', null, 'bill:yanfeng:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('137', '133', '删除', null, 'bill:yanfeng:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('138', '148', '一汽四环账单表', 'modules/bill/yiqisihuan.html', '', '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('139', '138', '查看', null, 'bill:yiqisihuan:list,bill:yiqisihuan:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('140', '138', '新增', null, 'bill:yiqisihuan:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('141', '138', '修改', null, 'bill:yiqisihuan:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('142', '138', '删除', null, 'bill:yiqisihuan:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('143', '148', '四维尔账单表', 'modules/bill/siweier.html', '', '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('144', '143', '查看', null, 'bill:siweier:list,bill:siweier:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('145', '143', '新增', null, 'bill:siweier:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('146', '143', '修改', null, 'bill:siweier:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('147', '143', '删除', null, 'bill:siweier:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('148', '41', '账单数据', null, null, '0', null, '0');
INSERT INTO `sys_menu` VALUES ('149', '41', '汇总数据', null, null, '0', null, '0');
