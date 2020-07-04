package com.spdb.resume.service.impl;


import com.spdb.resume.common.Const;
import com.spdb.resume.common.ResumeStatusCode;
import com.spdb.resume.common.ServerResponse;
import com.spdb.resume.dao.ResumeMapper;
import com.spdb.resume.pojo.Resume;
import com.spdb.resume.service.IResumeService;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @Author: A wei
 * @Date: 2020/7/1 10:19
 * @Last Modified by:
 * @last Modified date:
 * @Description: 简历服务逻辑
 */
@Service("iResumeService")
@MapperScan(basePackages = "com.spdb.resume.dao")
public class ResumeServiceImpl implements IResumeService {

    @Autowired
    private ResumeMapper resumeMapper;

    @Override
    public ServerResponse<String> createResume(Resume resume) {

        //1、测试身份证号码、电话、邮箱是否可用
        if (!checkResume(resume.getIdCardNumber(),Const.ID_CARD_NUMBER).isSuccess()){
            return ServerResponse.createByErrorMessage("当前身份证号已注册");
        }
        if(!checkResume(resume.getPhone(),Const.PHONE).isSuccess()){
            return ServerResponse.createByErrorMessage("电话已注册！");
        }
        if (!checkResume(resume.getEmail(),Const.EMAIL).isSuccess()){
            return ServerResponse.createByErrorMessage("邮箱已注册！");
        }
        //2、简历数据写入数据库,设置简历状态未申请
        resume.setStatus(ResumeStatusCode.NOTAPPLY.getCode());
        resumeMapper.insert(resume);

        return ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse<String> deleteResume(Resume resume) {
        //1、根据id查询是否有该简历

        //2、判断简历状态，如果是未申请状态可以删除，流程中无法删除

        //3、未申请状态，删除

        return null;
    }

    @Override
    public ServerResponse<String> updateResume(Resume resume) {

        //1、删除简历

        //2、更新简历


        return null;
    }

    @Override
    public ServerResponse<Resume> inquireResume(String id) {

        //1、判断id输入是否正确


        //2、查询Resume

        return null;
    }



    @Override
    public ServerResponse<Resume> saveResumeList(ArrayList<Resume> resumeArrayList) {
        return null;
    }

    /**
     *@Author: A wei
     *@Description 查询简历是否再人才库
     *@return boolean
     *@param
     **/
    private  ServerResponse checkResume(String str,String type){
        //1、校验输入数据是否为空
        if (str.isEmpty()){
            return ServerResponse.createByErrorMessage("简历校验失败");
        }
        if (Const.ID_CARD_NUMBER.equals(type)){
            if (resumeMapper.checkResumeIdCard(str) > 0){
                return ServerResponse.createByErrorMessage("身份证号码已注册");
            }
        }
        if (Const.PHONE.equals(type)){
            if (resumeMapper.checkResumePhone(str) > 0){
                return ServerResponse.createByErrorMessage("电话已注册！");
            }
        }
        if (Const.EMAIL.equals(type)){
            if (resumeMapper.checkResumeEmail(str) > 0){
                return ServerResponse.createByErrorMessage("邮箱已注册！");
            }
        }
        return ServerResponse.createBySuccess();
    }
    /**
     *@Author: A wei
     *@Description 根据id查询简历是否存在
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

    /**
     *@Author: A wei
     *@Description 根据id查简历
     *@return {@link Resume}
     *@param id
     **/

    private static Resume selectResumeById(String id,ArrayList<Resume> resumeArrayList){
        for (Resume item : resumeArrayList){
            if (item.getId().equals(id)){
                return item;
            }
        }
        return null;
    }


}
