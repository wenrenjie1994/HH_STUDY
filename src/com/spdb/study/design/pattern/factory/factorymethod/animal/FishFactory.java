package com.spdb.study.design.pattern.factory.factorymethod.animal;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 16:18
 */
public class FishFactory implements AnimalFactory {

    @Override
    public CollectAnimal collectAnimal() {
        return new Fish();
    }
}
