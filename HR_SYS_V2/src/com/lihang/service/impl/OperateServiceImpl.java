package com.lihang.service.impl;

import com.lihang.pojo.Resume;
import com.lihang.service.OperateService;
import com.lihang.util.FileUtils;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: LI
 * Date: 2020/7/5
 */
public class OperateServiceImpl implements OperateService {
    private static final String path = "E:\\resume\\resume.txt";
    @Override
    public Integer addResume(Resume resume) {
        try {
            FileUtils.objinsertToFile(resume,path);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public Integer deleteResume(String name) {
        try {
            FileUtils.deleteByname(name,path);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public Integer updateResume(Resume resume) {
        StringBuffer newLine = new StringBuffer(resume.getName()+"#"+resume.getId()+"#"+resume.getSchool()+"#"+resume.getProcess()+"#"+resume.getDeleteStatus());
        try {
            FileUtils.updateOneLine(resume.getName(),newLine.toString(),path);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public Resume getResumeByName(String name) {
        Resume resume = null;
        try {
            resume = FileUtils.getObjectByName(Resume.class,name,path);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resume;
    }
}
