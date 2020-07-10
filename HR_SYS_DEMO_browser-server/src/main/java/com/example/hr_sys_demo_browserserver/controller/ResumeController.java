package com.example.hr_sys_demo_browserserver.controller;

import com.example.hr_sys_demo_browserserver.pojo.Resume;
import com.example.hr_sys_demo_browserserver.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResumeController {
    @Autowired ResumeService resumeService;

    @RequestMapping("/home/get")
    public String login(Model model
    ){
        return resumeService.get(2).getSchool();
    }
}
