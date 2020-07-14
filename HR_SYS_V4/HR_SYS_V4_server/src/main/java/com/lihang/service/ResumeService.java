package com.lihang.service;

import com.lihang.pojo.Resume;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: LI
 * Date: 2020/7/10
 */
public interface ResumeService {
    public Integer addResume(Resume resume);
    public Integer deletResumeByName(String name);
    public Integer updateResume(Resume resume);
    public List<Resume> getResumeByName(String name);
    public Resume getResumeById(String id);
}
