package com.lihang.aopstudy.aop;


import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * Created by IntelliJ IDEA.
 * User: LI
 * Date: 2020/5/22*/


@Aspect
@Component

public class MyAspect2 {
    @Pointcut("execution(* com.lihang.aopstudy.controller.MyController.testAopSuccess(..))")
    public void myPointCut(){}
    @Before("myPointCut()")
    public void before(){
        System.out.println("方法执行:before2");
    }
    @After("myPointCut()")
    public void after(){
        System.out.println("方法执行：after2");
    }
   @AfterThrowing("myPointCut()")
    public void afterThrowing(){
        System.out.println("方法执行：afterThrowing2");
    }
   @Around("myPointCut()")
    public void around(){
        System.out.println("方法执行：around");
    }

     @AfterReturning("myPointCut()")
    public void afterReturning(){
        System.out.println("方法执行：afterReturning2");
    }
/*
@Before("execution(* com.lihang.aopstudy.controller.MyController.testAopSuccess(..))")
    public void before2(JoinPoint joinPoint){

       ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println("requestUrl:"+request.getRequestURI());
        System.out.println("requestMethod:"+request.getMethod());
        System.out.println("IP:"+request.getRemoteAddr());
        System.out.println("class_method:"+joinPoint.getSignature().getDeclaringTypeName()+"."
                                     +joinPoint.getSignature().getName());
        //System.out.println("args:"+ Arrays.toString(joinPoint.getArgs()));
    }
*/


    @AfterThrowing("execution(* com.lihang.aopstudy.controller.MyController.testAopError(..))")
    public void testAfterThrowing(){
        System.out.println("执行错误后执行");
    }

}
