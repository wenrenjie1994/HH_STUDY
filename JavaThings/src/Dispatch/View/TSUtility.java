package Dispatch.View;

import java.util.Scanner;

public class TSUtility {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * @Description 读取'1'-'4'中的字符，返回值为输入的字符
     * @author
     * @date 2020.7.29 10:40
     * @return
     */
    public static char readMenuSelection() {
        char c;
        while (true) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4') {
                System.out.print("select wrong! please input again: ");
            } else {
                break;
            }
        }
        return c;
    }

    /**
     * @Description 提示等待，直到输入回车键后返回
     * @author
     * @date 2020.7.29 10:40
     */
    public static void readReturn() {
        System.out.print("press enter to continue... ");
        readKeyBoard(100, true);
    }

    /**
     * @Description 读取一个长度不超过2位的整数，作为方法的返回值
     * @author
     * @date 2020.8.29 20:50
     * @return
     */
    public static int readInt() {
        int n;
        while (true) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("input number is wrong, please input again: ");
            }
        }
        return n;
    }

    /**
     * @Description 读取'Y'或'N'，作为方法的返回值
     * @author
     * @date 2020.7.29 10:55
     * @return
     */
    public static char readConfirmSelection() {
        char c;
        while (true) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("select wrong, please input again: ");
            }
        }
        return c;
    }

    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) {
                    return line;
                } else {
                    continue;
                }
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("input length (no more than " + limit + ")error, " +
                        "please input again: ");
                continue;
            }
            break;
        }
        return line;
    }
}
