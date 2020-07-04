package Overload;
/*
题目要求：
比较两个数据是否相等。
参数类型分别为两个byte类型，short类型，int类型，long类型
并在main方法中进行测试
 */

public class DemoMethodOverloadSame {
    public static void main(String[] args) {
        byte a = 10;
        byte b = 20;
        System.out.println(isSame(a,b));

        System.out.println(isSame((short) 20, (short)20));

        System.out.println(isSame(11,12));

        System.out.println(isSame(10L, 10L));
    }
    public static boolean isSame(byte a, byte b){
        boolean same;
        if(a == b){
            same = true;
        }else{
            same = false;
        }
        return same;
    }
    public static boolean isSame(short a, short b){
        boolean same = a==b ? true:false;
        return same;
    }
    public static boolean isSame(int a, int b){
        return a==b;
    }
    public static boolean isSame(long a, long b){
        if(a==b){
            return true;
        }else{
            return false;
        }
    }
}
