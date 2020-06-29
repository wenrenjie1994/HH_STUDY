package com.spdb.study.design.pattern.factory.factorymethod.animal;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 16:25
 */
public class AnimalFactoryTest {
    public static void main(String[] args) {
        /**
         * 获取 DogFactory实例 和 FishFactory实例
         * @author Mr.Longyx
         * @date 2020/6/21 16:28
         */
        AnimalFactory factory = new DogFactory();
        AnimalFactory factory1 = new FishFactory();

        /**
         * 通过DogFactory获取Dog实例对象
         * 通过FishFactory获取fish实例对象
         * @author Mr.Longyx
         * @date 2020/6/21 16:29
         */
        CollectAnimal dog = factory.collectAnimal();
        CollectAnimal fish = factory1.collectAnimal();

        dog.collect();
        fish.collect();

    }
}
