package com.lihang.dynamicdatasource2.annotation;

import java.lang.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: LI
 * Date: 2020/5/21
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyDataSource {
    String name() default "";
}
