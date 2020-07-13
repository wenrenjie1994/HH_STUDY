package com.spdb.study.design.pattern.visitor.kpi;

import java.util.Random;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 22:02
 */
public abstract class Employee {
    public String name;
    /**
     * 员工kpi
     * @author Mr.Longyx
     * @date 2020/7/12 22:03
     */
    public int kpi;

    public Employee(String name) {
        this.name = name;
        kpi = new Random().nextInt(10);
    }

    /**
     * 提供一个接收访问者访问的方法
     * @author Mr.Longyx
     * @date 2020/7/12 22:05
     */
    public abstract void accecpt(Visitor visitor);
}
