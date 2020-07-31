package JavaDemo.Exception.TryCatchFinally;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest02 {

    @Test
    public void Test1() {
        try {
            String str = "";
            str = "abc";
            int num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("数值转换异常");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void Test2() {
        try {
            int a = 10;
            int b = 0;
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            int[] arr = new int[10];
            System.out.println(arr[10]);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("OVER");
        }
    }

    @Test
    public void Test3() {
        int num = Test4();
        System.out.println(num);
    }

    public int Test4() {
        try {
            int[] arr = new int[10];
            System.out.println(arr[10]);
            return arr[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return -1;
        } finally {
            System.out.println("OVER!!");
        }
    }

    @Test
    public void Test5() {
        FileInputStream fileInputStream = null;
        try {
            File file = new File("hello.txt");
            fileInputStream = new FileInputStream(file);

            int data = fileInputStream.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fileInputStream.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (NullPointerException | IOException e) {
                e.printStackTrace();
            }
        }
    }

}
