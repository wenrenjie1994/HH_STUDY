package com.sp.lowbhrsys.service;

import com.sp.lowbhrsys.utils.ResponseData;
import com.sp.lowbhrsys.bean.ResumeBean;

import java.util.List;

/**
 * @author: libobo
 * @create: 2020-07-03 13:26
 * @description: 简历业务接口
 **/
public interface IResumeService {

    /**
     * 添加简历
     * @param resume 简历对象
     * @return 响应对象
     */
    public ResponseData addResume(ResumeBean resume);

    /**
     * 根据简历ID删除对应的简历信息
     * @param resumeId 简历ID
     * @return 响应对象
     */
    public ResponseData deleteResume(int resumeId);

    /**
     * 根据简历ID修改姓名、邮件、手机号
     * @param resumeId 简历ID
     * @param name 姓名
     * @param email 邮件
     * @param phone 手机号
     * @return
     */
    public ResponseData updateResume(int resumeId,String name,String email,String phone);

    /**
     *根据简历ID查询简历
     * @param resumeId 简历id
     * @return 响应对象，响应数据类型是ResumeBean
     */
    public ResponseData<ResumeBean> findResumeByResumeId(int resumeId);

    /**
     * 查询所有简历信息
     * @return
     */
    public ResponseData<List<ResumeBean>> findAllResume();
}
