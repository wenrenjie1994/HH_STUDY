package fu.day04.demo09;
/*
转换相关的方法
public char[] toCharArray();将当前字符串拆分成为字符数组作为返回值
public byte getByte();获得当前字符串底层的字节数组
public String replace(CharSequence oldString, CharSequence newString)
将所有出现的老字符串替换为新的字符串，返回替换之后的结果作为新字符串
 */
public class StringConvert {
    public static void main(String[] args) {
        char[] chars="hello".toCharArray();
        System.out.println(chars[0]);//h
        System.out.println("============");

    }
}
