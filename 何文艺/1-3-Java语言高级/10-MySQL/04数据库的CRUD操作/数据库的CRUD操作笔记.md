**数据库的CRUD操作笔记**  

----------


**一、SQL分类**  
1.DDL(Data Definition Language)：数据定义语言  
用来【定义】【数据库对象】：数据库、表、列等；关键字：CREATE、DROP、ALTER等  

2.DML(Data Manipulation Language)：数据操作语言  
用来对数据库中【表的数据记录】进行【增删改】；关键字：INSERT、DELETE、UPDATE等  

3.DQL(Data Query Language)：数据查询语言  
用来对数据库中【表的数据记录】进行【查询】；关键字：SELECT、WHERE等  

4.DCL(Data Control Language)：数据控制语言（了解）  
用来定义数据库的访问权限和安全级别及创建用户；关键字：GRANT、REVOKE等  

**二、DDL_操作和使用数据库**  
DDL操作数据库：CRUD  

1.C(CREATE)：增(CREATE)  

    a.创建数据库：CREATE DATABASE 数据库名称;  
    b.创建数据库时判断是否存在，若不存在再创建：CREATE DATABASE IF NOT EXISTS 数据库名称;  
    c.创建数据库并指定字符集：CREATE DATABASE 数据库名称 CHARACTER SET 字符集名称;  
    d.创建数据库时判断是否存在，若不存在再按指定字符集创建：CREATE DATABASE IF NOT EXISTS 数据库名称 CHARACTER SET 字符编码名称;  

2.R(RETRIEVE)：查(SHOW)  

    a.查询所有数据库的名称：SHOW DATABASES;  
    b.查询某个数据库的字符集（其实是查询某个数据库的创建语句）：SHOW CREATE DATABASE 数据库名称;    
3.U(UPDATE)：改(ALTER)  

    修改数据库的字符集：ALTER DATABASE 数据库名称 CHARACTER SET 字符集名称;  

4.D(DELETE)：删(DROP)  

    删除数据库：DROP DATABASE 数据库名称;  
    删除数据库时判断是否存在，如果存在再删除：DROP DATABASE IF EXISTS 数据库名称;  

5.使用数据库  

    查询当前正在使用的数据库名称：SELECT DATABASE();  
    使用数据库：USE 数据库名称;  