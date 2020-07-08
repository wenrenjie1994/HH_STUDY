package basic.method.demo1.day4;

import java.util.Arrays;

//用Arrays相关方法，将一个随机字符串所有字符升序排列，并倒序打印
public class DemoArraysPractise {
    public static void main(String[] args) {
        String str = "aljdasjdfoiaffrkjjb";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        System.out.print(chars);

        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }
    }
}
