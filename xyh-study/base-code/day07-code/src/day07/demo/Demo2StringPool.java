package day07.demo;
/*
字符串常量池(在堆内存中)：程序当中直接写上双引号字符串，就在字符串常量池中
对于常量来说，==是进行数值比较
对于引用类型来说，==是进行地址值比较
【示意图】
*/
public class Demo2StringPool {
    public static void main(String[] args) {
        String str1="abc";
        String str2="abc";
        char [] array={'a','b','c'};
        String str3=new String(array);
        System.out.println(str1==str2);
        System.out.println(str2==str3);
        System.out.println(str1==str3);
    }
}
