package Middle_Exception.Handle;

/**
 * @Author lee
 * @Date 2020/6/11 9:25 PM
 * 使用try-catch来处理异常
 **/
import java.io.FileInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TryCatch {
    public static void main(String[] args) {
        String file_path = "/Download/1.txt";
        try{

            System.out.println("试图打开"+file_path+"文件");
            File f = new File(file_path);
            new FileInputStream(f);
            System.out.println(file_path+"文件打开成功");
        }
        catch (FileNotFoundException e){
            System.out.println(file_path+"文件不存在");
            e.printStackTrace();

        }

        }
}
