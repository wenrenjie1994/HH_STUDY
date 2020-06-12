package Middle_Exception.Handle;

/**
 * @Author lee
 * @Date 2020/6/11 9:36 PM
 * 使用异常的父类Exception来处理异常
 **/
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;

public class ExceptionFatherClass {
    public static void main(String[] args) {
        String file_path = "/Download/1.txt";
        File f = new File(file_path);

        try{
            System.out.println("试图打开"+file_path+"文件");
            new FileInputStream(f);
            System.out.println("成功打开"+file_path+"文件");

        }catch(Exception e){
            System.out.println("找不到"+file_path+"文件");
            e.printStackTrace();

        }
    }
}
