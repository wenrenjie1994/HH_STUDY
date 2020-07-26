package basic.method.demo1.day13;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Throwable {
    public static void main(String[] args) /*throws FileNotFoundException *//*throws ParseException*/ {
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       Date date = null;
       try {
           date = sdf.parse("2020-07-26");
       } catch (ParseException e) {
           e.printStackTrace();
       }
       System.out.println(date);
    }*/
        try {
            readFile("d:\\a.txt");
        }catch (FileNotFoundException e){
            System.out.println("传递的文件后缀有误");
        }
    }
    public static void readFile(String filename) throws FileNotFoundException{
        if(!filename.equals("c:\\\\a.txt")){
            throw new FileNotFoundException("传递的文件路径有误");
        }
    }
}