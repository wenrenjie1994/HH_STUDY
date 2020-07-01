package com.spdb.study.design.pattern.factory.factorymethod.animal;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 16:17
 */
public class Dog implements CollectAnimal {
    @Override
    public void collect() {
        System.out.println("市场上采购狗狗");
    }
}
