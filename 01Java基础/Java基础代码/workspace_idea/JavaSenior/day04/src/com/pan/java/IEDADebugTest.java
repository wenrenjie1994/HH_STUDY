package com.pan.java;

import org.junit.Test;

/**
 * @author zhaopan@163.com
 * @creat 2020-04-18 9:14
 */
public class IEDADebugTest {

    @Test
            public void test(){

        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length());//4

        System.out.println(sb);//"null"

        StringBuffer sb1 = new StringBuffer(str);//抛异常
        System.out.println(sb1);//
    }

}
