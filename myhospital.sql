/*
 Navicat Premium Dump SQL

 Source Server         : MySql
 Source Server Type    : MySQL
 Source Server Version : 80402 (8.4.2)
 Source Host           : localhost:3306
 Source Schema         : myhospital

 Target Server Type    : MySQL
 Target Server Version : 80402 (8.4.2)
 File Encoding         : 65001

 Date: 19/08/2024 23:00:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_doctor
-- ----------------------------
DROP TABLE IF EXISTS `t_doctor`;
CREATE TABLE `t_doctor`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sub_id` int NULL DEFAULT NULL,
  `about` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `education` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `work_date` date NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT NULL,
  `photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `money` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_doctor
-- ----------------------------
INSERT INTO `t_doctor` VALUES (1, '王海花', '女', 3, '科副主任，主任医师。1987年毕业于浙江医科大学口腔医学专业，曾赴浙一医院进修，北京BITC口腔种植中心深造。担任中华口腔医学会口腔修复及口腔种植会员，浙江省口腔修复委员会委员，绍兴市口腔质控中心委员，绍兴市口腔中西医结合副主任委员。 ', '本科学士', '2012-11-14', '14574478857', '/pic/images/1723685401658.png', '主任医师', 20.00);
INSERT INTO `t_doctor` VALUES (2, '阮土耿', '男', 5, '主任医师。1984年参加工作，2002年毕业于温州医科大学，本科学历，1996年赴浙一医院进修口腔颌面外科，2016年赴上海参加Straumann种植高级培训。', '本科学士', '2015-11-30', '14574478857', '/pic/images/1723623849635.jpg', '主任医师', 20.00);
INSERT INTO `t_doctor` VALUES (3, '陈伟', '男', 6, '科主任，绍兴市医学重点学科带头人，主任医师，硕士生导师。1992年毕业于浙江医科大学，2004年获浙江大学医学院眼科学硕士学位。浙江省医师协会眼科分会常务委员、绍兴市医师协会眼科医师分会会长、绍兴市中西医结合学会眼科专业委员会副主任委员。曾在德国弗莱堡大学附属圣文森特医院、英国皇家自由医院研修。', '硕士研究生', '2014-12-02', '14574478857', '/pic/images/1723623858313.png', '主任医师', 15.00);
INSERT INTO `t_doctor` VALUES (4, '王琼', '女', 6, '副主任医师，2005年获温州医科大学眼视光学士学位，2009年获温州医科大学眼科硕士学位，从事眼科临床工作十多年，有丰富的临床经验，曾赴上海复旦大学附属眼耳鼻喉科医院进修学习眼科各亚专业疾病的诊断和治疗。', '本科学士', '2016-12-07', '14574478857', '/pic/images/1723623863499.png', '副主任医师', 25.00);
INSERT INTO `t_doctor` VALUES (5, '刘平', '男', 11, '科室学科带头人。大学本科，主任医师，中国中西结合学会鼻-鼻窦炎专家委员会委员，浙江省医师协会耳鼻咽喉科医学专委会委员，绍兴市医学会耳鼻咽喉科专业委员会副主任委员，曾先后在中山医科大第三附属医院、浙江大学附属第二医院、中国医学科学院肿瘤医院进修学习，先后发表国内外论文10余篇，主持参与市级课题研究数项。', '本科学士', '2015-12-08', '14574478857', '/pic/images/1723623870294.jpg', '主任医师', 30.00);
INSERT INTO `t_doctor` VALUES (6, '钱宇', '男', 11, '副院长兼骨科学科带头人，绍兴文理学院医学院副院长，教授、主任医师，浙江大学医学院博士生导师。1994年毕业于浙江医科大学，2009年获澳大利亚西澳大学博士学位。中华医学会骨科分会青年委员，浙江省医学会骨科分会常委、浙江省医师协会骨科分会常委，省康复学会脊柱脊髓损伤委员会常委，绍兴市医学会骨科分会主任委员，绍兴市医师协会骨科分会会长。', '博士研究生', '2014-12-10', '14574478857', '/pic/images/1723623878846.jpg', '主任医师', 35.00);
INSERT INTO `t_doctor` VALUES (7, '何磊', '男', 20, '浙江省康复医学会脊柱微创学组委员，绍兴市医学会骨科分会脊柱组委员。先后赴英国格罗斯特皇家医院，德国纽伦堡大学附属圣玛利安医院，荷兰埃文斯大学访问学习，主要从事各种颈肩痛腰腿痛及四肢骨折创伤的诊断治疗，尤其擅长椎间孔镜下腰椎间盘突出症的微创治疗以及老年性骨质疏松引起的胸腰椎骨折和髋部骨折的微创化手术治疗。', '硕士研究生', '2015-12-01', '14574478857', '/pic/images/1723623900674.png', '副主任医师', 50.00);
INSERT INTO `t_doctor` VALUES (8, '张凯杰', '男', 9, '主任医师。1985年毕业于上海第二军医大学，获学士学位，2002年赴上海长海医院进修消化内镜治疗及ERCP术。现任绍兴市消化专业委员会委员。', '本科学士', '2013-12-09', '14574478857', '/pic/images/1723623885426.jpeg', '主任医师', 15.00);
INSERT INTO `t_doctor` VALUES (9, '秦月花', '女', 9, '中国中西医结合学会疼痛专业委员会癌痛专委会委员；长期从事临床消化科工作，曾先后赴上海长海医院、浙江大学附属第一医院消化科进修；', '硕士研究生', '2016-12-07', '14574478857', '/pic/images/1723623907698.jpg', '主任医师', 15.00);
INSERT INTO `t_doctor` VALUES (10, '罗文文', '女', 9, '副主任医师，毕业于浙江大学医学院。', '本科学士', '2015-12-09', '14574478857', '/pic/images/1723623914321.jpg', '副主任医师', 15.00);
INSERT INTO `t_doctor` VALUES (13, '王撒旦', '男', 5, '笑医生', '初中', '2009-10-01', '1516161651', '/pic/images/1723515909041.jpeg', '医师', 15.00);

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `pat_id` int NULL DEFAULT NULL,
  `sch_id` int NULL DEFAULT NULL,
  `status` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_croatian_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (1, 1, 1, '已取消', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (2, 2, 2, '已取消', 'DSFAFF啊虽然个人风格');
INSERT INTO `t_order` VALUES (3, 2, 3, '待叫号', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (4, 2, 4, '已完成', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (5, 2, 5, '已取消', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (6, 3, 6, '待叫号', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (7, 4, 5, '待叫号', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (8, 4, 5, '已完成', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (9, 5, 5, '已取消', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (10, 6, 5, '已取消', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (11, 5, 1, '已取消', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (12, 2, 2, '已完成', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (13, 2, 3, '待叫号', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (14, 2, 4, '已取消', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (15, 2, 5, '待叫号', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (16, 2, 1, '已完成', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (17, 2, 2, '已取消', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (18, 2, 3, '已取消', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (19, 3, 4, '已取消', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (20, 2, 5, '待叫号', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (21, 2, 1, '已取消', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (22, 2, 2, '已完成', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (23, 2, 3, '待叫号', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (24, 2, 4, '已取消', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (25, 2, 5, '已取消', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (26, 4, 1, '已完成', '隧道股份公司公司G');
INSERT INTO `t_order` VALUES (27, 4, 1, '已完成', 'afafaa');
INSERT INTO `t_order` VALUES (28, 4, 1, '已完成', 'afafaa');
INSERT INTO `t_order` VALUES (31, 4, 1, '已完成', 'afafaa');
INSERT INTO `t_order` VALUES (32, 1, 6, '已取消', '预约挂号测试');
INSERT INTO `t_order` VALUES (33, 1, 2, '已取消', '预约挂号测试');
INSERT INTO `t_order` VALUES (34, 1, 2, '已取消', '预约挂号测试');
INSERT INTO `t_order` VALUES (35, 1, 1, '已取消', '预约挂号测试');
INSERT INTO `t_order` VALUES (36, 1, 1, '已取消', '预约挂号测试');

-- ----------------------------
-- Table structure for t_patient
-- ----------------------------
DROP TABLE IF EXISTS `t_patient`;
CREATE TABLE `t_patient`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `id_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `birth` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `mobile`(`phone` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_patient
-- ----------------------------
INSERT INTO `t_patient` VALUES (1, '18970277614', 'fEIGraNc8pBew/HmTME+gIgcy678hwbiappphCWziuBnH7ekAyUouFu2ZpBSQT+c', '/pic/images/1723685681024.jpg', '胡小小', '男', '42039591948218894X', '是的人反感的是法国是的人反感的是法国是的人反感的是法国是的人反感的是法国是的人反感的是法国是的人反感的是法国是的人反感的是法国是的人反感的是法国是的人反感的是法国是的人反感的是法国', '2024-08-17');
INSERT INTO `t_patient` VALUES (2, '17859654125', 'bB0k2AEmk7mhk4XluDN/OFOzzUYu1RgOUjaWEFrBEuyPAq4hXgOSknfivf10jzY0', '/pic/images/1723685529117.png', '李四', '男', '42039591948218894X', '222', '2024-08-24');
INSERT INTO `t_patient` VALUES (3, '17859654121', '6xxxsrJf2f/J9Bx3OsmEumESjyBefwhzieOV2uclyVvZwwbBk3UCugvpL3qttGs+', '/pic/images/1723685546541.jpg', '孙小美', '女', '42039591948218894X', '是的人反感的是法国是的人反感的是法国是的人反感的是法国是的人反感的是法国是的人反感的是法国是的人反感的是法国是的人反感的是法国是的人反感的是法国是的人反感的是法国是的人反感的是法国', '2024-08-17');
INSERT INTO `t_patient` VALUES (4, '173242424234', 'Lcqdk8IE4yxMPGqLVA3oejp3t3HiqhERhyaDE1w8NplNUbE0pv+3vKjnSKkuMLgR', '/pic/images/1723685718828.png', '王丽', '男', '42039591948218894X', 'zdcasdfsaf', '2024-08-03');
INSERT INTO `t_patient` VALUES (5, '1212313123', 'g7iRCJ5gn3iSE+TUM0IkEp/67ueNijn50H5MnqaO7pT1H9TT+XxZ1pVF67PcEXQL', '/pic/images/1723686194805.jpg', '阿萨', '女', '5189149198918', '的方式发顺丰', '2024-08-17');
INSERT INTO `t_patient` VALUES (6, '1324234', 'nkVPyC2Z3kzKaZp6BwG0dYnGsk9YXUPHdlAQ+0s8lVcQFIlLde2RrQ2DHjZIum6k', '/pic/images/1723686293813.jpg', '士大夫', '男', '5641911889', '阿尔法', '2024-08-10');

-- ----------------------------
-- Table structure for t_schedule
-- ----------------------------
DROP TABLE IF EXISTS `t_schedule`;
CREATE TABLE `t_schedule`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `doctor_id` int NULL DEFAULT NULL,
  `work_time` date NULL DEFAULT NULL,
  `count` int NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_schedule
-- ----------------------------
INSERT INTO `t_schedule` VALUES (1, 1, '2024-08-13', 8, '啊F爱上法网法网法网示范区');
INSERT INTO `t_schedule` VALUES (2, 1, '2024-08-12', 13, '撒旦法发挖坟挖坟');
INSERT INTO `t_schedule` VALUES (3, 2, '2024-08-21', 15, '阿斯蒂芬挖法违法');
INSERT INTO `t_schedule` VALUES (4, 10, '2024-08-13', 10, '案说法大大撒旦');
INSERT INTO `t_schedule` VALUES (5, 5, '2024-08-18', 15, '');
INSERT INTO `t_schedule` VALUES (6, 8, '2024-08-19', 14, '');
INSERT INTO `t_schedule` VALUES (7, 7, '2024-08-20', 10, '');
INSERT INTO `t_schedule` VALUES (9, 1, '2024-08-20', 10, '移动端');

-- ----------------------------
-- Table structure for t_subject
-- ----------------------------
DROP TABLE IF EXISTS `t_subject`;
CREATE TABLE `t_subject`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sub_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '科室代码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '科室名称',
  `duty_doctor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '责任医师',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '备注',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `create_time` date NULL DEFAULT NULL COMMENT '成立日期',
  `about` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '科室介绍',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1025 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_subject
-- ----------------------------
INSERT INTO `t_subject` VALUES (2, 'A02', '呼吸内科', '沈巨', '开展了多项基础研究和临床工作，完成省卫生厅重点推广项目及绍兴市多个科研项目，绍兴市科学技术进步一、二、三等奖多次。在国内外各级学术杂志发表学术论文数十篇，近年来已在中华、国家级等核心期刊发表论文40余篇，获得省、市自然科学优秀论文奖一、二等奖多次。', '24楼', '2015-10-28', '始建于20世纪60年代，80年代初组建呼吸科，经过多年不断的发展，成为绍兴市重点学科，浙江省浙东地区区域专病中心，中国肺癌防治联盟肺结节诊治基层分中心，国家GMP临床药物试验认证机构呼吸专业组，是一个以呼吸病临床医学为主，医疗、教学、科研相结合的专业性学科。开设呼吸专家门诊、专科门诊，哮喘、慢性咳嗽、肺结节、介入、戒烟等专病门诊。学科目前拥有两个病区，70张床位，主任医师五名，博士研究生一名，硕士研究生10余名。在绍兴最早开展及推广标准化的临床肺功能测定、呼吸危重症诊治、阻塞性睡眠呼吸障碍诊治，率先开展肺癌的早期诊断及多学科综合诊治，慢性气道疾病及肺部感染性疾病的规范化诊治，纤维支气管镜、胸腔镜的介入诊疗。拥有规模齐全的肺功能室，呼吸内镜室，睡眠呼吸监测室，配置高端的奥林巴斯电子支气管镜，超声电子支气管镜，冷冻仪，虚拟导航，内科胸腔镜及各种镜下介入诊治设备，配备综合肺功能诊断系统，纳库伦呼出气NO、CO检测仪，呼吸机，高流量吸氧机以及智能化的多导睡眠监测仪，可全面开展呼吸专科领域的各种诊断、治疗技术。');
INSERT INTO `t_subject` VALUES (3, 'A03', '放射科', '赵振华', '开展了多项基础研究和临床工作，近年来已在SCI、中华医学系列杂志等核心期刊发表论文79篇，获得省、市自然科学优秀论文奖多项。承担、完成卫生部、绍兴市科技局科研项目11项，省卫生厅、绍兴市重点推广项目3项目，获浙江省医药卫生科技创新二、三等奖多次', '40楼', '2021-11-23', '绍兴市人民医院放射科是绍兴地区实力最雄厚的放射影像中心，是集医疗、教学、科研于一体的专业性临床学科，省市医学重点学科，市级医学领先学科，是绍兴市医学影像会诊中心所在科室。放射科是浙江大学和绍兴文理学院硕士研究生培养基地，浙江大学医学院、温州医科大学、绍兴文理学院医学院的临床教育基地，也是国家级住院医师规范化培训放射专业基地和核医学基地，承担医学影像专业的临床教学、培训任务。');
INSERT INTO `t_subject` VALUES (4, 'A04', '输血科', '杨国灿', '科室现有在职专业技术人员12人，其中高级职称4人，具硕士学历3人，多人曾在上级医院进修，硕士研究生导师1名。每年接受相关专业规培生、进修生、实习生20多名；主办国家、省、市级继教项目多项。所有人员均具备输血、检验、医疗等专业知识，并接受输血相关理论和实践技能的培训和考核。', '7室', '2022-04-22', '输血科是集供血、教学及科研为一体的医技科室，同时具备业务和管理科室的特点，主要承担储血、配血、发血、临床输血指导、培训、咨询与会诊、参与用血不良事件调查、开展无偿献血的宣传与教育等各项医疗任务，保证临床医疗用血安全。科室拥有全自动血型分析仪、智能化全自动溶浆机、各型各类离心机、水浴箱和多台血液贮存专用冰箱、血小板恒温箱、温度监控系统、专用冷链取血箱、输血信息管理系统等现代化医疗仪器设备。开展疑难血型鉴定及交叉配血、不规则抗体筛查和鉴定、血小板抗体检测、Rh分型检测、新生儿溶血病检测等，推广术中自身输血，全面保障了临床安全、有效、科学用血。');
INSERT INTO `t_subject` VALUES (5, 'A05', '口腔科', '王海花', '开展多项基础研究和临床研究，已在省级及以上核心期刊发表论文多篇，完成绍兴市多个科研项目。', '24室', '2000-10-06', '我院1946年即设立牙科，至1957年改名为口腔科，是一个以口腔临床医学为主，医疗、教学、科研相结合的专业性学科。目前拥有牙科综合治疗椅22台，并配置有口腔CT、数字牙科X线机、口腔全景机、牙科种植系统、超声骨刀、根管显微镜、微波治疗仪、冷光美白仪、牙周治疗仪、全自动根管治疗仪、水激光治疗仪等先进设备。门诊诊疗环境整洁，设有独立的清洗消毒室和口腔种植手术室。科室开展各种口腔内科、口腔颌面外科、口腔修复、正畸、种植及各种牙周病、粘膜病的诊治，年门诊病人约5万人次，住院病人约500人次。现有口腔临床医师17名，其中主任医师4名，副主任医师4名，硕士9名。');
INSERT INTO `t_subject` VALUES (6, 'A06', '眼科', '陈伟', '开展了多项基础研究和临床工作，近年来在中华级、国家级及省级学术期刊发表论文数十篇，承担及完成省卫生厅、市级科技项目9项；获浙江省医药卫生科技创新奖、绍兴市科学技术奖共5项，开展新技术新项目十余项。 科内有1人未浙江省医学会眼科学分会委员及候任主委，2人为绍兴市医学会眼科学分会委员。有1人为温州医科大学和浙江省中医药大学硕士生导师。 ', '41楼', '2001-02-15', '成立于20世纪40年代，80年代初起独立设置眼科，是一个以眼科临床为主，医疗、教学、科研相结合的专业性学科。为绍兴市首批临床医学重点学科。目前年门急诊病人5万余人次，住院病人千余人次，收治白内障、青光眼、视网膜脱离、斜视、上睑下垂、眼外伤、眼眶肿瘤、慢性泪囊炎、泪道阻塞、视神经疾病、眼底血管性疾病等眼病，开展白内障超声乳化摘除术、青光眼复合式小梁切除术，青光眼引流装置植入术、青光眼白内障联合术、23G微创玻璃体视网膜手术、眼眶肿瘤摘除术、眼眶骨折修复术、鼻内窥镜下鼻腔泪囊造口术、泪道置管术、泪小管断裂吻合术、眼睑成形术、上睑下垂矫正术、斜视矫正术、活动性义眼座植入术、羊膜移植术、角膜缘干细胞移植术、板层角膜移植术、重睑成形术、眼袋去除术、内眦赘皮矫正术、提眉术等手术。目前临床医师14名；其中主任医师2名，副主任医师6名，硕士研究生4名。拥有进口白内障超声乳化机、前、后段玻璃体切割机、眼科手术显微镜，眼底激光机，YAG激光机，眼科OCT、超声生物显微镜（UBM）、眼底血管造影机，免散瞳眼底照相机，综合验光仪，全自动视野仪，眼电生理检查仪，眼科A/B超，角膜内皮细胞检查仪，角膜测厚仪，角膜地形图仪，非接触眼压计等众多先进的医疗仪器，为学科开展各项业务打下了坚实的基础。');
INSERT INTO `t_subject` VALUES (7, 'A07', '儿科', '陈啸洪', '我科各个专业学组有的放矢地开展了多项基础研究和临床工作，取得了大量可喜的成果。近年来已在《中华流行病学杂志》、《中华临床感染病杂志》、《中华医学杂志》、《中华全科医学》等核心期刊及《临床儿科杂志》、《实用儿科临床杂志》、《中国实用儿科杂志》、《当代儿科杂志》、《儿科急救医学》、《儿科药学》等专业杂志及其它杂志上发表论文近100篇', '10栋', '2012-07-03', '儿科为绍兴市临床医学重点学科，浙江省儿科住院医师规范化培训基地。学科团队业务水平高，技术力量雄厚，队伍结构合理，共有医生34名，护士14名，其中高级职称18名，硕士研究生导师5名，现任科主任为姚欢迎主任医师，任浙江省医学会儿科学分会委员，绍兴市医学会儿科学分会候任主委，绍兴市医师协会儿科学分会副会长，浙江省医学会儿科学分会急救学组委员。\n\n学科开放床位51张，年门急诊20余万人次，出院患儿4000余人次。目前有小儿呼吸、小儿消化、小儿内分泌、小儿神经、小儿风湿免疫、生长发育等亚专业。小儿内镜技术作为本科特色，目前小儿支气管镜无论数量及技术在省内达到领先，小儿胃镜是绍兴市内各医院唯一能开展检查及其治疗的技术；儿童哮喘作为全国儿童哮喘协作组成员，规范的诊疗及最现代的小儿雾化中心，为绍兴及周围县市的患儿提供优质的服务；其他如小儿癫痫的合理用药、儿童矮小症和早发育等诊疗技术达国内先进水平。近5年学科承担省、市级课题7项，在各类专业杂志发表论文20余篇，其中SCI 1篇，获得市级科技进步奖3项。是国家级规培基地、绍兴文理学院2.5+2.5临床教学基地。');
INSERT INTO `t_subject` VALUES (8, 'A08', '放疗科', '吴东平', '学科近三年主持科研项目6项，开展各类新技术3项。在国内外杂志上已发表学术论文10余篇，SCI收录6篇。学科内省级学术团体担任委员6人，市级学术团体担任委员10余人。', '28楼', '2002-03-22', '放疗学科自1997年5月组建开展肿瘤放射治疗，先后历属放射科、肿瘤（内）科，2018年9月独立成科。现有病区1个，开放床位26张，医师、护士和物理技术人员30余人，其中正高1人，副高5人，硕士学位7人，绍兴市文理学院硕士生导师1人。学科现拥有美国瓦里安Vital Beam和德国西门子直线加速器各一台，飞利浦Brilliance 大孔径CT定位机一台，Eclipse 15.5和Pinnacle 8.0计划验证系统，以及ORFIT放疗一体板、立体定向放疗体架和科莱瑞迪乳腺定位托架等放疗辅助设备。\n\n学科在绍兴地区首先开展图像引导放疗（IGRT）、体部立体定向放疗（SBRT）、容积旋转调强放疗（VMAT）技术。年收治放疗病人近900例、放疗2万人次，常规开展适形、调强放射治疗及SBRT等精准放疗技术，对鼻咽癌、头颈部肿瘤、食管癌、直肠癌、肺癌、乳腺癌、胰腺癌的诊治有丰富的临床经验。定期开展疑难病例MDT，为患者制定最佳治疗方案。经过20余年的发展，科室的影响力、病人收治数、新技术新项目开展、科研教育等方面在本地区保持领先。');
INSERT INTO `t_subject` VALUES (9, 'A09', '消化内科', '马阿火', ' 开展了多项基础研究和临床工作,近年来我科已完成市级科研项目3项，在各级杂志上发表论文30篇，SCI一篇。引进多项新技术，在市内领先开展胶囊内镜、胃肠动力、CTA，FMT等在胃肠疾病诊治中应用。现有绍兴市级学组主委、副主任5名，委员10名，浙江省消化病学分会常务委员1名，浙江省中西医结合学会消化病学常委一名。', '2室', '2018-08-05', '成立于1978年，是一个以消化系疾病临床诊治及内镜诊治为主，医疗、教学、科研相结合的专业性学科。目前拥有一个病区，46张床位，年住院病人3千余人次，年门诊量10万余人次，年胃镜检查约3万余人次，肠镜检查大约1万人次，ERCP检查800余人次，年开展无痛胃肠镜2万余人次，同时开展多种内镜下治疗，如息肉摘除，内镜下止血、消化道狭窄扩张及支架置入，胃造瘘术及营养管置入，EMR,,ESD,EUS,等技术。收治各种消化道疾病如消化道大出血、肝硬化腹水、肝性脑病、消化道肿瘤、黄疸，胰腺炎等患者，系绍兴市消化病学临床、教学与科研中心。国家级规培基地之 消化专业亚基地。在编临床医师22名；其中主任医师6名，副主任医师5名，其中硕士、博士研究生14名。拥有先进的诊疗设备，开展各种疑难危重消化道疾病的诊治及内镜下治疗。目前正在创建绍兴消化内镜学创新学科。目前在读硕士研究生三人。');
INSERT INTO `t_subject` VALUES (10, 'A10', '肿瘤内科', '王建芳', '近年来开展多项基础研究和临床研究工作，主持各级各类科研项目10余项，其中省级项目2项；获浙江省医药卫生三等奖1项、绍兴市科学技术二、三等奖各1项。发表各类学术论文40余篇，其中SCI收录9篇，中华级3篇。', '12号楼', '2018-09-12', '肿瘤内科及介入治疗科为绍兴市医学重点学科，是一个以集肿瘤化疗、肿瘤放疗、肿瘤介入、精准靶向治疗、生物免疫治疗及肿瘤姑息康复治疗于一体的肿瘤综合性治疗临床学科。学科自2008年成立以来，坚持走科学、规范、多学科合作的治疗之路，开展鼻咽癌、肺癌、食管癌、乳腺癌、脑瘤、胃癌、肠癌、泌尿系肿瘤、妇科肿瘤等常见肿瘤的综合治疗。2012年荣获“浙江省卫生厅癌痛规范化治疗示范病房”。2017年通过国家食药监总局的GCP认证，已开展多项肿瘤药物治疗的Ⅲ、Ⅳ期临床试验。学科团队成员中有主任医师4名，副主任医师2名，硕士研究生8名，在读博士研究生1名。');
INSERT INTO `t_subject` VALUES (11, 'A11', '耳鼻咽喉科', '刘平', '开展了多项基础研究和临床工作，近年来已在《中华耳鼻咽喉头颈外科杂志》、《临床耳鼻咽喉头颈外科杂志》等核心期刊发表论文多篇。完成省卫生厅重点推广项目及绍兴市多个科研项目，获绍兴市科学技术进步二等奖1次。', '14层', '2019-11-11', ' 医院成立初时本科与眼科合为一个科室，经过多年努力，于20世纪90年代成为独立学科，是一个以耳鼻咽喉临床医学为主，医疗、教学、科研相结合的专业性学科。目前拥有一个病区，40张床位，年住院病人1900余人次。在编临床医师14名；其中主任医师2名，副主任医师4名，其中硕士研究生6名。拥有各种先进的检查和手术设备。主要收治鼻息肉、鼻窦炎、腺样体肥大、扁桃体炎、鼻眼相关疾病、鼻腔鼻窦肿瘤、咽喉部肿瘤、声带息肉、各肿类型的中耳炎、突发性耳聋以及各种耳鼻咽喉科急诊：如鼻出血、气管、食道异物、头颈部外伤等。系绍兴市耳鼻咽喉学科临床、教学与科研中心。 ');
INSERT INTO `t_subject` VALUES (12, 'A12', '泌尿外科', '阎家骏', '致力于泌尿系肿瘤早期诊断及发病机制的研究，部分成果达国际先进、国内领先。近五年，承担省、厅、市级课题10余项，国家级继续教育项目10余项；获厅市级成果奖励5项；发表学术论文60余篇，其中SCI论文10余篇、中华级论文10余篇，获实用新型专利4项。', '40楼', '2009-05-22', '省市共建医学重点学科、绍兴市医学领先学科、绍兴地区规模最大的泌尿疾病诊疗中心之一。与上海交通大学附属第一医院、浙江大学附属第一医院、浙江大学附属邵逸夫医院、浙江省人民医院均建立合作关系。与上海交通大学附属第一医院开展合作，成立上海公济泌尿外科集团远程医疗平台绍兴分中心和夏术阶国家级名医工作站。我院首批获国家GCP认证专业。绍兴市医学会泌尿外科专业委员会、绍兴市中西医结合学会男科专业委员会、绍兴市康复医学会泌尿男科康复专科委员会主委单位。学科现有医师22人，其中主任医师9人，副主任医师10人，博士3人、硕士13人。学科成员担任国家级、省级、市级等各级各类学术职务40余人次。');
INSERT INTO `t_subject` VALUES (13, 'A13', '神经外科', '俞学斌', '在市内处于学术技术领先地位，在省内有较高的声誉。是绍兴市医学重点领先学科、浙江省医学扶植重点学科和浙东地区（绍兴、宁波、舟山）神经外科专病中心建设单位。', '7室', '2008-11-15', '是省卫生厅扶植重点学科、市医学重点领先学科，浙东地区神经外科专病中心建设单位，在省内具有较高知名度，技术力量雄厚。现有专业人员20人，其中正高职称7人，副高职称4人，中级职称6人，博士3人，硕士12人。固定床位88张，其中神经科监护病床（NICU）16张。主要诊治范围为：颅脑创伤、颅内肿瘤、脑血管疾病、脊髓疾病、功能性疾病、先天性疾病等，集临床、教学、科研为一体。');
INSERT INTO `t_subject` VALUES (14, 'A14', '风湿免疫科', '俞钟明', '近年来，该学科承担、参与省市级课题5项，院级课题2项，发病学术论文40余篇，其中SCI收录4篇。承担绍兴文理学院本科生研究生教学培养任务，是国家级医师规范化培训基地。多次参加国家、省内风湿病年会等学术会议，与省、市多家专科医院交流、学习。诊疗、学术水平在地市级处于先进水平。', '24室', '2011-07-20', '2005年开设风湿病门诊，2012年在内分泌代谢科成立风湿免疫组，2018年9月成立独立风湿免疫科。是绍兴地区首家独立的风湿免疫科，主要承担绍兴地区风湿病诊治、抢救、会诊，同时集教育、科研、预防于一体的专业性临床学科。目前科室医生9人，其中主任医师2名，主治医师4人，住院医师3人，其中8位硕士研究生。有6位医师在省、市学术团体中兼任学术职务，其中俞钟明主任任浙江省医学会风湿病分会常委，浙江省医师协会风湿免疫科医师分会常委，绍兴市医学会和绍兴市中西医结合学会风湿病专业委员会主任委员。赵书山主任任绍兴市医学会风湿病专业委员会副主任委员，浙江省医师协会风湿病相关肺血管间质病学组委员，浙江省医学会风湿病学分会骨内科学组和影像学组委员。\n\n科室现有14张病床，开设风湿免疫科普通门诊、专家门诊、专病门诊、特需专家门诊。目前年门诊量2万余人次，年出院病人1000人次以上，在绍兴及周边地区享有盛誉。本科室有上海仁济医院鲍春德教授“国内名医专家工作室”，鲍春德教授每月来一次特需门诊、教学、查房。');
INSERT INTO `t_subject` VALUES (15, 'A15', '康复医学科', '龚剑秋', '学科成员担任包括国家级委员、省级常务委员、常务理事、市级康复医学会秘书长、主委等各级各类学术职务80余人次，近年主持国家级继教8项，省市级10余项，获省部级立项2项，厅市级立项10余项，多次获厅市级科学技术二、三等奖，主持新技术新项目10余项，获国家实用新型专利5项，多项新技术填补市内空白，推广应用至省内外20多家医院', '40栋', '2006-08-06', '成立于2003年，是全市最早成立的专业医疗康复部门，2005年创建成绍兴市重点学科，2007年成为浙江省综合性医院中医名科(中医示范科)，2009年成为浙江省二家工伤康复试点医院之一，2010年绍兴市政府与荷兰政府签定了总投入230万欧元的中-荷康复医学学科建设项目，2012年获批浙江省住院医师规范化培训康复基地，2014年获批国家级住院医师规范化培训康复基地，同年与时任国际物理医学与康复医学学会主席励建安教授专家团队接轨，建立励建安(院士)专家团队工作站，2018年获批浙江省中医药创新类重点学科（中西医结合），同年底创建成为绍兴市领先学科，2019年入选“十三五”省中医药重点专科建设项目，2020年牵头成立了绍兴市康复医学质量控制中心。');
INSERT INTO `t_subject` VALUES (16, 'A16', '病理科', '王诚', '开展了多项基础研究和临床工作，近年来已在SCI、中华级、国家级杂志等核心期刊发表论文多篇，获得省、市自然科学优秀论文奖一、二等奖多次。完成及协助完成多个省、市科研项目，或国家发明专利2项，浙江省医药卫生科技创新二、三等奖多次，绍兴市科学技术进步一、二、三等奖多次。', '34栋', '2013-03-16', ' 创建于1962年，经过50多年，三代病理人的不懈努力，从一间房一个人，简陋的设备， 300例年检量发展到现在拥有2500平方米面积，16名工作人员、高级职称比例达到30%，博士、硕士研究生比例达到20%以上。拥有全套高质量专科仪器设备、主攻方向明确、管理制度完善、为具有亚专业（专科）特色的三级甲等综合性医院病理科。是绍兴市第三批重点学科，省市共建医学扶植重点建设学科，硕士带教点，病理质控中心挂靠单位与指导中心。承担着临床诊疗、教学、科研三方面的重要任务。\n      现在，常规年活检量超过3万例，冷冻快速病理会诊6千余例，细胞病理学（液基细胞学/穿刺病理学）8000例，常规开展外科组织病理学检查，术中快速冷冻病理会诊，细胞病理学（液基、细针穿刺）检查，15项组织化学检查，100余项免疫组织化学检查、免疫荧光检测，原位分子杂交技术等多项病理检查和辅助检查项目。');
INSERT INTO `t_subject` VALUES (17, 'A17', '肾内科', '沈水娟', '开展了多项基础研究和临床工作，已完成市级科技项目3项，现承担市级课题1项，浙江省卫生厅课题1项，浙江省医学会课题1项，引进新技术项目多项，近十年在中华级、国家级、省级杂志发表论文50余篇，SCI论文1篇，获浙江省医药卫生科技创新三等奖1次。', '37号楼', '2022-04-22', ' 是集肾脏病临床诊断、治疗、血液净化为一体的临床学科。创建于二十世纪八十年代，是绍兴市率先成立的独立科室建制的肾脏病学科，目前设置有2个病区，病床41张、透析床位49张。拥有国际先进水平的血液透析机44台、血液透析滤过机5台，水处理设备2套。2001年在绍兴地区率先开展经皮肾活检术，2010年成立腹膜透析治疗中心。目前全科有医护人员50名、血透室专职工程师1名，其中在编临床医师16名，其中主任医师4名，副主任医师3名，硕士研究生7名，在读硕士研究生3名，在读博士研究生1名。学科在诊治急性肾炎、慢性肾炎、肾病综合征、狼疮性肾炎、糖尿病肾病、尿路感染、泌尿系结核、肾移植状态等常见疾病的基础上，着重解决绍兴地区急、慢性肾功能衰竭的诊断治疗及危重病人的抢救，其诊疗水平处于绍兴地区领先地位。');
INSERT INTO `t_subject` VALUES (18, 'A18', '血液内科', '封蔚莹', '开展了多项基础研究和临床研究工作，迄今已承担各类厅局级科技项目10余项，获浙江省医药卫生科技创新奖、绍兴市科学技术奖10余项；共发表科研论文100余篇，其中SCI 收录5篇，中华级论文10余篇；开展新技术新项目十余项。', '23栋', '2000-10-06', '成立于20世纪60年代，80年代初组建血液科，是一个以血液病临床医学为主，医疗、教学、科研相结合的专业性学科。目前拥有一个病区，48张床位，包括百级层流病房2间，目前年住院病人2000余人次，年门诊病人15000余人次。收治急慢性白血病、淋巴瘤、多发性骨髓瘤、骨髓增生异常综合征以及各种贫血、出血等良、恶性血液病，系绍兴市血液病学临床、教学与科研中心。在编临床医师16名：其中主任医师4名，副主任医师2名，其中博士1名，硕士12名。拥有设备先进的血液病实验室，可以进行细胞学、免疫学、分子生物学及基因水平的研究。');
INSERT INTO `t_subject` VALUES (19, 'A19', '皮肤科', '陈宏', '开展多项临床新项目和基础研究，近年来发表于《中华皮肤科杂志》、《中国皮肤病麻风病学杂志》等核心期刊论文多篇，获得省医学会论文一等奖二次。报道了多个非常少见的病例。', '27栋', '2001-02-15', '创建于20世纪80年代，是一个从事皮肤病、性传播疾病、皮肤美容等业务的临床一线科室，年门诊量达5万余人次。皮肤科技术力量雄厚，专业人才队伍结构合理，现有在编临床医师5名，其中副主任医师1名，硕士研究生2名，3名医师具有浙江省美容主诊医师资格证书。学科在诊治湿疹、银屑病、过敏性皮炎、白癜风等常见疾病的基础上，相继开展了性病、皮肤外科、皮肤美容亚专业，着重解决重症药疹、皮肤肿瘤、红斑狼疮、大疱性皮肤病等危重疑难性皮肤病的诊疗。');
INSERT INTO `t_subject` VALUES (20, 'A20', '骨科', '陈雪荣', '近5年来，本学科承担省、市科研项目 7 项；获省、市科技进步奖 7 项；在专业杂志发表论文45篇，其中SCI 3篇、中华级杂志8 篇。', '21室', '2012-07-03', '集预防、治疗、康复、保健及教学于一体，致力于治疗骨科常见病、多发病及各种骨科疑难杂症；重视手术治疗、药物治疗、物理治疗、康复锻炼等治疗方法的规范化组合；针对不同个体、不同年龄、不同疾病、不同病程、不同要求，选择个性化治疗方案，充分体现治疗的个体化，其诊疗水平在全市同行业中处于领先地位。');
INSERT INTO `t_subject` VALUES (21, 'A', '外星', '李四', '阿萨大大', '1楼', '2024-08-19', '啊发发');
INSERT INTO `t_subject` VALUES (22, 'S222', '脱发科', '沈巨', '十大打算', '阿萨', '2024-08-14', '啊实打实的a');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'user1', 'E7iUminUhzcM+ZSQBlJS3Gav8I4gBG/minbuwp9FZ9v4X7tJq+FUl5hsX9r4eNYJ', '沙瑞金', 'sdfsdffsdfdfsd');
INSERT INTO `t_user` VALUES (2, 'admin', '2edI7jvA9Fj5jmQRv9OLYFghLR9EdTJ7CEr2Q2muE3UhvzKisnyVBz768cxDCJZt', '赵立春', '一次');
INSERT INTO `t_user` VALUES (4, 'admin11', 'vPq2ZQVfya3rvMKsGxUaDbt8+BU5paOA/pqiB6IR92ruyl+GCcgdY4cLm9QrqSU2', '祁同伟', '阿松大阿达萨达啊啊');

SET FOREIGN_KEY_CHECKS = 1;
