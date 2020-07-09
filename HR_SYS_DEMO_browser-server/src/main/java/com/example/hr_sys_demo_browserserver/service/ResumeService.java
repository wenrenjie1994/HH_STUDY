package com.example.hr_sys_demo_browserserver.service;

import com.example.hr_sys_demo_browserserver.pojo.Resume;

import java.util.List;

public interface ResumeService {
    public int add(Resume resume);

    public void delete(int id);

    public Resume get(int id);

    public int update(Resume resume);

    public List<Resume> list();
}
