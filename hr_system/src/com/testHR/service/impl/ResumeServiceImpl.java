package com.testHR.service.impl;

import com.testHR.dao.ResumeDao;
import com.testHR.dao.impl.ResumeDaoImpl;
import com.testHR.dto.ResumeDTO;
import com.testHR.model.Resume;
import com.testHR.service.ResumeService;
import com.testHR.utils.TransctionUtils;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @description:
 * @author: zeng
 * @modified By:
 */
public class ResumeServiceImpl implements ResumeService {
    ResumeDao resumeDao = new ResumeDaoImpl();

    @Override
    public void addResume() {
        try {
            TransctionUtils.startTransction();
            System.out.println("您已进入简历添加模式");
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入简历人的姓名,以回车结束");
            String name = sc.nextLine();
            System.out.println("请输入简历人的id,以回车结束");
            Integer id = Integer.parseInt(sc.nextLine());
            System.out.println("请输入简历人的学校,以回车结束");
            String school = sc.nextLine();
            Resume resume = new Resume(name, id, school);
            int i = resumeDao.insert(resume);
            if (i > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
            System.out.println();
            TransctionUtils.commit();
        } catch (Exception e) {
            try {
                TransctionUtils.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteResume() {
        try {
            TransctionUtils.startTransction();
            System.out.println("您已进入简历删除模式");
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入要删除简历人的id，以回车结束");
            Integer inputId = Integer.parseInt(sc.nextLine());
            Resume resume = resumeDao.queryById(inputId);
            if(resume == null){
                System.out.println("该简历人不存在");
                System.out.println();
                return;
            }
            System.out.println("请选择您的删除模式：0->简历拉黑;1->删除数据");
            int input = sc.nextInt();
            if (input == 0) {
                int update = resumeDao.updateDeleteStatus(inputId);
                if (update > 0) {
                    System.out.println("操作成功");
                } else {
                    System.out.println("操作失败");
                }
                System.out.println();
            } else if (input == 1) {
                int delete = resumeDao.delete(inputId);
                if (delete > 0) {
                    System.out.println("操作成功");
                } else {
                    System.out.println("操作失败");
                }
                System.out.println();
            } else {
                System.out.println("您的选择有误。");
                System.out.println();
            }
            TransctionUtils.commit();
        } catch (Exception e) {
            try {
                TransctionUtils.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void updateResume() {
        try {
            TransctionUtils.startTransction();
            System.out.println("-------您已进入简历修改模式-------");
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入要修改简历人的id，以回车结束");
            Integer inputId = Integer.parseInt(sc.nextLine());
            Resume resume = resumeDao.queryById(inputId);
            if(resume == null){
                System.out.println("该简历人不存在");
                System.out.println();
                return;
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
                    int update = resumeDao.update(resume, inputId);
                    if (update > 0){
                        System.out.println("修改成功");
                        System.out.println();
                    }else{
                        System.out.println("修改失败");
                        System.out.println();
                    }
                    break;//退出循环
                }
            }
            TransctionUtils.commit();
        } catch (Exception e) {
            try {
                TransctionUtils.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void queryResume() {
        try {
            TransctionUtils.startTransction();
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
                    resumeDTO.setResumes(resumeDao.queryAll());
                    resumeDTO.showAllList();
                    break;//直接跳出switch
                case 2:
                    ResumeDTO resumeDTO2 = new ResumeDTO();
                    resumeDTO2.setResumes(resumeDao.queryEffList());
                    resumeDTO2.showSomeList();
                    break;//直接跳出switch
                case 3:
                    ResumeDTO resumeDTO3 = new ResumeDTO();
                    resumeDTO3.setResumes(resumeDao.queryBlackList());
                    resumeDTO3.showSomeList();
                    break;
                case 4:
                    System.out.println("请输入您要查询的姓名，以回车结束");
                    String name = sc.nextLine();
                    ResumeDTO resumeDTO4 = new ResumeDTO();
                    resumeDTO4.setResumes(resumeDao.queryByName(name));
                    resumeDTO4.showSomeList();
                    break;
                case 5:
                    System.out.println("请输入您要查询的id，以回车结束");
                    Integer inputId = Integer.parseInt(sc.nextLine());
                    Resume resume = resumeDao.queryById(inputId);
                    if(resume != null){
                        System.out.println("----------------您的查询结果为：----------------");
                        resume.show();
                    } else {
                        System.out.println("没有查询信息");
                    }
                    System.out.println("-------------------------------------------------");
                    System.out.println();
                    break;
                case 6:
                    System.out.println("请输入您要查询的学校，以回车结束");
                    String school = sc.nextLine();
                    ResumeDTO resumeDTO6 = new ResumeDTO();
                    resumeDTO6.setResumes(resumeDao.queryBySchool(school));
                    resumeDTO6.showSomeList();
                    break;
                case 7:
                    System.out.println("请输入您要查询的状态，以回车结束");
                    Integer process = Integer.parseInt(sc.nextLine());
                    ResumeDTO resumeDTO7 = new ResumeDTO();
                    resumeDTO7.setResumes(resumeDao.queryByProcess(process));
                    resumeDTO7.showSomeList();
                    break;
                default:
                    System.out.println("您的选择有误，查询失败！");
            }
            TransctionUtils.commit();
        } catch (Exception e) {
            try {
                TransctionUtils.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
