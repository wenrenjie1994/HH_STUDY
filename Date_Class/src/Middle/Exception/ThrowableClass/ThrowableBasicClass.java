package Middle_Exception.ThrowableClass;

/**
 * @Author lee
 * @Date 2020/6/12 7:48 AM
 * Throwable是异常处理的基类
 **/
import java.io.FileInputStream;
import java.io.File;


public class ThrowableBasicClass {
    public static void main(String[] args) {
        String file_path = "/Download/1.txt";
        File f = new File(file_path);

        try{
            new FileInputStream(f);
        }catch (Throwable e){
            e.printStackTrace();

        }
    }
}
