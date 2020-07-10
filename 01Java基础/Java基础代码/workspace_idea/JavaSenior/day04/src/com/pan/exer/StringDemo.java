package com.pan.exer;

import org.junit.Test;

/**
 * 2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
 * <p>
 * 3.获取一个字符串在另一个字符串中出现的次数。
 * 比如：获取“ab”在 “cdabkkcadkabkebfkabkskab”
 * 中出现的次数
 * <p>
 * 4.获取两个字符串中最大相同子串。比如：
 * str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"//10
 * 提示：将短的那个串进行长度依次递减的子串与较长
 * 的串比较。
 *
 * @author zhaopan@163.com
 * @creat 2020-04-17 16:45
 */

//将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
public class StringDemo {

     //方式一：转成char[]
    public String reverse(String str, int start, int end) {
        if (str != null && str.length() != 0) {
            char[] chars = str.toCharArray();
            for (int x = start, y = end; x < y; x++, y--) {
                char temp = chars[x];
                chars[x] = chars[y];
                chars[y] = temp;
            }
            return new String(chars);
        }
        return null;
    }

    //方式二：使用String的拼接操作
    public String reverse1(String str, int startIndex, int endIndex) {
        if (str != null && str.length() != 0) {
            //第一部分
            String reverseStr = str.substring(0, startIndex);
            //第二部分
            for (int i = endIndex; i >= startIndex; i--) {
                reverseStr += str.charAt(i);
            }
            //第三部分
            reverseStr += str.substring(endIndex + 1);
            return reverseStr;
        }
        return null;
    }

    //方式三：使用StringBuffer/StringBuilder替换String
    public String reverse2(String str, int startIndex, int endIndex) {
        if (str != null && str.length() != 0) {
            StringBuilder sb = new StringBuilder(str.length());
            //第一部分
            sb.append(str.substring(0,startIndex));
            //第二部分
            for (int i = endIndex; i >= startIndex; i--) {
                sb.append(str.charAt(i));
            }
            //第三部分
            sb.append(str.substring(endIndex+1));
            return sb.toString();


        }
        return null;
    }

    @Test
    public void test() {
        String str = "abcdefg";
        String reverse = reverse2(str, 2, 5);
        System.out.println(reverse);
    }


}
