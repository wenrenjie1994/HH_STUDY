package Middle_Exception.ThrowableClass;

/**
 * @Author lee
 * @Date 2020/6/12 7:53 AM
 * 在方法声明时可以抛出指定异常，比如FileNotFoundException能否抛出Throwable这个异常类？
 *      可以抛出，因为Throwable是异常处理的基类
 *      抛出之后，在调用的时候必须对异常进行处理，要么继续抛出，要么catch
 *      但是这样的设计缺陷明显，不知道抛出的异常具体是哪一种异常
 **/

import java.io.File;
import java.io.FileInputStream;

public class Exercise {

    public static void method() throws Throwable{
        String file_path = "/Download/1.txt";
        File f = new File(file_path);
        new FileInputStream(f);
    }
    public static void main(String[] args) {

       // method();如果直接调用就没有处理可查异常，编译不通过
        try{
            method();
        }catch (Throwable e){
            e.printStackTrace();
        }

    }
}
