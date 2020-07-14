package JavaDemo.Array;

import java.util.Scanner;

public class YanghuiTriangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();

        int[][] arr = new int[x][x];
        /*
        int[][] arr = new int[x][];
        for (int i=0; i<x; i++) {
            arr[x] = new int[i+1];
        }
         */
        for (int i=0; i<x; i++) {
            //the first number is 1 each row
            arr[i][0] = 1;
            for (int j=1; j<i; j++) {
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
            //the last number is 1 each row
            arr[i][i] = 1;
        }

        for (int i=0; i<x; i++) {
            for (int j=0; j<=i; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
