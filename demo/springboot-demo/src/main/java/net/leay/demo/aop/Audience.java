package net.leay.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 5/29/20 3:47 PM
 */
@Aspect
public class Audience {
  @Pointcut("execution(* net.leay.demo.aop.Performance.perform(..))")
  public void per() {}

  //表演前 手机静音
  @Before("per()")
  public void silenceCellPhone() {
    System.out.println("silence Cell Phone");
  }
}
