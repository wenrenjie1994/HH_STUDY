package com.lihang.aopstudy.controller;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by IntelliJ IDEA.
 * User: LI
 * Date: 2020/5/22
 */
@RestController
@RequestMapping("/aop")
public class MyController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @GetMapping("/success")
    public void testAopSuccess(){
        logger.info("这是我的主方法");
    }
    @GetMapping("/error")
    public void testAopError(){
        logger.debug("这是我的主异常方法");
        int a = 1/0;
    }


}
