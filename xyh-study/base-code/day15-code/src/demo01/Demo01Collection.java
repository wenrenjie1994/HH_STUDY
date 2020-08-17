package demo01;
import java.util.ArrayList;
import java.util.Collection;

/*
一、Collection:集合是java中提供的一种容器，可以用来存放多个数据。
集合与数组的区别：
1.数组的长度是固定的，集合的长度是可变的
2.数组中存储的是同一类型的元素，可以使基本数据类型值。
集合存储的都是对象，而且对象的类型可以不一致。

二、学习集合的目标，1.会使用集合存储数据，2.会遍历集合，3.掌握每一种集合的特性
集合的框架：
List接口：1.有序的集合。2.允许存储重复元素。3.有索引，可以使用普通的for循环遍历
子类有：Vector集合、ArrayList集合、LinkedList集合
Set接口：1.不允许存储重复元素。2.没有索引，不能使用普通的for循环遍历
子类有：TreeSet集合（无序）、HashSet集合(无序)、LinkedHashSet集合（有序）
List接口与Set接口均继承了Collection接口。
Collection接口：定义所的是所有单列集合中共性方法，所有单列集合都可以使用共性的方法。
没有索引的方法。
集合框架的学习方式：
1.学习顶层：学习顶层接口/抽象类中共性的方法。所有子类都可以使用
2.使用底层：顶层不是接口就是抽象类，无法创建对象使用，需要使用底层子类创建对象使用
三、Collection集合的常用方法
任何单列集合都可以使用Collection接口中的方法
共性方法：
public boolean add(E e)：把给定的对象添加到当前集合中
public void clear():清空集合中所有的元素
public boolean remove(E e):把给定的对象在当前集合中删除
public boolean contains(E e):判断当前集合中是否包含给定的对象
public int size():返回集合中元素的个数
public Object[] toArray():把集合中的元素，存储到数组中
* */
public class Demo01Collection {
    public static void main(String[] args) {
        //创建集合元素，可以使用多态
        Collection<String> coll=new ArrayList<>();
        System.out.println(coll);//重写了toString方法，打印非地址
        boolean b1=coll.add("张三");
        coll.add("李四");
        coll.add("王五");
        System.out.println("b1="+b1);//true
        System.out.println(coll);
        System.out.println("=======================");

        boolean b2=coll.remove("王五");
        System.out.println("b2="+b2);
        System.out.println(coll);
        boolean b3=coll.remove("小六");
        System.out.println("b3="+b3);
        System.out.println(coll);

        System.out.println("=======================");
        boolean b4=coll.contains("小六");
        boolean b5=coll.contains("张三");
        System.out.println("b4="+b4);
        System.out.println("b5="+b5);

        System.out.println("=======================");
        boolean b6=coll.isEmpty();
        System.out.println("b6="+b6);

        System.out.println("=======================");
        int size=coll.size();
        System.out.println("size="+size);
        System.out.println("=======================");
        Object[] arr=coll.toArray();
        for (int i = 0; i <arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("=======================");
        coll.clear();
        System.out.println(coll);
        System.out.println(coll.isEmpty());



    }
}
