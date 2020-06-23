package com.spdb.study.reflect.dom4j;

import com.spdb.study.reflect.BaseMethod;
import com.spdb.study.reflect.TestCase;

/**
 * @author Mr.Longyx
 * @date 2020年06月22日 1:09
 */
public class TestApplicationContext {
    public static void main(String[] args){
        XmlApplicationContext applicationContext = new XmlApplicationContext("main/resources/spring-context.xml");
        BaseMethod baseMethod = (BaseMethod)applicationContext.getBean("baseMethod");
        TestCase testCase = applicationContext.getBean("testCase", TestCase.class);

        System.out.println(baseMethod);
        System.out.println(testCase);
    }
}
