package com.pan.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author zhaopan@163.com
 * @creat 2020-04-20 14:38
 */
public class CollectionTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String ("Tom"));
        coll.add(false);
//        Person p = new Person("Jerry", 20);
//        coll.add(p);
        coll.add(new Person("Jerry", 20));
        //6.contains(Object obj)：判断当前集合中是否包含Obj
        //在判断时会调用obj对象所在类的equals（）
        boolean contains = coll.contains(123);
        System.out.println(contains);//true
        System.out.println(coll.contains(new String("Tom")));//true
        //使用equals（）判断（比较的是内容不是地址）
//        System.out.println(coll.contains(p));//true
        System.out.println(coll.contains(new Person("Jerry", 20)));//false-->true
        //使用equals（）判断，但是没重写equals（）方法，其实内部还是个==
        //ctrl+Alrt+s重写equals（）方法，就变成了true
        //7.containsAll(Collection coll1)：判断coll1中的所有元素是否都存在于当前集合中
        Collection coll1 = Arrays.asList(123, 456);
        System.out.println(coll.containsAll(coll1));//true
    }

    @Test
    public void test2(){
        //8. remove(Object obj):从当前集合中移除obj元素
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String ("Tom"));
        coll.add(new Person("Jerry", 20));
        coll.add(false);
        coll.remove(123);
        System.out.println(coll);
        coll.remove(new Person("Jerry", 20));
        System.out.println(coll);
        //9.removeALL(Collection coll1):从当前集合中移除coll1中所有的元素
        Collection coll1 = Arrays.asList(1234, 456);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String ("Tom"));
        coll.add(new Person("Jerry", 20));
        coll.add(false);
        //10.retainAll(Collection coll1):获取当前集合与coll1集合的交集，返回给当前集合
//        Collection coll1 = Arrays.asList(123, 456);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        //11. equals(Object obj)：要想返回true，需要当前集合和形参集合的元素相同
        Collection coll1 = new ArrayList();//有序
        coll1.add(123);
        coll1.add(456);
        coll1.add(new String ("Tom"));
        coll1.add(new Person("Jerry", 20));
        coll1.add(false);
        System.out.println(coll.equals(coll1));
    }

    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String ("Tom"));
        coll.add(false);
        //12.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());
        //13.集合转换为数组：toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        //拓展：数组转换为集合:调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);
        //14.iterator()：返回迭代器Iterator接口的实例，用于遍历集合元素。
        //放在IteratorTest.java中测试
    }


}
