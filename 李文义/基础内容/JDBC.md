Class.forName("com.mysql.jdbc.Driver"); //1.加载MySQL驱动(开发推荐的方式)
Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver"); //1.加载SQLServer驱动(开发推荐的方式)

url地址写法：
Oracle：jdbc:oracle:thin:@localhost:1521:shen
SqlServer：jdbc:microsoft:sqlserver://localhost:1433; DatabaseName=shen
MySql：jdbc:mysql://localhost:3306/shen

连接数据库：
Connection conn = DriverManager.getConnection(url,user,pass); 

创建Statement对象用于向数据库发送SQL语句：
Statement st = conn.createStatement();
Statement对象常用方法：
executeQuery(String sql) 	用于向数据发送查询语句。
executeUpdate(String sql)	用于向数据库发送insert、update或delete语句
execute(String sql)	用于向数据库发送任意sql语句
addBatch(String sql)	把多条sql语句放到一个批处理中。
executeBatch()	向数据库发送一批sql语句执行。

PreperedStatement是Statement的孩子，它的实例对象：PreperedStatement st =  conn.preparedStatement()
相对于Statement对象而言，PreperedStatement可以避免SQL注入的问题。

ResultSet用于代表Sql语句的执行结果。Resultset封装执行结果时，采用的类似于表格的方式，ResultSet 对象维护了一个指向表格数据行的游标，初始的时候，游标在第一行之前，调用ResultSet.next() 方法，可以使游标指向具体的数据行，进行调用方法获取该行的数据。
获取行：
next()：移动到下一行
Previous()：移动到前一行
absolute(int row)：移动到指定行
beforeFirst()：移动resultSet的最前面。
afterLast() ：移动到resultSet的最后面。
获取值：
getObject(int index)
getObject(string columnName)
