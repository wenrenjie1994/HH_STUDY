CREATE DATABASE HRSv3;

USE HRSv3;

CREATE TABLE hr_resume(
   -- 主键
   serialid INT PRIMARY KEY AUTO_INCREMENT,
   -- 身份id
   id VARCHAR(100),
   -- 名称   
   NAME VARCHAR(100),
   -- 学校
   school VARCHAR(200),
   -- 邮箱
   email  VARCHAR(200)
);

SELECT * FROM hr_resume;

INSERT  INTO hr_resume(serialid,id,NAME,school,email) VALUES (1,'123','张三','北京大学','zhangsan@qq.com');
INSERT  INTO hr_resume(serialid,id,NAME,school,email) VALUES (DEFAULT,'124','李四','清华大学','lisi@qq.com');
INSERT  INTO hr_resume(id,NAME,school,email) VALUES ('125','王五','清华大学','wangwu@qq.com');

SELECT * FROM hr_resume WHERE id = '23';

DELETE FROM hr_resume WHERE id = '123';
INSERT  INTO hr_resume(id,NAME,school,email) VALUES ('123','张三','北京大学','zhangsan@qq.com');

UPDATE hr_resume SET NAME='小明',school='电子科大',email='xm@qq.com' WHERE id='125'
