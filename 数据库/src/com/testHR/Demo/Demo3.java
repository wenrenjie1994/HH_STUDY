package com.testHR.Demo;

import com.testHR.model.Resume;
import com.testHR.utils.DruidUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @description:
 * @author: zeng
 * @modified By:
 */
public class Demo3 {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());

    @Test
    public void test1(){
        String sql = "insert into resume(name,id,school,process,delete_status) values(?,?,?,?,?)";
        int i = jdbcTemplate.update(sql, "三狗", 3, "村大", 1, 0);
        System.out.println(i);
    }

    @Test
    public void test2(){
        //查询所有记录，封装成JavaBean，存储到List中
        String sql = "select * from resume";
        List<Resume> resumeList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Resume>(Resume.class));
        for (Resume resume : resumeList) {
            System.out.println(resume);
        }
    }

    @Test
    public void test3(){
        //查询所有记录，封装成JavaBean，存储到List中
        String sql = "select * from resume where school = ? and delete_status = ?";
        List<Resume> resumeList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Resume>(Resume.class),"村大",1);
        for (Resume resume : resumeList) {
            System.out.println(resume);
        }
    }
}
