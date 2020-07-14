package com.lihang.service.impl;

import com.lihang.pojo.Resume;
import com.lihang.service.ResumeService;
import com.lihang.util.DbUtils;
import com.lihang.util.MyDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: LI
 * Date: 2020/7/10
 */
public class ResumeServiceImpl implements ResumeService {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet res = null;
    private MyDataSource dataSource = new MyDataSource();

    /**
     * @param resume
     * @return
     */
    @Override
    public Integer addResume(Resume resume) {
        String sql = "insert into resume(name,id,school,process,deleteStatus) value(?,?,?,?,?)";
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, resume.getName());
            ps.setString(2, resume.getId());
            ps.setString(3, resume.getSchool());
            ps.setInt(4, resume.getProcess());
            ps.setInt(5, resume.getDeleteStatus());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DbUtils.release(ps, res);
            dataSource.reBack(conn);
        }
        return 1;
    }

    /**
     * 逻辑删除
     *
     * @param name
     * @return
     */
    @Override
    public Integer deletResumeByName(String name) {
        String sql = "update resume set deleteStatus = 1 where name = ?";
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DbUtils.release(ps, res);
            dataSource.reBack(conn);
        }
        return 1;
    }

    /**
     * update Resume By Id
     *
     * @param resume
     * @return
     */
    @Override
    public Integer updateResume(Resume resume) {
        String sql = "update resume set name = ? ,school=? ,process=? where id = ?";
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, resume.getName());
            ps.setString(2, resume.getSchool());
            ps.setInt(3, resume.getProcess());
            ps.setString(4, resume.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DbUtils.release(ps, res);
            dataSource.reBack(conn);
        }
        return 1;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public List<Resume> getResumeByName(String name) {
        String sql = "select * from resume where name = ? and deleteStatus = 0";
        List<Resume> list = new ArrayList<>();
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            res = ps.executeQuery();
            while (res.next()) {
                Resume resume = new Resume();
                resume.setName(name);
                resume.setId(res.getString("id"));
                resume.setSchool(res.getString("school"));
                resume.setProcess(res.getInt("process"));
                resume.setDeleteStatus(0);
                list.add(resume);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.release(ps, res);
            dataSource.reBack(conn);
        }
        return list;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Resume getResumeById(String id) {
        String sql = "select * from resume where id = ? and deleteStatus = 0";
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            res = ps.executeQuery();
            res.next();
            Resume resume = new Resume();
            resume.setName(res.getString("name"));
            resume.setId(res.getString("id"));
            resume.setSchool(res.getString("school"));
            resume.setProcess(res.getInt("process"));
            resume.setDeleteStatus(0);
            return resume;
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            DbUtils.release(ps, res);
            dataSource.reBack(conn);
        }
        return null;
    }
}
