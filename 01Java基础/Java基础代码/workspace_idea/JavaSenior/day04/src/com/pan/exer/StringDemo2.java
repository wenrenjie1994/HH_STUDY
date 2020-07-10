package com.pan.exer;

import org.junit.Test;

/**
 * @author zhaopan@163.com
 * @creat 2020-04-17 21:06
 */

/*
4.获取两个字符串中最大相同子串。比如：
 * str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"//10
 * 提示：将短的那个串进行长度依次递减的子串与较长的串比较。
 */

public class StringDemo2 {

    //前提：两个字符串中只有一个最大相同子串
    public String maxSameSubString(String str1, String str2) {
        //取出长短字符串
        if (str1 != null && str2 != null) {
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() <= str2.length()) ? str1 : str2;
            int length = minStr.length();

            for (int i = 0; i < length; i++) {

                for (int x = 0, y = length - i; y <= length; x++, y++) {


                    String subStr = minStr.substring(x, y);
                    if (maxStr.contains(subStr)) {
                        return subStr;
                    }


                }

            }


        }
        return null;


    }

    @Test
    public void test(){
        String str1 = "abcwerthello1yuiodef";
        String str2 = "cvhello1bnm";
        String s = maxSameSubString(str1, str2);
        System.out.println(s);


    }





}
