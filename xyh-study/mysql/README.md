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

1. 注意：
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
* 大数据类型（不常用）
blob：字节（电影，mp3）<br>
text:字符（文本的内容）<br>
* 数值型（重点）
tinyint、samllint、int、bigint、float、double
* 逻辑型
bit
* 日期型（重点）<br> 
date:只包含日期（年月日）<br>
time:只包含时间（时分秒）<br>
datetime：包含日期和时间。如果插入数据的时候，字符值为空，字段值就为空<br>
timestamp：包含日期和时间。如果插入数据的时候，设置字段的值为空，默认获取当前的系统时候，把时间存入字段中
5. 单表约束
* 约束的好处：保证数据的完整性
* 主键约束：<br>
(1) 关键字：primary key通过该关键字声明某列为主键<br>
(2) 唯一：值不能相同 <br>
(3) 非空：值不能为空 <br>
(4) 被引用：和外键一起来使用<br>
* 唯一约束
声明字段是唯一的，使用关键字unique
* 非空约束
声明字段的值不能为空。使用关键字not null
#### 删除和查看表
1. 删除表：drop table 表名
2. 查看标签
* desc 表名; --查询表结构的详细信息
* show tables; --查看当前数据库中所有的表结构
* show create table 表名; --查看表的创建信息

#### 修改表
1. 添加一个新的字段
* alter table 表名 add 字段名称 数据类型(长度) 约束;
2. 修改字段的数据类型，长度或者约束
* alter table 表名 modify 字段名称 数据类型(长度) 约束;
3. 删除某个字段
* alter table 表名 drop 字段名称;
4. 修改字段名称
* alter table 表名 change 旧字段 新字段数据类型(长度) 约束;
5.修改表名称
* rename table 旧表名 to 新表名
### 数据库的数据

#### 插入数据（insert）
1. 添加数据，使用insert into 关键字来添加数据
* insert into 表(字段1，字段2，字段3)values(值1，值2，值3) ---向表中的指定字段添加值
* insert into 表 values(值1，值2，值3，值4....) ---向表中的所有字段添加值
2. 注意事项
* 插入的数据与字段类型相同
* 数据的大小应该在规定的范围内
* 数据中的数据的列的位置和字段位置一一对应
* 字符串和日期类型的数据，必须使用单引号括起来
3. 例子
* insert into employees (id,name,gender) values(2,'Dora','女');
* insert into employees values (3,'Marry','女','1993-06-23','业务经理',6600,'my name is Marry');

#### 解决中文乱码问题

1. 问题引入：dos窗口 默认编码是GBK，mysql 客户端窗口是utf-8， mysql服务器 utf-8
2. 注意：客户端给服务器端传输不同编码时，不会乱码，服务器内部已经解决了
3. 如何解决：
* 先把mysql服务器停止
* 找到mysql安装路径，找到my.ini的配置文件
* 修改**客户端**的编码，改为gbk<br>
  default-character-set=gbk<br>
* 重启mysql服务器

#### 修改数据
1. 修改数据，使用update关键字来完成修改数据
* update 表名称 set 字段1=值1,字段2=值2 where 条件
* 修改字段1和字段2的值：
 > 如果没有where关键字，说明修改的默认所有的记录
 > 如果有where关键字，修改的是符合条件的记录
2. 注意：
* 如果要是没有where的条件语句，默认修改所有的数据
* 如果有where的条件语句，修改的符合条件的数据

#### 删除数据库
1. 删除语句
* delete from 表 where 条件
> 如果不加where，默认删除所有的数据
> 如果加where，删除符合条件的数据
2. 删除所有的数据
* delete from 表
> 一行一行删掉
> 支持事务的操作，可通过回滚，可以找回
* truncate 表中存放数据
> 先把整个表删掉（数据删除了），创建一个与原来一模一样的表

#### 查询数据select

1. 查询语句的语法
* select * from 表;  --默认查询所有的字段数据
* select 字段1,字段2,字段3 from 表; --查询指定的字段数据
* DISTINCT   --去掉重复 select  distinct salary  from 表;
* 可以对查询的列进行运算  <br>
select salary+100 from employees; <br>
select username ,(math+english+chinese) from students<br>
select username ,(math+english+chinese) as total from students<br>
2. 查询语句中可以使用as关键字起别名
* 别名的真正用法，采用的多表查询，为了区分每张表，起个别名
* as的关键字可以省略不写，中间需要用空格
* 一般都是给表起别名<br>
select s.username,s.math from stu s;<br>
select s.username,u.username from stu s,user u;<br>
3. 可以使用where语句对查询结果进行过滤<br>
select * from employees as emp where salary>4000;<br>;
select username ,(math+english+chinese) as total from students where total>200; 写法错误<br>
select username ,(math+english+chinese) as total from students where math+english+chinese>200; 写法正确<br>

#### where字句后可以使用的符号
1. 常用的符号
* >  <  <=  >=  =  <>(不等于)  

* in  --代表范围
* select * from employees where salary in(6600,4000);

* like  --模糊查询<br>

like 关键字的写法：<br>
select * from employees where name like '张_'; 使用_ 占位符，结果：张飞 张三 张x（符合）张得顺（不符合）<br><br>
select * from employees where name like '张%'; 结果 张飞 张三 张x 张得顺都符合<br>

like '%张';     --结果：以张结尾的都可以<br>
like '%张%';    --结果：只要包含张就可以<br>
总结<br>
条件需要使用单引号<br>
需要使用占位符  _ :代表一个位置，%代表多个位置<br>

* and    --与    例如：select * from employees where  salary>6000 and age<30; --查询工资大于6000且年龄小于30的员工信息
* or     --或   例如：select * from employees where  salary>6000 or age<30;  --查询工资大于6000或者年龄小于30的员工信息
* not    --非   例如：select * from employees where salary not in(4000,6000); --查询工资不是4000和6000的员工
* between  and  例如：select * from employees where salary between 4000 and 6600; --查询工资在4000（包括）到6600（包括）以内的员工信息

#### 使用order by 对结果进行排序
1. 语法：
* order by 字段 asc  --降序排列
* order by 字段 desc  --升序排列

* select name, (math+chinses+english) as total from students order by total desc;  --对学生的数学、语文、英语总成绩进行降序排序，并显示姓名和总分
* select name, math,english from students order by english desc,math desc; --对学生成绩按照英语进行降序，再按照数据进行降序排列，并显示姓名、数据和英语成绩

2. 注意事项
* order by 放在select语句末尾
* select * from xx where xx order by xx；

#### 聚合函数
1. 概念：excel表格。求数量，求和，平均值，最大值，最小值
2. 聚合函数操作的都是某一列的数据
3. 聚合函数
* count() --求数量
> select count(*) | count(列名) from 表
> 统计一个班级共有多少学生： select count(*) from students；
> 统计学生数学成绩大于90的学生个数： select count(math) from students where math>90;
* sum() --求某一列数据的和
* 注意： 没有sum(*),只有sum(列明),且只对数值类型起作用
> select sum(math) from students; --查询班级的数学总成绩
> select sum(math+english+chinese) from students; --查询班级所有成绩的总成绩
> select sum(chinese)/cout(*) from students; --查询班级语文的平均分

* avg() --求平均值
>select avg(chinese) from students; --查询班级语文的平均分
4. 总结 
* 聚集函数，是函数，不要忘记写()
* 计算都是某一列的数据
* 聚集函数
> count() --求数量
> sum() --求和
> avg() --求平均值
> max() --求最大值
> min() --最小值

#### 分组查询

1. 分组的概念
* select * from students --查询所有数据，默认为一组
* 可以使用关键字 group by sex 根据字段进行分组
> select count(*) from employees group by gender; --统计两个性别的人数
> select product,sum(price) from orders group by product having sum(price)>100 ; --查询购买了几类商品，并且每类总价大于100的商品
> select product ,sum(price) from orders where price>95 group by product having sum(price)>100;--查询购买几类商品，并且商品价格需要大于100，每类总价大于100的商品
* 使用where的条件语句，若果有分组，是在分组之前的条件
* having关键字是进行分组的条件过滤
* where关键字后不能使用聚集函数，而having可以使用聚集函数













 






