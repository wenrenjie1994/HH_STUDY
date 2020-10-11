package com.longyx.study.design.pattern.template.jdbc.dao;

import com.longyx.study.design.pattern.template.jdbc.JdbcTemplate;
import com.longyx.study.design.pattern.template.jdbc.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

/**
 * 模拟通过自己写的JdbcTemplate操作数据库
 * @author Mr.Longyx
 * @date 2020年07月01日 14:17
 */
public class UserDao extends JdbcTemplate {
    public UserDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> selectAll(){
        String sql = "select * from user";
        return super.executeQuery(sql, (RowMapper<User>) (rs, rowNum) -> {
            User user = new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setAge(rs.getInt("age"));
            user.setAddr(rs.getString("addr"));

            return user;
        },null);
    }
}
