-- test @date 
create table user_(id_ VARCHAR(64),name_ VARCHAR(32),password_ VARCHAR(64));

-- crawler_ 
CREATE TABLE `crawl_info_` (
  `id_` varchar(64) NOT NULL,
  `title_` varchar(64) DEFAULT NULL COMMENT '标题',
  `desc_` varchar(256) DEFAULT NULL COMMENT '描述',
  `content_` text COMMENT '内容',
  `img_` varchar(516) DEFAULT NULL COMMENT '图片',
	`pulish_author_` varchar(32) DEFAULT NULL COMMENT '发布用户',
  `pulish_time_` datetime DEFAULT NULL COMMENT '发布时间',
	`requst_from_` varchar(64) DEFAULT NULL COMMENT '请求来源',
  `requst_url_` varchar(256) DEFAULT NULL COMMENT '请求链接',
  `create_by_` varchar(64) DEFAULT NULL COMMENT '创建人',
  `create_time_` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


