package demo04;
/*
比较两个数据是否相等
参数类型：两个byte，两个short,两个long,两个int

*/
public class MethodOverloadSame {
    public static void main(String[] args) {
        byte a=10;
        byte b =20;
        System.out.println(isSame(a,b));
        System.out.println(isSame((short)10,(short)10));
        System.out.println(isSame(10L,12L));
        System.out.println(isSame(10,10));

    }
    public static boolean isSame(byte a,byte b){
        return a==b;
    }
    public static boolean isSame(short a,short b){
        return a==b;
    }
    public static boolean isSame(long a,long b){
        return a==b;
    }
    public static boolean isSame(int a,int b){
        return a==b;
    }
}
