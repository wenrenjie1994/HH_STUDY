package com.spdb.resume.service.impl;


import com.spdb.resume.common.Const;
import com.spdb.resume.common.ResumeStatusCode;
import com.spdb.resume.common.ServerResponse;
import com.spdb.resume.dao.ResumeMapper;
import com.spdb.resume.pojo.Resume;
import com.spdb.resume.service.IResumeService;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;

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
        int resultCount = resumeMapper.insert(resume);
        if (resultCount == 0){
            return ServerResponse.createByErrorMessage("新建简历失败！");
        }else{
            return ServerResponse.createBySuccess("简历创建成功！");
        }

    }

    @Override
    public ServerResponse<String> deleteResume(Resume resume) {
        //1、根据id查询是否有该简历
        if (!checkResume(resume.getId().toString(),Const.ID).isSuccess()){
            return ServerResponse.createByErrorMessage("简历不存在！");
        }
        //2、判断简历状态，如果是未申请状态可以删除，流程中无法删除
        if (resume.getStatus() != ResumeStatusCode.NOTAPPLY.getCode()){
            return ServerResponse.createByErrorMessage("简历正在审核流程中，无法删除！");
        }
        //3、未申请状态，删除
        int resultCount = resumeMapper.deleteByPrimaryKey(resume.getId());
        if (resultCount == 0){
            return ServerResponse.createByErrorMessage("简历删除失败");
        }else{
            return ServerResponse.createBySuccess("简历删除成功！");
        }

    }

    @Override
    public ServerResponse<String> updateResume(Resume resume) {
        //1、查找简历是否存在
        if (!checkResume(resume.getId().toString(),Const.ID).isSuccess()){
            return ServerResponse.createByErrorMessage("简历不存在！");
        }
        //2、判断简历状态，未申请状态可以更新，流程中无法更新
        if (resume.getStatus() != ResumeStatusCode.NOTAPPLY.getCode()){
            return ServerResponse.createByErrorMessage("简历正在审核流程中，无法更新！");
        }
        //3、更新简历
        int resultCount = resumeMapper.updateByPrimaryKeySelective(resume);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("简历更新失败！");
        }else{
            return ServerResponse.createBySuccess("简历更新成功！");
        }
    }

    @Override
    public ServerResponse<Resume> inquireResume(Integer id) {
        //1、校验id
        if (id == null){
           return ServerResponse.createByErrorMessage("输入id为空！");
        }
        //2、根据id查找简历是否存在
        if (!checkResume(id.toString(),Const.ID).isSuccess()){
            return ServerResponse.createByErrorMessage("简历不存在！");
        }
        //2、查询Resume
        Resume resultResume = resumeMapper.selectByPrimaryKey(id);
        if (resultResume == null){
            return ServerResponse.createByErrorMessage("简历不存在");
        }else{
            return ServerResponse.createBySuccess(resultResume);
        }
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
        if (Const.ID.equals(type)){
            if (resumeMapper.checkResumeID(Integer.parseInt(str)) <= 0){
                return ServerResponse.createByErrorMessage("简历不存在");
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
