-- test @date 
create table user_(id_ VARCHAR(64),name_ VARCHAR(32),password_ VARCHAR(64));

-- crawler_ 
CREATE TABLE `crawl_info` (
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



CREATE TABLE JOIN_ACTIVITY (
	ID_ VARCHAR (64) PRIMARY KEY,
	TITLE_ VARCHAR (256) COMMENT '标题',
	DESC_ VARCHAR (512) COMMENT '描述',
	CONTENT_ TEXT COMMENT '内容',
	AUTHOR_ VARCHAR (64),
	CREATE_TIME_ DATE,
	CREATE_USER_ VARCHAR (64),
	UPDATE_TIME_ DATE,
	UPDATE_USER_ VARCHAR (64)
);

ALTER TABLE JOIN_ACTIVITY COMMENT = '活动表';

CREATE TABLE JOIN_ACTIVITY_IMG (
	ID_ VARCHAR (64) PRIMARY KEY,
	IMG_ VARCHAR (256) COMMENT '图片路径',
	ACT_ID_ VARCHAR (64) COMMENT '活动外键',
	CREATE_USER_ VARCHAR (64),
	UPDATE_TIME_ DATE,
	UPDATE_USER_ VARCHAR (64)
) ALTER TABLE JOIN_ACTIVITY COMMENT = '活动图片表';


drop table JOIN_CRAWLER_INFO;
CREATE TABLE JOIN_CRAWLER_INFO (
	ID_ VARCHAR (64) PRIMARY KEY,
	TITLE_ VARCHAR (256) COMMENT '标题',
	DESC_ VARCHAR (512) COMMENT '描述',
	CONTENT_ TEXT COMMENT '内容',
	AUTHOR_ VARCHAR (64) COMMENT '发布人',
	PUBLISH_TIME_ varchar(32) comment '发布时间',
	VIEW_COUNT_ varchar(32) comment '浏览数',
	FROM_TYPE_ VARCHAR (32) comment '来源type',
	FROM_URL_ VARCHAR (512) COMMENT '来源url',
	CREATE_TIME_ DATE,
	CREATE_USER_ VARCHAR (64),
	UPDATE_TIME_ DATE,
	UPDATE_USER_ VARCHAR (64)
);

ALTER TABLE JOIN_CRAWLER_INFO COMMENT = '爬取信息表';




