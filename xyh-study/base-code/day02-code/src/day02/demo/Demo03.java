package day02.demo;
/*方法：有参数和无参数
有参数：方法需要数据条件才能完成任务
无参数：方法不需要任何数据，可独立完成任务
*/
public class Demo03 {
    public static void main(String[] args) {
        //根据具体的应用场景来确定方法是否有参数
        //计算两个数相乘:有参数
        method1(2,2);
        //打印hello：无参数
        method2();
    }
    public static void method1(int a ,int b){
        int result=a*b;
        System.out.println(result);
    }
    public static void method2(){
        System.out.println("hello");
    }
}
