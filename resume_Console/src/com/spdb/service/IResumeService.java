package com.spdb.service;

import com.spdb.common.ServerResponse;
import com.spdb.pojo.Resume;

import java.util.ArrayList;

/**
 * @Author: A wei
 * @Date: 2020/7/2 9:02
 * @Last Modified by:
 * @last Modified date:
 * @Description:
 */
public interface IResumeService {
    /**
     *@Author: A wei
     *@Description 新建简历
     *@return {@link ServerResponse<Resume>}
     *@param
     **/
    ServerResponse<Resume> createResume(Resume resume,ArrayList<Resume> resumeArrayList);

    /**
     *@Author: A wei
     *@Description 删除简历
     *@return {@link ServerResponse<String>}
     *@param resume
     **/
    ServerResponse<String> deleteResume(Resume resume,ArrayList<Resume> resumeArrayList);
    /**
     *@Author: A wei
     *@Description 修改简历
     *@return {@link ServerResponse<Resume>}
     *@param  resume
     **/
    ServerResponse<String> updateResume(Resume resume,ArrayList<Resume> resumeArrayList);
    /**
     *@Author: A wei
     *@Description 查询简历
     *@return {@link ServerResponse<Resume>}
     *@param id
     **/
    ServerResponse<Resume> selectResume(String id,ArrayList<Resume> resumeArrayList);
}
