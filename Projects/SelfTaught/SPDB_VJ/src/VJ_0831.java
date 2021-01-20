import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class VJ_0831 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] no = new int[n];
        for (int i = n - 1; i >= 0; i--)
            no[i] = sc.nextInt();
        int[] ai = new int[m];
        for (int i = 0; i < m; i++)
            ai[i] = sc.nextInt();
        int[] result = new int[n];
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < no.length; i++) {
            if (!s.contains(no[i])) {
                s.add(no[i]);
            }
            result[n - 1 - i] = s.size();
        }
        for (int i = 0; i < ai.length; i++)
            System.out.println(result[ai[i] - 1]);
    }
}
