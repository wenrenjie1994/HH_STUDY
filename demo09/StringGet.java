package fu.day04.demo09;
/*
Sting中与获取有关的方法：
public int length();//字符串长度
public String concat(String str)//将当前字符串和参数字符串拼接成为返回字符串
public char charAt(int index);获取指定索引位置的单个字符
public int indexOf(Sring str);查找参数字符串在本字符串当中首次出现的索引位。如果没有，返回-1.置

 */

public class StringGet {
    public static void main(String[] args) {
        int length="sadvdhfgfsjc,mcn,scnhfkjsh".length();
        System.out.println("字符长度是："+length);

//      拼接字符串
        String str1="hello";
        String str2="world";
        String str3=str1.concat(str2);
        System.out.println(str1);//hello
        System.out.println(str2);//world
        System.out.println(str3);//helloworld
        System.out.println("============");

        //获取指定索引的单个字符
        char ch="hello".charAt(1);
        System.out.println("1号索引位置的字符是："+ch);
        System.out.println("============");

        //查找字符串首次出现的索引位置
        //只查找第一次出现的位置，后面的不管
        String original="hellowworld";
        int index=original.indexOf("llo");
        System.out.println("第一次出现的位置是："+index);//2

    }
}
