package com.lihang.aopstudy.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * Created by IntelliJ IDEA.
 * User: LI
 * Date: 2020/5/22
 */
@Aspect
@Component
@Order(2)
public class MyAspect {
    @Pointcut("execution(* com.lihang.aopstudy.controller.MyController.testAopSuccess(..))")
    public void myPointCut(){}
    @Before("myPointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("方法执行:before1");
    }
    @After("myPointCut()")
    public void after(){
        System.out.println("方法执行：after1");
    }
   @AfterThrowing("myPointCut()")
    public void afterThrowing(){
        System.out.println("方法执行：afterThrowing1");
    }
    @Around("myPointCut()")
    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("方法执行：around1");
        point.proceed();
        System.out.println("方法执行：around2");
    }
     @AfterReturning("myPointCut()")
    public void afterReturning(){
        System.out.println("方法执行：afterReturning1");
    }
        @AfterThrowing("execution(* com.lihang.aopstudy.controller.MyController.testAopError(..))")
    public void testAfterThrowing(){
            System.out.println("执行错误后执行");
    }
    /*@Before("execution(* com.lihang.aopstudy.controller.MyController.testAopSuccess(..))")
    public void before2(JoinPoint joinPoint){

       ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println("requestUrl:"+request.getRequestURI());
        System.out.println("requestMethod:"+request.getMethod());
        System.out.println("IP:"+request.getRemoteAddr());
        System.out.println("class_method:"+joinPoint.getSignature().getDeclaringTypeName()+"."
                                     +joinPoint.getSignature().getName());
        //System.out.println("args:"+ Arrays.toString(joinPoint.getArgs()));
    }*/


}
