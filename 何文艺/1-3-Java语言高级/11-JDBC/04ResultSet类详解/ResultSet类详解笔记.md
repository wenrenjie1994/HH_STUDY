**ResultSet类详解笔记**  

----------


ResultSet（接口）：结果集对象，封装查询结果  
一、ResultSet_基本操作  
1.boolean next()：游标向下移动一行，判断当前行是否有数据，若有则返回true，否则返回false  
2.xxx getXxx(参数)：获取数据（Xxx代表数据类型）  
参数：int：代表列的编号，从1开始  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;String：代表列的名字  

二、ResultSet_遍历操作  

    while(re.next()) {
        获取并操作数据
    }