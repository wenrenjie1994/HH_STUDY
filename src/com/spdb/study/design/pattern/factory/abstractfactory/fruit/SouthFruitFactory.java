package com.spdb.study.design.pattern.factory.abstractfactory.fruit;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 19:00
 */
public class SouthFruitFactory implements FruitFactory{
    @Override
    public CollectFruit collectApple() {
        return new SouthApple();
    }

    @Override
    public CollectFruit collectBanana() {
        return new SouthBanana();
    }

    @Override
    public CollectFruit collectGrape() {
        return new SouthGrape();
    }
}
