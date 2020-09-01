package com.sp.lowbhrsys.controller;

import com.sp.lowbhrsys.utils.ResponseData;
import com.sp.lowbhrsys.bean.ResumeBean;
import com.sp.lowbhrsys.service.IResumeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: libobo
 * @create: 2020-07-22 20:02
 * @description: 处理来自于客户端的请求
 **/

@RestController
public class ResumeController {
    @Resource(name = "resumeDBService")
    private IResumeService resumeService;

    @PostMapping("/addResume")
    private ResponseData addResume(ResumeBean resume){
        return resumeService.addResume(resume);
    }
    @RequestMapping("/delResume")
    private ResponseData delResume(Integer resumeId){
        return resumeService.deleteResume(resumeId);
    }
    @RequestMapping("/updateResume")
    private ResponseData updateResume(Integer resumeId,String name,String email,String phone){
        return resumeService.updateResume(resumeId,name,email,phone);
    }
    @RequestMapping("/findResume")
    private ResponseData findResume(Integer resumeId){
        return resumeService.findResumeByResumeId(resumeId);
    }
    @RequestMapping("/findAllResume")
    private ResponseData findAllResume(){
        return resumeService.findAllResume();
    }

}
