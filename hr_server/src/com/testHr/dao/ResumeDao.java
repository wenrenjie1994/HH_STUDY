package com.testHr.dao;

import com.testHr.model.Resume;

import java.util.List;

/**
 * @description:
 * @author: zeng
 * @modified By:
 */
public interface ResumeDao {
    int insert(Resume resume) throws Exception;

    int updateDeleteStatus(Integer inputId) throws Exception;

    int delete(Integer inputId) throws Exception;

    Resume queryById(Integer inputId) throws Exception;

    int update(Resume resume, Integer inputId) throws Exception;

    List<Resume> queryAll() throws Exception;

    List<Resume> queryEffList() throws Exception;

    List<Resume> queryBlackList() throws Exception;

    List<Resume> queryByName(String name) throws Exception;

    List<Resume> queryBySchool(String school) throws Exception;

    List<Resume> queryByProcess(Integer process) throws Exception;
}
