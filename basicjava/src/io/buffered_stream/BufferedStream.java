package io.buffered_stream;

import java.io.*;

//设计一个方法，用于移除Java文件中的注释
//
//public void removeComments(File javaFile)

//        比如，移出以//开头的注释行
//
//        File f = new File("d:/LOLFolder/LOL.exe");
//        System.out.println("当前文件是：" +f);
////文件是否存在
//        System.out.println("判断是否存在："+f.exists());
////是否是文件夹
//        System.out.println("判断是否是文件夹："+f.isDirectory());
public class BufferedStream {
    public void removeComments(File javaFile){
        File f_out = new File("./src/io/buffered_stream/TestOut");
        try(
                FileReader fr = new FileReader(javaFile);
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter(f_out);
                PrintWriter pw = new PrintWriter(fw);
        ){
            String line;
            String line_trim;
            while ((line = br.readLine()) != null){
                line_trim = line.trim();
                if (line_trim.startsWith("//")){
                    continue;
                }
                pw.println(line);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File f = new File("./src/io/buffered_stream/TestIn.java");
        BufferedStream bs = new BufferedStream();
        bs.removeComments(f);
    }
}
