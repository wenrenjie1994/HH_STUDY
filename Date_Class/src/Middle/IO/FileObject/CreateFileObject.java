package Middle_IO;

/**
 * @Author lee
 * @Date 2020/6/13 4:25 PM
 **/
import java.io.File;

public class CreateFileObject {
    public static void main(String[] args) {
        String file_path = "/Download/20200602054945225";
        File f = new File(file_path);
        System.out.println("f的绝对路径："+f.getAbsolutePath());//不论文件是否存在都会有结果

        File f1 = new File("表二.JPG");
        System.out.println("f1的绝对路径："+f1.getAbsolutePath());//不论文件是否存在都会有结果

        File f2 = new File(f, "1.txt");
        System.out.println("f2的绝对路径："+f2.getAbsolutePath());//不论文件是否存在都会有结果
        //不需要文件真实存在
        //也并未创建这个文件

    }
}
