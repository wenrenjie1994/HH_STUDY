package com.pan.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author zhaopan@163.com
 * @creat 2020-04-20 13:55
 */
public class CollectionTset {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        //1.add(Object e)：将元素e添加到集合coll中
        coll.add("AA");
        coll.add("BB");
        coll.add("123");//自动装箱
        coll.add(new Date());
        //2.size()：获取添加的元素个数
        System.out.println(coll.size());//4
        //3.add all(Collection coll1 ):将coll1集合中
        // 的元素添加到当前集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);
        System.out.println(coll.size());//6
        System.out.println(coll);
        //4.clear():清空集合元素
        coll.clear();
        //5.isEmpty():判断当前集合是否为空
        System.out.println(coll.isEmpty());//true
    }

}
