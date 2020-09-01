package com.sp.lowbhrsys.service.impl;

import com.sp.lowbhrsys.utils.ResponseData;
import com.sp.lowbhrsys.utils.ResumeMemory;
import com.sp.lowbhrsys.bean.ResumeBean;
import com.sp.lowbhrsys.service.IResumeService;

import java.util.List;

/**
 * @author: libobo
 * @create: 2020-07-03 15:03
 * @description: 基于内存实现增删改查操作
 **/
public class ResumeMemoryServiceImpl implements IResumeService {
    @Override
    public ResponseData addResume(ResumeBean resume) {
        //判断姓名，身份证，学校，电话号码等是否填写
        if (resume.getName().isEmpty()){
            return ResponseData.returnError("姓名为空，请重写输入");
        }
        if (resume.getId().isEmpty()||resume.getId().length()!=18){
            return ResponseData.returnError("身份证未输入，或格式不正确");
        }
        if (resume.getSchool().isEmpty()){
            return ResponseData.returnError("学校为空，请重写输入");
        }
        if (resume.getPhone().isEmpty()){
            return ResponseData.returnError("电话号码为空，请重新输入");
        }
        //.......等等......

        //由于resumeId由数据库生成，但现阶段只能自己生成，该resumeId模仿数据库主键id自增长
        resume.setResumeId(ResumeMemory.list.get(ResumeMemory.list.size()-1).getResumeId()+1);
        ResumeMemory.list.add(resume);
        return ResponseData.returnSuccess();
    }

    @Override
    public ResponseData deleteResume(int resumeId) {
        for (ResumeBean resume:
             ResumeMemory.list) {
            if (resumeId==resume.getResumeId()){
                ResumeMemory.list.remove(resume);
                return ResponseData.returnSuccess();
            }
        }
        return ResponseData.returnError("删除失败，没有找到该简历信息！");
    }

    /**
     *
     * @param resumeId 简历ID
     * @param name 姓名
     * @param email 邮件
     * @param phone 手机号
     * @return
     */
    @Override
    public ResponseData updateResume(int resumeId,String name,String email,String phone) {
        for (ResumeBean r:
                ResumeMemory.list) {
            if (r.getResumeId()==resumeId){
                r.setName(name);
                r.setEmail(email);
                r.setPhone(phone);
                return ResponseData.returnSuccess();
            }
        }
        return ResponseData.returnError("修改失败，没有找到该简历信息！");
    }

    @Override
    public ResponseData<ResumeBean> findResumeByResumeId(int resumeId) {
        for (ResumeBean resume:
             ResumeMemory.list) {
            if (resumeId==resume.getResumeId()){
                return ResponseData.returnData(resume);
            }
        }
        return ResponseData.returnError("没有找到改简历信息！");
    }

    @Override
    public ResponseData<List<ResumeBean>> findAllResume() {
       return ResponseData.returnData(ResumeMemory.list);
    }

}
