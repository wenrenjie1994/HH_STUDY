package com.spdb.lowbhrsys.service.impl;

import com.spdb.lowbhrsys.bean.ResumeBean;
import com.spdb.lowbhrsys.service.IResumeService;
import com.spdb.lowbhrsys.utils.BaseDB;
import com.spdb.lowbhrsys.utils.ResponseData;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author: libobo
 * @create: 2020-07-06 21:53
 * @description: 数据库版,本应该将数据库的操作写在dao层中，但懒得写。。。。。就直接写在业务层
 **/
public class ResumeDBServiceImpl extends BaseDB implements IResumeService {
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
        //从连接池中获取连接
        this.setConnection();
        try {
            ps=con.prepareStatement("insert into t_resume values(null,?,?,?,?,?,?,?)");
            ps.setString(1,resume.getName());
            ps.setString(2,resume.getId());
            ps.setString(3,resume.getSex());
            ps.setString(4,resume.getSchool());
            ps.setString(5,resume.getEmail());
            ps.setString(6,resume.getPhone());
            ps.setInt(7,resume.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            this.rollback();
            e.printStackTrace();
            return ResponseData.returnError("存储失败，数据库异常！");
        }
        return ResponseData.returnSuccess();
    }

    @Override
    public ResponseData deleteResume(int resumeId) {
        int count=0;
        this.setConnection();
        try {
            ps=con.prepareStatement("delete from t_resume where resumeId=?");
            ps.setInt(1,resumeId);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            this.rollback();
            e.printStackTrace();
            return ResponseData.returnError("删除失败,数据库异常！");
        }
        return count ==1?ResponseData.returnSuccess():ResponseData.returnError("删除失败，没有找到该简历信息！");
    }

    @Override
    public ResponseData updateResume(int resumeId, String name, String email, String phone) {
        int count=0;
        this.setConnection();
        try {
            ps=con.prepareStatement("update t_resume set name=?,email=?,phone=? where resumeId=?");
            ps.setString(1,name);
            ps.setString(2,email);
            ps.setString(3,phone);
            ps.setInt(4,resumeId);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            this.rollback();
            e.printStackTrace();
            return ResponseData.returnError("更新失败,数据库异常！");
        }
        return count ==1?ResponseData.returnSuccess():ResponseData.returnError("更新失败，没有找到该简历信息！");
    }

    @Override
    public ResponseData<ResumeBean> findResumeByResumeId(int resumeId) {
        this.setConnection();
        ResumeBean resume=null;
        try {
            ps=con.prepareStatement("select * from t_resume where resumeId=?");
            ps.setInt(1,resumeId);
            re=ps.executeQuery();
            if (re.next()){
                resume=new ResumeBean();
                resume.setResumeId(re.getInt("resumeId"));
                resume.setName(re.getString("name"));
                resume.setId(re.getString("id"));
                resume.setSex(re.getString("sex"));
                resume.setSchool(re.getString("school"));
                resume.setEmail(re.getString("email"));
                resume.setPhone(re.getString("phone"));
                resume.setStatus(re.getInt("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseData.returnError("查询失败,数据库异常！");
        }
        return resume!=null?ResponseData.returnData(resume):ResponseData.returnError("没有找到该简历信息！");
    }

    @Override
    public ResponseData<List<ResumeBean>> findAllResume() {
        this.setConnection();
        List<ResumeBean> list=new ArrayList<>();
        try {
            ps=con.prepareStatement("select * from t_resume");
            re=ps.executeQuery();
            while (re.next()){
                ResumeBean resume=new ResumeBean();
                resume.setResumeId(re.getInt("resumeId"));
                resume.setName(re.getString("name"));
                resume.setId(re.getString("id"));
                resume.setSex(re.getString("sex"));
                resume.setSchool(re.getString("school"));
                resume.setEmail(re.getString("email"));
                resume.setPhone(re.getString("phone"));
                resume.setStatus(re.getInt("status"));
                list.add(resume);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseData.returnError("查询失败,数据库异常！");
        }
        return ResponseData.returnData(list);
    }
}
