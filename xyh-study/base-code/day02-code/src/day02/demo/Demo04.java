package day02.demo;
/*有返回值和无返回值 */
public class Demo04 {
    public static void main(String[] args) {
        //有返回值
        int sum=getSum(12,18);
        System.out.println(sum);
        //无返回值
        printSum(120,180);
    }
    public static int getSum(int a,int b){
        int result=a+b;
        return result;
    }
    public static void  printSum(int a ,int b){
        System.out.println(a+b);
    }



}
