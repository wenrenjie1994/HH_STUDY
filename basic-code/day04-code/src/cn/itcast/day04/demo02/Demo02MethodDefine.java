package cn.itcast.day04.demo02;

public class Demo02MethodDefine {
    public static void main(String[] args) {
        System.out.println(sum(1,100));
    }
    public static int sum(int a, int b){
        int result = 0;
        for(int i=a;i<=b;i++){
            result += i;
        }
        return result;
    }
}
