## SQL语句语言（操作数据库）
### mysql数据库的概念
一个数据库的服务器包含多个数据库，一个数据库中有多张表，一个表中包含多个字段（字段和JavaBean的属性是对应的）<br>
表中存放数据,一行数据和一个JavaBean实体对象相对应

### SQL：Structured Query Language（结构化查询语言）
1. SQL非过程性的语言
*过程性语言：依赖上一条或者几条语句执行
*非过程性语言：一条语言，就对应一个返回结果
2. SQL语言是基础
### SQL语言的分类
1. DDL 数据库定义语言
* 创建数据库、创建表、创建视图、创建索引 修改数据库 删除数据库 修改表 删除表
* create（创建） alter（修改） drop（删除）
2. DML 数据操作语言
*操作数据、插入数据（insert）、修改数据（update）、删除数据（delete）
3. DCL 数据控制语言（存储过程）
* if else while（逻辑代码）
4 DQL 数据查询语言
* 从表中查询数据（select）
### 数据库的操作
#### 创建数据库的语法
1. 基本语法（常用）：create database 数据库名称
2. 正宗语法：create database 数据名称 character set 编码 collate 校对规则
注：校对规则决定当前数据库属性
#### 例子
1. 创建一个名称为mydb1的数据库：create database mydb1
2. 创建一个使用utf8字符集的mydb2数据库：create database mydb2 character set ‘utf-8’
3. 创建一个使用utf8字符集，并带校对规则的mydb3数据库：create database mydb3 character set ‘utf-8’ collate ‘utf8_bin’
注：默认的编码规则为utf8
#### 查看数据库（重点）
1. show databases;  --查看所有数据库
2. use 数据库名称; --使用该数据库
3. show create database 数据库名称; --查询数据库的创建信息
4. select database() --查询当前正在使用的数据库
#### 删除数据库
1. drop database 数据库名称  --删除数据库
#### 修改数据库（慎用）
alter database 数据库名称 character set ‘gbk’ collate ‘校对规则’;
注：该命令改变不了数据库的名称
### 表操作
#### 创建表
1. 语法：
create table 表名称(<br>
    字段1 类型(长度) 约束，<br>
	字段2 类型(长度) 约束，<br>
	字段3 类型(长度) 约束<br>
	
);<br>
2. 注意：
* 创建表的时候，后面用小括号，且最后以分号结束
* 编写字段，字段与字段之间使用逗号，最后一个字段不能使用逗号
* 如果声明字符串数据的类型，长度必须指定
* 如果不指定数据的长度，有默认值的。int类型的默认长度值是11
3. 创建一张表结构
create table employee(<br>
     id int primary key,<br>
	 name varchar(30),<br>
	 gender char(5),<br>
	 birthday date,<br>
	 job varchar(50),<br>
	 salary double,<br>
	 resume text<br>
);<br>
4.表设计类型（重点）
* 字符串型
varchar：长度可变。可节省空间<br>
char：长度不可变。长度不够使用空格补全<br>
*大数据类型（不常用）
blob：字节（电影，mp3）<br>
text:字符（文本的内容）<br>
* 数值型（重点）
tinyint、samllint、int、bigint、float、double
* 逻辑型
bit
*日期型（重点） 
date:只包含日期（年月日）<br>
time:只包含时间（时分秒）<br>
datetime：包含日期和时间。如果插入数据的时候，字符值为空，字段值就为空<br>
timestamp：包含日期和时间。如果插入数据的时候，设置字段的值为空，默认获取当前的系统时候，把时间存入字段中
5. 单表约束
* 约束的好处：保证数据的完整性
* 主键约束：
(1) 关键字：primary key通过该关键字声明某列为主键
(2) 唯一：值不能相同 
(1) 非空：值不能为空 
(1) 被引用：和外键一起来使用
* 唯一约束
声明字段是唯一的，使用关键字unique
* 非空约束
声明字段的值不能为空。使用关键字not null
#### 删除和查看表
1. 删除表：drop table 表明
2. 查看标签
*desc 表名; --查询表的信息
*show tables; --查看当前数据库中所有标签
*show create table 表名; --查看表的创建信息


 






