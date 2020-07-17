package com.testHr.service.impl;

import com.testHr.dto.ResumeDTO;
import com.testHr.model.Resume;
import com.testHr.service.ResumeService;
import com.testHr.utils.Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @description: 逻辑实现
 * @author: zeng
 * @modified By:
 */
public class ResumeServiceImpl implements ResumeService {

    @Override
    public void addResume(BufferedReader in, PrintWriter out) {
        try {
            System.out.println("您已进入简历添加模式");
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入简历人的姓名,以回车结束");
            String name = sc.nextLine();
            System.out.println("请输入简历人的id,以回车结束");
            String id = sc.nextLine();
            System.out.println("请输入简历人的学校,以回车结束");
            String school = sc.nextLine();
            ResumeDTO resumeDTO = new ResumeDTO();
            resumeDTO.setHead("add");
            resumeDTO.setBody(name+","+id+","+school);
            out.println(resumeDTO.getHead()+":"+resumeDTO.getBody());//发送添加信息到服务器端
            resumeDTO = Parser.parseMessage(in.readLine());//接受返回信息，并解析
            if(resumeDTO.isSuccess() == true){
                System.out.println("----添加成功！----");
                System.out.println();
            }else{
                throw new RuntimeException("出错:"+resumeDTO.getReturnfailMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteResume(BufferedReader in, PrintWriter out) {
        try {
            System.out.println("您已进入简历删除模式");
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入要删除简历人的id，以回车结束");
            String inputId = sc.nextLine();
            ResumeDTO resumeDTO = new ResumeDTO();
            resumeDTO.setHead("queryById");
            resumeDTO.setBody(inputId);
            out.println(resumeDTO.getHead()+":"+resumeDTO.getBody());//先查询该简历人是否存在
            resumeDTO = Parser.parseMessage(in.readLine());
            if(resumeDTO.isSuccess() == true){
                System.out.println();//该id存在
            }else{
                throw new RuntimeException("出错:"+resumeDTO.getReturnfailMessage());
            }
            System.out.println("请选择您的删除模式：0->简历拉黑;1->删除数据");
            int input = Integer.parseInt(sc.nextLine());
            if (input == 0) {
                resumeDTO.setHead("updateDeleteStatus");
                resumeDTO.setBody(inputId);
                out.println(resumeDTO.getHead()+":"+resumeDTO.getBody());
                resumeDTO = Parser.parseMessage(in.readLine());
                if(resumeDTO.isSuccess() == true){
                    System.out.println("----拉黑成功----");//
                    System.out.println();
                }else{
                    throw new RuntimeException("出错:"+resumeDTO.getReturnfailMessage());
                }
            } else if (input == 1) {
                resumeDTO.setHead("delete");
                resumeDTO.setBody(inputId);
                out.println(resumeDTO.getHead()+":"+resumeDTO.getBody());
                resumeDTO = Parser.parseMessage(in.readLine());
                if(resumeDTO.isSuccess() == true){
                    System.out.println("----删除成功----");//
                    System.out.println();
                }else{
                    throw new RuntimeException("出错:"+resumeDTO.getReturnfailMessage());
                }
            } else {
                System.out.println("！！您的选择有误！！");
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateResume(BufferedReader in, PrintWriter out) {
        try {
            System.out.println("-------您已进入简历修改模式-------");
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入要修改简历人的id，以回车结束");
            String inputId = sc.nextLine();
            Resume resume = new Resume();
            ResumeDTO resumeDTO = new ResumeDTO();
            resumeDTO.setHead("queryById");
            resumeDTO.setBody(inputId);
            out.println(resumeDTO.getHead()+":"+resumeDTO.getBody());//先查询该简历人是否存在
            resumeDTO = Parser.parseMessage(in.readLine());
            if(resumeDTO.isSuccess() == true){
                System.out.println();//该id存在
                resume = resumeDTO.getResume();
            }else{
                throw new RuntimeException("出错:"+resumeDTO.getReturnfailMessage());
            }
            while (true){
                System.out.println("---重新录入简历人信息，请选择您要修改的内容：---");
                System.out.println("--------------修改姓名请输入1----------------");
                System.out.println("---------------修改id请输入2-----------------");
                System.out.println("--------------修改学校请输入3----------------");
                System.out.println("-------------修改简历状态请输入4-------------");
                System.out.println("-------------确认修改信息请输入5--------------");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice){
                    case 1:
                        System.out.println("请输入新的姓名，以回车结束：");
                        String name = sc.nextLine();
                        resume.setName(name);
                        break;//直接跳出switch
                    case 2:
                        System.out.println("请输入新的id，以回车结束：");
                        Integer id = Integer.parseInt(sc.nextLine());
                        resume.setId(id);
                        break;
                    case 3:
                        System.out.println("请输入新的学校，以回车结束");
                        String school = sc.nextLine();
                        resume.setSchool(school);
                        break;
                    case 4:
                        System.out.println("请输入新的简历状态，以回车结束");
                        Integer process = Integer.parseInt(sc.nextLine());
                        resume.setProcess(process);
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("您的选择有误，请重新输入！");
                }
                if (choice == 5){//确认修改信息，并修改
                    resumeDTO.setHead("update");
                    resumeDTO.setBody(resume.getName()+","+resume.getId()+","+resume.getSchool()+","+resume.getProcess()+","+inputId);
                    out.println(resumeDTO.getHead()+":"+resumeDTO.getBody());
                    resumeDTO = Parser.parseMessage(in.readLine());
                    if(resumeDTO.isSuccess() == true){
                        System.out.println("----修改成功----");//
                        System.out.println();
                    }else{
                        throw new RuntimeException("修改失败,原因:"+resumeDTO.getReturnfailMessage());
                    }
                    break;//退出循环
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void queryResume(BufferedReader in, PrintWriter out) {
        try {
            System.out.println("------您已进入简历查询模式，请选择您的查询类型-------");
            System.out.println("-----------------全部查询请输入1------------------");
            System.out.println("---------------查询有效简历请输入2-----------------");
            System.out.println("----------------黑名单查询请输入3-----------------");
            System.out.println("-----------------查询姓名请输入4-----------------");
            System.out.println("------------------查询id请输入5-----------------");
            System.out.println("-----------------查询学校请输入6-----------------");
            System.out.println("-----------------查询状态请输入7-----------------");
            Scanner sc = new Scanner(System.in);
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    ResumeDTO resumeDTO = new ResumeDTO();
                    resumeDTO.setHead("queryAll");
                    resumeDTO.setBody("");
                    out.println(resumeDTO.getHead()+":"+resumeDTO.getBody());
                    resumeDTO = Parser.parseMessage(in.readLine());
                    if(resumeDTO.isSuccess()){
                        resumeDTO.showAllList();
                    }else{
                        throw new RuntimeException("出错:"+resumeDTO.getReturnfailMessage());
                    }
                    break;//直接跳出switch
                case 2:
                    ResumeDTO resumeDTO2 = new ResumeDTO();
                    resumeDTO2.setHead("queryEffList");
                    resumeDTO2.setBody("");
                    out.println(resumeDTO2.getHead()+":"+resumeDTO2.getBody());
                    resumeDTO2 = Parser.parseMessage(in.readLine());
                    if(resumeDTO2.isSuccess()){
                        resumeDTO2.showSomeList();
                    }else{
                        throw new RuntimeException("出错:"+resumeDTO2.getReturnfailMessage());
                    }
                    break;
                case 3:
                    ResumeDTO resumeDTO3 = new ResumeDTO();
                    resumeDTO3.setHead("queryBlackList");
                    resumeDTO3.setBody("");
                    out.println(resumeDTO3.getHead()+":"+resumeDTO3.getBody());
                    resumeDTO3 = Parser.parseMessage(in.readLine());
                    if(resumeDTO3.isSuccess()){
                        resumeDTO3.showSomeList();
                    }else{
                        throw new RuntimeException("出错:"+resumeDTO3.getReturnfailMessage());
                    }
                    break;
                case 4:
                    System.out.println("请输入您要查询的姓名，以回车结束");
                    String name = sc.nextLine();
                    ResumeDTO resumeDTO4 = new ResumeDTO();
                    resumeDTO4.setHead("queryByName");
                    resumeDTO4.setBody(name);
                    out.println(resumeDTO4.getHead()+":"+resumeDTO4.getBody());
                    resumeDTO4 = Parser.parseMessage(in.readLine());
                    if(resumeDTO4.isSuccess()){
                        resumeDTO4.showSomeList();
                    }else{
                        throw new RuntimeException("出错:"+resumeDTO4.getReturnfailMessage());
                    }
                    break;
                case 5:
                    System.out.println("请输入您要查询的id，以回车结束");
                    String inputId = sc.nextLine();
                    ResumeDTO resumeDTO5 = new ResumeDTO();
                    resumeDTO5.setHead("queryById");
                    resumeDTO5.setBody(inputId);
                    out.println(resumeDTO5.getHead()+":"+resumeDTO5.getBody());
                    resumeDTO5 = Parser.parseMessage(in.readLine());
                    if(resumeDTO5.isSuccess()){
                        System.out.println("----------------您的查询结果为：----------------");
                        resumeDTO5.getResume().show();
                    }else{
                        throw new RuntimeException("出错:"+resumeDTO5.getReturnfailMessage());
                    }
                    System.out.println();
                    break;
                case 6:
                    System.out.println("请输入您要查询的学校，以回车结束");
                    String school = sc.nextLine();
                    ResumeDTO resumeDTO6 = new ResumeDTO();
                    resumeDTO6.setHead("queryBySchool");
                    resumeDTO6.setBody(school);
                    out.println(resumeDTO6.getHead()+":"+resumeDTO6.getBody());
                    resumeDTO6 = Parser.parseMessage(in.readLine());
                    if(resumeDTO6.isSuccess()){
                        resumeDTO6.showSomeList();
                    }else{
                        throw new RuntimeException("出错:"+resumeDTO6.getReturnfailMessage());
                    }
                    break;
                case 7:
                    System.out.println("请输入您要查询的状态，以回车结束");
                    String process = sc.nextLine();
                    ResumeDTO resumeDTO7 = new ResumeDTO();
                    resumeDTO7.setHead("queryByProcess");
                    resumeDTO7.setBody(process);
                    out.println(resumeDTO7.getHead()+":"+resumeDTO7.getBody());
                    resumeDTO7 = Parser.parseMessage(in.readLine());
                    if(resumeDTO7.isSuccess()){
                        resumeDTO7.showSomeList();
                    }else{
                        throw new RuntimeException("出错:"+resumeDTO7.getReturnfailMessage());
                    }
                    break;
                default:
                    System.out.println("您的选择有误，查询失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void over(BufferedReader in, PrintWriter out) {
        out.println("over");
        try {
            ResumeDTO resumeDTO = Parser.parseMessage(in.readLine());
            if ("over".equals(resumeDTO.getHead())) {
                System.out.println(resumeDTO.getBody());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
