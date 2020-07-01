package com.spdb.study.design.pattern.factory.simplefactory.fruit;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 14:45
 */
public class Banana implements IFruit {
    @Override
    public void collect() {
        System.out.println("采集香蕉");
    }
}
