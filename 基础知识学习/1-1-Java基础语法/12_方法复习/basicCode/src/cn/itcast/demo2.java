package cn.itcast;

public class demo2 {
    public static void main(String[] args) {
        int result = getSum(10,20);
        System.out.println("==========");
    }
    public static int getSum(int a,int b){
        return a+b;
    }
    public static  void getSum2(int a,int b){
        int result = a+b;
        System.out.println(result);
    }
}
