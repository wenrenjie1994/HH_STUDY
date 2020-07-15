package demo08.This;
/*
* this关键字用来访问本类的内容，用法有以下三种
* 1.在本类的成员方法中，访问本类的成员变量
* 2.在本类的成员方法中，访问本类的另一个成员方法
* 3.在本类的构造方法中，访问本类另一个构造方法
* 在3中应该注意
* 1）this(....)调用必须是构造方法的第一个语句，且应该是唯一的
* 2) super(...)和this(...)不能同时使用，否则和1）矛盾
* */
public class Son extends Father{
    int num=20;
    public Son(){
        //在本类的构造方法中，访问本类另一个构造方法
        this(20);
        System.out.println("本类的无参数构造");
    }
    public Son(int num){
        System.out.println("本来的有参数构造方法，参数是"+num);
    }
    public void showNum(){
        int num=10;
        System.out.println(num);//局部变量10
        //在本类的成员方法中，访问本类的成员变量
        System.out.println(this.num);//20
    }

    public void methodA(){
        System.out.println("AAAAA");
    }
    public void methodB(){
        //在本类的成员方法中，访问本类的另一个成员方法
        this.methodA();
        System.out.println("BBBBB");
    }
}
