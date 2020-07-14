package com.testHR.dao.impl;

import com.testHR.dao.ResumeDao;
import com.testHR.model.Resume;
import com.testHR.utils.DruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @description:
 * @author: zeng
 * @modified By:
 */
public class ResumeDaoImpl implements ResumeDao {
    @Override
    public int insert(Resume resume) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "insert into resume(name,id,school) values(?,?,?)";
        int i = jdbcTemplate.update(sql, resume.getName(), resume.getId(), resume.getSchool());
        return i;
    }
}
