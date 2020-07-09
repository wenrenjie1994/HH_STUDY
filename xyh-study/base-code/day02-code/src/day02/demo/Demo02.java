package day02.demo;

/*方法进阶：定义两个数相加的方法
三要素：
1.返回值类型：int
2.方法名称：sum
3.参数列表：int a,int b
方法的三种调用格式：
1.单独调用，方法名称（参数）
2.打印调用
3.赋值调用
注：返回值类型为void的方法只能进行单独调用
*/
public class Demo02 {
    public static void main(String[] args) {
        //单独调用
        sum(10,20);
        System.out.println("=====================");
        //打印调用
        System.out.println(sum(10,20));
        System.out.println("=====================");
        //赋值调用
        int number=sum(10,20);
        System.out.println(number);

    }
    public static int sum(int a,int b){
        int result=a+b;
        System.out.println("方法执行了");
        return result;
    }


}
