package demo01.sub;

import demo01.MyClass;

public class Stranger {
    public void method(){
        //不同包非子类，只能访问修饰符为public变量
        System.out.println(new MyClass().num3);
    }
}
