/*
Navicat MySQL Data Transfer

Source Server         : conn
Source Server Version : 50141
Source Host           : localhost:3306
Source Database       : maildb

Target Server Type    : MYSQL
Target Server Version : 50141
File Encoding         : 65001

Date: 2018-08-16 11:37:10
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `sys_mail`
-- ----------------------------
DROP TABLE IF EXISTS `sys_mail`;
CREATE TABLE `sys_mail` (
  `MailId` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(200) NOT NULL,
  `Content` varchar(500) NOT NULL,
  `CreateTime` date NOT NULL,
  `SenderId` int(11) NOT NULL,
  PRIMARY KEY (`MailId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_mail
-- ----------------------------
INSERT INTO `sys_mail` VALUES ('1', 'asdfasdf', 'asdfasdfsf', '2018-08-16', '6');

-- ----------------------------
-- Table structure for `sys_mail_recive`
-- ----------------------------
DROP TABLE IF EXISTS `sys_mail_recive`;
CREATE TABLE `sys_mail_recive` (
  `ReciverId` int(11) NOT NULL,
  `MailId` int(11) NOT NULL,
  `State` int(11) NOT NULL DEFAULT '0' COMMENT '0-未读；1-已读；9-已删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_mail_recive
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_users`
-- ----------------------------
DROP TABLE IF EXISTS `sys_users`;
CREATE TABLE `sys_users` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `Account` varchar(50) NOT NULL,
  `Pwd` varchar(50) NOT NULL,
  `State` int(11) NOT NULL DEFAULT '1' COMMENT '1-有效；0-无效',
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users
-- ----------------------------
INSERT INTO `sys_users` VALUES ('6', 'Mike', '202CB962AC59075B964B07152D234B70', '1');
INSERT INTO `sys_users` VALUES ('7', 'Jack', '202CB962AC59075B964B07152D234B70', '1');
INSERT INTO `sys_users` VALUES ('8', 'Tom', '202CB962AC59075B964B07152D234B70', '1');
INSERT INTO `sys_users` VALUES ('9', 'Jerry', '202CB962AC59075B964B07152D234B70', '1');
INSERT INTO `sys_users` VALUES ('10', 'Rose', '202CB962AC59075B964B07152D234B70', '1');
