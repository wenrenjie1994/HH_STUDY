package com.spdb.resume;

import com.spdb.resume.common.ServerResponse;
import com.spdb.resume.pojo.Resume;
import com.spdb.resume.service.IResumeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import java.sql.Timestamp;

@Rollback(false) //关闭数据回滚
@ComponentScan(basePackages = "com.spdb.resume.service")
@SpringBootTest
class ResumeApplicationTests {

    @Autowired
    private IResumeService iResumeService;

    private Resume resume =  new Resume( 1,
                                        "fuaowei",
                                        "420621199506127746",
                                        "scu",
                                        "optical-enginering",
                                        0,
                                        "18512842515",
                                        "Aowei_fu@163.com",
                                        0,
                                        new Timestamp(20200704),
                                        new Timestamp(20200704));
    @Test
    void contextLoads() {
    }

    @Test
    void checkCreateResume(){
        ServerResponse response = iResumeService.createResume(resume);
        if (response.isSuccess()){
            System.out.println("建立插入成功！");
        }else{
            System.out.println(response.getMessage());
        }

    }

    @Test
    void checkDeleteResume(){
        ServerResponse response = iResumeService.deleteResume(resume);
        if (response.isSuccess()){
            System.out.println("简历删除成功");
        }else{
            System.out.println(response.getMessage());
        }
    }

    @Test
    void checkUpdateResume(){
        ServerResponse response = iResumeService.updateResume(resume);
        if (response.isSuccess()){
            System.out.println("简历更新成功");
        }else{
            System.out.println(response.getMessage());
        }
    }

    @Test
    void checkInquireResume(){
        ServerResponse response = iResumeService.inquireResume(resume.getId());
        if (response.isSuccess()){
            System.out.println("简历查询成功！");
        }else{
            System.out.println(response.getMessage());
        }
    }

}
