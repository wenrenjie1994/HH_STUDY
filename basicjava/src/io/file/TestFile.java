package io.file;
//一般说来操作系统都会安装在C盘，所以会有一个 C:\WINDOWS目录。
//
//        遍历这个目录下所有的文件(不用遍历子目录)
//
//        找出这些文件里，最大的和最小(非0)的那个文件，打印出他们的文件名

import java.io.File;

public class TestFile {
    //获取所有文件
    public File[] eumFile(File file){
        return file.listFiles();
    }
    //找到最小文件
    public void minFile(File[] fs){
        File min_file = fs[0];
        for (File f: fs){
            if (min_file.length() == 0){
                min_file = f;
            }
            if (f.length() > 0 && f.length() < min_file.length()){
                min_file = f;
            }
        }
        System.out.println("最小文件是：" + min_file + "大小是：" + min_file.length() + "字节");
    }

    //找到最大文件
    public void maxFile(File[] fs){
        File max_file = fs[0];
        for(File f: fs){
            if(f.length() > max_file.length()){
                max_file = f;
            }
        }
        System.out.println("最大文件是：" + max_file + "大小是：" + max_file.length() + "字节");
    }

    public static void main(String[] args) {
        File f = new File("C:\\WINDOWS");
        TestFile tf = new TestFile();
        tf.minFile(tf.eumFile(f));
        tf.maxFile(tf.eumFile(f));
    }
}
