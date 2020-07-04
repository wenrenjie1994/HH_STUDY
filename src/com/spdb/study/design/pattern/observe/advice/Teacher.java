package com.spdb.study.design.pattern.observe.advice;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者(异步通知)
 * 优点：
 * 1、观察者与被观察者之间建立了一种抽象的耦合
 * 2、观察者模式支持广播通信
 * 缺点：
 * 1、观察者之间有过多的细节依赖，提高时间消耗及程序的复杂度
 * 2、使用不当会造成循环调用
 * @author Mr.Longyx
 * @date 2020年07月03日 14:24
 */
public class Teacher implements Observer {
    private String name;
    
    public Teacher(String name){
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        GitHub github = (GitHub)o;
        Issues issues = (Issues)arg;
        System.out.println("================================");
        System.out.println(name + "，你好！\n"+"您收到了一个来自“"+github.getName()+"”的提问，希望能得到您的解答，问题内容如下：\n"+issues.getContent()+"\n"+"提问者："+issues.getUsername());
    }
}
