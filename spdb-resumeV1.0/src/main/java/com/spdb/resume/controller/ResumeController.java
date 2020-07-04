package com.spdb.resume.controller;

import com.spdb.resume.common.ServerResponse;
import com.spdb.resume.pojo.Resume;
import com.spdb.resume.service.IResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: A wei
 * @Date: 2020/7/4 14:41
 * @Last Modified by:
 * @last Modified date:
 * @Description: resume controller层，根据页面请求来做简历服务
 */
@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private IResumeService iResumeService;

    @RequestMapping(value = "/create_resume",method = RequestMethod.POST)
    public ServerResponse<String> createResume(Resume resume){

        return iResumeService.createResume(resume);


    }

}
