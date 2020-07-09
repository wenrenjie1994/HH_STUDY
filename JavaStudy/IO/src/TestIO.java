import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestIO {
    public static void main(String[] args) throws IOException {
        test1();//1曹瑞123456
        test2();//1曹瑞1234561曹瑞123456  追加写
        //test1();//1曹瑞123456
    }

    /**
     * 每次都重新写文件，追加写参考test2
     * @throws IOException
     */
    public static void test1() throws IOException{
        File file = new File("IO\\caoruitest.txt");
        OutputStream os = new FileOutputStream(file);
        os.write(49);

        /*
        可以使用String类中的方法把字符串转换为字节数组
        快速写入字符串
         */
        byte[] bytes = "曹瑞".getBytes();
        byte[] bytes2 = "123456".getBytes();
        os.write(bytes);
        os.write(bytes2);
        os.close();
    }

    /**
     * 追加写+换行
     * @throws IOException
     */
    public static void test2() throws IOException{
        File file = new File("IO\\caoruitest.txt");
        FileOutputStream fos = new FileOutputStream(file,true);
        fos.write(49);

        /*
        可以使用String类中的方法把字符串转换为字节数组
        快速写入字符串
         */
        byte[] bytes = "曹瑞".getBytes();
        byte[] bytes2 = "123456".getBytes();
        byte[] bytes3 = "\n123456".getBytes();
        fos.write(bytes);
        fos.write(bytes2);
        fos.write(bytes3);
        fos.close();
    }
}
