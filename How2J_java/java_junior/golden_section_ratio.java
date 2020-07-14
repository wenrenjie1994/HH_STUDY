package cn.anyglobe;

public class simpledemo {
    public static void main(String[] args) {
        int a = 0, b = 0;
        double min_num = 10e5;
        for (int i = 1; i <= 20; ++i) {
            for (int j = 1; j <= 20; ++j) {
                if (i % 2 == 0 && j % 2 == 0) continue;
                double ans = ((double)i / (double)j);
                double cnt = Math.abs(ans - 0.618);
                if (cnt < min_num) {
                    min_num = cnt;
                    a = i;
                    b = j;
                }
            }
        }
        System.out.println(min_num + "\n" + a + " " + b);
    }
}