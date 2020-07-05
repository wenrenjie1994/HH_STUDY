package com.lihang.service;

import com.lihang.pojo.Resume;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: LI
 * Date: 2020/7/5
 */
public interface OperateService {
    public Integer addResume(Resume resume);
    public Integer deleteResume(String name);
    public Integer updateResume(Resume resume);
    public Resume getResumeByName(String name);
}
