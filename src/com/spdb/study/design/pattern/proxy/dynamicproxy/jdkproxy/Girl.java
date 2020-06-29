package com.spdb.study.design.pattern.proxy.dynamicproxy.jdkproxy;

import com.spdb.study.design.pattern.proxy.staticproxy.Person;

/**
 *
 * @author Mr.Longyx
 * @date 2020年06月26日 21:30
 */
public class Girl implements Person {

    @Override
    public void findLove() {
        System.out.println("要求：舒服 帅");
        System.out.println("身高165cm及以上");
        System.out.println("有8块腹肌");
    }
}
