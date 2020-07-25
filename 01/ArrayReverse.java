package fu.day04.demo01;

/*
数组元素的反转
只使用原来的数组

数组元素的反转，其实就是对称位置的元素交换
通常遍历数组用一个索引：int i=0;
现在表示对称位置需要两个索引：int min=0;int max=array.length
*/
public class ArrayReverse {
    public static void main(String[] args) {
        int[] array = {10, 25, 9, 100, 89};

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);

        }
        System.out.println("=========");
        for (int min = 0, max = array.length - 1; min < max; min++, max--) {
            int temp=array[min];
            array[min]=array[max];
            array[max]=temp;

        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);

        }

    }
}
