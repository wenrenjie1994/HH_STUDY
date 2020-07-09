package day03.demo;
/*方法重载之练习题
 比较两个数据是否相等：
 参数类型分别为两个byte，两个short，两个int，两个long类型
 并在main方法中进行测试
 */

public class Demo02 {
    public static void main(String[] args) {
        byte a = 10;
        byte b = 20;
        System.out.println(isSame(a,b));
        System.out.println(isSame(11,12));
        System.out.println(isSame((short)11,(short)12));
        System.out.println(isSame(10L,10L));
    }

    public static boolean isSame(byte a ,byte b){
        System.out.println("两个byte类型的数据比较");
        boolean same;
        if(a==b){
            same=true;
        }else {
            same=false;
        }
        return same;
    }

    public static boolean isSame(short a ,short b){
        System.out.println("两个short类型的数据比较");
        boolean same;
        if(a==b){
            same=true;
        }else {
            same=false;
        }
        return same;
    }

    public static boolean isSame(int a ,int b){
        System.out.println("两个int类型的数据比较");
        boolean same;
        if(a==b){
            same=true;
        }else {
            same=false;
        }
        return same;
    }

    public static boolean isSame(long a ,long b){
        System.out.println("两个long类型的数据比较");
        boolean same;
        if(a==b){
            same=true;
        }else {
            same=false;
        }
        return same;
    }


}
