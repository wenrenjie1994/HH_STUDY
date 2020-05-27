package com.lihang.annotation.myannotation;

import java.lang.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: LI
 * Date: 2020/5/23
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {
    public String name();
    int age() default 18;
    int[] array();
}
