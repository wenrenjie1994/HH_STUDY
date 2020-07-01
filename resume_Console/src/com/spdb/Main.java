package com.spdb;

import com.spdb.pojo.Resume;
import com.spdb.util.IResumeCheck;

import java.util.ArrayList;
/**
 *@Author: A wei
 *@Description 测试java8的Lambda表达式，优化简历检查
 *@return
 *@param
 **/
public class Main {

    public static void main(String[] args) {
	// write your code here

        Resume resume1 = new Resume( "fuaowei",
                                    "420621199506128612",
                                    "scu",
                                    "optical enginering",
                                    0,
                                    "18512842515",
                                    "Aowei_fu@163.com",
                                    -1);

        Resume resume2 = new Resume( "张三",
                                    "4206211995061235892",
                                    "pk",
                                    "computer science",
                                    0,
                                    "18512841128",
                                    "zhansan@163.com",
                                    -1);

        ArrayList<Resume> resumeArrayList = new ArrayList<>();
        resumeArrayList.add(resume1);
        resumeArrayList.add(resume2);


        Resume resume3 = new Resume( "李四",
                                    "4206211995061221212",
                                    "pk",
                                    "computer science",
                                    0,
                                    "18512843232",
                                    "lisi@163.com",
                                    -1);
        resumeArrayList.add(resume3);

        if (checkResume(resume3,resumeArrayList,
                (Resume res1,Resume res2)-> res1.getId().equals(res2.getId()))){
                System.out.println("身份证号码已注册！");
        }else{
            System.out.println("身份证号码未注册！");
        }
        if (checkResume(resume3,resumeArrayList,
                (Resume res1,Resume res2)-> res1.getPhone().equals(res2.getPhone()))){
            System.out.println("电话号码已注册！");
        }else{
            System.out.println("电话号码未注册！");
        }

    }

    private static boolean checkResume(Resume checkResume, ArrayList<Resume> resumeList, IResumeCheck iResumeCheck){

        for (Resume item:resumeList){
            if (iResumeCheck.checked(item,checkResume)){
                return true;
            }
        }
        return false;
    }
}
