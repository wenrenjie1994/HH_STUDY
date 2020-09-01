package com.spdb.study.design.pattern.visitor.kpi;

import java.util.Random;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 22:09
 */
public class Engineer extends Employee {
    public Engineer(String name) {
        super(name);
    }

    @Override
    public void accecpt(Visitor visitor) {
        /**
         * 通过this实现伪动态双分派
         * @author Mr.Longyx
         * @date 2020/7/12 22:52
         * @param visitor
         */
        visitor.visit(this);
    }

    /**
     * 工程师每年考核指标：代码量
     * @author Mr.Longyx
     * @date 2020/7/12 22:15
     * @return int
     */
    public int getCodeLines(){
        return new Random().nextInt(10 * 10000);
    }
}
