import java.util.ArrayList;
import java.util.Scanner;

public class VJ_0824 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] x = new int[k];
            for (int i1 = 0; i1 < x.length; i1++) {
                x[i1] = sc.nextInt();
            }
            int max = x[0] - 1;
            if (n - x[k - 1] > max) max = n - x[k - 1];
            for (int j = 1; j < x.length; j++) {
                int minus = x[j] - x[j - 1];
                int minusSec = minus / 2;
                if (minusSec > max) max = minusSec;
            }
            list.add(max + 1);
        }
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
