# JDBC

## 一、Hello JDBC
### 1、数据库连接
* 初始化驱动：
```java
Class.forName("com.mysql.jdbc.Driver");
```
* 建立连接：
```java
Connection c = DriverManager.getConnection(
                   "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                   "root", "admin");
```
* 创建statement：
```java
Statement s = c.createStatement();
```
* 执行sql语句
```java
s.execute(sql);
```
* 关闭连接：先关Statement，后关Connection
* try-with-resource方式自动关闭连接

## 二、查询
### 1、查询语句
```java
ResultSet rs = s.executeQuery(sql)
```
### 2、execute、executeUpdate与executeQuery
* 相同点：execute与executeUpdate可执行增、删、改；executeQuery只能查询
* 不同点：
    * execute可执行查询语句；executeUpdate不能执行查询语句
    * execute返回boolean类型，true表示执行查询语句，false表示执行的是增、删、改等；
      executeUpdate返回int，表示有多少条数据受到影响；
      executeQuery返回单个结果集

## 三、相关操作
### 1、获取自增长id
```java
PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
ResultSet rs = ps.getGeneratedKeys();
```
### 2、获取表的元数据
```java
DatabaseMetaData dbmd = c.getMetaData();
dbmd.getDatabaseProductName();
dbmd.getDatabaseProductVersion();
dbmd.getCatalogSeparator();
dbmd.getDriverVersion();
```
### 3、事务
* 操作：
```java
Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");
//关闭自动提交
c.setAutoCommit(false);
//手动提交
c.commit();
```
### 4、ORM（Object Relationship Database Mapping）
* 一个对象，对应数据库里的一条记录

### 5、DAO（DataAccess Object）
* 驱动初始化放在构造方法中
* 提供getConnection方法返回连接