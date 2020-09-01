package com.spdb.study.design.pattern.mediator.general;

/**
 * 具体的中介处理类
 * @author Mr.Longyx
 * @date 2020年07月12日 12:40
 */
public class ConcreteMeditor extends Meditor {

    @Override
    public void transferA() {
        /**
         * 协调行为：A 转发到B
         * @author Mr.Longyx
         * @date 2020/7/12 12:47
         */
        this.colleagueB.selfMethodB();
    }

    @Override
    public void transferB() {
        /**
         * 协调行为：B 转发到 A
         * @author Mr.Longyx
         * @date 2020/7/12 12:48
         */
        this.colleagueA.selfMethodA();
    }
}
