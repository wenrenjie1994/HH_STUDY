package demo01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
迭代器：Collection集合元素通用的获取方式。
在获取元素之前需要判断集合中有没有元素。如果有把这个元素取出来，继续判断，
直到将集合中的元素全部取出来

java.util.Iteration
有两个常用方法：
1.boolean hasNext() 判断集合是否有下一个元素，如果仍有元素可以迭代，则返回ture
2.E next() 返回迭代下一个元素
Iteration迭代器，是一个接口，我们无法直接使用，需要使用Iteration接口的实现类对象
获取实现类的方式比较特殊。Collection接口中有一个方法叫做iterator(),返回的就是迭代器的实现类对象

注：it.next():做了两个事情，1.取出下一个元素，2.把指针移动下一位
使用步骤：
1.使用集合中的方法iterrator()获取迭代器的实现类对象，使用Iterator接口接收
2.使用Iterator接口中的方法hasNext判断还有没有下一个元素
3.使用Iterator接口中的方法next取出集合中的下一个元素
*/
public class Demo02Iteration {
    public static void main(String[] args) {
        Collection <String> coll=new ArrayList<>();
        coll.add("Dora");
        coll.add("Marry");
        coll.add("Tom");
        coll.add("Tonny");
        /*
         1.使用集合中的方法iterator()获取迭代器的实现类对象，使用Iterator接口接收（多态）
         注意：
         Iterator<E>接口也有泛型，迭代器的泛型跟着集合走，集合什么泛型，迭代器就是什么泛型
        */
        Iterator<String> it=coll.iterator();
        //2.使用Iterator接口中的方法hasNext判断还有没有下一个元素
        boolean b=it.hasNext();
        System.out.println(b);
        String s=it.next();
        System.out.println(s);
        System.out.println("====================");
        while(it.hasNext()){
            String  e=it.next();
            System.out.println(e);
        }
        System.out.println("====================");
        for (Iterator<String> it2=coll.iterator();it2.hasNext();){
            String  e=it2.next();
            System.out.println(e);
        }

    }
}
