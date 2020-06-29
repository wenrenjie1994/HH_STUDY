package com.spdb.study.design.pattern.factory.simplefactory.fruit;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 14:50
 */
public class FruitFactory {

    /**
     * 获取Apple实例
     * @author Mr.Longyx
     * @date 2020/6/21 14:50
     */
//    public  IFruit collectApple(){
//        return new Apple();
//    }
    /**
     * 获得Banana实例
     * @author Mr.Longyx
     * @date 2020/6/21 14:51
     */
//    public  IFruit collectBanana(){
//        return new Banana();
//    }

    /**
     * 获得具体水果对象
     * @author Mr.Longyx
     * @date 2020/6/21 14:59
     */
    public static IFruit collectFruit(String type){
        if (type.equalsIgnoreCase("apple")) {
            try {
                return Apple.class.newInstance();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }else if(type.equalsIgnoreCase("banana")){
            try {
                return Banana.class.newInstance();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("找不到相应的实例化类");
        }
        return null;
    }

    /**
     * Class 的方式
     * @author Mr.Longyx
     * @date 2020/6/21 15:06
     */
    public static IFruit collectFruit(Class<?> clazz) throws IllegalAccessException, InstantiationException {
        return (IFruit)clazz.newInstance();
    }
}
