**IO字符流笔记**  

----------


**一、字符输入流Reader类和FileReader类**  
java.io.Reader：是字符输入流的最顶层的父类，定义了一些共性的成员方法，是一个抽象类  
共性的成员方法：  

    1.int read()：读取单个字符并返回字符个数
    
    2.int read(char[] cubf)：一次读取多个字符，将字符读入数组
    
    3.void close()：关闭并释放与之关联的所有资源

java.io.FileReader extends InputStreamReader extends Reader  
FileReader：文件字符输入流  
作用：把硬盘文件中的数据以【字符】的方式读取到内存中  
构造方法：  

    FileReader(String filename)
    FileReader(File file)
    参数：读取文件的数据源
        String filename：文件的路径
        File file：文件

构造方法的作用：  
1.创建一个FileReader对象  
2.会把FileReader对象指向要读取的文件  

**二、字符输入流读取字符数据**  
步骤：  
1.创建一个FileReader对象，构造方法中绑定要读取的数据源  
2.使用FileReader对象中的方法read读取文件  
3.释放资源  

String类的构造方法：  
1.String(char[] value)：把字符数组转换为字符串  
2.String(char[] value, int offset, int count)：把字符数组的一部分转换为字符串  

**三、字符输出流Writer类和FileWriter类**  
java.io.Writer：是字符输出流的最顶层的父类，定义了一些共性的成员方法，是一个抽象类  
共性的成员方法：  

    1.void write(int c)：写入单个字符  
    
    2.void write(char[] cbuf)：写入字符数组
    
    3.abstract void write(char[] cbuf, int off, int len)：写入字符数组的某一部分；off--数组的开始索引，len--写的字符个数
    
    4.void write(String str)：写入字符串
    
    5.void write(String str, int off, int len)：写入字符串的某一部分；off--字符串的开始索引，len--写的字符个数
    
    6.void flush()：刷新该流的缓冲
    
    7.void close()：关闭此流，但要先刷新它

java.io.FileWriter extends OutputStreamWriter extends Writer  
FileWriter：文件字符输出流  
作用：把内存中的字符数据写入到文件中  

构造方法：  

    FileWriter(File file)：根据给定的File对象构造一个FileWriter对象
    FileWriter(String filename)：根据给定的文件名构造一个FileWriter对象
    参数：写入数据的目的地
        String filename：文件的路径
        File file：文件

构造方法的作用：  
1.会创建一个FileWriter对象  
2.会根据构造方法中传递的文件/文件的路径，创建文件  
3.会把FileWriter对象指向创建好的文件  

**四、字符输出流的基本使用_写出单个字符**  
步骤：  
1.创建一个FileWriter对象，构造方法中绑定要写入数据的目的地  
2.使用FileWriter中的方法write，把数据写入到内存缓冲区中（字符转换为字节）  
3.使用FileWriter中的方法flush，把内存缓冲区中的数据，刷新到文件中  
4.释放资源（会把内存缓冲区中的数据刷新到文件中）  

**五、flush方法和close方法的区别**  
flush：刷新缓冲区，流对象可以继续使用  
close：先刷新缓冲区，然后通知系统释放资源，流对象不可以再继续使用了  

**六、字符输出流写数据的其他方法**  

**七、使用try_catch_finally处理流中的异常**  
在JDK1.7之前使用try_catch_finally处理流中的异常  
格式：  

    try {
        //可能会产生异常的代码
    } catch(异常类的变量 变量名) {
        //异常的处理逻辑
    } finally {
        //一定会指定的代码
        //资源释放
    }

CopyImg.java改进  

```java
package stream;

import java.io.*;

public class CopyImg {
    public static void main(String[] args){
        //1.创建字节输入输出流对象
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(new File("E:\\IdeaProjects\\basic-code\\day0814-code\\src\\stream\\image1.jpg"));
            fos = new FileOutputStream(new File("E:\\IdeaProjects\\basic-code\\day0814-code\\src\\stream\\image2.jpg"));
            //2.将图片从硬盘读取到内存中
            byte[] bytes = new byte[1024];
            int len = 0;
            while (-1 != (len = fis.read(bytes))) {
                //3.将图片从内存读取到硬盘中
                fos.write(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
}
```

**八、JDK7和JDK9流中异常的处理（暂不了解）**  