import java.util.ArrayList;
import java.util.Scanner;

public class VJ_1011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int n = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.next());
        }
        boolean contain = false;
        int index = -1;
        if (s2.contains("*")) {
            contain = true;
            index = s2.indexOf("*");
        }
        ArrayList<String> res = new ArrayList<>();
        for (String s3 : list) {
            if (contain) {
                int minus = s3.length() - s2.length() + 1; //*替换为几个坏字符
                if (minus < 0) {
                    res.add("NO");
                    continue;
                } else if (minus == 0) {
                    String newS2 = s2.replace("*","");
                    if (match(s1, newS2, s3)) res.add("YES");
                    else res.add("NO");
                } else {
                    int start = index, end = index + minus - 1;
                    boolean containBad = false;
                    for (int i = start; i <= index + minus - 1; i++) {
                        if (s1.contains(new StringBuffer().append(s3.charAt(i)).toString())) {
                            containBad = true;
                            break;
                        }
                    }
                    if (containBad) {
                        res.add("NO");
                        continue;
                    }
                    //只有*
                    if (s2.length() == 1) {
                        res.add("YES");
                        continue;
                    } else if (start == 0) {
                        String newS2 = s2.substring(1);
                        String newS3 = s3.substring(end + 1);
                        if (match(s1, newS2, newS3)) res.add("YES");
                        else res.add("NO");
                    } else if (end == s3.length() - 1) {
                        String newS2 = s2.substring(0, index);
                        String newS3 = s3.substring(0, index);
                        if (match(s1, newS2, newS3)) res.add("YES");
                        else res.add("NO");
                    } else {
                        String leftS2 = s2.substring(0, index);
                        String leftS3 = s3.substring(0, index);
                        String rightS2 = s2.substring(index + 1);
                        String rightS3 = s3.substring(end + 1);
                        if (match(s1, leftS2, leftS3) && match(s1, rightS2, rightS3)) res.add("YES");
                        else res.add("NO");
                    }
                }
            } else {
                if (s2.length() != s3.length()) {
                    res.add("NO");
                    continue;
                }
                if (match(s1, s2, s3)) res.add("YES");
                else res.add("NO");
            }
        }
        for (String re : res) {
            System.out.println(re);
        }
    }

    public static boolean match(String s1, String s2, String s3) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s2.length(); i++) {
            if ((s2.charAt(i) == '?' && s1.contains(new StringBuffer().append(s3.charAt(i)).toString())) || s2.charAt(i) == s3.charAt(i))
                sb.append(s3.charAt(i));
        }
        if (sb.length() < s3.length()) return false;
        else return true;
    }
}
