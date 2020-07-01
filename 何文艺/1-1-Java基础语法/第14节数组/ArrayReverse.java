package cn.hwy.day0701.demo;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] a = {1,4,3,5,6};
        printArray(a);
        for(int i = 0, j = a.length - 1 ; i < j ; i++, j--) {
            int temp;
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        System.out.println();
        printArray(a);
    }
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
