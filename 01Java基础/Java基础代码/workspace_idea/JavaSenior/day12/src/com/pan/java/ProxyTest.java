package com.pan.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**动态代理的举例
 * @author zhaopan@163.com
 * @creat 2020-04-29 9:37
 */

interface Human{
    String getBelief();
    void eat(String food);
}
//被代理类
class SuperMan implements Human{
    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }
    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+ food);
    }
}
/*
要想实现动态代理需要解决的问题？
问题一：如何根据加载到内存中的被代理类，动态创建一个代理类及其对象？
问题二：当通过代理类的对象调用方法时，如何动态调用被代理类中的同名方法？
 */

//代理类
class ProxyFactory{
    //调用此方法返回一个代理类的对象，解决问题一
    public static Object getProxyInstance(Object obj){//obj:被代理类对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}
class MyInvocationHandler implements InvocationHandler{
    //声明一个被代理类的对象
    private Object obj;//需要使用被代理类的对象进行赋值
    //如何赋值？构造器赋值/方法赋值
    public void bind (Object obj){
        this.obj = obj;
    }
    //当通过代理类的对象调用方法a时，就会自动调用如下方法：invoke()
   //将被代理类要执行的方法a的功能，声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method():即为代理类对象调用的方法，此方法也就作为了被代理对象要调用的方法
        //obj:被代理类的对象
        Object returnValue = method.invoke(obj, args);
        //上述方法的返回值就作为当前类中invoke()的返回值
        return returnValue;
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        //1.创建被代理类的对象
        SuperMan superMan = new SuperMan();
        //2.创建代理类的对象:proxyInstance
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);//传递被代理类的对象
        //3.通过代理类的对象动态调用被代理类的方法
        //当通过代理类的对象调用方法时，会自动调用被代理类中同名的方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("四川麻辣烫");

        System.out.println("*****************");

        NikeFactory nikeFactory = new NikeFactory();
        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeFactory);
        proxyClothFactory.produceCloth();
    }
}
