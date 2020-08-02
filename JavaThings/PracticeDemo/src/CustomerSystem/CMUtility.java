package CustomerSystem;

import javax.lang.model.element.NestingKind;
import java.util.Scanner;

public class CMUtility {
    private static Scanner scanner = new Scanner(System.in);

    public static char readMenuSelection() {
        char c;
        while (true) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' &&
                c != '4' && c != '5') {
                System.out.print("非法输入，请重新输入： ");
            } else {
                break;
            }
        }
        return c;
    }

    /*
    从键盘读入一个字符，作为方法的返回值
    如果输入回车，则以defaultValue作为返回值
     */
    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);
        return str.length() == 0 ? defaultValue : str.charAt(0);
    }

    /*
    读取一个不超过2位的整数，作为方法的返回值
     */
    public static int readInt() {
        int n;
        while (true) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入非法，请重新输入： ");
            }
        }
        return n;
    }

    /*
    读取长度不超过2的整数，作为方法返回值
    没有输入直接回车，则以defaultValue作为返回值
     */
    public static int readInt(int defaultValue) {
        int n;
        while (true) {
            String str = readKeyBoard(2, true);
            if (str.equals("")) {
                return defaultValue;
            }
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入非法，请重新输入： ");
            }
        }
        return n;
    }

    /*
    读取一个长度不超过limit的字符串，作为返回值
     */
    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    /*
    读取一个字符串，作为方法的返回值
    输入回车，则以defaultValue作为返回值
     */
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("") ? defaultValue : str;
    }

    /*
    确认选择的输入，读取‘Y’或‘N’，作为方法的返回值
     */
    public static char readConfirmSelection() {
        char c;
        while (true) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("非法输入，请重新输入");
            }
        }
        return c;
    }

    private static String readKeyBoard(int i, boolean b) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (b) {
                    return line;
                } else {
                    continue;
                }
            }

            if (line.length() < 1 || line.length() > i) {
                System.out.println("输入长度非法，应不大于" + i + "，请重新输入： ");
                continue;
            }
            break;
        }
        return line;
    }
}
