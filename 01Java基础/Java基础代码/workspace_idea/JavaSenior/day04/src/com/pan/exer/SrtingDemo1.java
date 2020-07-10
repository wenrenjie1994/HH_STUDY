package com.pan.exer;

import org.junit.Test;

/**
 * @author zhaopan@163.com
 * @creat 2020-04-17 17:32
 */

/*
3.获取一个字符串在另一个字符串中出现的次数。
比如：获取“ab”在 “cdabkkcadkabkebfkabkskab”中出现的次数
 */
public class SrtingDemo1 {
    /**
     *取一个字符串在另一个字符串中出现的次数
     * @param mainStr 主字符串
     * @param subStr 子字符串
     * @return 子字符串在主字符串中出现的次数
     */
    public int getCount(String mainStr, String subStr){
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int index = 0;
        int count = 0;

        if(mainLength >= subLength){
            //方式一：
//            while( (index = mainStr.indexOf(subStr)) !=-1){
//                count++;
//                mainStr = mainStr.substring(index + subStr.length());
//            }

            //方式二：对方式一的改进
            while( (index = mainStr.indexOf(subStr,index)) !=-1){
                count++;
                index += subLength;

            }

            return count;
        }else{
            return 0;
        }

    }

    @Test
    public void test(){
        String str1 = "cdabkkcadkabkebfkabkskab";
        String str2 = "ab";
        int count = getCount(str1, str2);
        System.out.println(count);
    }

}
