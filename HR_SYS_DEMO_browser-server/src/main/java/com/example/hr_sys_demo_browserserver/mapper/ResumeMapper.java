package com.example.hr_sys_demo_browserserver.mapper;

import com.example.hr_sys_demo_browserserver.pojo.Resume;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ResumeMapper {

    String TABLE_NAME = "resume_list";
    String INSERT_FIELDS = "name, shcool, status";

    public int add(Resume resume);

    public void delete(int id);

    public Resume get(int id);

    public int update(Resume resume);

    public List<Resume> list();
}
