# MySQL
启动：net start mysql<br>
关闭：net stop mysql<br>
登录：mysql -uroot(user) - proot(password)<br>
mysql -h(id) -uroot(user) - proot(password)<br>
退出：exit<br>
# SQL分类
## DDL（操作数据库，表）
### 操作数据库：CRUD<br>
#### 1 创建数据库create<br>
创建：create database 数据库名称;<br>
创建,判断是否存在：create database if not exits 数据库名称;<br>
创建数据库并指定字符集：create database character set 字符集名( gbk ,utf8) <br>
#### 2 查询retrieve<br>
查询所有数据库的名称：show databases;<br>
查询某个数据库的字符集：show create databases 数据库名称;<br>
#### 3 修改update<br>
修改数据库的字符集：alter database 数据库名称 set 字符集名称;<br>
#### 4 删除delete<br>
删除：drop database if  exits 数据库名称;<br>
#### 5 查询数据库
查询当前正在使用的数据库：select database();<br>
使用数据库：use 数据库名称;<br>
### 操作表：CRUD<br>
#### 1 创建create<br>
create table 表名(<br>
列名1  数据类型1,<br>
列名2   数据类型2,<br>
。。。
列名2   数据类型2<br>
);
#### 2 查询retrieve<br>
查询某个数据库中所有表名称：show tables;<br>
查询表结构：desc 表名;<br>
#### 3 修改update<br>
#### 4 删除delete<br>
## DML（增删改表中数据）


## DQL（查询表中数据）
## DCL（权限和安全访问）
