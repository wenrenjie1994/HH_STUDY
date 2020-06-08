package com.example.demo.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * @Author: A wei
 * @Date: 2020/6/7 9:51
 * @Last Modified by:
 * @last Modified date:
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repository
public @interface FirstLevelRepository {

     String value() default "";
}
