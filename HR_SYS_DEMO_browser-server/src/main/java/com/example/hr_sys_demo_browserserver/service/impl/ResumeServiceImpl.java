package com.example.hr_sys_demo_browserserver.service.impl;

import com.example.hr_sys_demo_browserserver.mapper.ResumeMapper;
import com.example.hr_sys_demo_browserserver.pojo.Resume;
import com.example.hr_sys_demo_browserserver.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired ResumeMapper resumeMapper;

    @Override
    public int add(Resume resume){
        return resumeMapper.add(resume);
    }

    @Override
    public void delete(int id) {
        resumeMapper.delete(id);
    }

    @Override
    public Resume get(int id) {
        return resumeMapper.get(id);
    }

    @Override
    public int update(Resume resume) {
        return resumeMapper.update(resume);
    }

    @Override
    public List<Resume> list() {
        return resumeMapper.list();
    }


}
