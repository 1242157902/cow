/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : cowdb

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-03-21 11:15:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cow`
-- ----------------------------
DROP TABLE IF EXISTS `cow`;
CREATE TABLE `cow` (
  `cowId` int(6) NOT NULL AUTO_INCREMENT COMMENT '牛只编号',
  `sex` tinyint(1) NOT NULL COMMENT '牛性别;1:公；2：母',
  `cowCategory` int(4) NOT NULL COMMENT '牛只所属品种',
  `birthday` char(10) NOT NULL COMMENT '牛出生日期',
  `weight` double(5,1) NOT NULL COMMENT '牛重量',
  `inWeight` double(5,1) NOT NULL COMMENT '入场体重',
  `inDate` char(13) NOT NULL COMMENT '入场日期',
  `houseId` int(6) NOT NULL COMMENT '牛所在牛舍',
  `state` int(1) NOT NULL DEFAULT '1' COMMENT '状态,1:正常，2:离场;3:不在',
  PRIMARY KEY (`cowId`)
) ENGINE=InnoDB AUTO_INCREMENT=1014 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cow
-- ----------------------------
INSERT INTO `cow` VALUES ('1000', '1', '1001', '2017-02-27', '90.0', '56.8', '2017-02-27', '1003', '1');
INSERT INTO `cow` VALUES ('1001', '1', '1002', '2017-02-27', '90.0', '56.8', '2017-02-27', '1000', '1');
INSERT INTO `cow` VALUES ('1002', '1', '1003', '2017-02-27', '90.0', '56.8', '2017-02-27', '1000', '3');
INSERT INTO `cow` VALUES ('1003', '2', '1000', '2016-02-01', '90.0', '20.0', '2016-08-01', '1003', '1');
INSERT INTO `cow` VALUES ('1004', '2', '1000', '2016-02-01', '90.0', '27.0', '2016-08-09', '1000', '2');
INSERT INTO `cow` VALUES ('1005', '1', '1000', '2016-02-03', '99.0', '60.0', '2016-08-09', '1000', '1');
INSERT INTO `cow` VALUES ('1006', '1', '1004', '2016-02-12', '66.0', '12.0', '2016-08-09', '1000', '1');
INSERT INTO `cow` VALUES ('1007', '1', '1009', '2016-02-09', '222.0', '123.0', '2016-08-09', '1003', '1');
INSERT INTO `cow` VALUES ('1008', '1', '1006', '2016-02-03', '224.0', '124.0', '2016-08-09', '1004', '1');
INSERT INTO `cow` VALUES ('1009', '2', '1000', '2016-02-09', '225.0', '123.0', '2016-08-09', '1000', '1');
INSERT INTO `cow` VALUES ('1010', '1', '1007', '2016-02-01', '222.0', '123.0', '2016-08-09', '1004', '1');
INSERT INTO `cow` VALUES ('1011', '2', '1005', '2016-08-09', '223.0', '21.0', '2017-02-01', '1000', '1');
INSERT INTO `cow` VALUES ('1012', '1', '1000', '2016-02-12', '444.0', '33.0', '2016-08-01', '1000', '1');
INSERT INTO `cow` VALUES ('1013', '1', '1000', '2016-02-09', '234.0', '123.0', '2016-08-01', '1005', '1');

-- ----------------------------
-- Table structure for `cow_category`
-- ----------------------------
DROP TABLE IF EXISTS `cow_category`;
CREATE TABLE `cow_category` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '品种编号',
  `categoryName` varchar(16) NOT NULL COMMENT '品种名称',
  `description` varchar(256) NOT NULL COMMENT '品种描述',
  `state` int(1) DEFAULT '0' COMMENT '类别状态：0：在用，1：不用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1012 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cow_category
-- ----------------------------
INSERT INTO `cow_category` VALUES ('1000', 'd11', 'd11', '1');
INSERT INTO `cow_category` VALUES ('1001', 'sd', 'ddd', '1');
INSERT INTO `cow_category` VALUES ('1002', 'sss', 'ssss', '0');
INSERT INTO `cow_category` VALUES ('1003', 'sss1', 'ssss1', '0');
INSERT INTO `cow_category` VALUES ('1004', 'gg', 'gg', '1');
INSERT INTO `cow_category` VALUES ('1005', 'zz', 'zz', '1');
INSERT INTO `cow_category` VALUES ('1006', 'qq', 'qq', '0');
INSERT INTO `cow_category` VALUES ('1007', 'ww', 'ww', '0');
INSERT INTO `cow_category` VALUES ('1008', 'rr', 'rr', '1');
INSERT INTO `cow_category` VALUES ('1009', '西杂', '西杂', '1');
INSERT INTO `cow_category` VALUES ('1010', 'dd', 'dd', '1');
INSERT INTO `cow_category` VALUES ('1011', 'gg', 'gg', '0');

-- ----------------------------
-- Table structure for `cow_house`
-- ----------------------------
DROP TABLE IF EXISTS `cow_house`;
CREATE TABLE `cow_house` (
  `houseId` int(4) NOT NULL AUTO_INCREMENT COMMENT '牛舍编号：四位：如000001',
  `cowCategory` int(4) NOT NULL COMMENT '牛品种编号',
  `cowManager` int(6) DEFAULT NULL COMMENT '牛舍管理员',
  `cowFeeder` int(6) DEFAULT NULL COMMENT '牛舍饲养员',
  `cowVeter` int(6) DEFAULT NULL COMMENT '责任兽医',
  `stock` int(3) NOT NULL DEFAULT '200' COMMENT '牛舍应存数量',
  `alredyStock` int(3) NOT NULL DEFAULT '0' COMMENT '已经有数量',
  `state` int(1) DEFAULT '0' COMMENT '状态 0：在用；1：未用',
  PRIMARY KEY (`houseId`)
) ENGINE=InnoDB AUTO_INCREMENT=1011 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cow_house
-- ----------------------------
INSERT INTO `cow_house` VALUES ('1000', '1001', '18', '20', '19', '200', '12', '0');
INSERT INTO `cow_house` VALUES ('1001', '1000', '9', '20', '19', '200', '21', '1');
INSERT INTO `cow_house` VALUES ('1002', '1001', '18', '15', '19', '200', '22', '1');
INSERT INTO `cow_house` VALUES ('1003', '1001', '18', '15', '19', '200', '22', '1');
INSERT INTO `cow_house` VALUES ('1004', '1005', '13', '20', '21', '2000', '0', '0');
INSERT INTO `cow_house` VALUES ('1005', '1000', '9', '20', '1', '200', '0', '0');
INSERT INTO `cow_house` VALUES ('1006', '1000', '9', '20', '1', '200', '0', '0');
INSERT INTO `cow_house` VALUES ('1007', '1000', '9', '20', '1', '200', '0', '0');
INSERT INTO `cow_house` VALUES ('1008', '1000', '9', '20', '1', '200', '12', '0');
INSERT INTO `cow_house` VALUES ('1009', '1000', '9', '20', '1', '200', '12', '0');
INSERT INTO `cow_house` VALUES ('1010', '1000', '9', '20', '1', '200', '0', '0');

-- ----------------------------
-- Table structure for `feeds`
-- ----------------------------
DROP TABLE IF EXISTS `feeds`;
CREATE TABLE `feeds` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '经办人',
  `feedid` int(4) NOT NULL COMMENT '饲料品种',
  `num` double(5,2) NOT NULL DEFAULT '0.00',
  `unit` varchar(12) DEFAULT '公斤' COMMENT '单位',
  `price` double(5,2) NOT NULL COMMENT '单价',
  `total` double(9,2) NOT NULL COMMENT '总金额',
  `manufacturer` varchar(32) NOT NULL COMMENT '生产厂家',
  `state` int(2) NOT NULL COMMENT '出库，还是入库；1：入库；2：出库',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feeds
-- ----------------------------
INSERT INTO `feeds` VALUES ('2', '杨双亮', '2', '4.00', '公斤', '2.00', '8.00', '上海饲料厂', '2');
INSERT INTO `feeds` VALUES ('3', '杨双亮', '2', '3.00', '公斤', '2.00', '6.00', '上海饲料厂', '2');
INSERT INTO `feeds` VALUES ('4', 'admin', '10', '1.00', '公斤', '12.00', '12.00', '北京饲料厂', '1');
INSERT INTO `feeds` VALUES ('5', 'admin', '1', '12.00', '公斤', '10.00', '120.00', '天津饲料厂', '2');
INSERT INTO `feeds` VALUES ('6', 'admin', '6', '12.00', '公斤', '10.00', '120.00', '天津饲料厂', '2');
INSERT INTO `feeds` VALUES ('7', 'admin', '1', '3.00', '公斤', '3.00', '9.00', '北京饲料厂', '1');
INSERT INTO `feeds` VALUES ('8', 'admin', '11', '2.00', '公斤', '2.00', '4.00', '上海饲料厂', '1');
INSERT INTO `feeds` VALUES ('9', 'admin', '11', '1.00', '公斤', '2.00', '2.00', '上海饲料厂', '1');
INSERT INTO `feeds` VALUES ('10', 'admin', '11', '1.00', '公斤', '2.00', '2.00', '上海饲料厂', '1');
INSERT INTO `feeds` VALUES ('11', 'admin', '10', '2.00', '公斤', '2.00', '4.00', '天津饲料厂', '1');
INSERT INTO `feeds` VALUES ('12', 'admin', '8', '2.00', '公斤', '2.00', '4.00', '河南饲料厂', '1');
INSERT INTO `feeds` VALUES ('13', 'admin', '10', '30.00', '公斤', '1.00', '30.00', '山东饲料厂', '1');
INSERT INTO `feeds` VALUES ('14', 'admin', '5', '12.00', '公斤', '1.00', '12.00', '天津饲料厂', '2');
INSERT INTO `feeds` VALUES ('15', 'admin', '5', '1.00', '公斤', '1.00', '1.00', '天津饲料厂', '1');
INSERT INTO `feeds` VALUES ('16', 'admin', '5', '12.00', '公斤', '1.00', '12.00', '天津饲料厂', '2');
INSERT INTO `feeds` VALUES ('17', 'admin', '4', '6.00', '公斤', '1.00', '6.00', '天津饲料厂', '2');

-- ----------------------------
-- Table structure for `feed_category`
-- ----------------------------
DROP TABLE IF EXISTS `feed_category`;
CREATE TABLE `feed_category` (
  `feedid` int(6) NOT NULL AUTO_INCREMENT,
  `feedname` varchar(32) NOT NULL COMMENT '饲料名称',
  `description` varchar(128) NOT NULL COMMENT '饲料品牌描述',
  `state` int(1) NOT NULL COMMENT '状态;0:在使用；1：为未使用',
  PRIMARY KEY (`feedid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feed_category
-- ----------------------------
INSERT INTO `feed_category` VALUES ('1', '饲料11', '饲料11', '0');
INSERT INTO `feed_category` VALUES ('2', '饲料2', '饲料2', '1');
INSERT INTO `feed_category` VALUES ('3', '饲料3', '饲料3', '1');
INSERT INTO `feed_category` VALUES ('4', '饲料4', '饲料4', '0');
INSERT INTO `feed_category` VALUES ('5', '饲料5', '饲料5', '0');
INSERT INTO `feed_category` VALUES ('6', 'ss1', 'ss1', '0');
INSERT INTO `feed_category` VALUES ('7', 'ss2', 'ss2', '0');
INSERT INTO `feed_category` VALUES ('8', 'ss3', 'ss3', '0');
INSERT INTO `feed_category` VALUES ('9', 'ss4', 'ss4', '0');
INSERT INTO `feed_category` VALUES ('10', 'ss5', 'ss5', '1');
INSERT INTO `feed_category` VALUES ('11', 'ss6', 'ss6', '0');

-- ----------------------------
-- Table structure for `record`
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `houseId` int(4) NOT NULL COMMENT '牛舍',
  `cowId` int(6) NOT NULL COMMENT '牛编号',
  `state` int(1) NOT NULL COMMENT '牛状态：1：配种；2:产犊；3:流产',
  `time` char(10) NOT NULL COMMENT '记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', '1000', '1000', '3', '2017-02-27');
INSERT INTO `record` VALUES ('2', '1002', '1002', '2', '2017-03-07');
INSERT INTO `record` VALUES ('3', '1003', '1007', '1', '2017-03-08');
INSERT INTO `record` VALUES ('4', '1003', '1004', '3', '2017-03-08');
INSERT INTO `record` VALUES ('5', '1000', '1005', '2', '2017-03-08');
INSERT INTO `record` VALUES ('6', '1000', '1003', '1', '2017-03-08');
INSERT INTO `record` VALUES ('7', '1000', '1006', '3', '2017-03-08');
INSERT INTO `record` VALUES ('8', '1004', '1008', '2', '2017-03-08');
INSERT INTO `record` VALUES ('9', '1000', '1005', '3', '2017-03-08');
INSERT INTO `record` VALUES ('10', '1000', '1009', '2', '2017-03-08');
INSERT INTO `record` VALUES ('11', '1000', '1009', '1', '2017-03-08');

-- ----------------------------
-- Table structure for `stock`
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键Id',
  `feedid` int(4) NOT NULL COMMENT '某种饲料Id',
  `quantity` double(8,2) NOT NULL COMMENT '数量',
  `feedname` varchar(32) NOT NULL COMMENT '饲料名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES ('1', '5', '13.00', '饲料5');
INSERT INTO `stock` VALUES ('2', '4', '50.00', '饲料4');
INSERT INTO `stock` VALUES ('3', '8', '2.00', 'ss3');
INSERT INTO `stock` VALUES ('4', '10', '30.00', 'ss5');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(6) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `name` varchar(32) NOT NULL COMMENT '姓名',
  `password` varchar(32) NOT NULL COMMENT '密码:初始密码：123456，MD5加密',
  `role` int(2) NOT NULL DEFAULT '1' COMMENT '角色：1：管理员，2：饲养员；3：兽医',
  `time` char(13) NOT NULL COMMENT '入职时间',
  `loginName` varchar(32) NOT NULL COMMENT '登陆用户名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '杨双亮', '123456', '3', '1488186796553', 'test');
INSERT INTO `user` VALUES ('9', 'admin', '123456', '1', '1477065600000', 'admin');
INSERT INTO `user` VALUES ('10', 'ysl', '123456', '1', '1477152000000', 'ysl');
INSERT INTO `user` VALUES ('11', 'admint', '123456', '1', '1477065600000', 'admin');
INSERT INTO `user` VALUES ('12', 'ysldd', '123456', '1', '1477152000000', 'ysl');
INSERT INTO `user` VALUES ('13', 'admin1', '123456', '1', '1477065600000', 'admin');
INSERT INTO `user` VALUES ('14', 'ysl12', '123456', '1', '1477152000000', 'ysl12');
INSERT INTO `user` VALUES ('15', 'admin2', '123456', '1', '1477065600000', 'admin');
INSERT INTO `user` VALUES ('16', 'ysl2', '123456', '1', '1477152000000', 'ysl');
INSERT INTO `user` VALUES ('18', 'zj3', 'zj', '1', '1487687889395', 'zj');
INSERT INTO `user` VALUES ('19', 'zj4', 'zj', '3', '1487687991452', 'zj');
INSERT INTO `user` VALUES ('20', 'ysl5', '123456', '2', '1487688042601', 'ysl');
INSERT INTO `user` VALUES ('21', 'ss6', '123456', '3', '1487688155727', 'ss');
INSERT INTO `user` VALUES ('22', '227', '123456', '2', '1487688420842', '22');
INSERT INTO `user` VALUES ('24', '44', '44', '3', '1487688478939', '44');
INSERT INTO `user` VALUES ('25', 'ww8', '123456', '2', '1487689693528', 'ww');
INSERT INTO `user` VALUES ('26', 'ss14', '123456', '1', '1487690170765', 'ss1');
INSERT INTO `user` VALUES ('27', 'ee4', 'ee', '2', '1487690181991', 'ee');
INSERT INTO `user` VALUES ('28', 'rr3', 'rr', '1', '1487690189038', 'rr');
INSERT INTO `user` VALUES ('29', 'ttss', 'ttss', '2', '1487690197746', 'ttss');
INSERT INTO `user` VALUES ('30', 'aa', 'aa', '2', '1488185694921', 'aa');
INSERT INTO `user` VALUES ('31', '杨双亮w', 'ysl', '1', '1488186187954', 'ysl');
INSERT INTO `user` VALUES ('32', '杨双亮e', '123456', '1', '1488187659317', '杨双亮');
