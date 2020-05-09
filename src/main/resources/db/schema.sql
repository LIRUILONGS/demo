DROP TABLE IF EXISTS `hr`;
CREATE TABLE `hr`  (
  `id` int(11) NOT NULL  COMMENT 'hrID',
  `name` varchar(32)  NULL DEFAULT NULL COMMENT '姓名',
  `phone` char(11)  NULL DEFAULT NULL COMMENT '手机号码',
  `telephone` varchar(16)  NULL DEFAULT NULL COMMENT '住宅电话',
  `address` varchar(64)  NULL DEFAULT NULL COMMENT '联系地址',
  `enabled` tinyint(1) NULL DEFAULT 1,
  `username` varchar(255)  NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255)  NULL DEFAULT NULL COMMENT '密码',
  `userface` varchar(255)  NULL DEFAULT NULL,
  `remark` varchar(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;
