import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;



public class TestException {
    
    //try catch
    public static void main(String[] args) {
        File f = new File("d:/LOL.exe");
        try {
            System.out.println("试图打开LOL");
            new FileInputStream(f);
            System.out.println("成功打开");
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("LOL文件不存在");
            e.printStackTrace();
        }
    }
}