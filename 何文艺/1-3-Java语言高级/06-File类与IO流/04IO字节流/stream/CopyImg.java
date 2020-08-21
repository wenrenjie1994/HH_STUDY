package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyImg {
    public static void main(String[] args) throws IOException {
        //1.创建字节输入输出流对象
        FileInputStream fis = new FileInputStream(new File("E:\\IdeaProjects\\basic-code\\day0814-code\\src\\stream\\before\\image.jpg"));
        FileOutputStream fos = new FileOutputStream(new File("E:\\IdeaProjects\\basic-code\\day0814-code\\src\\stream\\after\\image.jpg"));
        //2.将图片从硬盘读取到内存中
        byte[] bytes = new byte[1024];
        int len = 0;
        while (-1 != (len = fis.read(bytes))) {
            //3.将图片从内存读取到硬盘中
            fos.write(bytes);
        }
        fis.close();
        fos.close();
    }
}
