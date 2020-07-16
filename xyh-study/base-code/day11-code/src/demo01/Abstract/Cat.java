package demo01.Abstract;

import java.security.PublicKey;

/*子类必须覆盖重写抽象方法的abstract关键字*/
public class Cat extends Animal{

    public Cat(){
        System.out.println("我是猫");
    }
    @Override
    public  void  eat(){
        System.out.println("猫吃鱼");
    }
}
