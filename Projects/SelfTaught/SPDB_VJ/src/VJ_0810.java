import java.util.Scanner;

public class VJ_0810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n < 4 || n > 10000) {
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
            if (n == 4) {
                System.out.println("1 * 2 = 2");
                System.out.println("2 * 3 = 6");
                System.out.println("6 * 4 = 24");
                continue;
            }
            if (n == 5) {
                System.out.println("3 - 1 = 2");
                System.out.println("5 - 2 = 3");
                System.out.println("2 * 3 = 6");
                System.out.println("6 * 4 = 24");
                continue;
            }
            System.out.println("1 + 5 = 6");
            System.out.println("6 - 6 = 0");
            for (int i = 7; i <= n; i++) {
                System.out.printf("%d * %d = 0\n", 0, i);
            }
            System.out.println("0 + 2 = 2");
            System.out.println("2 * 3 = 6");
            System.out.println("6 * 4 = 24");
        }
    }
}