package com.pan.java;

import org.junit.Test;

import java.io.*;

/**
 * @author zhaopan@163.com
 * @creat 2020-04-23 13:54
 */
public class BufferedTest {
    @Test
    /*
    实现非文本文件的复制
     */
    public void BufferedTest()  {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File("桌面1.jpg");
            File destFile = new File("桌面2.jpg");
            //2.造流
            //2.1造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.复制的细节：读取，写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求1：先关闭外层的流，再关闭内层的流
            if(bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：在关闭外层流的同时，内层流也会自动进行关闭
            //所以可以省略内层流的关闭
//        fos.close();
//        fis.close();
        }

    }


    //实现文件复制的方法
    public void copyFileWithBuffered(String srcPath,String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //2.造流
            //2.1造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.复制的细节：读取，写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求1：先关闭外层的流，再关闭内层的流
            if(bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：在关闭外层流的同时，内层流也会自动进行关闭
            //所以可以省略内层流的关闭
//        fos.close();
//        fis.close();
        }

    }


    @Test
    public void testCopyFileWithBuffered(){
        String srcPath = "C:\\Users\\ZHAOPAN\\Desktop\\1.pdf";
        String destPath = "C:\\Users\\ZHAOPAN\\Desktop\\2.pdf";

        long start = System.currentTimeMillis();

        copyFileWithBuffered(srcPath,destPath);

        long end = System.currentTimeMillis();

        System.out.println(end-start);//17
    }

}
