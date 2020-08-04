package fu.day04.demo10;
/*
java.util.Arrays是一个与数组相关的工具类，里面提供了大量静态方法，用来实现数组常见的操作

public static String toString(数组)：将参数数组变成字符串，（按照默认格式【num1,num2,...,numn]）
 public static void sort(数组):按照默认升序（从小到大）堆数组进行排序
注意：对于数字,sort默认按照升序，从小到大
    对于字符串，sort默认按照字母升序
    对于自定义类型，那么这个自定义类需要有comparable 或comparator 接口支持
 */

import java.util.Arrays;

public class DemoArrays {
    public static void main(String[] args) {
        int[] intArray={10,20,30};
        //将int【】数组按照默认格式变成字符串
        String intStr= Arrays.toString(intArray);
        System.out.println(intStr);//[10,20,30]

        //排序
        int[] array1={1,5,3,34,75};
        Arrays.sort(array1);
        System.out.println(Arrays.toString(array1));//[1,3,5,34,75]

        String[] array2={"aaa","bbb","ccc"};
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array2));
    }
}
