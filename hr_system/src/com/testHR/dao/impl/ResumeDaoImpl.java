package com.testHR.dao.impl;

import com.testHR.dao.ResumeDao;
import com.testHR.model.Resume;
import com.testHR.utils.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @description:
 * @author: zeng
 * @modified By:
 */
public class ResumeDaoImpl implements ResumeDao {
    @Override
    public int insert(Resume resume) throws Exception{
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "insert into resume(name,id,school) values(?,?,?)";
        int i = jdbcTemplate.update(sql, resume.getName(), resume.getId(), resume.getSchool());
        return i;
    }

    @Override
    public int updateDeleteStatus(Integer inputId) throws Exception{
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "update resume set delete_status = 0 where id = ? ";
        int update = jdbcTemplate.update(sql, inputId);
        return update;
    }

    @Override
    public int delete(Integer inputId) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "delete from resume where id = ?";
        int delete = jdbcTemplate.update(sql,inputId);
        return delete;
    }

    @Override
    public Resume queryById(Integer inputId) throws Exception {
        Resume resume = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "select * from resume where id = ?";
        resume = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Resume>(Resume.class), inputId);
        return resume;
    }

    @Override
    public int update(Resume resume, Integer inputId) throws Exception{
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "update resume set name=?,id=?,school=?,process=? where id = ?";
        int update = jdbcTemplate.update(sql, resume.getName(),resume.getId(),resume.getSchool(),resume.getProcess(),inputId);
        return update;
    }

    @Override
    public List<Resume> queryAll() throws Exception{
        List<Resume> list = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "select * from resume";
        list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Resume>(Resume.class));
        return list;
    }

    @Override
    public List<Resume> queryEffList() throws Exception{
        List<Resume> list = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "select name,id,school,process from resume where delete_Status = 1";
        list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Resume>(Resume.class));
        return list;
    }

    @Override
    public List<Resume> queryBlackList() throws Exception{
        List<Resume> list = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "select name,id,school,process from resume where delete_Status = 0";
        list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Resume>(Resume.class));
        return list;
    }

    @Override
    public List<Resume> queryByName(String name) throws Exception{
        List<Resume> list = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "select * from resume where name = ?";
        list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Resume>(Resume.class), name);
        return list;
    }

    @Override
    public List<Resume> queryBySchool(String school) throws Exception{
        List<Resume> list = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "select * from resume where school = ?";
        list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Resume>(Resume.class), school);
        return list;
    }

    @Override
    public List<Resume> queryByProcess(Integer process) throws Exception{
        List<Resume> list = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "select * from resume where process = ?";
        list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Resume>(Resume.class), process);
        return list;
    }
}
