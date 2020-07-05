package com.spdb.resume.service;

import com.spdb.resume.common.ServerResponse;
import com.spdb.resume.pojo.Resume;
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
     *@param resume
     **/
    ServerResponse<String> createResume(Resume resume);

    /**
     *@Author: A wei
     *@Description 删除简历
     *@return {@link ServerResponse<String>}
     *@param resume
     **/
    ServerResponse<String> deleteResume(Resume resume);
    /**
     *@Author: A wei
     *@Description 修改简历
     *@return {@link ServerResponse<Resume>}
     *@param  resume
     **/
    ServerResponse<String> updateResume(Resume resume);
    /**
     *@Author: A wei
     *@Description 查询简历
     *@return {@link ServerResponse<Resume>}
     *@param id
     **/
    ServerResponse<Resume> inquireResume(Integer id);

    /**
     *@Author: A wei
     *@Description 此方法可以用于批量读写，批量操作时采用缓存数据库存储批量简历，一定时间后批量写入mysql数据库中
     *@return
     *@param
     **/
    ServerResponse<Resume> saveResumeList(ArrayList<Resume> resumeArrayList);
}
