package Middle_Exception.Handle;

import java.io.FileNotFoundException;

/**
 * @Author lee
 * @Date 2020/6/11 10:24 PM
 **/
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Exercise_my {
    public static void main(String[] args) {

        int x = method();
        System.out.println(x);
    }

    public static int method(){
        String file_path = "/Download/1.txt";
        File f = new File(file_path);
        try{
            new FileInputStream(f);
            return 1;
        }catch (FileNotFoundException e){
            e.printStackTrace();
            return 2;
        }
        finally {
            return 3;
        }
    }
}

