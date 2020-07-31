package JavaDemo.Exception.Practice;

import java.util.Scanner;

public class ExeDemo02 {
    public static int ecm(int i, int j) throws EcDef {
        if (i < 0 || j < 0) {
            throw new EcDef("molecule and denominate are negative!!");
        }
        return i / j;
    }

    public static void main(String[] args) {
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int result = ecm(a, b);
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("datatype is inconsistent!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("missing command line parameter!");
        } catch (ArithmeticException e) {
            System.out.println("denominate is zero");
        } catch (EcDef e) {
            System.out.println(e.getMessage());
        }
    }
}

