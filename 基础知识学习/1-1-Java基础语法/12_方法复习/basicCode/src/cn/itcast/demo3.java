package cn.itcast;

public class demo3 {
    public static void main(String[] args) {
        int a1=10,b1=20;
        boolean isSame = a1==b1?true:false;
        System.out.println(isSame);
        System.out.println(isSame1(10,10));
    }
    public static boolean isSame1(int a,int b){
        return a==b;
    }
}
