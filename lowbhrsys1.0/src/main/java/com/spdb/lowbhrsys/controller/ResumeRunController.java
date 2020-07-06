package com.spdb.lowbhrsys.controller;

import com.spdb.lowbhrsys.bean.ResumeBean;
import com.spdb.lowbhrsys.service.IResumeService;
import com.spdb.lowbhrsys.service.impl.ResumeDBServiceImpl;
import com.spdb.lowbhrsys.service.impl.ResumeMemoryServiceImpl;
import com.spdb.lowbhrsys.utils.ResponseData;

import java.util.List;
import java.util.Scanner;

/**
 * @author: libobo
 * @create: 2020-07-03 17:15
 * @description: 模仿controller调用业务层
 **/
public class ResumeRunController {
//    private static IResumeService resumeService=new ResumeMemoryServiceImpl();
    private static IResumeService resumeService=new ResumeDBServiceImpl();
    public static void addResume(){
        System.out.println("欢迎进入添加简历界面！");
        System.out.println("请依次输入姓名、身份证、性别、学校、邮件、手机号，以回车分割！");
        Scanner in=new Scanner(System.in);
        String name=in.nextLine();
        String id=in.nextLine();
        String sex=in.nextLine();
        String school=in.nextLine();
        String email=in.nextLine();
        String phone=in.nextLine();
        ResumeBean resume=new ResumeBean(name,id,sex,school,email,phone);
        ResponseData responseData = resumeService.addResume(resume);
        if (responseData.getCode()==200){
            System.out.println("完成添加简历！");
        }else{
            System.out.println("添加失败，失败原因："+responseData.getMsg());
        }
        showStudent();
        //System.in 在java中是静态变量，当前类所有的scanner对象共享它，
        //当一个scanner对象执行close()操作后，其他所有的scanner对象都不可用了，用时需要注意一下
//        in.close();
    }
    public static void updateResume(){
        System.out.println("欢迎进入修改简历界面！");
        System.out.println("请依次输入简历ID、姓名、邮件、手机号，以回车分割！！");
        Scanner in=new Scanner(System.in);
        int resumeId=in.nextInt();
        in.nextLine();
        String name=in.nextLine();
        String email=in.nextLine();
        String phone=in.nextLine();
        ResponseData responseData = resumeService.updateResume(resumeId,name,email,phone);
        if (responseData.getCode()==200){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败，失败原因："+responseData.getMsg());
        }
        showStudent();
    }
    public static void delResume(){
        System.out.println("欢迎进入删除简历界面！");
        System.out.println("请输入简历ID！");
        Scanner in=new Scanner(System.in);
        int resumeId=in.nextInt();
        ResponseData responseData = resumeService.deleteResume(resumeId);
        if (responseData.getCode()==200){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败，失败原因："+responseData.getMsg());
        }
        showStudent();
    }
    public static void findResume(){
        System.out.println("欢迎进入查询简历页面！");
        System.out.println("请输入简历ID！");
        Scanner in=new Scanner(System.in);
        int resumeId=in.nextInt();
        ResponseData<ResumeBean> responseData = resumeService.findResumeByResumeId(resumeId);
        if (responseData.getCode()==200){
            System.out.println("查询成功：姓名："+responseData.getData().getName()+"身份证："+responseData.getData().getId()+"性别："+responseData.getData().getSex()
                    +"学校："+responseData.getData().getSchool()+"邮箱："+responseData.getData().getEmail()+"电话："+responseData.getData().getPhone());
        }else {
            System.out.println("查询失败，失败原因："+responseData.getMsg());
        }
        showStudent();
    }
    public static void showStudent(){
        System.out.println("是否查看所有学生信息，y/n");
        Scanner in=new Scanner(System.in);
        String y=in.nextLine();
        if ("y".equals(y)){
            ResponseData<List<ResumeBean>> allResume = resumeService.findAllResume();
            List<ResumeBean> list=allResume.getData();
            System.out.println("共有"+list.size()+"份简历！");
            for (ResumeBean resume:
                    list) {
                System.out.println("简历ID"+resume.getResumeId()+"姓名："+resume.getName()+"身份证："+resume.getId()+"性别："+resume.getSex()
                        +"学校："+resume.getSchool()+"邮箱："+resume.getEmail()+"电话："+resume.getPhone()+"简历状态："+resume.getStatus());
            }
        }
//        in.close();
    }
}
