package exercise.demo01;
/*
静态初始化还可以有省略格式
数据类型[] 数组名称 = {元素}；
静态初始化一旦使用省略格式，不能拆分为两部分；
*/
public class Demo02Array {
    public static void main(String[] args) {
        int[] array1 ={1,2,3,4,5};
        int[] array2 ;
        array2= new int[] {1,3,5,6};
        int[] array3;
        array3 =new int[300];
    }
}
