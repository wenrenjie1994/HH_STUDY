package com.spdb.study.design.pattern.factory.factorymethod.animal;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 16:15
 */
public class Fish implements CollectAnimal {
    @Override
    public void collect() {
        System.out.println("市场上采购鱼");
    }
}
