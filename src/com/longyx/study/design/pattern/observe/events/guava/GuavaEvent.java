package com.spdb.study.design.pattern.observe.events.guava;

import com.google.common.eventbus.Subscribe;

/**
 * Guava是轻松落地观察者模式的一种解决方案
 * @author Mr.Longyx
 * @date 2020年07月03日 19:35
 */
public class GuavaEvent {

    @Subscribe
    public void subscribe(String str){
        System.out.println("执行subscribe方法，传入参数："+str);
    }
}
