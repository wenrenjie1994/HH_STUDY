package com.spdb.study.design.pattern.factory.simplefactory.fruit;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 14:45
 */
public class FruitFactoryTest {
    /**
     * 引入简单工厂之前(每次都new 实现类)
     * @author Mr.Longyx
     * @date 2020/6/21 14:45
     */
//    public static void main(String[] args) {
//        IFruit fruit = new Apple();
//        fruit.collectFruit();
//    }
    /**
     * version:1.0
     * 初步引入简单工厂
     * @author Mr.Longyx
     * @date 2020/6/21 14:49
     * @param args
     */
//    public static void main(String[] args) {
//        FruitFactory factory = new FruitFactory();
//        IFruit apple = factory.collectApple();
//        apple.collectFruit();
//
//    }

    /**
     * version:v2.0
     * @author Mr.Longyx
     * @date 2020/6/21 15:08
     */
//    public static void main(String[] args) {
//        IFruit apple = FruitFactory.collectFruit("apple");
//        IFruit banana = FruitFactory.collectFruit("banana");
//        apple.collect();
//        banana.collect();
//    }

    /**
     * version:3.0
     * @author Mr.Longyx
     * @date 2020/6/21 15:13
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        IFruit apple = FruitFactory.collectFruit(Apple.class);
        IFruit banana = FruitFactory.collectFruit(Banana.class);
        apple.collect();
        banana.collect();
    }
}
