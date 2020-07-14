package JavaDemo.Array;

public class Demo01 {
    public static void main(String[] args) {
        int[][] arr = new int[][] {{3,5,8}, {12,9}, {7,0,6,4}};
        int sum = 0;
        for (int[] ar : arr) {
            for (int x : ar) {
                sum += x;
            }
        }
        System.out.println(sum);
    }
}
