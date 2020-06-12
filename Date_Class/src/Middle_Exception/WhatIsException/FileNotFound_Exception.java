package Middle_Exception.WhatIsException;

/**
 * @Author lee
 * @Date 2020/6/11 9:14 PM
 * 不处理文件不存在异常，编译不通过
 **/
import java.io.File;
import java.io.FileInputStream;

public class FileNotFound_Exception {
    public static void main(String[] args) {
        File f = new File("/Download/1.txt");
        //该文件不存在
        // new FileInputStream(f);
    }
}
