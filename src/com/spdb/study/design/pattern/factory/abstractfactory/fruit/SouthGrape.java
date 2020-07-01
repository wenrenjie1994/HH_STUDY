package com.spdb.study.design.pattern.factory.abstractfactory.fruit;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 18:57
 */

public class SouthGrape extends Grape {
    @Override
    public void collect() {
        System.out.println("采集南方葡萄");
    }
}
