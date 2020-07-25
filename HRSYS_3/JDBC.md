# JDBC API （在Java.sql中）#
## 主要功能： ##
- Connection接口：与数据库建立连接，并担任传送数据的任务。
- Statement接口：由Connection产生，负责执行SQL语句。
- ResultSet接口：负责保持Statement执行后所产生的查询结果。
# JDBC驱动 #
## 功能 ##
负责连接各种不同的数据库。
# DriverManager类 （在Java.sql中）#
## 功能 ##
管理各种不同的JDBC驱动。
# Java数据库编程 #
## JDBC访问数据库的步骤 ##
- 加载JDBC驱动。`Class.forName("com.mysql.cj.jdbc.Driver");`
- 与数据库建立连接。
- 创建Statement或PreparedStatement对象。
- 发送SQL语句，并得到返回结果。
- 处理返回结果。
- 释放资源。