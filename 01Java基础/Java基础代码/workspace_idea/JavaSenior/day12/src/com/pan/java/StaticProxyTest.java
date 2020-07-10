package com.pan.java;

/**静态代理举例
 *特点：代理类和被代理类在编译期间就确定下来了
 * @author zhaopan@163.com
 * @creat 2020-04-29 9:24
 */
interface ClothFactory{
    void produceCloth();
}

//提供代理类
class ProxyClothFactory implements ClothFactory{
    //声明属性
    private ClothFactory factory;//拿被代理对象进行实例化
    //提供当前类的构造器
    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }
    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续的收尾工作");
    }
}

//提供具体的被代理类
class NikeFactory implements ClothFactory{
    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代理类的对象
        NikeFactory nike = new NikeFactory();
        //创建代理类对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);
        //通过代理类的对象对调用produceCloth()
        proxyClothFactory.produceCloth();
    }
}
