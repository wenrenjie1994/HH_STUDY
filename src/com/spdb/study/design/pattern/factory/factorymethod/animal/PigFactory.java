package com.spdb.study.design.pattern.factory.factorymethod.animal;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 16:22
 */
public class PigFactory implements AnimalFactory {
    @Override
    public CollectAnimal collectAnimal() {
        return new Pig();
    }
}
