create table resume(
  uuid int(10) not null auto_increment comment 'UUID',
	name varchar(255) not null comment '名字',
  id varchar(255) not null comment '身份证号',
  school varchar(255) not null comment '学校',
  process int(10) not null DEFAULT '0' comment '简历状态',
  deleteStatus boolean not null DEFAULT '0' comment '逻辑删除标识',
  primary key (uuid)
)engine = InnoDB auto_increment=1 default charset utf8;