package cn.sheng.day03;


/*
 *       数组传参：传递的是数组的地址（类比c中传引用）
 *
 *       任何数据类型都可以作为方法的参数类型和返回值，且传递的都是数据的地址
 * */


public class Demo05ArrayParam {

    public static void main(String[] args) {
        int arrayA[] = {1, 2, 3, 4};
        changeArray(arrayA);
        System.out.println(arrayA[0]);

        arrayA[0] = 0;
        int arrayB[] = changeArray(arrayA);
        System.out.println(arrayB[0]);

    }

    public static int[] changeArray(int array[]) {

        array[0] = 5;

        return array;


    }

}
