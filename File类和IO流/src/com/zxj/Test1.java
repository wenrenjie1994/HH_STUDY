package com.zxj;

import java.io.*;

/**
 * @description:
 * @author: zeng
 * @modified By:
 */
public class Test1 {
    public static void main(String[] args) {
        copyFile();
    }

    /**
     * 拷贝文件到另一个文件
     */
    public static void copyFile(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        byte[] bt = new byte[1024];
        int len = 0;
        try {
            bis = new BufferedInputStream(new FileInputStream("来拷贝.txt"));
            bos = new BufferedOutputStream(new FileOutputStream("拷贝后.txt"));
            while((len = bis.read(bt))!= -1){
                bos.write(bt,0,len);
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bis!=null){
                    bis.close();
                }
                if (bos!=null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
