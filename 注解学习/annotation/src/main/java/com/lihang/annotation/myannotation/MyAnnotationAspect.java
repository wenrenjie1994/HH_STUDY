package com.lihang.annotation.myannotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import sun.reflect.annotation.AnnotationParser;

import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 * User: LI
 * Date: 2020/5/23
 */
@Aspect
@Component
public class MyAnnotationAspect {//aop实现注解功能
    @Pointcut("@annotation(com.lihang.annotation.myannotation.MyAnnotation)")
    public void pointcut(){}

    @Around("pointcut()")
    public void dealAnnotation(ProceedingJoinPoint point){
       MethodSignature methodSignature = (MethodSignature) point.getSignature();
       Method method = methodSignature.getMethod();
       MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
        System.out.println("name:"+myAnnotation.name());
    }
}
