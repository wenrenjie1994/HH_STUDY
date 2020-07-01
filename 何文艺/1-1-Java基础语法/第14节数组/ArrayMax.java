package cn.hwy.day0701.demo;

public class ArrayMax {
    public static void main(String[] args) {
        int[] a = {2, 5, 3, 10, 58, 16};
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            max = a[i] > max ? a[i] : max;
        }
        System.out.println("最大值是：" + max);
    }
}
