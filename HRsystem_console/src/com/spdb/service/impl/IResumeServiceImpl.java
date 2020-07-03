package com.spdb.service.impl;

import com.spdb.common.ResumeStatusCode;
import com.spdb.common.ServerResponse;
import com.spdb.pojo.Resume;
import com.spdb.service.IResumeService;
import com.spdb.util.IResumeCheck;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @Author: A wei
 * @Date: 2020/7/2 9:03
 * @Last Modified by:
 * @last Modified date:
 * @Description: 简历服务 增删改查
 */
public class IResumeServiceImpl implements IResumeService {

    public ServerResponse<Resume> createResume(Resume resume, ArrayList<Resume> resumeArrayList) {

        //1、判断是否参数有null值 后续可以考虑采用lombok的@NotNULL进行参数校验
        if (resume.getName().isEmpty()) return ServerResponse.createByErrorMessage("姓名为空！请输入您的姓名");

        if (resume.getId().isEmpty() || resume.getId().length()!= 18) return ServerResponse.createByErrorMessage("身份证输入错误！");

        if (resume.getSchool().isEmpty()) return ServerResponse.createByErrorMessage("学校为空！请输入您的学校信息");

        if (resume.getMajor().isEmpty()) return ServerResponse.createByErrorMessage("专业为空！请输入您的专业信息");

        if (resume.getPhone().isEmpty()) return ServerResponse.createByErrorMessage("电话为空！请输入您的电话号码");

        //3、查询id、电话、邮箱是否已注册。是：返回错误，否继续下一步。

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

    public ServerResponse<String> deleteResume(Resume resume,ArrayList<Resume> resumeArrayList) {


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
    public ServerResponse<String> updateResume(Resume resume,ArrayList<Resume> resumeArrayList) {
       //删除
        if (!deleteResume(resume,resumeArrayList).isSuccess()){
            return ServerResponse.createByErrorMessage("更新失败");
        }
        //更新简历
        resumeArrayList.add(resume);
        return ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse<Resume> selectResume(String id,ArrayList<Resume> resumeArrayList) {
        //1、查询id是否为空
        if (id.isEmpty()){
            return ServerResponse.createByErrorMessage("id为空！请输入正确证件号码");
        }
        //2、查询简历
        Resume resume =selectResumeById(id,resumeArrayList);
        //3、判断简历状态
        if (resume == null){
            return ServerResponse.createByErrorMessage("查询失败，简历不存在！");
        }else{
            return ServerResponse.createBySuccess(resume);
        }
    }

    @Override
    public ServerResponse<String> saveResumeList(String path,ArrayList<Resume> resumeArrayList) {
        //2、简历库是否有简历
        if (resumeArrayList.size() == 0){
            return ServerResponse.createByErrorMessage("当前简历库无简历信息！");
        }
        //3、写简历到我们的txt文档
        try{
            writeResumeList(path,resumeArrayList);
            return ServerResponse.createBySuccess();
        }catch (IOException e){
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("IO异常");
        }

    }

    /**
     *@Author: A wei
     *@Description 查询简历是否在人才库
     *@return boolean
     *@param checkResume,resumeList,iResumeCheck
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
    public static Resume selectResumeById(String id,ArrayList<Resume> resumeArrayList){
        for (Resume item : resumeArrayList){
            if (item.getId().equals(id)){
                return item;
            }
        }
        return null;
    }

    /**
     *@Author: A wei
     *@Description 获取用户输入简历信息，生成简历对象
     *@return
     *@param
     **/
    public static Resume getResumeInformation(int status){
        if(status == 1){
            System.out.println("-------welcome to create resume-------");
            System.out.println("please type your: name、id、school、major、sex、phone、email");
        }else if(status == 3){
            System.out.println("-------welcome to update resume-------");
            System.out.println("please type your name、id、school、major、sex、phone、email");
        }
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String id = scanner.nextLine();
        String school = scanner.nextLine();
        String major = scanner.nextLine();
        String sexStr = scanner.nextLine();
        int sex = "男".equals(sexStr)? 0:1;
        String phone = scanner.nextLine();
        String email = scanner.nextLine();

        scanner.close();

        Resume result = new Resume(name,id,school,major,sex,phone,email, ResumeStatusCode.NOTAPPLY.getCode());

        return result;
    }
    /**
     *@Author: A wei
     *@Description 根据id获取用户简历
     *@return
     *@param
     **/
    public static ServerResponse getUserResumeById(int status,ArrayList<Resume> resumeArrayList){
        switch (status){
            case 2:{
                System.out.println("-------welcome to delete resume-------");
                System.out.println("please type your: id");
                Scanner scanner = new Scanner(System.in);
                String id = scanner.nextLine();
                scanner.close();
                return ServerResponse.createBySuccess(selectResumeById(id,resumeArrayList));
            }
            case 4:{
                System.out.println("-------welcome to inquire resume-------");
                System.out.println("please type your: id");
                Scanner scanner = new Scanner(System.in);
                String id = scanner.nextLine();
                scanner.close();
                return ServerResponse.createBySuccess(id);
            }
        }

        return null;
    }
    /**
     *@Author: A wei
     *@Description 打印简历信息
     *@return
     *@param
     **/
    public static void printResume(Resume result){
        System.out.println("name:"+result.getName()+"\n" +
                "id:" + result.getId()+"\n"+
                "school:" + result.getSchool()+"\n"+
                "major:" + result.getMajor() + "\n"+
                "sex:" + (result.getSex() == 0?"男":"女") + "\n"+
                "phone:" + result.getPhone() + "\n"+
                "email:" + result.getEmail() + "\n");
    }

    /**
     *@Author: A wei
     *@Description 写入文件流
     *@return boolean
     *@param
     **/
    public static boolean writeResumeList(String path,ArrayList<Resume> resumeArrayList) throws IOException{
        //将文件操作转换为缓冲流操作
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));

        for (Resume item : resumeArrayList){
            bufferedWriter.write(item.getName()+" " +
                                     item.getId()+" "+
                                     item.getSchool()+" "+
                                     item.getMajor() + " "+
                                     (item.getSex() == 0?"男":"女") + " "+
                                     item.getPhone() + " "+
                                     item.getEmail() + "\n");
        }

        bufferedWriter.close();
        return true;
    }

    /**
     *@Author: A wei
     *@Description 从文件中读取数据
     *@return ArrayList<Resume>
     *@param
     **/
    public static ArrayList<Resume> loadResumes(String path){
        //1、测试路径
        if (path.isEmpty()){
            System.out.println("路径名不对,请输入正确路径名！");
            return null;
        }
        //2、读取文件
        File file = new File(path);
        BufferedReader bufferedReader = null;
        ArrayList<Resume> resumeArrayList = new ArrayList<>();
        Resume resume = null;
        try{
            //3、读入缓存
            bufferedReader = new BufferedReader(new FileReader(file));
            String str;
            //4、数据操作，装载成简历对象
            while((str = bufferedReader.readLine()) != null){
                String[] arrayStr = str.split(" ");
                resume = new Resume(arrayStr[0],
                                    arrayStr[1],
                                    arrayStr[2],
                                    arrayStr[3],
                                    arrayStr[4].equals("男")?0:1,
                                    arrayStr[5],
                                    arrayStr[6],
                                    ResumeStatusCode.NOTAPPLY.getCode());
                resumeArrayList.add(resume);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return resumeArrayList;
    }

}

