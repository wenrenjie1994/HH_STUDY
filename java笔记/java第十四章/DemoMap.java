package basic.method.demo1.day12;

import com.sun.tools.javac.util.List;

import java.util.HashMap;
import java.util.Scanner;

public class DemoMap {
    //计算一个字符串中每个字符出现的次数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String  str = sc.nextLine();

        HashMap<Character,Integer>  map = new HashMap<>();
        for (char c:str.toCharArray()){
            if (map.containsKey(c)){
                Integer value = map.get(c);
                value++;
                map.put(c,value);
            }
            else {
                map.put(c,1);
            }
        }
        for (Character key:map.keySet()){
            Integer value = map.get(key);
            System.out.println(key+"="+value);
        }
        //  jdk9的新特性，of静态方法g
        List<String> list1 = List.of("a", "b", "c");
        System.out.println(list1);
    }
}
