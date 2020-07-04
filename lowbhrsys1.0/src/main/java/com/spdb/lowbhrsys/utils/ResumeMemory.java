package com.spdb.lowbhrsys.utils;

import com.spdb.lowbhrsys.bean.ResumeBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: libobo
 * @create: 2020-07-03 15:09
 * @description:
 **/
public class ResumeMemory {
    public static List<ResumeBean> list=new ArrayList<>();
    /**
     * 初始给10个简历放入容器,基于文件不需要有初始内容
     */
//    static{
//        for (int i = 0; i <10 ; i++) {
//            int resumeId=i;
//            String name= "张"+i;
//            String id="51"+i+"654199"+i+"042"+i+"192"+i;
//            String sex=(i/2==0?"女":"男");
//            String school="川农";
//            String email="14"+i+"@qq.com";
//            String phone="1335215458"+i;
//            int status=new Random().nextInt(8);
//            ResumeBean resume=new ResumeBean(name,id,sex,school,email,phone);
//            resume.setResumeId(resumeId);
//            resume.setStatus(status);
//            list.add(resume);
//        }
//    }
}
