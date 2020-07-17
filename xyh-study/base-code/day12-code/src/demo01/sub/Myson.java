package demo01.sub;

import demo01.MyClass;

public class Myson extends MyClass {
    public void methodSon(){
        System.out.println(super.num1);
        System.out.println(super.num3);
        //System.out.println(super.num);不能访问
        //System.out.println(super.num2);不能访问
    }
}
