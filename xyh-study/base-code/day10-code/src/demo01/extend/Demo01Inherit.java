package demo01.extend;
/*
一、继承的概念
继承主要解决的问题是共性抽取
面向对象的三大特性：封装性、继承性、多态性
继承是多肽的前提，如果没有继承，就没有多态
             继承
子类（派生类）---->父类（基类、超类）
继承关系的特点
1.子类可以拥有父类的“内容”
2.子类还可以拥有自己专有的内容
二、定义格式
在继承关系中“子类就是一个父类”
如：讲师（子类）就是一个员工（父类）
格式如下：
public class 父类名称{

}

public class 子类名称 extends 父类名称{
}
*/
public class Demo01Inherit {
    public static void main(String[] args) {
        Teacher teacher=new Teacher();
        teacher.method();
        Assistant assistant=new Assistant();
        assistant.method();
    }

}
