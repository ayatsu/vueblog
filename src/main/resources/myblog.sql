/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : myblog

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 04/01/2022 19:55:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for m_blog
-- ----------------------------
DROP TABLE IF EXISTS `m_blog`;
CREATE TABLE `m_blog`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `created` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint NOT NULL,
  `type` tinyint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100000026 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of m_blog
-- ----------------------------
INSERT INTO `m_blog` VALUES (10000001, 1, 'testTitle1', 'description1', 'content1', '2021-12-31 20:00:00', 0, 1);


-- ----------------------------
-- Table structure for m_user
-- ----------------------------
DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` int NOT NULL,
  `type` int NOT NULL,
  `created_time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of m_user
-- ----------------------------
INSERT INTO `m_user` VALUES (1, 'ayatsu', 'admin', '6790cd36c595a0493418265cdf69fa48', 0, 0, '2021-12-31 20:00:00');
INSERT INTO `m_user` VALUES (2, 'jua', 'jua', 'eb12ff5d474a5093d124c447eebe3342', 0, 0, '2021-12-31 20:00:00');
INSERT INTO `m_user` VALUES (3, 'nuklfest', 'nuklfest', 'e074067ef100fcecd739298f7e949cda', 0, 1, '2021-12-31 20:00:00');
INSERT INTO `m_user` VALUES (4, 'kacchan', 'kacchan', 'e074067ef100fcecd739298f7e949cda', 0, 1, '2021-12-31 20:00:00');
INSERT INTO `m_user` VALUES (6, '992861399', 'QQ992861399', '43cb5dc176c2a340f388a4e8b3ecb8c4', 0, 2, '2022-01-07 17:00:00');
INSERT INTO `m_user` VALUES (7, '136435561', 'QQ136435561', 'c2a4bed10d619f0b8f192482309eabd9', 0, 2, '2022-01-07 23:00:00');
INSERT INTO `m_user` VALUES (8, 'smdk', 'simodike', '526dd36303506a7953d5d97e5589c26c', 0, 2, '2022-01-08 19:00:00');
INSERT INTO `m_user` VALUES (9, '1830783912', 'QQ1830783912', '965685b84a24e17863d7417a92da87bf', 0, 2, '2022-01-12 19:00:00');
INSERT INTO `m_user` VALUES (10, '616748093', 'QQ616748093', 'e974701188603093eb31239ae6d3d8d9', 0, 2, '2022-01-14 10:00:00');

UPDATE m_blog SET created='2022-01-16 15:30:00' WHERE id='10000009'
DELETE FROM `m_user` WHERE username='tempvisitor';
SET FOREIGN_KEY_CHECKS = 1;
