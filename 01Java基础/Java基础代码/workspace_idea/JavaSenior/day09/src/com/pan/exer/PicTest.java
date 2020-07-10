package com.pan.exer;

import org.junit.Test;

import java.io.*;

/**
 * @author zhaopan@163.com
 * @creat 2020-04-23 14:37
 */
public class PicTest {
    //图片的加密
    @Test
    public void test1() {
        FileInputStream fis = null;
        FileOutputStream fos = null;//不造文件也可以
        try {
            fis = new FileInputStream(new File("桌面1.jpg"));
            fos = new FileOutputStream("桌面secret.jpg");

            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                //对字节数组进行修改
                //错误方式：把buffer取出来赋值给新的变量了，对新的变量进行修改，
                // 但buffer数组中的数据没有变
                //            for(byte b:buffer){
                //                b = (byte)(b^5);
                //            }
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }

                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //图片的解密
    @Test
    public void test2() {
        FileInputStream fis = null;
        FileOutputStream fos = null;//不造文件也可以
        try {
            fis = new FileInputStream(new File("桌面secret.jpg"));
            fos = new FileOutputStream("桌面4.jpg");

            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                //对字节数组进行修改
                //错误方式：把buffer取出来赋值给新的变量了，对新的变量进行修改，
                // 但buffer数组中的数据没有变
                //            for(byte b:buffer){
                //                b = (byte)(b^5);
                //            }
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
