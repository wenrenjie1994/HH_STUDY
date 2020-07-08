package basic.method.demo1.day4;

import java.util.Scanner;

//键盘输入一个字符串，并且统计其中各种字符出现得次数
public class Demo02Practise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String input = sc.next();

        int countUpper = 0;
        int countLower = 0;
        int countNumber = 0;
        int countOther = 0;

        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if ('A'<=ch&&ch<='Z'){
                countUpper++;
            }
            else if('a'<=ch&&ch<='z'){
                countLower++;
            }
            else if('0'<=ch&&ch<='9'){
                countNumber++;
            }
            else {
                countOther++;
            }
        }

        System.out.println("大写字母有："+countUpper);
        System.out.println("小写字母有："+countLower);
        System.out.println("数字有："+countNumber);
        System.out.println("其他字符有"+countOther);
    }

}
