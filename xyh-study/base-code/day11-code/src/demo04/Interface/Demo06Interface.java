package demo04.Interface;

import jdk.swing.interop.SwingInterOpUtils;

/*
* 使用接口的时候需要注意：
* 1.接口是没有静态代码块或者构造方法的
* 2.一个类的直接父类有且只有一个，但一个类可以同时实现多个接口
*  格式：
* public class MyInterfaceImpl implement InterfaceA,InterfaceB{
*
* }
* 3.如果实现类所实现的多个接口当中存在重复的抽象方法，则重写一个即可
* 4.如果实现类没有覆盖重写所有接口当中的所有抽象方法，那么实现类必须是一个抽象类
* 5.如果实现类实现的多个接口中，存在重复的默认方法，那么实现类一定要多冲突的默认方法进行覆盖重写
* 6.一个类如果直接父类当中的方法，和接口当中的默认方法产生了冲突，优先用父类当中的方法
* */
public class Demo06Interface {
    public static void main(String[] args) {
        Zi zi=new  Zi();
        //优先使用父类的方法
        zi.show();
    }
}
