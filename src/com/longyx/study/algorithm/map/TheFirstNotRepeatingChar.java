package com.spdb.study.algorithm.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 查找第一个出现一次的字符(HashMap)
 * @author Mr.Longyx
 * @date 2020年07月01日 11:01
 */
public class TheFirstNotRepeatingChar {
    public static int firstNotRepeatingChar(String str){
        int len = str.length();
        int index = -1;
        if (str == "" || len == 0){
            return index;
        }
        /**
         * 使用HashMap缓存字符串中字符和对应的出现次数
         * @author Mr.Longyx
         * @date 2020/7/1 11:03
         * @param str
         * @return int
         */
        Map<Character, Integer> charMap = new HashMap<>();
        /**
         * 遍历字符串，将每个字符和对应的出现次数累加
         * @author Mr.Longyx
         * @date 2020/7/1 11:04
         * @param str
         * @return int
         */
        for (int i=0;i<len;i++) {
            if (charMap.containsKey(str.charAt(i))){
                int count = charMap.get(str.charAt(i));
                charMap.put(str.charAt(i),count + 1);
            }else{
               charMap.put(str.charAt(i),1);
            }
        }
        /**
         * 获取出现次数为1的字符，将其下标返回
         * @author Mr.Longyx
         * @date 2020/7/1 11:08
         * @param str
         * @return int
         */
        for(int i=0;i<len;i++){
            if (charMap.get(str.charAt(i)) == 1){
                index = i;
                return index;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String str = "kmbpbkmpj";
        System.out.println(firstNotRepeatingChar(str));
    }
}
