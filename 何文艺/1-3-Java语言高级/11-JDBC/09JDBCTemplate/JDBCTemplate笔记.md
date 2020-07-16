**JDBCTemplate笔记**  

----------


**一、JDBCTemplate_介绍**  
1.Spring JDBC：Spring框架对JDBC的简单封装；提供了一个JDBCTemplate对象简化JDBC的开发  
2.使用步骤：  
&nbsp;&nbsp;&nbsp;a.导入jar包  
&nbsp;&nbsp;&nbsp;b.创建JDBCTemplate对象，依赖于数据源DataSource：JDBCTemplate template = new JDBCTemplate(ds);  
&nbsp;&nbsp;&nbsp;c.调用JDBCTemplate的方法来完成CRUD的操作  

    update()：执行DML语句，增删改语句
    queryForMap()：查询结果将结果集封装为map集合，将列名作为key，将值作为value，将这条记录封装为一个map集合
        注意：这个方法查询的结果集长度只能是1
    queryForList()：查询结果将结果集封装为List集合
        注意：将每一条记录封装为一个Map集合，再将Map集合装载到List集合中
    query()：查询结果将结果封装为JavaBean集合
        注意：query()的参数RowMapper，一般我们使用BeanPropertyRowMapper实现类，它可以完成数据到JavaBean的自动封装
             new BeanPropertyRowMapper<类型>(类型.class)
    queryForObject()：查询结果将结果封装为对象
        注意：一般用于聚合函数的查询

**二、JDBCTemplate_快速入门（JDBCTemplateDemo01.java）**  

**三、JDBCTemplate_执行DML语句（student表 JDBCTemplateDemo02.java）**  
利用Junit单元测试：不依赖于主方法  
1.修改1号记录的 math 为 99  
2.添加一条记录  
3.删除刚才添加的记录  

**四、JDBCTemplate_执行DQL语句（JDBCTemplateDemo02.java）**  
4.查询id = 1的记录将其封装为Map集合  
5.查询所有的记录将其封装为List集  
6.查询所有的记录将其封装为Student对象的List集合  
7.查询总记录数  

JDBCTemplateDemo02.java

    package jdbctemplate;
    
    import domain.Student;
    import org.junit.Test;
    import org.springframework.jdbc.core.BeanPropertyRowMapper;
    import org.springframework.jdbc.core.JdbcTemplate;
    import org.springframework.jdbc.core.RowMapper;
    import utils.JDBCUtils;
    
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.List;
    import java.util.Map;
    
    /**
    * @program: TODO
    * @className:JDBCTemplateDemo02
    * @description:JDBCTemplate练习
    * @author: 何文艺
    * @create: 2020/7/16 11:35
    **/
    public class JDBCTemplateDemo02 {
    //1.获取JDBCTemplate对象
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    
    //Junit单元测试，可以让主方法独立执行
    @Test
    public void test1() {//1.修改1号记录的 math 为 99
        //2.定义sql
        String sql = "update student set math = 99 where id = 1";
        //3.执行sql
        int count = template.update(sql);
        System.out.println(count);
    }
    
    @Test
    public void test2() {//2.添加一条记录
        String sql = "insert into student(id,name,age) values(?,?,?)";
        int count = template.update(sql, null, "lucy", 19);
        System.out.println(count);
    }
    
    @Test
    public void test3() {//3.删除刚才添加的记录
        String sql = "delete from student where id = 10";
        int count = template.update(sql);
        System.out.println(count);
    }
    
    @Test
    public void test4_1() {//4.查询id = 1的记录将其封装为map集合
        String sql = "select * from student where id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1);
        System.out.println(map);
        //{id=1, name=nancy, age=12, sex=女, address=四川, math=99, english=60}
    }
    
    /*@Test
    public void test4_2() {//查询id = 1 或者 id = 2的记录将其封装为map集合：报错
        String sql = "select * from student where id = ? or id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1, 2);
        System.out.println(map);
        //queryForMap()这个方法查询的结果集长度只能是1
    }*/
    
    @Test
    public void test5() {//5.查询所有的记录将其封装为list集
        String sql = "select * from student";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
        //{id=1, name=nancy, age=12, sex=女, address=四川, math=99, english=60}
    }
    
    @Test
    public void test6_1() {//6.查询所有的记录将其封装为Student对象的List集合
        String sql = "select * from student";
        List<Student> list = template.query(sql, new RowMapper<Student>() {//自己实现
            @Override
            public Student mapRow(ResultSet rs, int i) throws SQLException {
                return new Student(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("sex"),
                        rs.getString("address"),
                        rs.getDouble("math"),
                        rs.getDouble("english"));
            }
        });
        for (Student stu : list) {
            System.out.println(stu);
        }
    }
    
    @Test
    public void test6_2() {//6.查询所有的记录将其封装为Student对象的List集合
        String sql = "select * from student";
        List<Student> list = template.query(sql, new BeanPropertyRowMapper<Student>(Student.class));//用自带的方法实现
        for (Student stu : list) {
            System.out.println(stu);
        }
    }
    
    @Test
    public void test7() {//查询总记录数
        String sql = "select count(id) from student";
        Long total = template.queryForObject(sql, Long.class);//用自带的方法实现
        System.out.println(total);
    }
    }
