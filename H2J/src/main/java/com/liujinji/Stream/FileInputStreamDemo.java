package com.liujinji.Stream;
/**
 * @author: liujinji0452@gmail.com
 * @time: 2020/7/19 14:20
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// 文件字节输入流，所有文件都可以使用
public class FileInputStreamDemo {
    private static String fileName = "src/main/resources/test.java";

    private static void FileInputStreamTest01() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
            int readData = 0;
            // 一次循环只读取一个字节，效率较低。
            while ((readData = fis.read()) != -1) {
                System.out.println(readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void FileInputStreamTest02() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
            byte[] bytes = new byte[4];
            int readCount = 0;
            while ((readCount = fis.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, readCount));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void FileInputStreamTest03() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
            byte[] bytes = new byte[4];
            int readCount = 0;
            while ((readCount = fis.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, readCount));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void FileInputStreamUtil() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
            System.out.println("总字节数量：" + fis.available());
            byte[] bytes = new byte[fis.available()];
            while ((fis.read(bytes)) != -1) {
                System.out.println(new String(bytes));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public static void main(String[] args) {
        FileInputStreamUtil();
    }
}
