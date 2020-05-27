package com.lihang.aopstudy.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: LI
 * Date: 2020/5/23
 */
@Aspect
@Component
public class TestPointCutAspect {
    @Pointcut("args(Integer)&&within(com.lihang.aopstudy.service.*)&&@within(org.springframework.stereotype.Service)")
    public void pointCut(){ }

    @Before("pointCut()")
    public void before(){
        System.out.println("执行方法：before");
    }
}
