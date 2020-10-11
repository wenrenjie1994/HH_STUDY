package com.longyx.study.design.pattern.memento.general;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 8:34
 */
public class Test {
    public static void main(String[] args) {
        /**
         * 发起人
         * @author Mr.Longyx
         * @date 2020/7/12 8:36
         */
        Originator  originator = new Originator();
        /**
         * 备忘录管理员
         * @author Mr.Longyx
         * @date  8:37
         */
        CareTaker careTaker = new CareTaker();
        /**
         * 管理员存储发起人的备忘录
         * @author Mr.Longyx
         * @date 2020/7/12 8:38
         */
        careTaker.storeMemento(originator.createMemento());
        /**
         * 发起人从管理员处获取备忘录进行回滚
         * @author Mr.Longyx
         * @date 2020/7/12 8:38
         */
        originator.restoreMemento(careTaker.getMemento());
    }
}
