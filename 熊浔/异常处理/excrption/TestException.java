import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestException {

    /*public static void main(String[] args) {

        File f= new File("F:/2.txt");

        try{
            System.out.println("打开 F:/2.txt");
            new FileInputStream(f);
            System.out.println("成功打开");
        }
        catch(FileNotFoundException e){
            System.out.println("F:/2.txt不存在");
            e.printStackTrace();
        }finally {
            System.out.println("不管是否出现异常都会执行！");
        }

    }*/

    /*public static void main(String[] args) {
        method1();
    }

    private static void method1() {
        try {
            method2();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("打开 F:/2.txt 失败" );
        }
    }

    private static void method2() throws FileNotFoundException {
        File f = new File("F:/2.txt");
        System.out.println("打开 F:/2.txt");
        new FileInputStream(f);
        System.out.println("成功打开");

    }*/


    public static int method() {
        int result;
        try {
            result =  return1();
        } catch (Exception e) {
            result = return2();
        } finally {
            result = return3();
        }
        return result;
    }

    private static int return1() {
        System.out.println("return 1");
        return 1;
    }
    private static int return2() {
        System.out.println("return 2");
        return 2;
    }
    private static int return3() {
        System.out.println("return 3");
        return 3;
    }

    public static void main(String[] args) {
        int result = method();
        System.out.println("result:" + result);

    }
}
