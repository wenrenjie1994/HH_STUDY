package com.spdb.study.design.pattern.factory.abstractfactory.fruit;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 19:01
 */
public class FruitFactoryTest {
    public static void main(String[] args) {
        FruitFactory factory = new SouthFruitFactory();
        CollectFruit apple = factory.collectApple();
        apple.collect();

        CollectFruit banana = factory.collectBanana();
        banana.collect();

        CollectFruit grape = factory.collectGrape();
        grape.collect();
    }
}
