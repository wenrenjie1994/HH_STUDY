package Middle_Exception.Handle;

/**
 * @Author lee
 * @Date 2020/6/11 10:08 PM
 * 利用throws来抛出异常，放在其他地方去处理
 * throw与throws的区别
 * throws用在方法申明中，表示有可能发生异常
 **/
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileInputStream;

public class ThrowsKeyword {
    public static void main(String[] args) {
        method1();
    }

    public static void method1() {
        try {
            method2();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void method2() throws FileNotFoundException{
        String file_path = "/Download/1.txt";
        File f= new File(file_path);
        System.out.println("试图打开"+file_path+"文件");
        new FileInputStream(f);
        System.out.println("成功打开"+file_path+"文件");

    }
}
