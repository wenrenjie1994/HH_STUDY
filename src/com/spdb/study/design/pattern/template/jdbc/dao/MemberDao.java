package com.spdb.study.design.pattern.template.jdbc.dao;

import com.spdb.study.design.pattern.template.jdbc.JdbcTemplate;
import com.spdb.study.design.pattern.template.jdbc.Member;
import com.spdb.study.design.pattern.template.jdbc.RowMapper;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年06月29日 21:25
 */
public class MemberDao extends JdbcTemplate {

    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> selectAll(){
        String sql = "select * from member";
        return super.executeQuery(sql, (RowMapper<Member>) (rs, rowNum) -> {
            Member member = new Member();
            member.setUsername(rs.getString("username"));
            member.setPassword(rs.getString("password"));
            member.setAge(rs.getInt("age"));
            member.setNickname(rs.getString("nickname"));
            member.setAddr(rs.getString("addr"));

            return member;
        },null);
    }
}
