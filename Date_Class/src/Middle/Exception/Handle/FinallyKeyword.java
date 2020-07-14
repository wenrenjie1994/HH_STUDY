package Middle_Exception.Handle;

/**
 * @Author lee
 * @Date 2020/6/11 9:58 PM
 * 无论是否出现异常，finally关键字中的代码都将被执行
 **/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FinallyKeyword {
    public static void main(String[] args) {
        String file_path = "/Download/1.txt";
        File f = new File(file_path);

        try{
            System.out.println("试图打开"+file_path+"文件");
            new FileInputStream(f);
            System.out.println("成功打开"+file_path+"文件");

        }catch(FileNotFoundException e){
            System.out.println("打开"+file_path+"文件失败");
            e.printStackTrace();

        }
        finally {
            System.out.println("finally中的句子都将被执行");

        }
    }
}
