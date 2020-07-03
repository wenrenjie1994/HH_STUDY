package exercise.demo01;
/*
数组：存放多个数据的容器
数组：
1.属于引用数据类型
2.同一数组中变量类型必须一致
3.数组长度在程序运行期间不可改变

数组初始化：
1.动态初始化（指定长度） 数据类型[] 数组名称 = new 数据类型[数组长度]
2.静态初始化（指定内容） 数据类型[] 数组名称 = new 数据类型[]{元素1，元素2，...}
*/
public class Demo01Array {
    public static void main(String[] args) {
        int[] array = new int[300];
        double[] array1 = new double[10];
        String[] array2 = new String[5];
        int[] array3 = new int[]{5,6,7,8,9};
        String[] array4 = new String[]{"Marry","Jerk"};
    }
}
