**数据库表的CRUD操作笔记**  

----------


**一、DDL_操作表**  
DDL操作表：CRUD  

1.C(CREATE)：增(CREATE)  

    创建表：  
    CREATE TABLE 表名(  
        列名1 数据类型1,  
        列名2 数据类型2,  
        ...  
        列名n 数据类型n  
    );  
注意：最后一列不加逗号","  

数据类型：  

    a.INT：整数  
    b.DOUBLE：小数（需要指定小数一共有多少位，以及小数点后面有多少位）  
      例score DOUBLE(5,2)  
    c.DATE：日期（年月日：yyyy-mm-dd）  
      DATETIME：日期（年月日时分秒：yyyy-mm-dd HH:mm:ss）  
      TIMESTAMP：时间戳（如果将来不给这个字段赋值或赋值为null，则默认使用当前的系统时间来自动赋值）  
    d.VARCHAR：字符串（需要指定最大的字符长度）  
      例name VARCHAR(20)  

创建一张学生表：  

    CREATE TABLE student(  
        id INT,  
        name VARCHAR(32),  
        age INT,  
        score DOUBLE(4,1),  
        birthday DATE,  
        insert_time TIMESTAMP  
    );  

创建一张表table2跟已存在的表table1一样（复制）：CREATE TABLE table2 LIKE table1;  

2.R(RETRIEVE)：查(SHOW)  

    查询某个数据库中所有的表名称：SHOW TABLES;  
    查询表结构：DESC 表名;  

3.U(UPDATE)：改(ALTER)  

    修改表名称：ALTER TABLE 旧表名 RENAME TO 新表名  
    修改表的字符集：ALTER TABLE 表名 CHARACTER SET 字符集名称  
    添加一列：ALTER TABLE 表名 ADD 列名 数据类型  
    修改列名称：ALTER TABLE 表名 CHANGE 旧列名 新列名 新数据类型  
    修改列类型：ALTER TABLE 表名 MODIFY 列名 新的数据类型  
    删除列：ALTER TABLE 表名 DROP 列名  

4.D(DELETE)：删(DROP)  

    删除表：DROP TABLE 表名;  
    删除表时判断表是否存在，若存在再删除：DROP TABLE IF EXISTS 表名;  

**二、图形化界面工具SQLyog**  