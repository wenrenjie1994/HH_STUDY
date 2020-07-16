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
