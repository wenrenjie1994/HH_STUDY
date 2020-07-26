package demo02;
/*
* 内部类
* 例如：人体和心脏；汽车和发动机
* 分类：
* 1.成员内部类
* 2.局部内部类（包含匿名内部类）
*
* 成员内部类的定义格式:
* 修饰符 class 类名称{
*   修饰符 class 类名称{
*       //...
*    }
* //....
* }
* 注意：内用外，随意使用；外用内需要借助内部类对象
*
* 如何使用成员内部类
* 1.在外部内的方法中使用内部类，然后main只是调用外部类的方法
* 2.直接方式：公式：
* 类名称 对象名=new 类名称();
* 外部类名称.内部类名称 对象名=new 外部类名称().new 内部类名称();
* */
public class Demo1InnerClass {

    public static void main(String[] args) {
        Body body=new Body();
        //1.在外部内的方法中使用内部类，然后main只是调用外部类的方法
        body.methodBody();

        //直接方式：公式：
        System.out.println("=====================");
        Body.Heart heart=new Body().new Heart();
        heart.beat();
    }
}
