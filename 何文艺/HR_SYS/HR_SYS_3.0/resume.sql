/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50648
Source Host           : localhost:3306
Source Database       : db

Target Server Type    : MYSQL
Target Server Version : 50648
File Encoding         : 65001

Date: 2020-07-13 10:38:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `resume`
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume` (
  `name` varchar(30) DEFAULT NULL,
  `id` varchar(30) NOT NULL DEFAULT '',
  `school` varchar(30) DEFAULT NULL,
  `process` int(11) DEFAULT NULL,
  `deleteStatus` int(11) DEFAULT NULL,
  `insert_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resume
-- ----------------------------
INSERT INTO `resume` VALUES ('hewenyi', '123456', '123456', '0', '1', null);
