package cn.sheng.day03;
/*
*      获取数组长度：
*           数组名.length
*
*           数组一经创建长度无法改变
* */


public class Demo04ArrayLength {
    public static void main(String[] args) {
        int arrayA[] = new int[3];

        int arrayB[] = {1, 2, 3, 4, 5};

        int len = arrayB.length;


        arrayA = new int[5] ;//arrayA原本指向的数组长度没变，只是arrayA指向了一个新的数组

        for (int i = 0; i < arrayA.length; i++) {
            System.out.println(arrayA[i]);
        }



    }
}
