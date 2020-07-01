package com.spdb.study.algorithm.string;

/**
 *  查找第一个只出现一次的字符(数组)
 * @author Mr.Longyx
 * @date 2020年07月01日 10:43
 */
public class TheFirstNotRepeatingChar {
    public static int firstNotRepeatingChar(String str){
        int length = str.length();
        int index = -1;
        if (length == 0 || str == ""){
            return index;
        }
        char[] chs = str.toCharArray();
        int[] ins = new int[256];
        /**
         * 将每个字符出现的次数累加
         * @author Mr.Longyx
         * @date 2020/7/1 10:49
         * @param str
         * @return int
         */
        for(int i=0;i<length; i++){
            ins[chs[i]]++;
        }
        /**
         * 找到只出现一次的字符，将其返回
         * @author Mr.Longyx
         * @date 2020/7/1 10:50
         * @param str
         * @return int
         */
        for(int i=0;i<length; i++){
            if (ins[chs[i]] == 1){
                index = i;
                return index;
            }
        }

        /**
         * 未找到返回-1
         * @author Mr.Longyx
         * @date 2020/7/1 10:52
         * @param str
         * @return int
         */
        return index;
    }

    public static void main(String[] args) {
        String str = "kmbpbkmpj";
        System.out.println(firstNotRepeatingChar(str));
    }
}
