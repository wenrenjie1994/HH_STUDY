package com.liujinji.Stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author: liujinji0452@gmail.com
 * @time: 2020/7/27 15:22
 */
public class FileCopyDemo {
    private static String filePath = "src/main/resources/";

    private static void FileCopyTest() {
        Scanner sc = new Scanner(System.in);

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            System.out.print("复制文件名：");
            String fileName = sc.next();
            fis = new FileInputStream(filePath + fileName);
            fos = new FileOutputStream(filePath + fileName.split("\\.")[0] + "_copy."+fileName.split("\\.")[1]);
            byte[] bytes = new byte[fis.available()];

            if (fis.read(bytes) != -1) {
                fos.write(bytes);
                fos.flush();
                System.out.println("文件："+fileName+" 复制成功。");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FileCopyTest();
    }
}
