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

 Date: 21/07/2020 15:16:14
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
INSERT INTO `resume` VALUES ('2675d5c5-9ea3-44d2-8b3e-a608fd073132', '2', '2', '2', 2);
INSERT INTO `resume` VALUES ('379c779f-ad33-422f-8770-f56f3602e428', '44', '44', '44', 44);
INSERT INTO `resume` VALUES ('635139f2-2148-4ece-9f4a-76268653b89b', '万股', '12', '55', 4);

SET FOREIGN_KEY_CHECKS = 1;
