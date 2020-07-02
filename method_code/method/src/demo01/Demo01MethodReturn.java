package demo01;
/*
1.定义一个方法，用来求出两个数字之和
2.定义一个方法，用来打印两个数字之和
*/
public class Demo01MethodReturn {
    public static void main(String[] args) {
        int num = getSum(15,25);
        System.out.println("返回值是："+num);
        System.out.println("----------");
        printSum(45,55);
    }
    //有返回值
    public static int getSum(int a,int b){
        int result =a+b;
        return result;
    }
    //无返回值
    public static void printSum(int a,int b){
        int result = a+b;
        System.out.println("结果是："+result);
    }

}
