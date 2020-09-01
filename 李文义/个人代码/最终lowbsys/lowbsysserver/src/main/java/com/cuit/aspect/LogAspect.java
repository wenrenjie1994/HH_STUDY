package com.cuit.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author liwenyi
 * @date 2020/7/24
 * desc 引入AOP
 */
@Log4j2
@Aspect
@Component
public class LogAspect {

    /**
     * 功能描述:
     * controller包的切入点
     *
     * @author: liwenyi
     */
    @Pointcut("execution(* com.cuit.controller.*.*(..))")
    public void controllerLog(){}   //签名，可以理解成这个切入点的一个名称

    /**
     * 功能描述:
     * 在所以controller类的所有方法前执行
     *
     * @param joinPoint 1
     * @return: void
     * @author: liwenyi
     */
    @Before("controllerLog()")
    public void beforeMethod(JoinPoint joinPoint){
        StringBuilder sb = new StringBuilder();
        sb.append("method:"+joinPoint.getSignature());
        log.info(sb);
    }
}
