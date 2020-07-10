package com.pan.java;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author zhaopan@163.com
 * @creat 2020-04-23 9:39
 */
public class FileReaderWriterTest {
    public static void main(String[] args) {
        File file = new File("hello.txt");//相较于当前工程
        System.out.println(file.getAbsolutePath());

        File file1 = new File("day09\\hello.txt");
        System.out.println(file1.getAbsolutePath());
    }

    /*
    将day09下的hello.txt文件内容读入程序中，并输出到控制台
     */
    @Test
    public void testFileReader() {
        FileReader fr = null;
        try {
            //1.实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");//相较于当前Module
            //2.提供具体的流
            fr = new FileReader(file);
            //3.数据的读入
            //read()：返回读入的一个字符。如果达到文件末尾，返回-1
            //方式一：
//        int data = fr.read();
//        while(data != -1){
//            System.out.print((char)data);
//            data = fr.read();
//        }
            //方式二：语法上的修改
            int data;
            while ((data = fr.read()) != -1){
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭操作
            try {
                if(fr != null)
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //对read()操作的升级：使用read()的重载方法
    @Test
    public void testFileReader1()  {
        FileReader fr = null;
        try {
            //1.File类的实例化
            File file = new File("hello.txt");
            //2.FileReader流的实例化
            fr = new FileReader(file);
            //3.读入的操作
            //read(char[] cbuf):返回每次读入cbuf数组中的字符的个数，
            //如果达到文件末尾，返回-1
            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf))!= -1){
                //错误的写法
//                for (int i = 0; i < cbuf.length; i++) {
//                    System.out.print(cbuf[i]);
//                }
                //正确的写法
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuf[i]);
//                }
                //方式二：
                //错误写法,对应方式一错误的写法
//                String str = new String(cbuf);
//                System.out.println(str);
                //正确的写法
                String str = new String(cbuf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            try {
                if(fr != null)
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    从内存中写出数据到硬盘的文件里
     */
    @Test
    public void testFileWriter()  {
        FileWriter fw = null;
        try {
            //1.提供File类的对象，指明写出到的文件
            File file = new File("hello1.txt");
            //2.提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file);
            //3.写出的具体操作
            fw.write("I have a dream!\n");
            fw.write("You need to have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            try {
                if(fw != null)
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
