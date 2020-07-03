package com.spdb;

import com.spdb.common.ServerResponse;
import com.spdb.pojo.Resume;
import com.spdb.service.IResumeService;
import com.spdb.service.impl.IResumeServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

import static com.spdb.service.impl.IResumeServiceImpl.getResumeInformation;

/**
 *@Author: A wei
 *@Description 程序流程引导类
 *@return
 *@param
 **/
public class Main {

    private static IResumeServiceImpl iResumeService = new IResumeServiceImpl();

    private static ArrayList<Resume> resumeArrayList = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    private static String resumePath = "E:\\HH_STUDY\\HRsystem_console\\src\\resource\\resume\\ResumeList.txt";

    public static void main(String[] args) {
	// write your code here
        Resume resume1 = new Resume( "fuaowei",
                                    "420621199506127746",
                                    "scu",
                                    "optical-enginering",
                                    0,
                                    "18512842515",
                                    "Aowei_fu@163.com",
                                    -1);

        Resume resume2 = new Resume( "张三",
                                    "4206211995061235892",
                                    "pk",
                                    "computer-science",
                                    0,
                                    "18512841128",
                                    "zhansan@163.com",
                                    -1);

        Resume resume3 = new Resume( "李四",
                                    "4206211995061221212",
                                    "pk",
                                    "computer-science",
                                    0,
                                    "18512843232",
                                    "lisi@163.com",
                                    -1);

        resumeArrayList.add(resume1);
        resumeArrayList.add(resume2);
        resumeArrayList.add(resume3);

        //文件导入简历
        resumeArrayList = IResumeServiceImpl.loadResumes(resumePath);

        //根据输入选项进行业务操作
        doSomething2Resume();

        iResumeService.saveResumeList(resumePath,resumeArrayList);

        scanner.close();

    }

    private static void menu(){
        System.out.println("-------Welcome to the spdb first version HR resume system-------");
        System.out.println("if you have something to do,choose one. ");
        System.out.println("---creat a new resume,input 1");
        System.out.println("---delete a resume,input 2");
        System.out.println("---update a resume,input 3");
        System.out.println("---inquire a resume,input 4");
        System.out.println("---exit system,input 5");
    }

    private static void doSomething2Resume(){

        while(true){

            menu(); //主菜单

            int choice = scanner.nextInt();

            switch (choice){
                case 1:{
                    Resume resume = getResumeInformation(1);
                    ServerResponse serverResponse = iResumeService.createResume(resume,resumeArrayList);
                    if (serverResponse.getStatus() < 0){
                        System.out.println(serverResponse.getMessage());
                    }else{
                        System.out.println("resume has been created!\n");
                    }
                    break;
                }
                case 2:{
                    Resume resume = (Resume) IResumeServiceImpl.getUserResumeById(2,resumeArrayList).getData();
                    ServerResponse serverResponse = iResumeService.deleteResume(resume,resumeArrayList);
                    if (serverResponse.getStatus() < 0){
                        System.out.println(serverResponse.getMessage());
                    }else{
                        System.out.println("resume has been deleted!\n");
                    }
                    break;
                }
                case 3:{
                    Resume resume = getResumeInformation(3);
                    ServerResponse serverResponse = iResumeService.updateResume(resume,resumeArrayList);
                    if (serverResponse.getStatus() < 0){
                        System.out.println(serverResponse.getMessage());
                    }else{
                        System.out.println("resume has been update!\n");
                    }
                    break;
                }
                case 4:{
                    String id = (String)IResumeServiceImpl.getUserResumeById(4,resumeArrayList).getData();
                    ServerResponse serverResponse = iResumeService.selectResume(id,resumeArrayList);
                    if (serverResponse.getStatus() < 0){
                        System.out.println(serverResponse.getMessage());
                    }else{
                        Resume result = (Resume) serverResponse.getData();
                        IResumeServiceImpl.printResume(result);
                    }
                    break;
                }
                case 5: {
                    System.out.println("bye bye!");
                    break;
                }
                default:
                    System.out.println("please enter the right option!");
                    break;
            }
        }
    }

}
