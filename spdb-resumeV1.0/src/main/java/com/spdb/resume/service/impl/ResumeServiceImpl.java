package com.spdb.resume.service.impl;

import com.spdb.resume.ResumeApplication;
import com.spdb.resume.common.ResumeStatusCode;
import com.spdb.resume.common.ServerResponse;
import com.spdb.resume.pojo.Resume;
import com.spdb.resume.service.IResumeService;
import com.spdb.resume.util.IResumeCheck;

import java.util.ArrayList;

/**
 * @Author: A wei
 * @Date: 2020/7/1 10:19
 * @Last Modified by:
 * @last Modified date:
 * @Description: 简历服务逻辑
 */
public class ResumeServiceImpl implements IResumeService {

    @Override
    public ServerResponse<Resume> createResume(String name, String id, String school,String major, int sex, String phone, String email) {

        //1、判断是否参数有null值 后续可以考虑采用lombok的@NotNULL进行参数校验
        if (name.isEmpty()) return ServerResponse.createByErrorMessage("姓名为空！请输入您的姓名");

        if (id.isEmpty() || id.length()!= 18) return ServerResponse.createByErrorMessage("身份证输入错误！");

        if (school.isEmpty()) return ServerResponse.createByErrorMessage("学校为空！请输入您的学校信息");

        if (major.isEmpty()) return ServerResponse.createByErrorMessage("专业为空！请输入您的专业信息");

        if (phone.isEmpty()) return ServerResponse.createByErrorMessage("电话为空！请输入您的电话号码");

        //2、创建Resume对象
        Resume resume = new Resume(name,id,school,major,sex,phone,email, ResumeStatusCode.NOTAPPLY.getCode());

        //3、查询id、电话、邮箱是否已注册。是：返回错误，否继续下一步。

        ArrayList<Resume> resumeArrayList = new ResumeApplication().getResumes();

        if (checkResume(resume,resumeArrayList,
                (Resume resume1,Resume resume2)-> resume1.getId().equals(resume2.getId()))){
            return ServerResponse.createByErrorMessage("身份证号码已注册！");
        }
        if (checkResume(resume,resumeArrayList,
                (Resume resume1,Resume resume2)-> resume1.getPhone().equals(resume2.getPhone()))){
            return ServerResponse.createByErrorMessage("电话已注册！");
        }
        if (checkResume(resume,resumeArrayList,
                (Resume resume1,Resume resume2)-> resume1.getEmail().equals(resume2.getEmail()))){
            return ServerResponse.createByErrorMessage("邮箱已注册！");
        }
        //4、新建简历到人才库
        resumeArrayList.add(resume);

        return ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse<String> deleteResume(Resume resume) {

        ArrayList<Resume> resumeArrayList = new ResumeApplication().getResumes();

        //1、根据id查询是否有该简历
        if (!checkResume(resume,resumeArrayList,
                (Resume resume1,Resume resume2)->resume1.getId().equals(resume2.getId()))){
            return ServerResponse.createByErrorMessage("该简历不存在");
        }

        //2、判断简历状态，如果是未申请状态可以删除，流程中无法删除
        if (resume.getStatus() != ResumeStatusCode.NOTAPPLY.getCode()){
            return ServerResponse.createByErrorMessage("您的简历正在审核流程中，暂无法删除");
        }

        //3、未申请状态，删除
        resumeArrayList.remove(resume);
        return ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse<String> updateResume(Resume resume) {
        return null;
    }

    @Override
    public ServerResponse<Resume> selectResume(String id) {
        return null;
    }

    /**
     *@Author: A wei
     *@Description 查询简历是否再人才库
     *@return boolean
     *@param
     **/
    private static boolean checkResume(Resume checkResume,ArrayList<Resume> resumeList, IResumeCheck iResumeCheck){

        for (Resume item:resumeList){
            if (iResumeCheck.checked(item,checkResume)){
                return true;
            }
        }
        return false;
    }
    /**
     *@Author: A wei
     *@Description 根据id查询简历
     *@return boolean
     *@param
     **/
    private static boolean checkResumeById(String id,ArrayList<Resume> resumeArrayList){
        for (Resume item : resumeArrayList){
            if (item.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
}
