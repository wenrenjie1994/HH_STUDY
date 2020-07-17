package com.caorui.service;


import com.caorui.bean.Applicant;
import com.caorui.dao.ApplicantDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ApplicantService {
    public static String insert(String[] strings) {
        String name = strings[1];//获得学生姓名
        String id = strings[2];//获得学生身份证号
        String school = strings[3];

        Applicant ap = new Applicant(name, id, school);//创建一个学生对象

        ApplicantDao dao = new ApplicantDao();
        int i = dao.insert(ap);
        if (i == 1) {
            return "录入成功";
        } else {
            return "录入失败";
        }
    }

    public static String delete(String[] strings) {
        String id = strings[1];//获得学生身份证号
        System.out.println(id);
        ApplicantDao dao = new ApplicantDao();
        if (dao.delete(id) != 0) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    public static String update(String[] strings) {
        // url = "3" + "/n" + id + "/n" + name + "/n" + school + "/n" + process;
        String id = strings[1];//获得学生身份证号
        String name = strings[2];
        String school = strings[3];
        int process = Integer.parseInt(strings[4]);

        //创建一个ap对象
        Applicant ap = new Applicant(name, id, school);
        ap.setProcess(process);
        ApplicantDao dao = new ApplicantDao();
        if (dao.update(ap) == 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    /**
     * 查询
     */
    public static String select(String[] strings) {
        //url = "2" + "/n" + choice + "/n" + id;
//        System.out.println("根据身份证查询请输入1");
//        System.out.println("根据姓名查询请输入2");
//        System.out.println("根据学校查询请输入3");
//        System.out.println("根据状态查询请输入4");
        int choice = Integer.parseInt(strings[1]);
        String parameter = strings[2];
        ApplicantDao dao = new ApplicantDao();
        ArrayList<Applicant> list = null;
        if (choice == 1) {
            list = dao.queryId(parameter);
        } else if (choice == 2) {
            list = dao.queryName(parameter);
        } else if (choice == 3) {
            list = dao.querySchool(parameter);
        } else if (choice == 4) {
            list = dao.queryProcess(Integer.parseInt(parameter));
        }

        Iterator<Applicant> iterator=list.iterator();
        while (iterator.hasNext()) {
            Applicant app=iterator.next();
            if(app.getDeleteStatus()==0){
                iterator.remove();
            }
        }
        if (list == null || list.size() == 0) {
            return "查无此人";
        } else {
            String message = "";
            for (Applicant app : list) {
                if (app.getDeleteStatus() != 0) {
                    message += "姓名：" + app.getName() + "  " +
                            "ID：" + app.getId() + "  " +
                            "学校：" + app.getSchool() + "  " +
                            "状态：" + app.getProcess()+"/n"
                    ;
                }
            }
            return message;

        }

    }
}
