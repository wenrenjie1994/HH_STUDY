package 输入输出流;

import java.io.*;

public class IOdemo {
//+++++++++++++++++字节流++++++++++++++++++++++
    //-----------------InputStream(从文件读出，相对于内存写入)-------------------------
    private static void showContent(String path) throws IOException, IOException {
        // 打开流
        FileInputStream fis = new FileInputStream(path);

        int len;
        while ((len = fis.read()) != -1) {
            System.out.print((char) len);
        }
        // 使用完关闭流
        fis.close();
    }

    private static void showContent2(String path) throws IOException {
        // 打开流
        FileInputStream fis = new FileInputStream(path);

        // 通过流读取内容
        byte[] byt = new byte[1024];
        int len = fis.read(byt);//
        for (int i = 0; i <len; i++) {
            System.out.print(byt[i]);
     }
        // 使用完关闭流
        fis.close();
    }
    //-----------------OutputStream(写入)-------------------------
    //    * 1. 创建流
    //    * 2，写数据
    //    * 3，关闭流
    private static void writeTxtFile(String path) throws IOException {
        // 1：打开文件输出流，流的目的地是指定的文件
        FileOutputStream fos = new FileOutputStream(path,true);

        // 2：通过流向文件写数据
        byte[] byt = "hello world:this is a hr demo".getBytes();//此处可定义编码方式eg:"UTF-8"
        fos.write(byt);

        // 3:用完流后关闭流
        fos.close();
    }
    //-----------------缓冲流-------------------------
    //实现文件拷贝
    public static void copyFile(String srcPath, String destPath)
            throws IOException {
        // 打开输入流，输出流
        FileInputStream fis = new FileInputStream(srcPath);
        FileOutputStream fos = new FileOutputStream(destPath);

        // 使用缓冲流,减少对硬盘的读取次数，降低对硬盘的损耗
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        // 读取和写入信息
        int len = 0;

        while ((len = bis.read()) != -1) {
            bos.write(len);
        }

        // 关闭流
        bis.close();
        bos.close();
    }
//+++++++++++++++++字符流++++++++++++++++++++++
    //字符流的抽象基类：Reader ， Writer
    //FileReader读文件
    public static void readFileDemo(String path) throws Exception {
        Reader reader = new FileReader(path);
        int len = 0;
        while ((len = reader.read()) != -1) {
            System.out.print((char) len);
        }
        reader.close();
    }

    public static void writeFileDemo(String path) throws Exception {
        Writer writer = new FileWriter(path);
        String txt="字符流写入测试";
        writer.write(txt);//可写string,char,char[]三类
        writer.close();
    }

    public static void bufferwriteFileDemo(String path) throws Exception {
        Writer writer = new FileWriter(path);
        //包装缓存流
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        String txt="缓存字符流写入测试";
        bufferedWriter.write(txt);//可写string,char,char[]三类
        bufferedWriter.close();
    }
    //编码总结
    //1.Unicode全世界每个不同语言的不同字符都统一编码,共有2的16次方个字符空间
    //2.字节流，ascall编码2的8次方编码，主要对应符号字母，数字等
    //3.UTF-16与UTF-8是针对Unicode编码的不同读取方式，UTF-8能通过编码（报头）区分单字节和多字节编码
    public IOdemo(){
    }

    public static void main(String[] args) throws Exception {
        String path="C:\\HH_STUDY\\HH_STUDY\\java基础学习\\输入输出流\\test";
        bufferwriteFileDemo(path);
    }
}
