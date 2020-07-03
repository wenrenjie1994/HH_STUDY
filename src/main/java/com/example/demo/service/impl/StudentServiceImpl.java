package com.example.demo.service.impl;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.student;
import com.example.demo.model.studentDTO;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public student selectByID(Integer studentId) {
        return studentDao.selectByID(studentId);
    }

    @Override
    public List<studentDTO> selectByName(String studentName) {
        List<student> studentList = studentDao.selectByName(studentName);
        return format(studentList);
    }

    @Override
    public List<studentDTO> selectAll() {
        List<student> studentList = studentDao.selectAll();
        return format(studentList);
    }

    @Override
    public int insert(student student) {
        return studentDao.insert(student)>0?200:500;
    }

    @Override
    public int update(student student) {
        return studentDao.update(student)>0?200:500;
    }

    @Override
    public int deleteByID(Integer studentId) {
        return studentDao.deleteByID(studentId)>0?200:500;
    }

    @Override
    public List<studentDTO> selectLimt(int page, int limit) {
        List<student> studentList = studentDao.selectLimt(page,limit);
        return format(studentList);
    }

    public List<studentDTO> format(List<student> studentList){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<studentDTO> dtos = new ArrayList<>();
        for(int i = 0; i < studentList.size(); i ++){
            studentDTO dto = new studentDTO();
            dto.setStudentId(studentList.get(i).getStudentId());
            dto.setStudentName(studentList.get(i).getStudentName());
            dto.setStudentTel(studentList.get(i).getStudentTel());
            dto.setStudentAddress(studentList.get(i).getStudentAddress());
            dto.setStudentEmail(studentList.get(i).getStudentEmail());
            dto.setStudentBirth(dateFormat.format(studentList.get(i).getStudentBirth()));
            dto.setStudentNumber(studentList.get(i).getStudentNumber());
            dto.setStudentSchool(studentList.get(i).getStudentSchool());
            dtos.add(dto);
        }
        return dtos;
    }
}
