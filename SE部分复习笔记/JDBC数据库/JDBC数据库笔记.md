1.  JDBC:

![1553408888(1)](media/997d83a36387a2e2b953e0a702e39827.png)

1.  JDBC常用接口

a.Driver接口：

![1553409286(1)](media/0f58c186e03df6ef42bb3dea2e7dd4f4.png)

//加载驱动类

Class.*forName*("com.mysql.jdbc.Driver");

b.DriverManager接口：

![1553409427(1)](media/d46e7356bcc0f832e9e4fd894110b127.png)

c.Connection接口：

![1553409628(1)](media/0422d0f6d807c9f7378117a35aa37ad0.png)

//建立连接(连接对象内部其实包含了Socket对象，是一个远程的连接。比较耗时！这是Connection对象管理的一个要点！)

//真正开发中，为了提高效率，都会使用连接池来管理连接对象！

conn =
DriverManager.*getConnection*("jdbc:mysql://localhost:3306/testjdbc","root","123456");

d.Statement接口：

![1553409893(1)](media/f43200f7b9032c8b408950c39f7abb49.png)

\* 测试Statement接口的用法，执行SQL语句，以及SQL注入问题

stmt = conn.createStatement();

// String name = "赵六";

// String *sql* = "insert into t_user (*username*,*pwd*,regTime) values
('"+name+"',66666,now())";

// stmt.execute(*sql*);//运行语句

//测试SQL注入

String id = "5 or 1=1 ";

String sql = "delete from t_user where id="+id;

stmt.execute(sql);

\* 测试PreparedStatement的基本用法

String sql = "insert into t_user (username,pwd,regTime) values (?,?,?)";
//?占位符

ps = conn.prepareStatement(sql);

// ps.setString(1, "高淇3"); //参数索引是从1开始计算， 而不是0

// ps.setString(2, "123456");

// ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));

//可以使用setObject方法处理参数

ps.setObject(1, "高淇5");

ps.setObject(2, "234567");

ps.setObject(3, **new** java.sql.Date(System.*currentTimeMillis*()));

// ps.execute();

**int** count = ps.executeUpdate();

e.ResultSet接口：

![1553410531(1)](media/97845236696a602adb865a2e3322856e.png)

\* 测试ResultSet结果集的基本用法

String sql = "select id,username,pwd from t_user where id\>?"; //?占位符

ps = conn.prepareStatement(sql);

ps.setObject(1, 2); //把id大于2的记录都取出来

rs = ps.executeQuery();//返回ResultSet结果集

**while**(rs.next()){

System.*out*.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getString(3));

}

//遵循：*resultset*--\>*statment*--\>connection这样的关闭顺序！一定要将三个*trycatch*块，分开写！

f.JDBC详细操作：

![1553411091(1)](media/62efe9b67b6580ced5ff55f4a2efc8fd.png)

\* 测试批处理的基本用法

conn.setAutoCommit(**false**); //设为手动提交

stmt = conn.createStatement();

**for**(**int** i=0;i\<20000;i++){

stmt.addBatch("insert into t_user (username,pwd,regTime) values
('gao"+i+"',666666,now())");

}

stmt.executeBatch();

conn.commit(); //提交事务

\* 测试事务的基本概念和用法

g.事务：

![1553411366(1)](media/206de502a1bfbec4f1d6400d7dc9875a.png)

DML（data manipulation language）数据操纵语言：UPDATE、INSERT、DELETE

DDL（data definition language）数据库定义语言：CREATE、ALTERL:修改、DROP

DCL（Data Control
Language）数据库控制语言：GRANT：授权、ROLLBACK：回滚、COMMIT：提交

DQL(Data Query Language)数据库查询语言：SELECT

![1553411773(1)](media/04d17b7b088c8107b650713e161030a8.png)

![1553411798(1)](media/a6b8b2472eec59e5e7cbb6a71f8d9c16.png)

h.时间类型

![1553412034](media/da2853eb5ffde7b9ab8908ea177e8cb6.png)

ps.setDate(3, date);

ps.setTimestamp(4, stamp);

1.  CLOB

![1553413312](media/d68c73a8eb1a58cc3dce1c55dfc6026e.png)

*ps* = conn.prepareStatement("insert into t_user (*username*,myInfo) values
(?,?) ");

// ps.setString(1, "高淇");

// ps.setClob(2, new FileReader(new File("d:/a.txt")));
//将文本文件内容直接输入到数据库中

//将程序中的字符串输入到数据库的CLOB字段中

// ps.setClob(2, new BufferedReader(new InputStreamReader(new
ByteArrayInputStream("*aaaabbbbbb*".getBytes()))));

ps = conn.prepareStatement("select \* from t_user where id=?");

ps.setObject(1, 101024);

rs = ps.executeQuery();

**while**(rs.next()){

Clob c = rs.getClob("myInfo");

r = c.getCharacterStream();

**int** temp = 0;

**while**((temp=r.read())!=-1){

System.*out*.print((**char**)temp);

}

j.BLOB

![1553413417(1)](media/d5c9255d2970ba358a474eb853c7863a.png)

*ps* = conn.prepareStatement("insert into t_user (*username*,headImg) values
(?,?) ");

// ps.setString(1, "高淇");

// ps.setBlob(2, new FileInputStream("d:/icon.jpg"));

// ps.execute();

ps = conn.prepareStatement("select \* from t_user where id=?");

ps.setObject(1, 101026);

rs = ps.executeQuery();

**while**(rs.next()){

Blob b = rs.getBlob("headImg");

is = b.getBinaryStream();

os = **new** FileOutputStream("d:/a.jpg");

**int** temp = 0;

**while**((temp=is.read())!=-1){

os.write(temp);

}
