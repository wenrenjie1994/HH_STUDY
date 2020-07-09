package com.spdb.study.java8.collector;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

/**
 * @author Mr.Longyx
 * @date 2020年07月08日 18:00
 */
public class CustomerCollector {
    public static void main(String[] args) {
        Collector<String, List<String>, List<String>> collector = new ToListCollector();
        String[] arr = new String[]{"Java","Python","Php","Linux","C++","Perl","大数据"};

        List<String> collect = Arrays.asList("Java", "Python", "Php", "Linux", "C++", "Perl", "大数据").parallelStream().filter(i -> i.length() > 3).collect(collector);
        System.out.println(collect);

        List<String> result = Arrays.stream(arr).filter(i -> i.length() > 3).collect(collector);
        System.out.println(result);
    }
}
