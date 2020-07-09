package day03.demo;
/*
访问数组：数组名称[索引值]
注：索引值的范围是从0到数组长度-1
使用动态初始化数组的时候，其中元素将会自动拥有一个默认值，规则如下：
1.整数类型：默认为0
2.浮点类型：默认为0.0
3.字符类型：默认为‘\u0000’(不可见字符)
4.布尔类型：默认为false值
5.引用类型：默认为null值
注：静态初始化也有默认值，只是系统自动将默认值替换成了大括号当中的具体数值
*/
public class Demo04 {
    public static void main(String[] args) {
        int[] array={10,20,30};
        System.out.println(array);//[@723279cf:数组地址对应的哈希值。f表示是16进制
        System.out.println(array[0]);

        int[] array1=new int[3];
        System.out.println(array1);//内存地址
        System.out.println(array1[0]);//0
        System.out.println(array1[1]);//0
        System.out.println(array1[2]);//0

        //给数组赋值
        array1[1]=123;
        System.out.println(array1[1]);

    }
}
