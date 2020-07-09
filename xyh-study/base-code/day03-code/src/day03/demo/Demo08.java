package day03.demo;
/*
数组作为方法参数传递,传递的是数组的地址值.
数组也可以作为方法的返回值,返回的是数组的地址值
*/

public class Demo08 {
    public static void main(String[] args) {
        int[] array=new int[]{1,2,3,6,9};
        printArray(array);
        int[] array1=new int[]{1,2,3,6,9,10};
        printArray(array1);
        int []result=calculate(10,20,30);
        System.out.println("sum="+result[0]);
        System.out.println("sum="+result[1]);
        System.out.println("结果接收到的是"+result);
    }
    //数组作为方法的参数传递
    public static  void printArray(int [] array){
        System.out.println("方法接收到的参数是"+array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    //数组作为方法的返回值
    public static  int[]  calculate(int a,int b,int c) {
        int sum=a+b+c;
        int avg=sum/3;
        int [] array=new int[2];
        array[0]=sum;
        array[1]=avg;
        System.out.println("返回的值是"+array);
        return array;

    }

}

