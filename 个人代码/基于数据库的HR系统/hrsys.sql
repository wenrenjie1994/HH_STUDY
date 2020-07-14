/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : hrsys

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 14/07/2020 13:18:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for resume
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume`  (
  `resume_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IDCard` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `school` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `process` int(2) NOT NULL,
  PRIMARY KEY (`resume_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resume
-- ----------------------------
INSERT INTO `resume` VALUES ('10051cc0-2ff5-4b15-8f3f-915c43cb2f5e', '1', '2', '2', 2);
INSERT INTO `resume` VALUES ('635139f2-2148-4ece-9f4a-76268653b89b', '万股', '12', '55', 4);
INSERT INTO `resume` VALUES ('71178992-25e4-4ce8-b713-c4023ae9a2d3', '3', '3', '3', 3);

SET FOREIGN_KEY_CHECKS = 1;
