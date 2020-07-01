package com.spdb.study.algorithm.map.traverse;

import java.util.HashMap;
import java.util.Map;

/**
 * 5、使用Lambda表达式遍历HashMap
 * @author Mr.Longyx
 * @date 2020年07月01日 11:51
 */
public class LambdaIteratorHashMap {
    public static void main(String[] args) {
        Map<Integer, String> coursesMap = new HashMap<>();

        coursesMap.put(1,"Java");
        coursesMap.put(2,"Python");
        coursesMap.put(3,"C");
        coursesMap.put(4,"C++");
        coursesMap.put(5,"Spring");
        coursesMap.put(6,"MyBatis");

        coursesMap.forEach((key,value)->{
            System.out.println(key+" "+value);
        });
    }
}
