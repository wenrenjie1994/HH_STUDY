package com.spdb.resume.service;

import com.spdb.resume.common.ServerResponse;
import com.spdb.resume.pojo.Resume;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @Author: A wei
 * @Date: 2020/7/1 10:17
 * @Last Modified by:
 * @last Modified date:
 * @Description: 个人简历操作
 */
public interface IResumeService {

    /**
     *@Author: A wei
     *@Description 新建简历
     *@return {@link ServerResponse<Resume>}
     *@param name,id,school,major,sex,phone,email
     **/
    ServerResponse<Resume> createResume(String name, String id, String school, String major, int sex, String phone, String email, ArrayList<Resume> resumeArrayList);

    /**
     *@Author: A wei
     *@Description 删除简历
     *@return {@link ServerResponse<String>}
     *@param resume
     **/
    ServerResponse<String> deleteResume(Resume resume, ArrayList<Resume> resumeArrayList);
    /**
     *@Author: A wei
     *@Description 修改简历
     *@return {@link ServerResponse<Resume>}
     *@param  resume resumeArrayList
     **/
    ServerResponse<String> updateResume(Resume resume,ArrayList<Resume> resumeArrayList);
    /**
     *@Author: A wei
     *@Description 查询简历
     *@return {@link ServerResponse<Resume>}
     *@param id
     **/
    ServerResponse<Resume> selectResume(String id, ArrayList<Resume> resumeArrayList);
}
