package com.testHR.service.impl;

import com.testHR.dao.ResumeDao;
import com.testHR.dao.impl.ResumeDaoImpl;
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
            Resume resume = new Resume(name,id,school);
            int i = resumeDao.insert(resume);
            if(i>0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
            TransctionUtils.commit();
        } catch (SQLException e) {
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

    }

    @Override
    public void updateResume() {

    }

    @Override
    public void searchResume() {

    }
}
