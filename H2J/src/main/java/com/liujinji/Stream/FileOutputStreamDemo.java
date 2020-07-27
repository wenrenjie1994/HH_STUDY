package com.liujinji.Stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: liujinji0452@gmail.com
 * @time: 2020/7/27 14:45
 */

public class FileOutputStreamDemo {
    private static String fileName = "src/main/resources/writeDemo.txt";

    private static void FileOutputStreamTest01() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName, true); // 在FOS构造时加上true/false, 代表追加或清空重建，默认false
            String cnStr = "写入中文字符串";
            byte[] bytes = cnStr.getBytes();
            fos.write(bytes);

            fos.flush();// 写入完毕后一定要刷新
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FileOutputStreamTest01();
    }
}
