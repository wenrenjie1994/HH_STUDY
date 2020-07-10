package com.lihang;

import com.lihang.pojo.Resume;
import com.lihang.service.ResumeService;
import com.lihang.service.impl.ResumeServiceImpl;
import com.lihang.util.DbUtils;
import com.lihang.util.MyDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ResumeService resumeService = new ResumeServiceImpl();
    /*    Resume resume = new Resume("lihang", "23432", "太原理工", 0, 0);
        resumeService.addResume(resume);*/
        System.out.println(resumeService.getResumeById("23432").toString());
    }
}
