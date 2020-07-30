package demo01;

import java.util.ArrayList;

/*
public boolean equals(Object obj){
  return (this==obj)
}
注：
== 比较运算法，若是基本数据类型：比较的值；若是引用数据类型，比较的是两个对象的地址值
*/
public class Demo02Equals {

    public static void main(String[] args) {
        Person p1=new Person("Dora",12);
        Person p2=new Person("Tom",13);
        boolean out=p1.equals(p2);
        System.out.println(out);//没有进行重写时，结果为false
        p1=p2;
        out=p1.equals(p2);
        System.out.println(out);//没有进行重写时，结果为ture

        //一般都是返回false值，所以没有意义，需要重写Equals方法,比较两个对象的属性
        Person p3=new Person("Tom",13);
        out=p1.equals(p3);
        System.out.println(out);//重写后，结果为ture

        //程序优化
        ArrayList<String> list=new ArrayList<>();
        out=p1.equals(list);
        System.out.println(out);
    }
}
