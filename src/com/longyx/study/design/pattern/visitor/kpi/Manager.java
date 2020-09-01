package com.spdb.study.design.pattern.visitor.kpi;

import java.util.Random;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 22:10
 */
public class Manager extends Employee {
    public Manager(String name) {
        super(name);
    }

    @Override
    public void accecpt(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * 考核的指标是每年新产品的研发量
     * @author Mr.Longyx
     * @date 2020/7/12 22:16
     * @return int
     */
    public int getProducts(){
        return new Random().nextInt(10);
    }
}
