package demo01.Abstract;
/*
抽象方法：加上abstract关键字，去掉大括号，直接分号结束
抽象类：抽象方法所在的类必须是抽象类。在class之前写上abstract

如何使用抽象类和抽象方法
1.不能直接创建抽象类对象
2.必须用一个子类来继承抽象类
3.子类必须覆盖重写抽象方法的abstract关键字
覆盖重写的实现：子类去掉抽象方法的abstract关键字，然后补上方法体大括号
4.创建子类对象进行使用
*/
public abstract class  Animal {
    public Animal(){
        System.out.println("我是动物");
    }
    public abstract void eat();

}
