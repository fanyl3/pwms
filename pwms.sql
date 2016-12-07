/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50401
Source Host           : localhost:3306
Source Database       : pwms

Target Server Type    : MYSQL
Target Server Version : 50401
File Encoding         : 65001

Date: 2016-12-07 15:34:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `ID` varchar(64) NOT NULL,
  `PERMISSION_NAME` varchar(64) DEFAULT NULL,
  `URL` varchar(255) DEFAULT NULL,
  `SORT` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '账号管理', '/system/userList.action', '10');

-- ----------------------------
-- Table structure for permission_rel
-- ----------------------------
DROP TABLE IF EXISTS `permission_rel`;
CREATE TABLE `permission_rel` (
  `ID` varchar(64) NOT NULL,
  `PERMISSION_REL_ID` varchar(64) DEFAULT NULL,
  `PERMISSION_ID` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_rel
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` varchar(64) NOT NULL,
  `NAME` varchar(64) DEFAULT NULL,
  `USER_NAME` varchar(64) DEFAULT NULL,
  `STAFF_ID` varchar(64) DEFAULT NULL,
  `PHONE` varchar(11) DEFAULT NULL,
  `EMAIL` varchar(64) DEFAULT NULL,
  `SEX` int(1) DEFAULT NULL,
  `PASSWORD` varchar(64) DEFAULT NULL,
  `PERMISSION_REL_ID` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
