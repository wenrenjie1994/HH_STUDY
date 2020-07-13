package com.zxj;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: zeng
 * @modified By:
 */
public class Test2 {
    public static void main(String[] args) {
        Map<Student, String> map = new HashMap<>();
        map.put(new Student("大狗", 25), "四川");
        map.put(new Student("二狗", 30), "武汉");
        //遍历
        Set<Map.Entry<Student, String>> entrySet = map.entrySet();
        for (Map.Entry<Student, String> studentStringEntry : entrySet) {
            Student student = studentStringEntry.getKey();
            String area = studentStringEntry.getValue();
            System.out.println(student+"来自:"+area);
        }
    }
}
