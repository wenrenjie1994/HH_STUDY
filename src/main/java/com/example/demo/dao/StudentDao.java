package com.example.demo.dao;

import com.example.demo.model.student;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentDao {

    private static final String NAMESPACE = "com.example.demo.dao.StudentDao.";

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public student selectByID(Integer studentId) {
        return sqlSessionTemplate.selectOne(NAMESPACE+"selectByID",studentId);
    }


    public List<student> selectByName(String studentName) {
        return sqlSessionTemplate.selectList(NAMESPACE+"selectByName",studentName);
    }


    public List<student> selectAll() {
        return sqlSessionTemplate.selectList(NAMESPACE+"selectAll");
    }


    public int insert(student student) {
        return sqlSessionTemplate.insert(NAMESPACE+"insert",student);
    }


    public int update(student student) {
        return sqlSessionTemplate.update(NAMESPACE+"update",student);
    }


    public int deleteByID(Integer studentId) {
        return sqlSessionTemplate.delete(NAMESPACE+"deleteByID",studentId);
    }


    public List<student> selectLimt(int page, int limit) {
        Map<String,Integer> map = new HashMap<>();
        map.put("page",page);
        map.put("limit",limit);
        return sqlSessionTemplate.selectList(NAMESPACE+"selectLimt",map);
    }
}
