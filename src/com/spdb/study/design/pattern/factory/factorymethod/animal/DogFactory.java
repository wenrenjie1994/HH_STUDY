package com.spdb.study.design.pattern.factory.factorymethod.animal;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 16:21
 */
public class DogFactory implements AnimalFactory {
    @Override
    public CollectAnimal collectAnimal() {
        return new Dog();
    }
}
