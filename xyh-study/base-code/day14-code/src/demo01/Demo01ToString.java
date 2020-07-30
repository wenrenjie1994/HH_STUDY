package demo01;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
java.long。Object 的toString方法
Object是类层次结构的根（最顶层的类），每个类都使用Object作为超类
所有对象（包括数组）都实现这个类的方法

注意：看一个类是否重写了toString方法，直接打印这个类对应对象的名字即可，
如果没有重写这个方法，则打印的就是对象的地址值。
*/
public class Demo01ToString {
    public static void main(String[] args) {
        Person person=new Person("张三",15);
        String s= person.toString();
        System.out.println(s);//没有进行重写时，结果为demo01.Person@723279cf

        //直接打印对象的名字，其实就是调用对象的toString方法
        System.out.println(person);//没有进行重写时，demo01.Person@723279cf
        Random r=new Random();//没有重写toString方法
        System.out.println(r);

        Scanner sc=new Scanner(System.in);//重写toString方法
        System.out.println(sc);

        ArrayList<Integer> list=new ArrayList<>();//重写toString方法
        list.add(1);
        list.add(2);
        System.out.println(list);

    }
}
