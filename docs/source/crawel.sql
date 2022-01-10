USE `pedestal`;

CREATE TABLE `cms_content` (
`content_id` VARCHAR(40) NOT NULL COMMENT '内容ID',
`title` VARCHAR(150) NOT NULL COMMENT '标题',
`content` LONGTEXT COMMENT '文章内容',
`release_date` DATETIME NOT NULL COMMENT '发布日期',
PRIMARY KEY (`content_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='CMS内容表';