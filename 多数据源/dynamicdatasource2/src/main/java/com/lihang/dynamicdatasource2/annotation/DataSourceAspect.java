package com.lihang.dynamicdatasource2.annotation;

import com.lihang.dynamicdatasource2.config.DynamicDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 * User: LI
 * Date: 2020/5/21
 */
@Aspect
@Component
public class DataSourceAspect implements Ordered {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Pointcut("@annotation(com.lihang.dynamicdatasource2.annotation.MyDataSource)")
    public void dataSourcePointCut(){}

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point){
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        MyDataSource dataSource = method.getAnnotation(MyDataSource.class);
        if (dataSource == null){
            DynamicDataSource.setDataSource("one");
        }else {
            DynamicDataSource.setDataSource(dataSource.name());
        }

        try {
            return point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            DynamicDataSource.clearDataSource();
        }
        return null;
    }
    @Override
    public int getOrder() {
        return 1;
    }
}
