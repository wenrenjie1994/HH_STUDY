package com.spdb.study.design.pattern.factory.factorymethod.animal;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 16:16
 */
public class Pig implements CollectAnimal {
    @Override
    public void collect() {
        System.out.println("市场采购小猪");
    }
}
