/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : db_siakad

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 11/10/2019 22:08:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_mahasiswa
-- ----------------------------
DROP TABLE IF EXISTS `t_mahasiswa`;
CREATE TABLE `t_mahasiswa`  (
  `nim` char(7) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `nama` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `alamat` varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `jk` char(1) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`nim`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_mahasiswa
-- ----------------------------
INSERT INTO `t_mahasiswa` VALUES ('1212501', 'eko widodo', 'malang', 'L');
INSERT INTO `t_mahasiswa` VALUES ('1212502', 'eko cahyono', 'pasuruan', 'L');
INSERT INTO `t_mahasiswa` VALUES ('1212503', 'eko cahyadi', 'probolinggo', 'L');
INSERT INTO `t_mahasiswa` VALUES ('1212555', 'ernawati', 'pasuruan', 'P');
INSERT INTO `t_mahasiswa` VALUES ('1212556', 'tomojoyo', 'surabaya', 'L');
INSERT INTO `t_mahasiswa` VALUES ('1212567', 'erniwati setyo budi', 'malang', 'P');
INSERT INTO `t_mahasiswa` VALUES ('1212568', 'ernawati yuliet', 'banyuwangi', 'P');

SET FOREIGN_KEY_CHECKS = 1;
