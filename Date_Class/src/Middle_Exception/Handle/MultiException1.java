package Middle_Exception.Handle;

/**
 * @Author lee
 * @Date 2020/6/11 9:41 PM
 * 用多个catch分别来处理不同的异常
 **/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class MultiException1 {
    public static void main(String[] args) {
        String file_path = "/Download/1.txt";
        File f = new File(file_path);
        try{
            System.out.println("试图打开"+file_path+"文件");
            new FileInputStream(f);
            System.out.println("成功打开"+file_path+"文件");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sdf.parse("2020-06-11");


        }catch(FileNotFoundException e){
            System.out.println(file_path+"文件打开失败");
            e.printStackTrace();

        }
        catch(ParseException e){
            System.out.println("日期解析错误");
            e.printStackTrace();
        }
    }
}
