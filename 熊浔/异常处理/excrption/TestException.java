import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestException {

    public static void main(String[] args) {

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

    }
}
