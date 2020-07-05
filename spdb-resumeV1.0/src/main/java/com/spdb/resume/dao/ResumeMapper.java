package com.spdb.resume.dao;

import com.spdb.resume.pojo.Resume;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *@Author: A wei
 *@Description 简历映射文件，负责执行数据库
 *@return
 *@param
 **/
@Mapper
public interface ResumeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Resume record);

    int insertSelective(Resume record);

    Resume selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Resume record);

    int updateByPrimaryKey(Resume record);

    int checkResumeIdCard(String idCard);

    int checkResumePhone(String phone);

    int checkResumeEmail(String email);

    int checkResumeID(Integer id);

}