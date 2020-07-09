package day04.demo;
import javax.swing.*;
import java.util.Scanner;

/*
匿名对象(Anonymous)：
一般情况类名称 对象名=new 类名称();
而匿名对象就是只有右边的对象，没有左边的名字和赋值运算符。
格式：new 类名称();
注：匿名对象只能使用一次。
使用建议：如果确定这个对象只需要使用唯一的一次：如匿名对象作为参数的返回值



*/
public class Demo3 {
    public static void main(String[] args) {
        Person person=new Person();
        person.name="Dora";
        person.showName();
        //匿名对象
        new Person().name="Dora";
        new Person().showName();//null
        Scanner sc= methodReturn();
        int num=sc.nextInt();
        System.out.println("输入的是："+num);

    }

    //使用匿名函数作为参数的返回值
    public static  Scanner methodReturn(){

        return new Scanner(System.in);
    }

}

