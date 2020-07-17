package demo04.Interface;
/*
接口就是多个类的公共规范
接口是一种引用数据类型,最重要的内容就是其中的抽象方法
一、如何定义一个接口的格式
public interface 接口名称(){
//接口内容
}
如果是java7，接口中可以包含的内容有：
1.常量
2.抽象方法
如果是java8，可以额外包含的内容有：
3.默认方法
4.静态方法
如果是java9，还可以额外包含
5.私有方法

二、接口的使用步骤
1.接口不能直接使用，必须有一个实现类来实现接口
格式:
public class 实现类名称 implements 接口名称{
//....
}
2.接口的实现类必须覆盖重写（实现）接口中所有的抽象方法
3.创建实现类的对象进行使用

注意事项：如果实现类并没有覆盖重写接口中所有的抽象方法，则这个实现类就必须是抽象类
* */
public class Demo01Interface {
    public static void main(String[] args) {
        MyInterfaceAbstractimpl imp=new MyInterfaceAbstractimpl();
        imp.methodAbs1();
        imp.methodAbs2();
        imp.methodAbs3();
        imp.methodAbs4();
    }
}
