package Middle_Exception.Category;

/**
 * @Author lee
 * @Date 2020/6/12 7:10 AM
 * CheckedException是必须进行处理的异常，如果不处理则编译不能通过
 * 常见的CheckedException如IO异常和SQL异常
 * 处理方式：1.try-catch；2.throws
 **/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

public class Checked_Exception {
    public static void main(String[] args) {
        String file_path = "/Download/1.txt";
        File f= new File(file_path);

        try{
            System.out.println("试图打开"+file_path+"文件");
            new FileInputStream(f);

            System.out.println("成功打开"+file_path+"文件");

        }catch (FileNotFoundException e){
            System.out.println("打开"+file_path+"文件失败");
            e.printStackTrace();

        }
    }
}
