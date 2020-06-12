package Middle_Exception.Handle;

/**
 * @Author lee
 * @Date 2020/6/11 9:50 PM
 * 全部放在一个catch里面使用if来分别判断
 * 代码紧凑
 * 但是不易于追踪，需要通过instanceof来判断异常类型
 **/
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;


public class MultiException2 {
    public static void main(String[] args) {
        String file_path ="/Download/1.txt";
        File f = new File(file_path);
        try{
            System.out.println("试图打开"+file_path+"文件");
            new FileInputStream(f);
            System.out.println("成功打开"+file_path+"文件");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sdf.parse("2020-06-11");
        }catch(FileNotFoundException |ParseException e){
            if(e instanceof  FileNotFoundException){
                System.out.println(file_path+"文件不存在");
            }
            if(e instanceof ParseException){
                System.out.println("解析失败");
            }
            e.printStackTrace();
        }
    }
}
