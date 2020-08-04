package fu.day04.demo09;
/*
字符串的截取方法：
public String substring(int index);截取从参数位置一直到字符串末尾，返回新字符串
public String substring(int begin,int end):截取中间的字符串
备注[begin,end),包括左边，不包括右边
 */
public class Substring {
    public static void main(String[] args) {
        String str1="helloworld";
        String str2=str1.substring(5);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println("===========");

        String str3=str1.substring(4,7);
        System.out.println(str3);

    }
}
