/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : how2java

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2017-12-27 10:40:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category_`
-- ----------------------------
DROP TABLE IF EXISTS `category_`;
CREATE TABLE `category_` (
  `id` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category_
-- ----------------------------
INSERT INTO `category_` VALUES ('2', 'category2');
INSERT INTO `category_` VALUES ('3', 'category3');
INSERT INTO `category_` VALUES ('4', 'category4');
INSERT INTO `category_` VALUES ('5', 'category5');
INSERT INTO `category_` VALUES ('6', 'category6');
INSERT INTO `category_` VALUES ('7', 'category7');
INSERT INTO `category_` VALUES ('10', 'cc');
INSERT INTO `category_` VALUES ('11', 'cc');
INSERT INTO `category_` VALUES ('12', 'cc');
INSERT INTO `category_` VALUES ('13', 'cc');
INSERT INTO `category_` VALUES ('14', 'ccbb');
INSERT INTO `category_` VALUES ('15', 'ccbb');
INSERT INTO `category_` VALUES ('19', 'ccbb');
INSERT INTO `category_` VALUES ('20', 'asdfasdf');
INSERT INTO `category_` VALUES ('25', 'hiss');
INSERT INTO `category_` VALUES ('10000', 'ccbb');
INSERT INTO `category_` VALUES ('10001', 'asdf');
INSERT INTO `category_` VALUES ('1003648', 'asdf');
