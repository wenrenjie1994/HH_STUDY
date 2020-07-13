package com.zxj;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description:
 * @author: zeng
 * @modified By:
 */
public class Test1 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("大狗", 10));
        list.add(new Student("二狗", 15));
        //遍历1
//        for (Student student : list) {
//            System.out.println(student);
//        }
        //遍历2
        Iterator<Student> iterator = list.iterator();
        while(iterator.hasNext()){
            Student student = iterator.next();
            System.out.println(student);
        }
    }
}
