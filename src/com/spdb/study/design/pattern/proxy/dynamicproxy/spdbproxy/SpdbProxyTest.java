package com.spdb.study.design.pattern.proxy.dynamicproxy.spdbproxy;

import com.spdb.study.design.pattern.proxy.dynamicproxy.jdkproxy.Girl;
import com.spdb.study.design.pattern.proxy.staticproxy.Person;

/**
 * @author Mr.Longyx
 * @date 2020年06月26日 22:20
 */
public class SpdbProxyTest {
    public static void main(String[] args) {
        Person person = (Person) new SpdbMatchMaker().getInstance(new Girl());

        person.findLove();
    }
}
