package demo02;

import java.util.ArrayList;
import java.util.Iterator;

/*
* 泛型：是一种未知的数据类型，当我们不知道使用什么数据类型的时候，可以使用泛型
* 泛型也可以看作是一个变量，用来接收数据类型
* E e：Element
* T t：Type类型
* ArrayList集合在定义的时候不知道集合都会存储什么类型的数据，所以类型使用了泛型E
* public class ArrayList<E>{
*   public boolean add(E e){}
*   public E get (int index){}
* }
* 注：创建集合对象的时候，就会确定泛型的数据类型
* ArrayList <String> list=new ArrayList<String>();
* public class ArrayList<String>:即把String赋给E
* */
public class Demo01Fanxing {
    public static void main(String[] args) {
        show01();
    }

    private static void show01() {
        /*创建集合对象，不使用泛型
        * 好处：集合不使用泛型，默认的类型是Object类型，可以存储任意类型的数据
        * 弊端：
        * 不安全，会引发异常
        *
        * */
        ArrayList list=new ArrayList();
        list.add("abc");
        list.add(1);
        Iterator it=list.iterator();
        while (it.hasNext()){
            Object obj=it.next();
            System.out.println(obj);
            //想要使用String类特有的方法，length获取字符串的长度；多态：Object obj="abc";
            //向下转型
            String s=(String)obj;
            //不安全，可能引发异常
            System.out.println(s.length());//会抛出.ClassCastException:不能将Integer类型转化为String类型
        }
    }
}
