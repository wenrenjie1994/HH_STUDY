import java.util.ArrayList;
import java.util.Scanner;

public class VJ_0926 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] t = new int[3];//搭配个数
        ArrayList<Integer> listT = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'B') t[0] = t[0] + 1;
            if (str.charAt(i) == 'S') t[1] = t[1] + 1;
            if (str.charAt(i) == 'C') t[2] = t[2] + 1;
        }
        for (int i : t) {
            if (i != 0) listT.add(i);
        }
        ArrayList<Integer> listN = new ArrayList<>();//存量
        for (int i = 0; i < 3; i++) {
            listN.add(sc.nextInt());
        }
        ArrayList<Integer> listP = new ArrayList<>();//价格
        for (int i = 0; i < 3; i++) {
            listP.add(sc.nextInt());
        }
        if (!str.contains("C")) {
            listN.remove(2);
            listP.remove(2);
        }
        if (!str.contains("S")) {
            listN.remove(1);
            listP.remove(1);
        }
        if (!str.contains("B")) {
            listN.remove(0);
            listP.remove(0);
        }
        Long r = sc.nextLong();//money

        int[] already = new int[listN.size()];
        for (int i = 0; i < listN.size(); i++) {
            already[i] = listN.get(i) / listT.get(i);
        }
        int max = already[0];
        long min = already[0];
        for (int i = 0; i < listN.size(); i++) {
            if (already[i] > max) max = already[i];
            if (already[i] < min) min = already[i];
        }

        boolean[] isLevelUpdated = new boolean[listN.size()];
        boolean allLevelUpdated = false;

        while (true) {
            if (max == min && allLevelUpdated == true) {
                int priceSum = 0;
                for (int i = 0; i < listP.size(); i++) {
                    priceSum+=listP.get(i)*listT.get(i);
                }
                min = min + (r / priceSum);
                break;
            }
            if (max == min && allLevelUpdated == false) {
                int need = 0;
                for (int i = 0; i < already.length; i++) {
                    need += listP.get(i) * (listT.get(i) - (listN.get(i) - already[i] * listT.get(i)));
                }
                if (r >= need) {
                    r -= need;
                    min++;
                    int priceSum = 0;
                    for (int i = 0; i < listP.size(); i++) {
                        priceSum+=listP.get(i)*listT.get(i);
                    }
                    min = min + (r / priceSum);
                    break;
                }
            }
            //先找最小值索引
            int min1 = already[0], minIndex = 0;
            for (int i = 0; i < already.length; i++) {
                if (already[i] < min1) {
                    min1 = already[i];
                    minIndex = i;
                }
            }
            //补齐过
            isLevelUpdated[minIndex] = true;
            boolean start = true;
            for (boolean b : isLevelUpdated) {
                if (b == false) start = false;
            }
            if (start == true) allLevelUpdated = true;
            //补齐最小的
            int need = listP.get(minIndex) * (listT.get(minIndex) - (listN.get(minIndex) - already[minIndex] * listT.get(minIndex)));
            if (r >= need) {
                r -= need;
                already[minIndex] = already[minIndex] + 1;
                listN.set(minIndex, already[minIndex] * listT.get(minIndex));
                boolean isLevelUp = true;
                for (int i : already) {
                    if (i == min1) isLevelUp = false;
                }
                if (isLevelUp) min++;
            } else {
                break;
            }
        }
        System.out.println(min);
    }
}
