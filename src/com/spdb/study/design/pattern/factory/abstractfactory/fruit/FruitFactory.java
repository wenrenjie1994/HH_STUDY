package com.spdb.study.design.pattern.factory.abstractfactory.fruit;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 18:49
 */
public interface FruitFactory {
    /**
     * 采集苹果
     * @author Mr.Longyx
     * @date 2020/6/21 18:49
     */
    CollectFruit collectApple();
    /**
     * 采集香蕉
     * @author Mr.Longyx
     * @date 2020/6/21 18:50
     */
    CollectFruit collectBanana();
    /**
     * 采集葡萄
     * @author Mr.Longyx
     * @date 2020/6/21 18:50
     */
    CollectFruit collectGrape();
}
