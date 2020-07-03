package com.example.demo.service;


import com.example.demo.model.student;
import com.example.demo.model.studentDTO;

import java.util.List;

public interface StudentService {

    /**
     * 选择指定 ID 的学生信息
     * @param studentId 学生ID
     * @return 返回指定 ID 的学生信息
     */
    student selectByID(Integer studentId);

    /**
     * 选择指定 studentName 的学生信息。
     * 支持模糊查找
     * @param studentName 学生名字
     * @return 返回若干条指定 studentName 的学生信息
     */
    List<studentDTO> selectByName(String studentName);

    /**
     * 选择所有的仓库管理员信息
     * @return 返回所有的仓库管理员信息
     */
    List<studentDTO> selectAll();

    /**
     * 插入一条学生信息
     * @param student 学生信息
     */
    int insert(student student);

    /**
     * 更新学生信息
     * @param student 仓库管理员信息
     */
    int update(student student);

    /**
     * 删除指定 ID 的学生信息
     * @param studentId 学生ID
     */
    int deleteByID(Integer studentId);

    List<studentDTO> selectLimt(int page, int limit);
}
