package com.spdb.study.algorithm.map.traverse;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 2、使用Iterator遍历HashMapKeySet
 * @author Mr.Longyx
 * @date 2020年07月01日 11:35
 */
public class IteratorHashMapKeySet {
    public static void main(String[] args) {
        Map<Integer, String> coursesMap = new HashMap<>();
        coursesMap.put(1,"java");
        coursesMap.put(2,"C");
        coursesMap.put(3,"C++");
        coursesMap.put(4,"Python");
        coursesMap.put(5,"Spring");
        coursesMap.put(6,"Linux");

        Iterator<Integer> iterator = coursesMap.keySet().iterator();
        while (iterator.hasNext()){
            Integer key = iterator.next();
            System.out.println(key+ " "+coursesMap.get(key));
        }
    }
}
