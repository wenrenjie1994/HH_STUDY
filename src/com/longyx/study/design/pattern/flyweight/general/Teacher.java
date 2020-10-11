package com.longyx.study.design.pattern.flyweight.general;

/**
 * @author Mr.Longyx
 * @date 2020年07月05日 23:08
 */
public class Teacher implements Person {
    private String num;

    public Teacher() {

    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public void dailyTask(String task) {
        System.out.println("发放预习资料 --> 制作上课ppt课件 --> 在线授课 --> 布置作业");
        System.out.println("Object address: "+System.identityHashCode(this));
    }
}
