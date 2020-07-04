package Method;

/*
有参数，小括号当中有内容，当一个方法需要一些数据条件，才能完成任务的时候，就是有参数。
例如两个数字相加，必须直到两个数字各自是多少，才能相加

无参数：小括号当中留空。一个方法不需要任何数据条件，自己就能独立完成任务，就是无参数。
例如定义一个方法，打印固定10次HelloWorld
 */

public class DemoMethodParam {
    public static void main(String[] args) {
        method1(10,20);
        method2();
    }
    //有参数：输出两个数的乘积
    public static void method1(int a, int b){
        int result = a * b;
        System.out.println("the result is " + result);
    }

    //无参数：输出固定次数文本信息
    public static void method2(){
        for (int i = 1; i <= 10; i++) {
            System.out.println("Hello World" + i);
        }
    }
}
