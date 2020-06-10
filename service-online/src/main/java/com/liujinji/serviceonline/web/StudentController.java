package com.liujinji.serviceonline.web;

import com.liujinji.serviceonline.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Slf4j
@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @RequestMapping
    public String processStudent(@Valid Student student, Errors errors){
        if (errors.hasErrors()){
            log.warn("校验错误");
            return "/home";
        }
        log.info(student.toString());
        return "/home";
    }
}
