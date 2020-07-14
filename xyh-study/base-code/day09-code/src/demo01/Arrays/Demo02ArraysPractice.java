package demo01.Arrays;

import java.util.Arrays;

/*使用Arrays相关的API，将一个随机字符串中所有字符升序排列，并倒序打印*/
public class Demo02ArraysPractice {
    public static void main(String[] args) {
        String str="asv76agfqwdfvasdfvjh";
        char[] chars=str.toCharArray();
        //对数组进行升序排列
        Arrays.sort(chars);
        for (int i = chars.length-1; i >=0; i--) {
            System.out.print(chars[i]);
        }
    }
}
