package cn.sheng.day03;

/*数组
       1.引用数据类型
       2.长度固定

       数组初始化：
       1.动态初始化
       数据类型 数组名称[] = new 数据类型[数组长度]
       2.静态初始化
       数据类型 数组名称[] = new 数据类型[] {数组内容}
       数据类型 数组名称[] = {数组内容}
*/

public class Demo01Array {
    public static void main(String[] args) {
        int ArrayA[]  = new int[300];
        int ArrayB[] = new int[] {1,2,3,4,5};
        int ArrayC[] = {6,7,8,9,10};
        System.out.println(ArrayB); //打印地址

    }

}
