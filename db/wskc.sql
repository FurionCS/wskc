/*
 Navicat Premium Data Transfer

 Source Server         : Ljfaliyun
 Source Server Type    : MySQL
 Source Server Version : 50634
 Source Host           : 123.207.231.196:3306
 Source Schema         : wskc

 Target Server Type    : MySQL
 Target Server Version : 50634
 File Encoding         : 65001

 Date: 09/11/2017 17:31:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_brand_info
-- ----------------------------
DROP TABLE IF EXISTS `t_brand_info`;
CREATE TABLE `t_brand_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '品牌表',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '品牌名字',
  `industry_id` int(11) NOT NULL COMMENT '所属行业id',
  `company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '品牌所属公司',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '记录创建时间',
  `least_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `industry_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行业名称',
  `status` int(11) NULL DEFAULT 1 COMMENT '状态(1:正常,0停用,2:s审核中)',
  `creater_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sql1`(`industry_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_brand_info
-- ----------------------------
INSERT INTO `t_brand_info` VALUES (1, '贴贴艾', 8, '广州', '2017-01-24 15:40:29', '2017-01-25 15:40:35', '保健与卫生', 1, 1);
INSERT INTO `t_brand_info` VALUES (2, 'NewBalance', 9, 'NewBalance', '2017-01-24 14:39:38', '2017-01-25 14:39:43', '生活', 1, 1);
INSERT INTO `t_brand_info` VALUES (3, '蒙牛纯牛奶', 6, '中国蒙牛乳业有限公司', '2017-01-19 14:42:39', '2017-01-25 14:42:44', '餐饮', 1, 1);
INSERT INTO `t_brand_info` VALUES (4, '肾宝', 8, '广州制药', '2017-01-27 15:14:03', '2017-01-27 15:14:03', '保健与卫生', 2, 1);
INSERT INTO `t_brand_info` VALUES (5, '溪秀', 7, '广州溪秀生物科技有限责任公司', '2017-02-07 10:05:07', '2017-02-07 10:05:07', '护理美容', 1, 1);
INSERT INTO `t_brand_info` VALUES (6, '纤芊酵素', 1, '广州晨雅', '2017-02-15 18:07:31', '2017-02-15 18:07:31', '	互联网', 1, 8);
INSERT INTO `t_brand_info` VALUES (7, '伊丽莎白', 7, '伊丽莎白公司', '2017-04-09 20:08:23', '2017-04-09 20:08:23', '护理美容', 1, 1);
INSERT INTO `t_brand_info` VALUES (8, 'ck', 7, 'ck', '2017-05-03 08:57:34', '2017-05-03 08:57:34', '护理美容', 1, 1);
INSERT INTO `t_brand_info` VALUES (9, '海飞丝', 7, '宝洁', '2017-05-03 21:16:39', '2017-05-03 21:16:39', '护理美容', 1, 2);
INSERT INTO `t_brand_info` VALUES (10, '思科', 3, '思科', '2017-05-05 21:12:17', '2017-05-05 21:12:17', 'IT硬件与设备', 1, 1);
INSERT INTO `t_brand_info` VALUES (11, '华为', 3, '华为', '2017-05-05 21:21:27', '2017-05-05 21:21:27', 'IT硬件与设备', 1, 1);
INSERT INTO `t_brand_info` VALUES (12, '伊丽莎白', 7, '伊丽莎白', '2017-06-23 22:52:09', '2017-06-23 22:52:09', '护理美容', 1, 1);
INSERT INTO `t_brand_info` VALUES (13, 'AHC', 7, 'AHC', '2017-06-23 22:55:16', '2017-06-23 22:55:16', '护理美容', 1, 1);
INSERT INTO `t_brand_info` VALUES (14, 'CPB', 7, '去去去', '2017-06-24 10:53:03', '2017-06-24 10:53:03', '护理美容', 1, 1);

-- ----------------------------
-- Table structure for t_industry_info
-- ----------------------------
DROP TABLE IF EXISTS `t_industry_info`;
CREATE TABLE `t_industry_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '行业表',
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '行业名称',
  `user_num` int(11) NOT NULL DEFAULT 0 COMMENT '行业下用户数',
  `brand_num` int(11) NOT NULL DEFAULT 0 COMMENT '行业下的品牌数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_industry_info
-- ----------------------------
INSERT INTO `t_industry_info` VALUES (1, '	互联网', 2, 0);
INSERT INTO `t_industry_info` VALUES (2, 'IT软件与服务', 0, 0);
INSERT INTO `t_industry_info` VALUES (3, 'IT硬件与设备', 0, 0);
INSERT INTO `t_industry_info` VALUES (4, '通信与运营商', 0, 0);
INSERT INTO `t_industry_info` VALUES (5, '	网络游戏', 0, 0);
INSERT INTO `t_industry_info` VALUES (6, '餐饮', -1, 0);
INSERT INTO `t_industry_info` VALUES (7, '护理美容', 6, 1);
INSERT INTO `t_industry_info` VALUES (8, '保健与卫生', 6, 1);
INSERT INTO `t_industry_info` VALUES (9, '生活', 0, 0);
INSERT INTO `t_industry_info` VALUES (10, '其它', 0, 0);

-- ----------------------------
-- Table structure for t_industry_user
-- ----------------------------
DROP TABLE IF EXISTS `t_industry_user`;
CREATE TABLE `t_industry_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '行业表id',
  `industry_id` int(11) NULL DEFAULT NULL COMMENT '行业id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `create_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` date NULL DEFAULT NULL COMMENT '修改时间',
  `modify_num` int(11) NULL DEFAULT 0 COMMENT '修改次数',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `iu1`(`user_id`, `industry_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_industry_user
-- ----------------------------
INSERT INTO `t_industry_user` VALUES (10, 8, 1, '2017-01-24', '2017-01-24', 0);
INSERT INTO `t_industry_user` VALUES (15, 7, 1, '2017-02-07', '2017-02-07', 0);
INSERT INTO `t_industry_user` VALUES (16, 7, 2, '2017-02-08', '2017-02-08', 0);
INSERT INTO `t_industry_user` VALUES (18, 7, 3, '2017-02-08', '2017-02-08', 0);
INSERT INTO `t_industry_user` VALUES (19, 8, 3, '2017-02-08', '2017-02-08', 0);
INSERT INTO `t_industry_user` VALUES (20, 7, 4, '2017-02-08', '2017-02-08', 0);
INSERT INTO `t_industry_user` VALUES (21, 8, 4, '2017-02-08', '2017-02-08', 0);
INSERT INTO `t_industry_user` VALUES (22, 7, 5, '2017-02-08', '2017-02-08', 0);
INSERT INTO `t_industry_user` VALUES (23, 8, 5, '2017-02-08', '2017-02-08', 0);
INSERT INTO `t_industry_user` VALUES (24, 8, 6, '2017-02-08', '2017-02-08', 0);
INSERT INTO `t_industry_user` VALUES (25, 7, 6, '2017-02-08', '2017-02-08', 0);
INSERT INTO `t_industry_user` VALUES (27, 1, 8, '2017-02-15', '2017-02-15', 0);
INSERT INTO `t_industry_user` VALUES (28, 1, 7, '2017-02-17', '2017-02-17', 0);
INSERT INTO `t_industry_user` VALUES (43, 8, 2, '2017-05-03', '2017-05-03', 0);
INSERT INTO `t_industry_user` VALUES (45, 1, 1, '2017-06-24', '2017-06-24', 0);

-- ----------------------------
-- Table structure for t_product_allocation
-- ----------------------------
DROP TABLE IF EXISTS `t_product_allocation`;
CREATE TABLE `t_product_allocation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '调拨单id',
  `allocation_no` varchar(17) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调拨单编号',
  `allocation_user_id` int(11) NOT NULL COMMENT '调拨人',
  `allocation_to` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '调给人',
  `brand_id` int(11) NULL DEFAULT NULL COMMENT '品牌id',
  `brand_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌名称',
  `product_id` int(11) NULL DEFAULT NULL COMMENT '产品id',
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `num` int(11) NOT NULL DEFAULT 1 COMMENT '数量',
  `counter_fee` double NOT NULL DEFAULT 0 COMMENT '手续费',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT ' 修改时间',
  `type` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型(调入,调出)',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_product_allocation
-- ----------------------------
INSERT INTO `t_product_allocation` VALUES (8, '20170208300300521', 1, 'cs', 5, '溪秀', 3, '小绿盒润颜修复蚕丝面膜', 19, 0, 5, '2017-02-08 14:16:32', '2017-02-08 14:16:32', '调出', '第一次测试');
INSERT INTO `t_product_allocation` VALUES (9, '20170208300100190', 1, '测试', 1, '贴贴艾', 1, '艾艾灸', 1, 0, 2, '2017-02-08 14:24:38', '2017-02-08 14:24:38', '调出', 'd');
INSERT INTO `t_product_allocation` VALUES (10, '20170208300200116', 1, '测试', 1, '贴贴艾', 2, '艾艾贴', 3, 0, 2, '2017-02-08 14:29:25', '2017-02-08 14:29:25', '调出', '第四次');
INSERT INTO `t_product_allocation` VALUES (11, '20170503300100122', 2, '佳妍', 1, '贴贴艾', 1, '艾艾灸', 2, 0, 5, '2017-05-03 21:30:01', '2017-05-03 21:30:01', '调入', '测试');
INSERT INTO `t_product_allocation` VALUES (12, '20170503300100110', 2, '测试', 1, '贴贴艾', 1, '艾艾灸', 10, 0, 5, '2017-05-03 21:30:38', '2017-05-03 21:30:38', '调出', '测试');
INSERT INTO `t_product_allocation` VALUES (13, '20170503300100154', 2, '程胜', 1, '贴贴艾', 1, '艾艾灸', 2, 0, 2, '2017-05-03 22:12:02', '2017-05-03 22:12:02', '调入', '程胜');
INSERT INTO `t_product_allocation` VALUES (14, '20170503300100132', 2, '测试', 1, '贴贴艾', 1, '艾艾灸', 2, 0, 2, '2017-05-03 22:24:59', '2017-05-03 22:24:59', '调入', '  谁');
INSERT INTO `t_product_allocation` VALUES (15, '20170503300100136', 2, '佳艳', 1, '贴贴艾', 1, '艾艾灸', 2, 0, 2, '2017-05-03 22:31:25', '2017-05-03 22:31:25', '调入', '测试');

-- ----------------------------
-- Table structure for t_product_info
-- ----------------------------
DROP TABLE IF EXISTS `t_product_info`;
CREATE TABLE `t_product_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品表id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `code` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品编号',
  `size` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格',
  `unit` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位',
  `brand_id` int(11) NULL DEFAULT NULL COMMENT '品牌id',
  `create_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `least_time` date NULL DEFAULT NULL COMMENT '修改时间',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `least_user_id` int(11) NULL DEFAULT NULL COMMENT '修改者id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_product_info
-- ----------------------------
INSERT INTO `t_product_info` VALUES (1, '艾艾灸', '123456', '小', '盒', 1, '2017-01-10', '2017-01-25', 1, 1);
INSERT INTO `t_product_info` VALUES (2, '艾艾贴', '654321', '4张', '盒', 1, '2017-01-31', '2017-01-31', 1, 0);
INSERT INTO `t_product_info` VALUES (3, '小绿盒润颜修复蚕丝面膜', '692344278595', '5片装', '盒', 5, '2017-02-07', '2017-02-07', 1, 0);
INSERT INTO `t_product_info` VALUES (4, '纤芊酵素', '6959576556562', '20', '盒', 6, '2017-02-15', '2017-02-15', 8, 0);

-- ----------------------------
-- Table structure for t_product_library
-- ----------------------------
DROP TABLE IF EXISTS `t_product_library`;
CREATE TABLE `t_product_library`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '出库表id',
  `library_user_id` int(11) NULL DEFAULT NULL COMMENT '出库人id',
  `library_no` varchar(17) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出库编号',
  `type` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出入类型',
  `brand_id` int(11) NULL DEFAULT NULL COMMENT '品牌id',
  `brand_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌名称',
  `product_id` int(11) NULL DEFAULT NULL COMMENT '产品id',
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `num` int(11) NULL DEFAULT NULL COMMENT '数量',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `price` double NOT NULL,
  `relevance_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_product_library
-- ----------------------------
INSERT INTO `t_product_library` VALUES (4, 1, '20170208400300579', '销售出库', 5, '溪秀', 3, '小绿盒润颜修复蚕丝面膜', 11, 2, '第一次测试', '2017-02-08 14:14:23', '2017-02-08 14:14:23', 100, '20170208500300525');
INSERT INTO `t_product_library` VALUES (5, 1, '20170208400300520', '调拨出库', 5, '溪秀', 3, '小绿盒润颜修复蚕丝面膜', 19, 2, '第二次出库', '2017-02-08 14:21:13', '2017-02-08 14:21:13', 100, '20170208300300521');
INSERT INTO `t_product_library` VALUES (6, 1, '20170214400100181', '销售出库', 1, '贴贴艾', 1, '艾艾灸', 6, 2, '测试', '2017-02-14 10:52:17', '2017-02-14 10:52:17', 59.74, '20170214500100142');
INSERT INTO `t_product_library` VALUES (7, 1, '20170214400200126', '销售出库', 1, '贴贴艾', 2, '艾艾贴', 10, 2, '测试', '2017-02-14 10:56:09', '2017-02-14 10:56:09', 98.03, '20170214500200175');
INSERT INTO `t_product_library` VALUES (8, 1, '20170409400100141', '销售出库', 1, '贴贴艾', 1, '艾艾灸', 6, 2, 'test', '2017-04-09 14:21:51', '2017-04-09 14:21:51', 76.59, '20170409500100114');
INSERT INTO `t_product_library` VALUES (9, 1, '20170409400300533', '销售出库', 5, '溪秀', 3, '小绿盒润颜修复蚕丝面膜', 4, 2, 'test', '2017-04-09 14:23:34', '2017-04-09 14:23:34', 50, '20170409500300545');
INSERT INTO `t_product_library` VALUES (10, 2, '20170503400100143', '调拨出库', 1, '贴贴艾', 1, '艾艾灸', 10, 2, '测试', '2017-05-03 22:34:45', '2017-05-03 22:34:45', 100, '20170503300100110');
INSERT INTO `t_product_library` VALUES (11, 2, '20170504400100130', '销售出库', 1, '贴贴艾', 1, '艾艾灸', 3, 2, '测试', '2017-05-04 09:55:20', '2017-05-04 09:55:20', 126.25, '20170504500100112');
INSERT INTO `t_product_library` VALUES (12, 1, '20170623400300597', '销售出库', 5, '溪秀', 3, '小绿盒润颜修复蚕丝面膜', 20, 2, 'test', '2017-06-23 23:06:32', '2017-06-23 23:06:32', 188.74, '20170623500300583');
INSERT INTO `t_product_library` VALUES (13, 1, '20170624400300532', '销售出库', 5, '溪秀', 3, '小绿盒润颜修复蚕丝面膜', 2, 2, '', '2017-06-24 10:59:12', '2017-06-24 10:59:12', 188.74, '20170624500300576');

-- ----------------------------
-- Table structure for t_product_storage
-- ----------------------------
DROP TABLE IF EXISTS `t_product_storage`;
CREATE TABLE `t_product_storage`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '入库表id',
  `storage_no` varchar(17) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入库编号',
  `type` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `brand_id` int(11) NULL DEFAULT NULL COMMENT '品牌id',
  `brand_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌名称',
  `product_id` int(11) NULL DEFAULT NULL COMMENT '产品id',
  `product_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `num` int(11) NULL DEFAULT NULL COMMENT '数量',
  `price` double NULL DEFAULT NULL COMMENT '单价',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `relevance_no` varchar(17) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '关联编号(采购编号,调拨编号)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_product_storage
-- ----------------------------
INSERT INTO `t_product_storage` VALUES (7, '20170208200300520', '采购入库', 5, '溪秀', 3, '小绿盒润颜修复蚕丝面膜', 10, 100, 2, '第一次溪秀入库', '2017-02-08 11:55:38', '2017-02-08 12:02:12', 1, '20170208100300548');
INSERT INTO `t_product_storage` VALUES (8, '20170208200300582', '采购入库', 5, '溪秀', 3, '小绿盒润颜修复蚕丝面膜', 10, 100, 2, '第一次入库测试', '2017-02-08 14:12:15', '2017-02-08 14:12:15', 1, '20170208100300517');
INSERT INTO `t_product_storage` VALUES (9, '20170208200100124', '采购入库', 1, '贴贴艾', 1, '艾艾灸', 30, 60, 2, '第五次测试', '2017-02-08 14:31:20', '2017-02-08 14:31:20', 1, '20170208100100181');
INSERT INTO `t_product_storage` VALUES (10, '20170214200200120', '采购入库', 1, '贴贴艾', 2, '艾艾贴', 30, 100, 2, '测试', '2017-02-14 10:54:24', '2017-02-14 10:54:24', 1, '20170214100200176');
INSERT INTO `t_product_storage` VALUES (11, '20170409200100129', '采购入库', 1, '贴贴艾', 1, '艾艾灸', 13, 100, 2, 'test', '2017-04-09 12:31:12', '2017-04-09 12:31:12', 1, '20170409100100124');
INSERT INTO `t_product_storage` VALUES (12, '20170409200100132', '采购入库', 1, '贴贴艾', 1, '艾艾灸', 5, 100, 2, 'test', '2017-04-09 13:21:08', '2017-04-09 13:21:08', 1, '20170409100100159');
INSERT INTO `t_product_storage` VALUES (13, '20170409200200128', '采购入库', 1, '贴贴艾', 2, '艾艾贴', 5, 100, 2, 'test', '2017-04-09 13:54:36', '2017-04-09 13:54:36', 1, '20170409100200172');
INSERT INTO `t_product_storage` VALUES (14, '20170409200300537', '采购入库', 5, '溪秀', 3, '小绿盒润颜修复蚕丝面膜', 7, 50, 2, 'test', '2017-04-09 14:19:49', '2017-04-09 14:19:49', 1, '20170409100300517');
INSERT INTO `t_product_storage` VALUES (15, '20170503200300546', '采购入库', 5, '溪秀', 3, '小绿盒润颜修复蚕丝面膜', 8, 100, 2, '五月测试', '2017-05-03 18:38:55', '2017-05-03 18:38:55', 1, '20170503100300553');
INSERT INTO `t_product_storage` VALUES (16, '20170503200100199', '采购入库', 1, '贴贴艾', 1, '艾艾灸', 14, 130, 2, '测试', '2017-05-03 21:27:30', '2017-05-03 21:27:30', 2, '20170503100100124');
INSERT INTO `t_product_storage` VALUES (17, '20170503200100198', '调拨入库', 1, '贴贴艾', 1, '艾艾灸', 2, 100, 2, '测试', '2017-05-03 22:32:48', '2017-05-03 22:32:48', 2, '20170503300100122');
INSERT INTO `t_product_storage` VALUES (18, '20170623200300525', '采购入库', 5, '溪秀', 3, '小绿盒润颜修复蚕丝面膜', 100, 200, 2, 'test1', '2017-06-23 23:03:38', '2017-06-23 23:03:38', 1, '20170623100300533');
INSERT INTO `t_product_storage` VALUES (19, '20170624200200119', '采购入库', 1, '贴贴艾', 2, '艾艾贴', 2, 100, 2, '', '2017-06-24 10:57:29', '2017-06-24 10:57:29', 1, '20170304100200146');

-- ----------------------------
-- Table structure for t_purchase_info
-- ----------------------------
DROP TABLE IF EXISTS `t_purchase_info`;
CREATE TABLE `t_purchase_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '采购表id',
  `purchase_no` varchar(17) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '采购编号20161219+0000+000+00',
  `product_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `product_id` int(11) NULL DEFAULT NULL COMMENT '产品id',
  `brand_id` int(11) NULL DEFAULT NULL COMMENT '品牌id',
  `brand_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌名称',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '采购人id',
  `price` double NULL DEFAULT NULL COMMENT '价格',
  `num` int(11) NULL DEFAULT NULL COMMENT '数量',
  `other_fee` double NULL DEFAULT 0 COMMENT '其他费用',
  `delivery_fee` double NULL DEFAULT NULL COMMENT '快递费',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `status` int(11) NULL DEFAULT NULL COMMENT '1:已收货2:未收货3:已退货4:部分退货',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_purchase_info
-- ----------------------------
INSERT INTO `t_purchase_info` VALUES (7, '20170208100300517', '小绿盒润颜修复蚕丝面膜', 3, 5, '溪秀', 1, 100, 10, 0, 0, '2017-02-08 14:07:05', '2017-02-08 14:07:05', 4, '第一次测试');
INSERT INTO `t_purchase_info` VALUES (8, '20170208100100181', '艾艾灸', 1, 1, '贴贴艾', 1, 60, 30, 0, 6, '2017-02-08 14:30:41', '2017-02-08 14:30:41', 4, '第五次测试');
INSERT INTO `t_purchase_info` VALUES (9, '20170208100200132', '艾艾贴', 2, 1, '贴贴艾', 1, 120, 10, 0, 0, '2017-02-08 14:33:44', '2017-02-08 14:33:44', 2, '测试');
INSERT INTO `t_purchase_info` VALUES (10, '20170214100200176', '艾艾贴', 2, 1, '贴贴艾', 1, 100, 30, 0, 5, '2017-02-14 10:53:41', '2017-02-14 10:53:41', 4, '测试');
INSERT INTO `t_purchase_info` VALUES (11, '20170304100200146', '艾艾贴', 2, 1, '贴贴艾', 1, 100, 2, 0, 5, '2017-03-04 09:29:42', '2017-03-04 09:29:42', 4, '三月测试');
INSERT INTO `t_purchase_info` VALUES (12, '20170409100100124', '艾艾灸', 1, 1, '贴贴艾', 1, 100, 13, 0, 0, '2017-03-09 12:30:22', '2017-03-09 12:30:22', 4, 'test');
INSERT INTO `t_purchase_info` VALUES (13, '20170409100100159', '艾艾灸', 1, 1, '贴贴艾', 1, 100, 5, 0, 0, '2017-04-09 13:19:52', '2017-04-09 13:19:52', 4, 'test');
INSERT INTO `t_purchase_info` VALUES (14, '20170409100200172', '艾艾贴', 2, 1, '贴贴艾', 1, 100, 5, 0, 0, '2017-04-09 13:53:51', '2017-04-09 13:53:51', 4, 'test');
INSERT INTO `t_purchase_info` VALUES (15, '20170409100300517', '小绿盒润颜修复蚕丝面膜', 3, 5, '溪秀', 1, 50, 7, 0, 0, '2017-04-09 14:19:31', '2017-04-09 14:19:31', 4, 'test');
INSERT INTO `t_purchase_info` VALUES (16, '20170503100300553', '小绿盒润颜修复蚕丝面膜', 3, 5, '溪秀', 1, 100, 8, 0, 10, '2017-05-03 10:58:18', '2017-05-03 10:58:18', 4, '五月测试');
INSERT INTO `t_purchase_info` VALUES (17, '20170503100100124', '艾艾灸', 1, 1, '贴贴艾', 2, 130, 14, 0, 10, '2017-05-03 21:22:07', '2017-05-03 21:22:34', 4, '测试');
INSERT INTO `t_purchase_info` VALUES (18, '20170623100300533', '小绿盒润颜修复蚕丝面膜', 3, 5, '溪秀', 1, 200, 100, 0, 0, '2017-06-23 23:01:25', '2017-06-23 23:02:03', 4, 'test1');

-- ----------------------------
-- Table structure for t_purchase_return
-- ----------------------------
DROP TABLE IF EXISTS `t_purchase_return`;
CREATE TABLE `t_purchase_return`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand_id` int(11) NULL DEFAULT NULL,
  `brand_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `delivery_fee` double NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `num` int(11) NOT NULL,
  `other_fee` double NULL DEFAULT NULL,
  `price` double NOT NULL,
  `product_id` int(11) NULL DEFAULT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `purchase_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `return_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NOT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_resource_info
-- ----------------------------
DROP TABLE IF EXISTS `t_resource_info`;
CREATE TABLE `t_resource_info`  (
  `id` int(11) NOT NULL COMMENT '资源表id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源许可',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接',
  `pid` int(11) NULL DEFAULT NULL COMMENT '父级资源',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态0:表示停用,1:启用',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_79ttd3p06vrcdhnld9mckdatv`(`pid`) USING BTREE,
  CONSTRAINT `FK_79ttd3p06vrcdhnld9mckdatv` FOREIGN KEY (`pid`) REFERENCES `t_resource_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_role_info
-- ----------------------------
DROP TABLE IF EXISTS `t_role_info`;
CREATE TABLE `t_role_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色表id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `sn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色代号',
  `role_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_role_resource`;
CREATE TABLE `t_role_resource`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色资源表id',
  `r_id` int(11) NULL DEFAULT NULL COMMENT '资源id',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_qie95ky0tnqn6cl36rd606yxo`(`role_id`) USING BTREE,
  INDEX `FK_qie96ky0tnqn6cl36rd606yxo`(`r_id`) USING BTREE,
  CONSTRAINT `FK_qie95ky0tnqn6cl36rd606yxo` FOREIGN KEY (`role_id`) REFERENCES `t_role_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_qie96ky0tnqn6cl36rd606yxo` FOREIGN KEY (`r_id`) REFERENCES `t_resource_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_sole_info
-- ----------------------------
DROP TABLE IF EXISTS `t_sole_info`;
CREATE TABLE `t_sole_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '销售表id',
  `sole_user_id` int(11) NULL DEFAULT NULL COMMENT '销售人id',
  `sole_no` varchar(17) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '销售编号',
  `type` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '普通零售' COMMENT '销售类型',
  `brand_id` int(11) NOT NULL COMMENT '品牌id',
  `brand_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌名称',
  `product_id` int(11) NOT NULL COMMENT '产品id',
  `product_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `num` int(11) NOT NULL DEFAULT 1 COMMENT '数量',
  `price` double NULL DEFAULT NULL COMMENT '价格',
  `other_fee` double NULL DEFAULT NULL COMMENT '其他费用',
  `delivery_fee` double NULL DEFAULT NULL COMMENT '快递费用',
  `fact_price` double NULL DEFAULT NULL COMMENT '实际价格',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL COMMENT '销售状态',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `customer` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_sole_info
-- ----------------------------
INSERT INTO `t_sole_info` VALUES (9, 1, '20170208500300525', '普通零售', 5, '溪秀', 3, '小绿盒润颜修复蚕丝面膜', 11, 100, 0, 0, 150, '2017-02-08 14:13:31', 4, '2017-02-08 14:13:31', '测试', '第一次测试');
INSERT INTO `t_sole_info` VALUES (10, 1, '20170214500100142', '普通零售', 1, '贴贴艾', 1, '艾艾灸', 6, 59.74, 0, 0, 112.5, '2017-02-14 10:51:30', 4, '2017-02-14 10:51:30', '程胜', '无备注');
INSERT INTO `t_sole_info` VALUES (11, 1, '20170214500200175', '普通代理', 1, '贴贴艾', 2, '艾艾贴', 10, 98.03, 0, 0, 150, '2017-02-14 10:55:40', 4, '2017-02-14 10:55:40', '测试', '无备注');
INSERT INTO `t_sole_info` VALUES (12, 1, '20170304500100116', '普通零售', 1, '贴贴艾', 1, '艾艾灸', 4, 59.74, 0, 0, 100, '2017-03-04 09:30:55', 2, '2017-03-04 09:30:55', '测试', '三月测试');
INSERT INTO `t_sole_info` VALUES (13, 1, '20170409500100114', '普通零售', 1, '贴贴艾', 1, '艾艾灸', 6, 76.59, 0, 0, 100, '2017-04-09 14:21:25', 4, '2017-04-09 14:21:25', 'cs', 'test');
INSERT INTO `t_sole_info` VALUES (14, 1, '20170409500300545', '普通零售', 5, '溪秀', 3, '小绿盒润颜修复蚕丝面膜', 4, 50, 0, 0, 130, '2017-04-09 14:22:59', 4, '2017-04-09 14:22:59', '程胜', 'test');
INSERT INTO `t_sole_info` VALUES (15, 2, '20170504500100112', '普通零售', 1, '贴贴艾', 1, '艾艾灸', 3, 126.25, 0, 10, 150, '2017-05-04 09:54:06', 4, '2017-05-04 09:54:44', '测试', '测试');
INSERT INTO `t_sole_info` VALUES (16, 1, '20170506500300598', '普通零售', 5, '溪秀', 3, '小绿盒润颜修复蚕丝面膜', 2, 86.36, 0, 0, 100, '2017-05-06 14:25:11', 2, '2017-05-06 14:25:11', '程胜', '程胜');
INSERT INTO `t_sole_info` VALUES (17, 1, '20170623500300583', '普通零售', 5, '溪秀', 3, '小绿盒润颜修复蚕丝面膜', 20, 188.74, 0, 0, 500, '2017-06-23 23:05:48', 4, '2017-06-23 23:05:48', 'cs', 'test');
INSERT INTO `t_sole_info` VALUES (18, 1, '20170624500300576', '普通零售', 5, '溪秀', 3, '小绿盒润颜修复蚕丝面膜', 2, 188.74, 0, 0, 200, '2017-06-24 10:58:35', 4, '2017-06-24 10:58:35', '', '无备注');

-- ----------------------------
-- Table structure for t_sole_return
-- ----------------------------
DROP TABLE IF EXISTS `t_sole_return`;
CREATE TABLE `t_sole_return`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand_id` int(11) NULL DEFAULT NULL,
  `brand_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `delivery_fee` double NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `num` int(11) NOT NULL,
  `other_fee` double NULL DEFAULT NULL,
  `price` double NOT NULL,
  `product_id` int(11) NULL DEFAULT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `return_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sole_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_user_brand_puser
-- ----------------------------
DROP TABLE IF EXISTS `t_user_brand_puser`;
CREATE TABLE `t_user_brand_puser`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户品牌上家表',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `brand_id` int(11) NULL DEFAULT NULL COMMENT '品牌id',
  `puser_id` int(11) NULL DEFAULT -1 COMMENT '上家id(-1表示暂无上家)',
  `auth_code` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '00000000' COMMENT '该用户的品牌授权码,用于绑定上下级关系',
  `create_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `puser_remark` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '无' COMMENT '上家备注',
  `brand_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌名称',
  `num` int(11) NULL DEFAULT 0 COMMENT '代理数量',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sql1`(`user_id`, `brand_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user_brand_puser
-- ----------------------------
INSERT INTO `t_user_brand_puser` VALUES (1, 1, 1, -1, '12432143111', '2017-01-17', '无', '贴贴艾', 2);
INSERT INTO `t_user_brand_puser` VALUES (14, 1, 5, -1, '15a166f431f', '2017-02-07', '无', '溪秀', 2);
INSERT INTO `t_user_brand_puser` VALUES (15, 2, 5, 1, '15a1d2bfa10', '2017-02-08', '程胜', '溪秀', 1);
INSERT INTO `t_user_brand_puser` VALUES (16, 3, 5, 2, '15a1d34f95b', '2017-02-08', '佳艳', '溪秀', 0);
INSERT INTO `t_user_brand_puser` VALUES (17, 3, 1, 1, '15a1d3604e3', '2017-02-08', '程胜', '贴贴艾', 0);
INSERT INTO `t_user_brand_puser` VALUES (18, 4, 5, 1, '15a1dd18a35', '2017-02-08', '程胜', '溪秀', 1);
INSERT INTO `t_user_brand_puser` VALUES (19, 4, 1, 1, '15a1dd276ae', '2017-02-08', '程胜', '贴贴艾', 1);
INSERT INTO `t_user_brand_puser` VALUES (20, 5, 5, -1, '15a1dd4479b', '2017-02-08', '无', '溪秀', 0);
INSERT INTO `t_user_brand_puser` VALUES (21, 6, 1, 4, '15a1dd92221', '2017-02-08', '孟璠', '贴贴艾', 0);
INSERT INTO `t_user_brand_puser` VALUES (22, 6, 5, 4, '15a1dda5ce8', '2017-02-08', '孟', '溪秀', 0);
INSERT INTO `t_user_brand_puser` VALUES (23, 8, 6, -1, '15a413e6f7c', '2017-02-15', '无', '纤芊酵素', 0);
INSERT INTO `t_user_brand_puser` VALUES (24, 1, 7, -1, '15b529dd944', '2017-04-09', '无', '伊丽莎白', 0);
INSERT INTO `t_user_brand_puser` VALUES (31, 2, 1, -1, '15bce76d8d2', '2017-05-03', '无', '贴贴艾', 0);
INSERT INTO `t_user_brand_puser` VALUES (34, 1, 9, -1, '15bf7e85ea9', '2017-05-11', '无', '海飞丝', 0);
INSERT INTO `t_user_brand_puser` VALUES (36, 1, 13, -1, '15cd7e50995', '2017-06-24', '无', 'AHC', 0);
INSERT INTO `t_user_brand_puser` VALUES (37, 1, 14, -1, '15cd804b7e4', '2017-06-24', '无', 'CPB', 0);

-- ----------------------------
-- Table structure for t_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  `openid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信openId',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `user_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '1:男2:女0:保密',
  `city` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市',
  `status` int(11) NULL DEFAULT NULL COMMENT '用户状态',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `least_time` datetime(0) NULL DEFAULT NULL COMMENT '最近登录时间',
  `user_nike` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '匿名' COMMENT '用户昵称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user_info
-- ----------------------------
INSERT INTO `t_user_info` VALUES (1, 'o9pbww7-CwheMiCL9yfgmqx4mOdQ', 'admin', '202cc9b0383b17524dc1086113e42c55', 'http://wx.qlogo.cn/mmopen/ibFB3Wvc2Sfb0MTTkoAtUodzadwtM3hC4utg2M6asBVfp1pJ3J9OGbb1GSD3icAasBiban5AALQYFKzJUG27RrbTu310gCn1SIc/0', '1115206778@qq.com', '保密', '衢州', 1, '2017-01-09 00:00:00', '2017-01-25 00:00:00', 'admin');

-- ----------------------------
-- Table structure for t_user_product_stock
-- ----------------------------
DROP TABLE IF EXISTS `t_user_product_stock`;
CREATE TABLE `t_user_product_stock`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '库存表id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `brand_id` int(11) NULL DEFAULT NULL COMMENT '品牌id',
  `product_id` int(11) NULL DEFAULT NULL COMMENT '产品id',
  `num` int(11) NULL DEFAULT NULL COMMENT '数量',
  `brand_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌名称',
  `product_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `status` int(11) NULL DEFAULT 1 COMMENT '1:正常0:停用',
  `total_money` double NULL DEFAULT NULL,
  `warn_num` int(11) NULL DEFAULT 1 COMMENT '警告库存',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sql1`(`user_id`, `brand_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user_product_stock
-- ----------------------------
INSERT INTO `t_user_product_stock` VALUES (2, 1, 1, 1, 37, '贴贴艾', '艾艾灸', '2017-01-31 00:00:00', '2017-04-09 14:21:52', 1, 2834.02, 1);
INSERT INTO `t_user_product_stock` VALUES (3, 1, 1, 2, 30, '贴贴艾', '艾艾贴', '2017-01-31 00:00:00', '2017-06-24 10:57:30', 1, 2954.7, 4);
INSERT INTO `t_user_product_stock` VALUES (4, 1, 5, 3, 89, '溪秀', '小绿盒润颜修复蚕丝面膜', '2017-02-07 10:44:17', '2017-06-24 10:59:12', 1, 16797.72, 12);
INSERT INTO `t_user_product_stock` VALUES (5, 2, 5, 3, 12, '溪秀', '小绿盒润颜修复蚕丝面膜', '2017-02-08 18:02:17', '2017-02-08 18:02:17', 1, 1200, 1);
INSERT INTO `t_user_product_stock` VALUES (6, 3, 5, 3, 3, '溪秀', '小绿盒润颜修复蚕丝面膜', '2017-02-08 18:31:17', '2017-02-08 18:31:17', 1, 300, 1);
INSERT INTO `t_user_product_stock` VALUES (7, 4, 5, 3, 5, '溪秀', '小绿盒润颜修复蚕丝面膜', '2017-02-08 21:03:00', '2017-02-08 21:03:00', 1, 500, 1);
INSERT INTO `t_user_product_stock` VALUES (8, 5, 5, 3, 20, '溪秀', '小绿盒润颜修复蚕丝面膜', '2017-02-08 21:06:13', '2017-02-08 21:06:13', 1, 2000, 1);
INSERT INTO `t_user_product_stock` VALUES (9, 6, 5, 3, 3, '溪秀', '小绿盒润颜修复蚕丝面膜', '2017-02-08 21:12:51', '2017-02-08 21:12:51', 1, 300, 1);
INSERT INTO `t_user_product_stock` VALUES (10, 6, 1, 2, 3, '贴贴艾', '艾艾贴', '2017-02-08 21:13:09', '2017-02-08 21:13:09', 1, 150, 1);
INSERT INTO `t_user_product_stock` VALUES (11, 4, 1, 1, 4, '贴贴艾', '艾艾灸', '2017-02-08 22:08:40', '2017-02-08 22:08:40', 1, 200, 1);
INSERT INTO `t_user_product_stock` VALUES (12, 4, 1, 2, 3, '贴贴艾', '艾艾贴', '2017-02-08 22:08:59', '2017-02-08 22:08:59', 1, 150, 1);
INSERT INTO `t_user_product_stock` VALUES (13, 3, 1, 2, 4, '贴贴艾', '艾艾贴', '2017-02-08 22:10:22', '2017-02-08 22:10:22', 1, 200, 1);
INSERT INTO `t_user_product_stock` VALUES (14, 8, 6, 4, 100, '纤芊酵素', '纤芊酵素', '2017-02-15 18:11:08', '2017-02-15 18:11:08', 1, 6500, 50);
INSERT INTO `t_user_product_stock` VALUES (15, 2, 1, 1, 13, '贴贴艾', '艾艾灸', '2017-05-03 21:19:48', '2017-05-04 09:55:20', 1, 1641.25, 11);

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色表id',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_4uvv76e86ms8ru0kk9s01d3s2`(`role_id`) USING BTREE,
  INDEX `FK_kefwen29p9h9ilvry31mgyc94`(`user_id`) USING BTREE,
  CONSTRAINT `FK_4uvv76e86ms8ru0kk9s01d3s2` FOREIGN KEY (`role_id`) REFERENCES `t_role_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_kefwen29p9h9ilvry31mgyc94` FOREIGN KEY (`user_id`) REFERENCES `t_user_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
