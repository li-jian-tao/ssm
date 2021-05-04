/*
Navicat Oracle Data Transfer
Oracle Client Version : 10.2.0.5.0

Source Server         : oracle
Source Server Version : 100200
Source Host           : 127.0.0.1:1521
Source Schema         : CMS

Target Server Type    : ORACLE
Target Server Version : 100200
File Encoding         : 65001

Date: 2021-05-04 22:08:52
*/


-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE "CMS"."article";
CREATE TABLE "CMS"."article" (
"id" NUMBER NOT NULL ,
"title" VARCHAR2(255 BYTE) NULL ,
"summary" VARCHAR2(400 BYTE) NULL ,
"content" CLOB NULL ,
"releaseDate" TIMESTAMP(6)  NULL ,
"clickTimes" NUMBER NULL ,
"state" NUMBER NULL ,
"reportNum" NUMBER NULL ,
"user_id" NUMBER NULL ,
"category_id" NUMBER NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO "CMS"."article" VALUES ('1', '中国移动招聘', '中国移动招聘', '1583388043575额度重点字段理解.docx', TO_TIMESTAMP(' 2020-03-05 14:00:43:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '5', '-2', '2', '3', '2');
INSERT INTO "CMS"."article" VALUES ('2', '中国联通招聘', '中国联通招聘', '1583388319625额度重点字段理解.docx', TO_TIMESTAMP(' 2020-03-05 14:05:19:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '17', '2', '1', '3', '2');
INSERT INTO "CMS"."article" VALUES ('3', '中国电信招聘', '中国电信招聘', '1583388747555额度重点字段理解.docx', TO_TIMESTAMP(' 2020-03-05 14:12:27:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '12', '2', '1', '3', '2');
INSERT INTO "CMS"."article" VALUES ('4', '大学生就业情况分析', '大学生就业情况分析', '1583389291685额度重点字段理解.docx', TO_TIMESTAMP(' 2020-03-05 14:21:31:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '21', '2', '3', '2', '5');
INSERT INTO "CMS"."article" VALUES ('5', '大学生该如何面对就业压力', '大学生该如何面对就业压力', '1583389772326额度重点字段理解.docx', TO_TIMESTAMP(' 2020-03-05 14:29:32:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', '-2', '1', '2', '5');
INSERT INTO "CMS"."article" VALUES ('21', '软件工程知识', '软件工程知识', '1583556121487额度重点字段理解.docx', TO_TIMESTAMP(' 2020-03-07 12:42:01:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '4', '1', null, '2', '7');
INSERT INTO "CMS"."article" VALUES ('22', '通信工程知识', '通信工程知识', '1583557064472额度重点字段理解.docx', TO_TIMESTAMP(' 2020-03-07 12:57:44:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '3', '1', null, '2', '8');
INSERT INTO "CMS"."article" VALUES ('23', '广州酷狗有限公司招聘', '广州酷狗有限公司招聘', '1583557973531额度重点字段理解.docx', TO_TIMESTAMP(' 2020-03-07 13:12:53:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '7', '1', null, '3', '3');
INSERT INTO "CMS"."article" VALUES ('41', '招聘视频', '招聘视频', 'abc.mp4', TO_TIMESTAMP(' 2020-03-19 15:17:32:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '113', '1', null, '23', '3');
INSERT INTO "CMS"."article" VALUES ('81', 'java编程原理', 'java编程原理', '1588345073951培训大纲.doc', TO_TIMESTAMP(' 2020-05-01 22:57:53:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '3', '1', null, '3', '7');
INSERT INTO "CMS"."article" VALUES ('62', '当前疫情情况受疫情的影响', '当前疫情情况受疫情的影响', '1585305842490额度重点字段理解.docx', TO_TIMESTAMP(' 2020-03-27 18:44:02:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '0', null, '45', '5');
INSERT INTO "CMS"."article" VALUES ('63', '当前就业形势严峻', '当前就业形势严峻', '1585367514177额度重点字段理解.docx', TO_TIMESTAMP(' 2020-03-28 11:51:54:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '0', null, '45', '5');
INSERT INTO "CMS"."article" VALUES ('65', '666', '666', '1585367841392培训大纲.doc', TO_TIMESTAMP(' 2020-03-28 11:57:21:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '0', null, '45', '18');
INSERT INTO "CMS"."article" VALUES ('66', '777', '777', '1585369326568培训大纲.doc', TO_TIMESTAMP(' 2020-03-28 12:22:06:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '0', null, '45', '18');
INSERT INTO "CMS"."article" VALUES ('68', '99', '99', '1585458199599培训大纲.doc', TO_TIMESTAMP(' 2020-03-29 13:03:19:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '0', null, '45', '18');
INSERT INTO "CMS"."article" VALUES ('69', '当前就业形势不容乐观', '当前就业形势不容乐观', '1585458730981额度重点字段理解.docx', TO_TIMESTAMP(' 2020-03-29 13:12:10:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '0', null, '45', '5');
INSERT INTO "CMS"."article" VALUES ('71', '我的六级英语学习历程', '我的六级英语学习历程', '1585542335270培训大纲.doc', TO_TIMESTAMP(' 2020-03-30 12:25:35:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '9', '99', '5', '51', '15');
INSERT INTO "CMS"."article" VALUES ('82', '数据库原理', '数据库原理', '1588603243773培训大纲.doc', TO_TIMESTAMP(' 2020-05-04 22:40:43:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '0', null, '3', '7');
INSERT INTO "CMS"."article" VALUES ('83', '数字逻辑', '数字逻辑', '1588605431147培训大纲.doc', TO_TIMESTAMP(' 2020-05-04 23:17:11:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '0', null, '3', '8');
INSERT INTO "CMS"."article" VALUES ('84', '数字逻辑', '数字逻辑', '1588605563327培训大纲.doc', TO_TIMESTAMP(' 2020-05-04 23:19:23:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '0', null, '3', '8');
INSERT INTO "CMS"."article" VALUES ('85', '数字逻辑2', '数字逻辑2', '1588605619412额度重点字段理解.docx', TO_TIMESTAMP(' 2020-05-04 23:20:19:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '0', null, '3', '8');
INSERT INTO "CMS"."article" VALUES ('86', '数字逻辑3', '数字逻辑3', '1588641948469培训大纲.doc', TO_TIMESTAMP(' 2020-05-05 09:25:48:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '0', null, '3', '8');
INSERT INTO "CMS"."article" VALUES ('87', '就压', '就压', '1588642318216培训大纲.doc', TO_TIMESTAMP(' 2020-05-05 09:31:58:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '0', null, '3', '5');
INSERT INTO "CMS"."article" VALUES ('88', '测试的', '测试的', '1588642495932额度重点字段理解.docx', TO_TIMESTAMP(' 2020-05-05 09:34:55:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '0', null, '3', '5');
INSERT INTO "CMS"."article" VALUES ('89', '再次测试', '再次测试', '1588642546832额度重点字段理解.docx', TO_TIMESTAMP(' 2020-05-05 09:35:46:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '0', null, '3', '5');
INSERT INTO "CMS"."article" VALUES ('90', '五五', '五五', '1588643175157培训大纲.doc', TO_TIMESTAMP(' 2020-05-05 09:46:15:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '0', null, '3', '19');
INSERT INTO "CMS"."article" VALUES ('91', '就压', '就压', '1588643389112培训大纲.doc', TO_TIMESTAMP(' 2020-05-05 09:49:49:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '0', null, '3', '18');
INSERT INTO "CMS"."article" VALUES ('92', '就业视频', '就业视频', '1589251123419额度基础（一）.mp4', TO_TIMESTAMP(' 2020-05-12 10:38:43:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '3', '1', null, '2', '5');
INSERT INTO "CMS"."article" VALUES ('101', '安硕培训视频', '安硕培训视频', '1590120494887额度基础（一）.wmv', TO_TIMESTAMP(' 2020-05-22 12:08:14:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '3', '1', null, '3', '10');
INSERT INTO "CMS"."article" VALUES ('102', '安硕培训2', '安硕培训2', '1590123042436税务爬虫.mp4', TO_TIMESTAMP(' 2020-05-22 12:50:42:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '3', '1', null, '43', '10');
INSERT INTO "CMS"."article" VALUES ('103', '金玮四六级', '金玮四六级', '1590202518320爬虫入门基础.mp4', TO_TIMESTAMP(' 2020-05-23 10:55:18:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '2', '-2', '1', '63', '11');
INSERT INTO "CMS"."article" VALUES ('104', '实训', '实训', '1590228318458税务爬虫数据质量.mp4', TO_TIMESTAMP(' 2020-05-23 18:05:18:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '2', '1', null, '3', '12');
INSERT INTO "CMS"."article" VALUES ('121', 'crdjo1', 'ce2', '1617975619726MyVideo_1.mp4', TO_TIMESTAMP(' 2021-04-09 21:40:19:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', '1', null, '23', '11');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE "CMS"."category";
CREATE TABLE "CMS"."category" (
"id" NUMBER NOT NULL ,
"name" VARCHAR2(255 BYTE) NOT NULL ,
"description" VARCHAR2(255 BYTE) NULL ,
"parent_id" NUMBER NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO "CMS"."category" VALUES ('1', '招聘会所', null, null);
INSERT INTO "CMS"."category" VALUES ('2', '校园招聘', '校园招聘', '1');
INSERT INTO "CMS"."category" VALUES ('3', '社会招聘', '社会招聘', '1');
INSERT INTO "CMS"."category" VALUES ('4', '就业', null, null);
INSERT INTO "CMS"."category" VALUES ('5', '就业情况2', '就业情况2', '4');
INSERT INTO "CMS"."category" VALUES ('6', '专业技能', null, null);
INSERT INTO "CMS"."category" VALUES ('7', '软件工程', '软件工程', '6');
INSERT INTO "CMS"."category" VALUES ('8', '通信工程', '通信工程', '6');
INSERT INTO "CMS"."category" VALUES ('9', '培训', null, null);
INSERT INTO "CMS"."category" VALUES ('10', '杰普基地培训', '杰普基地培训', '9');
INSERT INTO "CMS"."category" VALUES ('11', '东软基地培训', '东软基地培训', '9');
INSERT INTO "CMS"."category" VALUES ('12', '千峰基地培训', '千峰基地培训', '9');
INSERT INTO "CMS"."category" VALUES ('13', '学习', null, null);
INSERT INTO "CMS"."category" VALUES ('14', '高等数学', '高等数学', '13');
INSERT INTO "CMS"."category" VALUES ('15', '大学英语', '大学英语', '13');
INSERT INTO "CMS"."category" VALUES ('16', '政治', '政治', '13');
INSERT INTO "CMS"."category" VALUES ('17', '生活', null, null);
INSERT INTO "CMS"."category" VALUES ('18', '心理方面', '心理方面', '-1');
INSERT INTO "CMS"."category" VALUES ('19', '生活技能', '生活技能', '17');
INSERT INTO "CMS"."category" VALUES ('20', '宿舍方面', '宿舍方面', '17');
INSERT INTO "CMS"."category" VALUES ('25', '实习', null, null);
INSERT INTO "CMS"."category" VALUES ('41', '培训基地', '培训基地', '25');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE "CMS"."user";
CREATE TABLE "CMS"."user" (
"id" NUMBER NOT NULL ,
"nickname" VARCHAR2(255 BYTE) NULL ,
"account" VARCHAR2(255 BYTE) NOT NULL ,
"password" VARCHAR2(255 BYTE) NOT NULL ,
"image" VARCHAR2(255 BYTE) NULL ,
"role" VARCHAR2(255 BYTE) DEFAULT '1'  NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO "CMS"."user" VALUES ('1', '管理员', 'admin', 'admin', '0.jpg', '0');
INSERT INTO "CMS"."user" VALUES ('2', '中国新闻网2', '123', '123', '1590156856909参考.jpg', '1');
INSERT INTO "CMS"."user" VALUES ('3', '黎剑涛f', '12138', '12138', '1617368953654u=.jpg', '1');
INSERT INTO "CMS"."user" VALUES ('23', '李海峰', '234', '234', '1617975360158timg.jpg', '1');
INSERT INTO "CMS"."user" VALUES ('43', '李东阳', '12345', '12345', '1585549192252u=.jpg', '1');
INSERT INTO "CMS"."user" VALUES ('51', '何金玮', '5555', '5555', null, '1');
INSERT INTO "CMS"."user" VALUES ('45', '胡宇栋', '66666', '66666', '1585030900421u=.jpg', '1');
INSERT INTO "CMS"."user" VALUES ('63', '李东田', '123456789', '123456789', '15902024705360.jpg', '1');

-- ----------------------------
-- Table structure for user_collection
-- ----------------------------
DROP TABLE "CMS"."user_collection";
CREATE TABLE "CMS"."user_collection" (
"id" NUMBER NOT NULL ,
"collection_date" TIMESTAMP(6)  NULL ,
"state" NUMBER DEFAULT 1  NULL ,
"user_id" NUMBER NULL ,
"article_id" NUMBER NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of user_collection
-- ----------------------------
INSERT INTO "CMS"."user_collection" VALUES ('1', TO_TIMESTAMP(' 2020-03-05 14:32:58:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '2', '4');
INSERT INTO "CMS"."user_collection" VALUES ('21', TO_TIMESTAMP(' 2020-03-08 14:51:18:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '23', '1');
INSERT INTO "CMS"."user_collection" VALUES ('22', TO_TIMESTAMP(' 2021-04-09 21:24:20:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '2', '3', '2');
INSERT INTO "CMS"."user_collection" VALUES ('41', TO_TIMESTAMP(' 2020-05-01 17:47:19:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', '3', '4');
INSERT INTO "CMS"."user_collection" VALUES ('61', TO_TIMESTAMP(' 2020-05-23 10:56:46:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', '63', '103');
INSERT INTO "CMS"."user_collection" VALUES ('62', TO_TIMESTAMP(' 2020-05-23 18:06:15:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', '3', '104');

-- ----------------------------
-- Table structure for user_comment
-- ----------------------------
DROP TABLE "CMS"."user_comment";
CREATE TABLE "CMS"."user_comment" (
"id" NUMBER NOT NULL ,
"comment_date" TIMESTAMP(6)  NULL ,
"comment_content" VARCHAR2(255 BYTE) NULL ,
"comment_times" NUMBER DEFAULT '0'  NULL ,
"user_id" NUMBER NULL ,
"article_id" NUMBER NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of user_comment
-- ----------------------------
INSERT INTO "CMS"."user_comment" VALUES ('1', TO_TIMESTAMP(' 2020-03-05 14:31:35:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '此文章到我创意', '3', '2', '4');
INSERT INTO "CMS"."user_comment" VALUES ('21', TO_TIMESTAMP(' 2020-03-29 15:19:23:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '我给你个6666', '1', '45', '4');
INSERT INTO "CMS"."user_comment" VALUES ('22', TO_TIMESTAMP(' 2020-03-30 12:58:18:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '金玮太厉害了。', '1', '45', '71');
INSERT INTO "CMS"."user_comment" VALUES ('23', TO_TIMESTAMP(' 2020-03-30 13:57:41:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '我要举报', '1', '2', '71');
INSERT INTO "CMS"."user_comment" VALUES ('24', TO_TIMESTAMP(' 2020-03-30 14:16:02:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '我是李东阳，', '0', '43', '71');
INSERT INTO "CMS"."user_comment" VALUES ('41', TO_TIMESTAMP(' 2020-05-01 18:10:47:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '今年的就业形式太难了', '1', '3', '4');
INSERT INTO "CMS"."user_comment" VALUES ('42', TO_TIMESTAMP(' 2020-05-01 18:11:05:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '么有比这个更难了', '0', '3', '4');
INSERT INTO "CMS"."user_comment" VALUES ('43', TO_TIMESTAMP(' 2020-05-01 18:11:57:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '给个赞', '0', '3', '4');
INSERT INTO "CMS"."user_comment" VALUES ('44', TO_TIMESTAMP(' 2020-05-12 15:06:37:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'function', '0', '3', '41');
INSERT INTO "CMS"."user_comment" VALUES ('45', TO_TIMESTAMP(' 2020-05-12 15:08:16:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'function', '0', '3', '41');
INSERT INTO "CMS"."user_comment" VALUES ('46', TO_TIMESTAMP(' 2020-05-12 15:28:00:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'function', '0', '3', '41');
INSERT INTO "CMS"."user_comment" VALUES ('47', TO_TIMESTAMP(' 2020-05-12 15:32:01:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'function', '0', '3', '41');
INSERT INTO "CMS"."user_comment" VALUES ('48', TO_TIMESTAMP(' 2020-05-12 15:33:43:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'function', '0', '3', '41');
INSERT INTO "CMS"."user_comment" VALUES ('49', TO_TIMESTAMP(' 2020-05-12 15:35:11:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'function', '0', '3', '41');
INSERT INTO "CMS"."user_comment" VALUES ('50', TO_TIMESTAMP(' 2020-05-12 15:39:51:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'function', '0', '3', '41');
INSERT INTO "CMS"."user_comment" VALUES ('51', TO_TIMESTAMP(' 2020-05-12 15:41:53:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'function', '0', '3', '41');
INSERT INTO "CMS"."user_comment" VALUES ('52', TO_TIMESTAMP(' 2020-05-12 15:46:01:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'function', '0', '3', '41');
INSERT INTO "CMS"."user_comment" VALUES ('53', TO_TIMESTAMP(' 2020-05-13 14:38:01:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'function', '0', '3', '41');
INSERT INTO "CMS"."user_comment" VALUES ('61', TO_TIMESTAMP(' 2020-05-22 12:51:44:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '我的看法', '0', '3', '102');
INSERT INTO "CMS"."user_comment" VALUES ('62', TO_TIMESTAMP(' 2020-05-23 10:57:48:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '胡宇栋', '1', '63', '103');
INSERT INTO "CMS"."user_comment" VALUES ('63', TO_TIMESTAMP(' 2020-05-23 18:06:35:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '视频', '1', '3', '104');
INSERT INTO "CMS"."user_comment" VALUES ('81', TO_TIMESTAMP(' 2021-02-08 22:49:04:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '无组织', '0', '3', '2');
INSERT INTO "CMS"."user_comment" VALUES ('82', TO_TIMESTAMP(' 2021-02-08 22:49:11:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '说说自己的看法', '1', '3', '2');
INSERT INTO "CMS"."user_comment" VALUES ('101', TO_TIMESTAMP(' 2021-04-02 21:08:40:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '说说自己的看法hhh', '1', '3', '2');

-- ----------------------------
-- Table structure for user_commentary
-- ----------------------------
DROP TABLE "CMS"."user_commentary";
CREATE TABLE "CMS"."user_commentary" (
"id" NUMBER NOT NULL ,
"commentary_times" NUMBER DEFAULT '0'  NULL ,
"commentary_state" NUMBER DEFAULT '1'  NULL ,
"user_id" NUMBER NULL ,
"article_id" NUMBER NULL ,
"usercomment_id" NUMBER NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of user_commentary
-- ----------------------------
INSERT INTO "CMS"."user_commentary" VALUES ('1', '0', '1', '2', '4', '1');
INSERT INTO "CMS"."user_commentary" VALUES ('21', '0', '1', '45', '4', '1');
INSERT INTO "CMS"."user_commentary" VALUES ('22', '0', '1', '2', '71', '23');
INSERT INTO "CMS"."user_commentary" VALUES ('23', '0', '1', '2', '71', '22');
INSERT INTO "CMS"."user_commentary" VALUES ('41', '0', '1', '3', '4', '1');
INSERT INTO "CMS"."user_commentary" VALUES ('42', '0', '1', '3', '4', '21');
INSERT INTO "CMS"."user_commentary" VALUES ('43', '0', '1', '3', '4', '41');
INSERT INTO "CMS"."user_commentary" VALUES ('61', '0', '1', '63', '103', '62');
INSERT INTO "CMS"."user_commentary" VALUES ('62', '0', '1', '3', '104', '63');
INSERT INTO "CMS"."user_commentary" VALUES ('81', '0', '1', '3', '2', '101');
INSERT INTO "CMS"."user_commentary" VALUES ('82', '0', '1', '3', '2', '82');

-- ----------------------------
-- Table structure for user_down
-- ----------------------------
DROP TABLE "CMS"."user_down";
CREATE TABLE "CMS"."user_down" (
"id" NUMBER NOT NULL ,
"down_date" TIMESTAMP(6)  NULL ,
"url" VARCHAR2(255 BYTE) NULL ,
"down_times" NUMBER DEFAULT '0'  NULL ,
"article_id" NUMBER NULL ,
"user_id" NUMBER NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of user_down
-- ----------------------------
INSERT INTO "CMS"."user_down" VALUES ('22', TO_TIMESTAMP(' 2020-05-19 16:47:44:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), 'abc.jpg', '0', '41', '3');
INSERT INTO "CMS"."user_down" VALUES ('42', TO_TIMESTAMP(' 2020-05-23 11:00:50:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1590123042436税务爬虫.jpg', '0', '102', '63');
INSERT INTO "CMS"."user_down" VALUES ('41', TO_TIMESTAMP(' 2020-05-22 12:52:05:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1590123042436税务爬虫.jpg', '0', '102', '3');
INSERT INTO "CMS"."user_down" VALUES ('43', TO_TIMESTAMP(' 2020-05-23 18:06:51:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1590228318458税务爬虫数据质量.jpg', '0', '104', '3');

-- ----------------------------
-- Table structure for user_history
-- ----------------------------
DROP TABLE "CMS"."user_history";
CREATE TABLE "CMS"."user_history" (
"id" NUMBER NOT NULL ,
"history_date" TIMESTAMP(6)  NULL ,
"article_id" NUMBER NULL ,
"category_id" NUMBER NULL ,
"user_id" NUMBER NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of user_history
-- ----------------------------
INSERT INTO "CMS"."user_history" VALUES ('2', TO_TIMESTAMP(' 2020-05-02 12:39:10:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '4', '5', '3');
INSERT INTO "CMS"."user_history" VALUES ('3', TO_TIMESTAMP(' 2020-05-02 15:48:15:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '81', '7', '3');
INSERT INTO "CMS"."user_history" VALUES ('4', TO_TIMESTAMP(' 2020-05-02 15:48:22:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '23', '3', '3');
INSERT INTO "CMS"."user_history" VALUES ('5', TO_TIMESTAMP(' 2020-05-02 15:48:47:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '21', '7', '3');
INSERT INTO "CMS"."user_history" VALUES ('6', TO_TIMESTAMP(' 2020-05-02 16:13:58:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '21', '7', '3');
INSERT INTO "CMS"."user_history" VALUES ('7', TO_TIMESTAMP(' 2020-05-02 16:38:38:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '2', '2', '3');
INSERT INTO "CMS"."user_history" VALUES ('8', TO_TIMESTAMP(' 2020-05-02 16:38:58:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '22', '8', '3');
INSERT INTO "CMS"."user_history" VALUES ('9', TO_TIMESTAMP(' 2020-05-02 16:39:04:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '41', '3', '3');
INSERT INTO "CMS"."user_history" VALUES ('10', TO_TIMESTAMP(' 2020-05-02 16:39:08:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '3', '2', '3');
INSERT INTO "CMS"."user_history" VALUES ('11', TO_TIMESTAMP(' 2020-05-02 16:40:07:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '2', '2', '2');
INSERT INTO "CMS"."user_history" VALUES ('12', TO_TIMESTAMP(' 2020-05-02 16:40:10:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '3', '2', '2');
INSERT INTO "CMS"."user_history" VALUES ('13', TO_TIMESTAMP(' 2020-05-02 16:40:13:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '4', '5', '2');
INSERT INTO "CMS"."user_history" VALUES ('14', TO_TIMESTAMP(' 2020-05-02 16:40:17:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '22', '8', '2');
INSERT INTO "CMS"."user_history" VALUES ('15', TO_TIMESTAMP(' 2020-05-04 21:05:47:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '71', '15', '3');
INSERT INTO "CMS"."user_history" VALUES ('16', TO_TIMESTAMP(' 2020-05-12 10:40:30:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '92', '5', '3');
INSERT INTO "CMS"."user_history" VALUES ('21', TO_TIMESTAMP(' 2020-05-22 12:48:04:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '101', '10', '3');
INSERT INTO "CMS"."user_history" VALUES ('22', TO_TIMESTAMP(' 2020-05-22 12:49:17:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '101', '10', '43');
INSERT INTO "CMS"."user_history" VALUES ('23', TO_TIMESTAMP(' 2020-05-22 12:51:17:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '102', '10', '3');
INSERT INTO "CMS"."user_history" VALUES ('24', TO_TIMESTAMP(' 2020-05-23 10:56:39:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '103', '11', '63');
INSERT INTO "CMS"."user_history" VALUES ('25', TO_TIMESTAMP(' 2020-05-23 10:59:47:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '4', '5', '63');
INSERT INTO "CMS"."user_history" VALUES ('26', TO_TIMESTAMP(' 2020-05-23 11:00:08:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '92', '5', '63');
INSERT INTO "CMS"."user_history" VALUES ('27', TO_TIMESTAMP(' 2020-05-23 11:00:37:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '102', '10', '63');
INSERT INTO "CMS"."user_history" VALUES ('28', TO_TIMESTAMP(' 2020-05-23 11:05:18:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '2', '2', '63');
INSERT INTO "CMS"."user_history" VALUES ('29', TO_TIMESTAMP(' 2020-05-23 11:11:13:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '41', '3', '63');
INSERT INTO "CMS"."user_history" VALUES ('30', TO_TIMESTAMP(' 2020-05-23 18:06:08:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '104', '12', '3');
INSERT INTO "CMS"."user_history" VALUES ('41', TO_TIMESTAMP(' 2021-04-09 21:38:04:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '104', '12', '23');
INSERT INTO "CMS"."user_history" VALUES ('42', TO_TIMESTAMP(' 2021-04-09 21:41:41:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '121', '11', '23');

-- ----------------------------
-- Table structure for user_like
-- ----------------------------
DROP TABLE "CMS"."user_like";
CREATE TABLE "CMS"."user_like" (
"id" NUMBER NOT NULL ,
"like_date" TIMESTAMP(6)  NULL ,
"state" NUMBER DEFAULT 1  NULL ,
"user_id" NUMBER NULL ,
"article_id" NUMBER NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of user_like
-- ----------------------------
INSERT INTO "CMS"."user_like" VALUES ('1', TO_TIMESTAMP(' 2020-03-08 14:52:33:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '2', '23', '1');
INSERT INTO "CMS"."user_like" VALUES ('2', TO_TIMESTAMP(' 2020-03-08 15:21:17:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', '3', '2');
INSERT INTO "CMS"."user_like" VALUES ('21', TO_TIMESTAMP(' 2020-05-22 22:07:51:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', '3', '4');
INSERT INTO "CMS"."user_like" VALUES ('22', TO_TIMESTAMP(' 2020-05-04 21:03:31:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', '3', '81');
INSERT INTO "CMS"."user_like" VALUES ('41', TO_TIMESTAMP(' 2020-05-22 22:15:54:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', '3', '102');
INSERT INTO "CMS"."user_like" VALUES ('42', TO_TIMESTAMP(' 2020-05-23 10:56:46:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', '63', '103');
INSERT INTO "CMS"."user_like" VALUES ('43', TO_TIMESTAMP(' 2020-05-23 11:00:12:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', '63', '92');
INSERT INTO "CMS"."user_like" VALUES ('44', TO_TIMESTAMP(' 2020-05-23 18:06:13:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', '3', '104');

-- ----------------------------
-- Table structure for user_note
-- ----------------------------
DROP TABLE "CMS"."user_note";
CREATE TABLE "CMS"."user_note" (
"id" NUMBER NOT NULL ,
"note_title" VARCHAR2(255 BYTE) NULL ,
"note_content" VARCHAR2(2550 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of user_note
-- ----------------------------
INSERT INTO "CMS"."user_note" VALUES ('1', '新用户注册信息', '欢迎来到本网站页面，祝你今后愉快。');
INSERT INTO "CMS"."user_note" VALUES ('2', '文章申报', '你所发表的文章正在审核，欢迎来到本网站页面，祝你今后愉快。');
INSERT INTO "CMS"."user_note" VALUES ('3', '文章申报成功', '你所发表的文章已经成功申报，欢迎来到本网站页面，祝你今后愉快。');
INSERT INTO "CMS"."user_note" VALUES ('4', '文章申报失败', '你所发表的文章已经失败申报，欢迎来到本网站页面，祝你今后愉快。');
INSERT INTO "CMS"."user_note" VALUES ('5', '文章举报信息', '你所发表的文章经过审核，存在有隐患问题，当前文章已被关闭');
INSERT INTO "CMS"."user_note" VALUES ('6', '文章举报信息', '你所举报的文章正在审核，过几天时间会公布');
INSERT INTO "CMS"."user_note" VALUES ('7', '文章举报成功', '你所举报的文章已经成功关闭，欢迎以后继续举报，祝你今后愉快。');
INSERT INTO "CMS"."user_note" VALUES ('8', '文章申报失败', '你所举报的文章经过审核，没有存在任何问题，欢迎以后继续举报，祝你今后愉快。');
INSERT INTO "CMS"."user_note" VALUES ('21', '测试西悉尼', '<p>测试西悉尼</p>');
INSERT INTO "CMS"."user_note" VALUES ('22', '二号文件二号文件和', '<p>二号文件二号文件和</p>');
INSERT INTO "CMS"."user_note" VALUES ('23', '二号文件二号文件和', '<p>二号文件二号文件和</p>');
INSERT INTO "CMS"."user_note" VALUES ('24', '黄后大道东', '<p>黄后大道东</p>');
INSERT INTO "CMS"."user_note" VALUES ('25', '北邮大学', '<p>北邮大学</p>');
INSERT INTO "CMS"."user_note" VALUES ('26', '深圳大学', '<p>深圳大学</p>');
INSERT INTO "CMS"."user_note" VALUES ('27', '二号文件二号文件和', '<p>深圳大学</p>');
INSERT INTO "CMS"."user_note" VALUES ('28', '广告来啦', '<p style="text-align: center;"><strong>这是广告<img src="http://image.biaobaiju.com/uploads/20180917/22/1537195272-SKNpIirjyf.jpg" width="20" height="20" title="测试的" border="2" alt="测试的" vspace="2"/></strong></p>');
INSERT INTO "CMS"."user_note" VALUES ('30', '广告来一波', '<p><span style="color: rgb(31, 73, 125);">广告来一波L：<a href="https://www.baidu.com/" target="_blank" title="百度">百度链接</a></span></p><p><img src="https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3790014455,2670545218&fm=26&gp=0.jpg" width="200" height="200" title="就压" border="2" alt="就压" vspace="2"/></p>');
INSERT INTO "CMS"."user_note" VALUES ('31', '来一波广告', '<p style="text-align: center;"><span style="color: rgb(31, 73, 125);"><img src="https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1590202940&di=789702e767ae3d9a7a345e1bc5ff75cd&src=http://image.biaobaiju.com/uploads/20180801/23/1533137122-vOrfsEHhpK.jpeg" width="200" height="200"/>来一波广告</span><br/></p>');
INSERT INTO "CMS"."user_note" VALUES ('32', null, '<p>了了了了了了</p>');
INSERT INTO "CMS"."user_note" VALUES ('33', '这是短信', '<p>这是短信<br/></p>');
INSERT INTO "CMS"."user_note" VALUES ('41', null, '<p><span style="color: rgb(229, 185, 183);">今天是个好日子</span><br/></p>');

-- ----------------------------
-- Table structure for user_noterelated
-- ----------------------------
DROP TABLE "CMS"."user_noterelated";
CREATE TABLE "CMS"."user_noterelated" (
"id" NUMBER NOT NULL ,
"note_date" TIMESTAMP(6)  NULL ,
"note_state" NUMBER DEFAULT '0'  NULL ,
"article_id" NUMBER NULL ,
"usernote_id" NUMBER NULL ,
"user_id" NUMBER NULL ,
"other_id" NUMBER NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of user_noterelated
-- ----------------------------
INSERT INTO "CMS"."user_noterelated" VALUES ('102', TO_TIMESTAMP(' 2020-05-21 18:18:41:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', null, '23', null, '1');
INSERT INTO "CMS"."user_noterelated" VALUES ('103', TO_TIMESTAMP(' 2020-05-21 18:21:18:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', null, '24', null, '1');
INSERT INTO "CMS"."user_noterelated" VALUES ('104', TO_TIMESTAMP(' 2020-05-21 18:24:45:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', null, '25', '2', '1');
INSERT INTO "CMS"."user_noterelated" VALUES ('105', TO_TIMESTAMP(' 2020-05-21 18:30:56:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', null, '26', null, '1');
INSERT INTO "CMS"."user_noterelated" VALUES ('106', TO_TIMESTAMP(' 2020-05-21 18:32:06:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', null, '27', null, '1');
INSERT INTO "CMS"."user_noterelated" VALUES ('107', TO_TIMESTAMP(' 2020-05-21 19:13:19:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', null, '28', null, '1');
INSERT INTO "CMS"."user_noterelated" VALUES ('108', TO_TIMESTAMP(' 2020-05-22 12:08:15:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', '101', '2', '3', '1');
INSERT INTO "CMS"."user_noterelated" VALUES ('109', TO_TIMESTAMP(' 2020-05-22 12:30:07:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', null, '30', null, '1');
INSERT INTO "CMS"."user_noterelated" VALUES ('110', TO_TIMESTAMP(' 2020-05-22 12:46:12:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '101', '3', '3', '1');
INSERT INTO "CMS"."user_noterelated" VALUES ('111', TO_TIMESTAMP(' 2020-05-22 12:50:42:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '102', '2', '43', '1');
INSERT INTO "CMS"."user_noterelated" VALUES ('112', TO_TIMESTAMP(' 2020-05-22 12:51:05:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '102', '3', '43', '1');
INSERT INTO "CMS"."user_noterelated" VALUES ('113', TO_TIMESTAMP(' 2020-05-23 10:54:02:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', null, '1', '63', '1');
INSERT INTO "CMS"."user_noterelated" VALUES ('114', TO_TIMESTAMP(' 2020-05-23 10:55:18:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '103', '2', '63', '1');
INSERT INTO "CMS"."user_noterelated" VALUES ('115', TO_TIMESTAMP(' 2020-05-23 10:56:09:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', '103', '3', '63', '1');
INSERT INTO "CMS"."user_noterelated" VALUES ('116', TO_TIMESTAMP(' 2020-05-23 10:57:01:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', '103', '5', '63', '1');
INSERT INTO "CMS"."user_noterelated" VALUES ('117', TO_TIMESTAMP(' 2020-05-23 10:57:01:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '103', '6', '63', '1');
INSERT INTO "CMS"."user_noterelated" VALUES ('118', TO_TIMESTAMP(' 2020-05-23 11:02:40:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', null, '31', null, '1');
INSERT INTO "CMS"."user_noterelated" VALUES ('119', TO_TIMESTAMP(' 2020-05-23 11:52:55:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', null, '32', null, '1');
INSERT INTO "CMS"."user_noterelated" VALUES ('120', TO_TIMESTAMP(' 2020-05-23 18:05:18:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '104', '2', '3', '1');
INSERT INTO "CMS"."user_noterelated" VALUES ('121', TO_TIMESTAMP(' 2020-05-23 18:05:56:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '104', '3', '3', '1');
INSERT INTO "CMS"."user_noterelated" VALUES ('122', TO_TIMESTAMP(' 2020-05-23 18:10:02:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', null, '33', null, '1');
INSERT INTO "CMS"."user_noterelated" VALUES ('141', TO_TIMESTAMP(' 2021-04-09 21:32:04:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '1', null, '41', null, '1');
INSERT INTO "CMS"."user_noterelated" VALUES ('142', TO_TIMESTAMP(' 2021-04-09 21:40:19:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '121', '2', '23', '1');
INSERT INTO "CMS"."user_noterelated" VALUES ('143', TO_TIMESTAMP(' 2021-04-09 21:41:15:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '0', '121', '3', '23', '1');

-- ----------------------------
-- Table structure for user_report
-- ----------------------------
DROP TABLE "CMS"."user_report";
CREATE TABLE "CMS"."user_report" (
"id" NUMBER NOT NULL ,
"report_date" TIMESTAMP(6)  NULL ,
"report_type" VARCHAR2(255 BYTE) NULL ,
"report_content" VARCHAR2(255 BYTE) NULL ,
"state" NUMBER DEFAULT '1'  NULL ,
"process_date" TIMESTAMP(6)  NULL ,
"process_content" VARCHAR2(255 BYTE) NULL ,
"user_id" NUMBER NULL ,
"article_id" NUMBER NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of user_report
-- ----------------------------
INSERT INTO "CMS"."user_report" VALUES ('1', TO_TIMESTAMP(' 2020-03-05 14:32:58:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '抄袭,色情,', '到我创意', '0', null, null, '2', '4');
INSERT INTO "CMS"."user_report" VALUES ('21', TO_TIMESTAMP(' 2020-03-07 14:29:43:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '暴力,反动,', '我要举报', '0', null, null, '3', '4');
INSERT INTO "CMS"."user_report" VALUES ('22', TO_TIMESTAMP(' 2020-03-07 17:50:19:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '抄袭,暴力,', '反正就是举报', '0', null, null, '23', '4');
INSERT INTO "CMS"."user_report" VALUES ('41', TO_TIMESTAMP(' 2020-03-08 14:51:18:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '暴力,色情,', '反动', '1', TO_TIMESTAMP(' 2020-03-17 16:14:10:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '处理失败', '23', '1');
INSERT INTO "CMS"."user_report" VALUES ('42', TO_TIMESTAMP(' 2020-03-08 15:21:31:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '暴力,', '举报', '1', TO_TIMESTAMP(' 2020-03-17 16:19:04:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '文章已成功处理', '3', '2');
INSERT INTO "CMS"."user_report" VALUES ('49', TO_TIMESTAMP(' 2020-03-08 16:08:55:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '反动,', '饭都没货', '0', null, null, '3', '3');
INSERT INTO "CMS"."user_report" VALUES ('62', TO_TIMESTAMP(' 2020-03-15 14:06:14:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '暴力,', '巴黎', '1', TO_TIMESTAMP(' 2020-03-23 18:00:22:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '文章已成功处理', '3', '5');
INSERT INTO "CMS"."user_report" VALUES ('61', TO_TIMESTAMP(' 2020-03-15 11:52:11:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '色情,反动,', '就是举报', '1', TO_TIMESTAMP(' 2020-03-17 16:14:10:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '处理失败', '3', '1');
INSERT INTO "CMS"."user_report" VALUES ('84', TO_TIMESTAMP(' 2020-03-30 14:01:57:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '抄袭,', '几位举报它', '0', null, null, '3', '71');
INSERT INTO "CMS"."user_report" VALUES ('82', TO_TIMESTAMP(' 2020-03-30 13:01:53:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '抄袭,', '呵呵呵呵', '0', null, null, '45', '71');
INSERT INTO "CMS"."user_report" VALUES ('83', TO_TIMESTAMP(' 2020-03-30 13:59:29:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '抄袭,', '举报', '0', null, null, '2', '71');
INSERT INTO "CMS"."user_report" VALUES ('85', TO_TIMESTAMP(' 2020-03-30 14:07:28:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '抄袭,', '66666666', '0', null, null, '23', '71');
INSERT INTO "CMS"."user_report" VALUES ('87', TO_TIMESTAMP(' 2020-03-30 14:18:39:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '色情,', '搞错了', '0', null, null, '43', '71');
INSERT INTO "CMS"."user_report" VALUES ('101', TO_TIMESTAMP(' 2020-05-23 10:57:01:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '暴力,色情,', '举报', '1', TO_TIMESTAMP(' 2020-05-23 10:58:46:000000', 'YYYY-MM-DD HH24:MI:SS:FF6'), '文章已成功处理', '63', '103');

-- ----------------------------
-- Sequence structure for ARTICLE_SEQUENCE
-- ----------------------------
DROP SEQUENCE "CMS"."ARTICLE_SEQUENCE";
CREATE SEQUENCE "CMS"."ARTICLE_SEQUENCE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 141
 CACHE 20;

-- ----------------------------
-- Sequence structure for CATEGORY_SEQUENCE
-- ----------------------------
DROP SEQUENCE "CMS"."CATEGORY_SEQUENCE";
CREATE SEQUENCE "CMS"."CATEGORY_SEQUENCE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 61
 CACHE 20;

-- ----------------------------
-- Sequence structure for COLLECTION_SEQUENCE
-- ----------------------------
DROP SEQUENCE "CMS"."COLLECTION_SEQUENCE";
CREATE SEQUENCE "CMS"."COLLECTION_SEQUENCE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 81
 CACHE 20;

-- ----------------------------
-- Sequence structure for COMMENT_SEQUENCE
-- ----------------------------
DROP SEQUENCE "CMS"."COMMENT_SEQUENCE";
CREATE SEQUENCE "CMS"."COMMENT_SEQUENCE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 121
 CACHE 20;

-- ----------------------------
-- Sequence structure for COMMENTARY_SEQUENCE
-- ----------------------------
DROP SEQUENCE "CMS"."COMMENTARY_SEQUENCE";
CREATE SEQUENCE "CMS"."COMMENTARY_SEQUENCE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 101
 CACHE 20;

-- ----------------------------
-- Sequence structure for DOWN_SEQUENCE
-- ----------------------------
DROP SEQUENCE "CMS"."DOWN_SEQUENCE";
CREATE SEQUENCE "CMS"."DOWN_SEQUENCE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 61
 CACHE 20;

-- ----------------------------
-- Sequence structure for HISTORY_SEQUENCE
-- ----------------------------
DROP SEQUENCE "CMS"."HISTORY_SEQUENCE";
CREATE SEQUENCE "CMS"."HISTORY_SEQUENCE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 61
 CACHE 20;

-- ----------------------------
-- Sequence structure for LIKE_SEQUENCE
-- ----------------------------
DROP SEQUENCE "CMS"."LIKE_SEQUENCE";
CREATE SEQUENCE "CMS"."LIKE_SEQUENCE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 61
 CACHE 20;

-- ----------------------------
-- Sequence structure for NOTE_SEQUENCE
-- ----------------------------
DROP SEQUENCE "CMS"."NOTE_SEQUENCE";
CREATE SEQUENCE "CMS"."NOTE_SEQUENCE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 61
 CACHE 20;

-- ----------------------------
-- Sequence structure for NOTERELATED_SEQUENCE
-- ----------------------------
DROP SEQUENCE "CMS"."NOTERELATED_SEQUENCE";
CREATE SEQUENCE "CMS"."NOTERELATED_SEQUENCE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 161
 CACHE 20;

-- ----------------------------
-- Sequence structure for REPORT_SEQUENCE
-- ----------------------------
DROP SEQUENCE "CMS"."REPORT_SEQUENCE";
CREATE SEQUENCE "CMS"."REPORT_SEQUENCE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 121
 CACHE 20;

-- ----------------------------
-- Sequence structure for USER_SEQUENCE
-- ----------------------------
DROP SEQUENCE "CMS"."USER_SEQUENCE";
CREATE SEQUENCE "CMS"."USER_SEQUENCE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 83
 CACHE 20;

-- ----------------------------
-- Indexes structure for table article
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table article
-- ----------------------------
ALTER TABLE "CMS"."article" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table category
-- ----------------------------

-- ----------------------------
-- Checks structure for table category
-- ----------------------------
ALTER TABLE "CMS"."category" ADD CHECK ("name" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table category
-- ----------------------------
ALTER TABLE "CMS"."category" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user
-- ----------------------------

-- ----------------------------
-- Uniques structure for table user
-- ----------------------------
ALTER TABLE "CMS"."user" ADD UNIQUE ("account");

-- ----------------------------
-- Checks structure for table user
-- ----------------------------
ALTER TABLE "CMS"."user" ADD CHECK ("account" IS NOT NULL);
ALTER TABLE "CMS"."user" ADD CHECK ("password" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table user
-- ----------------------------
ALTER TABLE "CMS"."user" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user_collection
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table user_collection
-- ----------------------------
ALTER TABLE "CMS"."user_collection" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user_comment
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table user_comment
-- ----------------------------
ALTER TABLE "CMS"."user_comment" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user_commentary
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table user_commentary
-- ----------------------------
ALTER TABLE "CMS"."user_commentary" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user_down
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table user_down
-- ----------------------------
ALTER TABLE "CMS"."user_down" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user_history
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table user_history
-- ----------------------------
ALTER TABLE "CMS"."user_history" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user_like
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table user_like
-- ----------------------------
ALTER TABLE "CMS"."user_like" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user_note
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table user_note
-- ----------------------------
ALTER TABLE "CMS"."user_note" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user_noterelated
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table user_noterelated
-- ----------------------------
ALTER TABLE "CMS"."user_noterelated" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user_report
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table user_report
-- ----------------------------
ALTER TABLE "CMS"."user_report" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Key structure for table "CMS"."article"
-- ----------------------------
ALTER TABLE "CMS"."article" ADD FOREIGN KEY ("user_id") REFERENCES "CMS"."user" ("id");
ALTER TABLE "CMS"."article" ADD FOREIGN KEY ("category_id") REFERENCES "CMS"."category" ("id");

-- ----------------------------
-- Foreign Key structure for table "CMS"."user_collection"
-- ----------------------------
ALTER TABLE "CMS"."user_collection" ADD FOREIGN KEY ("user_id") REFERENCES "CMS"."user" ("id");
ALTER TABLE "CMS"."user_collection" ADD FOREIGN KEY ("article_id") REFERENCES "CMS"."article" ("id");

-- ----------------------------
-- Foreign Key structure for table "CMS"."user_comment"
-- ----------------------------
ALTER TABLE "CMS"."user_comment" ADD FOREIGN KEY ("user_id") REFERENCES "CMS"."user" ("id");
ALTER TABLE "CMS"."user_comment" ADD FOREIGN KEY ("article_id") REFERENCES "CMS"."article" ("id");

-- ----------------------------
-- Foreign Key structure for table "CMS"."user_commentary"
-- ----------------------------
ALTER TABLE "CMS"."user_commentary" ADD FOREIGN KEY ("user_id") REFERENCES "CMS"."user" ("id");
ALTER TABLE "CMS"."user_commentary" ADD FOREIGN KEY ("article_id") REFERENCES "CMS"."article" ("id");
ALTER TABLE "CMS"."user_commentary" ADD FOREIGN KEY ("usercomment_id") REFERENCES "CMS"."user_comment" ("id");

-- ----------------------------
-- Foreign Key structure for table "CMS"."user_down"
-- ----------------------------
ALTER TABLE "CMS"."user_down" ADD FOREIGN KEY ("article_id") REFERENCES "CMS"."article" ("id");
ALTER TABLE "CMS"."user_down" ADD FOREIGN KEY ("user_id") REFERENCES "CMS"."user" ("id");

-- ----------------------------
-- Foreign Key structure for table "CMS"."user_history"
-- ----------------------------
ALTER TABLE "CMS"."user_history" ADD FOREIGN KEY ("article_id") REFERENCES "CMS"."article" ("id");
ALTER TABLE "CMS"."user_history" ADD FOREIGN KEY ("category_id") REFERENCES "CMS"."category" ("id");
ALTER TABLE "CMS"."user_history" ADD FOREIGN KEY ("user_id") REFERENCES "CMS"."user" ("id");

-- ----------------------------
-- Foreign Key structure for table "CMS"."user_like"
-- ----------------------------
ALTER TABLE "CMS"."user_like" ADD FOREIGN KEY ("user_id") REFERENCES "CMS"."user" ("id");
ALTER TABLE "CMS"."user_like" ADD FOREIGN KEY ("article_id") REFERENCES "CMS"."article" ("id");

-- ----------------------------
-- Foreign Key structure for table "CMS"."user_noterelated"
-- ----------------------------
ALTER TABLE "CMS"."user_noterelated" ADD FOREIGN KEY ("article_id") REFERENCES "CMS"."article" ("id");
ALTER TABLE "CMS"."user_noterelated" ADD FOREIGN KEY ("usernote_id") REFERENCES "CMS"."user_note" ("id");
ALTER TABLE "CMS"."user_noterelated" ADD FOREIGN KEY ("user_id") REFERENCES "CMS"."user" ("id");
ALTER TABLE "CMS"."user_noterelated" ADD FOREIGN KEY ("other_id") REFERENCES "CMS"."user" ("id");

-- ----------------------------
-- Foreign Key structure for table "CMS"."user_report"
-- ----------------------------
ALTER TABLE "CMS"."user_report" ADD FOREIGN KEY ("user_id") REFERENCES "CMS"."user" ("id");
ALTER TABLE "CMS"."user_report" ADD FOREIGN KEY ("article_id") REFERENCES "CMS"."article" ("id");
