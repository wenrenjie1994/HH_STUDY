package com.example.hr_sys_demo_browserserver.controller;

import com.example.hr_sys_demo_browserserver.pojo.Resume;
import com.example.hr_sys_demo_browserserver.service.ResumeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ResumeController {
    @Autowired ResumeService resumeService;

    /*restful 部分*/
    @RequestMapping("/resumes")
    public PageInfo<Resume> list(@RequestParam(value = "start", defaultValue = "1") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start, size, "id asc");
        List<Resume> rs = resumeService.list();
        System.out.println(rs.size());

        PageInfo<Resume> page = new PageInfo<>(rs,5); //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样

        return page;
    }

    /*页面跳转 部分*/
    @RequestMapping(value="/home", method= RequestMethod.GET)
    public ModelAndView listResume(){
        ModelAndView mv = new ModelAndView("home");
        return mv;
    }
}
