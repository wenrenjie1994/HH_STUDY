package com.spdb.study.algorithm.map.traverse;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 1、使用Iterator遍历HashMapEntrySet
 * @author Mr.Longyx
 * @date 2020年07月01日 11:21
 */
public class IteratorHashMapEntrySet {
    public static void main(String[] args) {
        Map<Integer, String> coursesMap = new HashMap<>();

        coursesMap.put(1,"Java");
        coursesMap.put(2,"Python");
        coursesMap.put(3,"C");
        coursesMap.put(4,"C++");
        coursesMap.put(5,"Spring");
        coursesMap.put(6,"MyBatis");

        Iterator<Entry<Integer,String>> iterator = coursesMap.entrySet().iterator();
        while(iterator.hasNext()){
            Entry<Integer,String> entry = iterator.next();
            System.out.println(entry.getKey() + " "+entry.getValue());
        }
    }
}
