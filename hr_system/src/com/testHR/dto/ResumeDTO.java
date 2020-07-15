package com.testHR.dto;

import com.testHR.model.Resume;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: zeng
 * @modified By:
 */
public class ResumeDTO {

    private List<Resume> list = new ArrayList<>();


    public void setResumes(List<Resume> list) {
        this.list = list;
    }

    public void showAllList() {
        System.out.println("----------------您的查询结果为：----------------");
        if (list != null && list.size() != 0) {//不为空且有内容
            for (Resume resume : list) {
                System.out.println(resume);
            }
        } else {
            System.out.println("没有查询信息");
        }
        System.out.println("-------------------------------------------------");
        System.out.println();
    }

    public void showSomeList() {
        System.out.println("----------------您的查询结果为：----------------");
        if (list != null && list.size() != 0) {
            for (Resume resume : list) {
                System.out.println("Resume{" +
                        "name='" + resume.getName() + '\'' +
                        ", id=" + resume.getId() +
                        ", school='" + resume.getSchool() + '\'' +
                        ", process=" + resume.getProcess() +
                        '}');
            }
        } else {
            System.out.println("没有查询信息");
        }
        System.out.println("-------------------------------------------------");
        System.out.println();
    }
}
