import java.util.Arrays;
import java.util.Scanner;

public class VJ_0817 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int result = x;
            if (x == 0) {
                int index = Arrays.binarySearch(arr, 0);
                if (index == -1) System.out.println(0);
                else System.out.println(1);
            } else {
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] < x) {
                        result--;
                    }
                    if (arr[i] == x) {
                        result++;
                    }
                }
                System.out.println(result);
            }
        }
    }
}
