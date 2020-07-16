package demo01.Abstract;
/*
* 使用抽象类和抽象方法的注意事项
* 1.抽象类不能直接创建对象，只能创建其非抽象类的子类对象
* 2.抽象类可以有构造方法，是供子类创建对象时，初始化父类成员使用
* 3.抽象类中，不一定包含抽象方法，但是又抽象方法的类必定是抽象类
* 4.抽象类的子类，必须重写抽象父类中所有抽象方法，否则编译无法通过，除非该子类也是抽象类
* */
public class DemoMain {
    public static void main(String[] args) {
        Cat cat=new Cat();
        cat.eat();
    }
}
