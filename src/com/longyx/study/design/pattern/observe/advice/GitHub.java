package com.longyx.study.design.pattern.observe.advice;

import java.util.Observable;

/**
 *  JDK提供的一种观察者的实现方式
 *  被观察者
 * @author Mr.Longyx
 * @date 2020年07月03日 14:12
 */
public class GitHub extends Observable {
    private static GitHub INSTANCE = null;

    private String name = "GitHub 生态圈";

    public String getName() {
        return name;
    }

    private GitHub(){}

    public static GitHub getInstance(){
        if (null == INSTANCE){
            synchronized (GitHub.class) {
                if (null == INSTANCE) {
                    INSTANCE = new GitHub();
                }
            }
        }
        return INSTANCE;
    }

    public void publishIssues(Issues issues){
        System.out.println(issues.getUsername()+"在"+this.name+"Issues上提交了一个问题！");
        setChanged();
        notifyObservers(issues);
    }
}
