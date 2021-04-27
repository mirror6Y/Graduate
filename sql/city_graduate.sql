/*
 Navicat Premium Data Transfer

 Source Server         : 147
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : city_graduate

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 16/02/2019 17:46:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_graduate
-- ----------------------------
DROP TABLE IF EXISTS `t_graduate`;
CREATE TABLE `t_graduate`  (
  `n_id` int(11) NOT NULL COMMENT '学号',
  `c_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `c_idCard` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号',
  `n_gender` tinyint(1) NULL DEFAULT NULL COMMENT '性别',
  `c_people` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '民族',
  `c_politicalStatus` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '政治面貌',
  `c_college` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '院系',
  `c_profession` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '专业',
  `c_grade` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '班级',
  `c_tel` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系方式',
  `d_graduateTime` date NULL DEFAULT NULL COMMENT '毕业时间',
  `c_education` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学历',
  `c_degree` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学位类别',
  `c_address` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '家庭地址',
  PRIMARY KEY (`n_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_graduate
-- ----------------------------
INSERT INTO `t_graduate` VALUES (201512031, '程宇浩', '', 1, '汉族', '共青团员', '', '软件工程', '1502', '', '2019-07-01', '本科', '学士', '安庆市');
INSERT INTO `t_graduate` VALUES (201512046, '刘野', '', 1, '汉族', '共青团员', '计算机工程学院', '软件工程', '1502', '18342224020', '2019-07-01', '本科', '学士', '铁岭市');

-- ----------------------------
-- Table structure for t_protocol
-- ----------------------------
DROP TABLE IF EXISTS `t_protocol`;
CREATE TABLE `t_protocol`  (
  `c_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `n_graduateId` int(9) NULL DEFAULT NULL COMMENT '毕业生学号',
  `c_unitId` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '单位统一社会信用代码',
  `c_fileRecUnit` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '档案接收单位名称',
  `c_fileRecAdd` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '档案接收单位地址',
  `c_contact` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系人',
  `c_zipCode` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮编',
  `c_accRecUnit` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '户口接收单位',
  `c_orgRecUnit` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '党、团组织关系接收单位',
  PRIMARY KEY (`c_id`) USING BTREE,
  INDEX `FK_Relationship_1`(`c_unitId`) USING BTREE,
  INDEX `FK_Relationship_2`(`n_graduateId`) USING BTREE,
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`c_unitId`) REFERENCES `t_unit` (`c_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`n_graduateId`) REFERENCES `t_graduate` (`n_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_protocol
-- ----------------------------
INSERT INTO `t_protocol` VALUES ('026F45EB0F53B8A914D2A4602D15FDB0', 201512046, '91210200051127124Q', '大连市甘井子区人才交流中心', '大连市甘井子区松江路19号', '人事代理部', '116030', '大连市甘井子区虹港路500号1-1', NULL);
INSERT INTO `t_protocol` VALUES ('ad11511762a14a248292be03e01f9c81', 201512031, '91210200241765653R', '大连市高新园区人才交流中心', '', '人事代理部', '', '', '');

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher`  (
  `n_id` int(16) NOT NULL COMMENT '工号\r\n',
  `c_password` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '123456' COMMENT '密码',
  `c_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `n_gender` tinyint(1) NULL DEFAULT NULL COMMENT '性别',
  `c_college` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '院系',
  `c_office` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '办公室',
  `c_tel` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系方式',
  `c_permission` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限',
  PRIMARY KEY (`n_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES (201212, '123456', '魏无羡', 1, '计算机工程学院', '1918', '15141224025', NULL);
INSERT INTO `t_teacher` VALUES (201213, '123456', '蓝忘机', 1, '计算机工程学院', '1918', '18341114200', '');

-- ----------------------------
-- Table structure for t_unit
-- ----------------------------
DROP TABLE IF EXISTS `t_unit`;
CREATE TABLE `t_unit`  (
  `c_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '统一社会信用代码',
  `c_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '单位名称',
  `c_address` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '通讯地址',
  `c_zipCode` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮编',
  `c_location` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '单位所在地',
  `c_contact` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系人',
  `c_contactTel` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_unit
-- ----------------------------
INSERT INTO `t_unit` VALUES ('91210200051127124Q', '华宇（大连）信息服务有限公司 ', '辽宁省大连市甘井子区金虹东路301号 ', '116039 ', '大连', '金男 ', '0411-39782287');
INSERT INTO `t_unit` VALUES ('91210200241765653R', '大连华信计算机技术股份有限公司', '辽宁省大连高新技术产业园区黄浦路977号', '116023', '大连', '张三', '');

SET FOREIGN_KEY_CHECKS = 1;
