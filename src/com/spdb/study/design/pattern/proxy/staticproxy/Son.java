package com.spdb.study.design.pattern.proxy.staticproxy;

/**
 * @author Mr.Longyx
 * @date 2020年06月26日 20:20
 */
public class Son implements Person{
    @Override
    public void findLove(){
        System.out.println("儿子要求：肤白貌美大长腿");
    }
}
