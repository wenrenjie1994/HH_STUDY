package com.longyx.study.algorithm.map.traverse;

import java.util.HashMap;
import java.util.Map;

/**
 * 3、使用for-each迭代遍历HashMap
 * @author Mr.Longyx
 * @date 2020年07月01日 11:41
 */
public class ForEachIteratorHashMap {
    public static void main(String[] args) {
        Map<Integer, String> coursesMap = new HashMap<>();

        coursesMap.put(1,"Java");
        coursesMap.put(2,"Python");
        coursesMap.put(3,"Linux");
        coursesMap.put(4,"C");
        coursesMap.put(5,"C++");
        coursesMap.put(6,"Spring");

        for (Map.Entry<Integer, String> entry : coursesMap.entrySet()) {
            System.out.println(entry.getKey() + " "+entry.getValue());
        }
    }

}
