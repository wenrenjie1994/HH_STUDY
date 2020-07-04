package com.spdb.resume;

import com.spdb.resume.pojo.Resume;
import com.spdb.resume.service.IResumeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;


import java.util.Date;

@Rollback(false) //关闭数据回滚
@ComponentScan(basePackages = "com.spdb.resume.service")
@SpringBootTest
//@MybatisTest //默认使用内存数据库
//@AutoConfigureTestDatabase(replace = NONE) //取消默认
class ResumeApplicationTests {

    @Autowired
    private IResumeService iResumeService;
    @Test
    void contextLoads() {
    }

    @Test
    void checkCreateResume(){

        Resume resume1 = new Resume( 1,
                                    "fuaowei",
                                    "420621199506127746",
                                    "scu",
                                    "optical-enginering",
                                    0,
                                    "18512842515",
                                    "Aowei_fu@163.com",
                                    0,
                                    new Date(2020,7,4,18,22,25),
                                    new Date());
        iResumeService.createResume(resume1);

    }

}
