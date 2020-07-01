package com.spdb.study.algorithm.map.traverse;

import java.util.HashMap;
import java.util.Map;

/**
 * 4、使用Stream API遍历HashMap
 * @author Mr.Longyx
 * @date 2020年07月01日 11:46
 */
public class StreamApiIteratorHashMap {
    public static void main(String[] args) {
        Map<Integer, String> coursesMap = new HashMap<>();

        coursesMap.put(1,"Java");
        coursesMap.put(2,"Python");
        coursesMap.put(3,"C");
        coursesMap.put(4,"C++");
        coursesMap.put(5,"Spring");
        coursesMap.put(6,"MyBatis");

        /**
         * 使用Stream API遍历HashMap
         * @author Mr.Longyx
         * @date 2020/7/1 11:48
         */
        coursesMap.entrySet().forEach((entry)->{
            System.out.println(entry.getKey() + " "+entry.getValue());
        });
    }
}
