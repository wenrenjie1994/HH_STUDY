package com.example.hr_sys_demo_browserserver.service;

import com.example.hr_sys_demo_browserserver.pojo.Resume;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResumeService {
    public int add(Resume resume);

    public void delete(@Param("id") int id);

    public Resume get(@Param("id") int id);

    public int update(Resume resume);

    public List<Resume> list();
}
