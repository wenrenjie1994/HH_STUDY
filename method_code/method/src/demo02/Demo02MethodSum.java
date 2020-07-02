package demo02;
//定义一个方法，求出1~100之间所有数字的和。
public class Demo02MethodSum {
    public static void main(String[] args) {
        System.out.println("结果是："+getSum());
    }
    public static int getSum(){
        int result=0;
        for(int i=1;i<=100;i++){
            result +=i;
        }
        return result;
    }
}
