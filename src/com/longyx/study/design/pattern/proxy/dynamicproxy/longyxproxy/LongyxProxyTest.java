package com.longyx.study.design.pattern.proxy.dynamicproxy.longyxproxy;

import com.longyx.study.design.pattern.proxy.dynamicproxy.jdkproxy.Girl;
import com.longyx.study.design.pattern.proxy.staticproxy.Person;

/**
 * @author Mr.Longyx
 * @date 2020年06月26日 22:20
 */
public class LongyxProxyTest {
    public static void main(String[] args) {
        Person person = (Person) new LongyxMatchMaker().getInstance(new Girl());

        person.findLove();
    }
}
