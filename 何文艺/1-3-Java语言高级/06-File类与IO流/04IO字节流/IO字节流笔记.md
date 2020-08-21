**IO字节流笔记**  

----------


**一、IO概述（概念和分类）**  
输入：把【硬盘】中的数据，读取到【内存】中使用  
输出：把【内存】中的数据，写入到【硬盘】中保存  

                    输入流          输出流
    字节流          字节输入流      字节输出流
                    InputStream     OutputStream
    
    字符流          字符输入流      字符输出流
                    Reader          Writer

**二、一切皆为字节**  
一切文件数据（文本、图片、视频等）在存储时，都是以二进制数字的形式保存，传输的时候也是以二进制的形式传输  
因此，字节流可以传输任意文件数据  

**三、字节输出流_OutputStream类和FileOutputStream类**  
java.io.OutputStream：此抽象类是表示输出字节流的所有类的超类；定义了一些子类共性的成员方法  

    1.public void close()：关闭此输出流并释放与此流相关联的任何系统资源
    
    2.public void flush()：属性此输出流并强制任何缓冲的数据字节被写出
    
    3.public void write(byte[] b)：将b.length字节从指定的字节数组写入此输出流
    
    4.public void write(byte[] b, int off, int len)：从指定的字节数组写入len字节，从偏移量off开始输出到此输出流
    
    5.public abstract void write(int b)：将指定的字节输出流

java.io.FileOutputStream extends OutputStream：文件字节输出流  
作用：把内存中的数据写入到硬盘的文件中  
构造方法：   

    FileOutputStream(String name)
    FileOutputStream(File file)
    参数：写入数据的目的地
        String name：文件的路径
        File file：文件

构造方法的作用：   
    1.创建一个FileOutputStream对象  
    2.会根据构造方法中传递的文件/文件路径创建一个空的文件  
    3.会把FileOutputStream对象指向创建好的文件  

**四、字节输出流写入数据到文件**  
1.写入数据的原理（内存->硬盘）：java程序 -> JVM -> OS -> OS调用写数据的方法 -> 把数据写入到文件中  
2.字节输出流的使用步骤【重点】：  
a.创建一个FileOutputStream对象，构造方法中传递写入数据的目的地  
b.调用FileOutputStream对象中的write方法，把数据写入到文件中  
c.释放资源（流使用会占用一定的内存，使用完毕要把内存清空，提高程序的效率）  

**五、文件存储的原理和记事本打开文件**  
硬盘中存储的数据都是字节  
在写数据的时候，会把数据转换成相应的二进制表示形式进行写入并存储  
任意的文本编辑器（记事本、notepad++）在打开文件的时候，都会查询编码表，把字节转换为字符表示  
0-127：查询ASCII码表  
其他值：查询系统默认码表（中文系统GBK）  

例：写入97，在记事本中打开是a  

**六、字节输出流写多个字节的方法**  

    1.public void write(byte[] b)：将b.length字节从指定的字节数组写入此输出流
        如果写的第一个字节是正数（0-127），那么显示的时候会查询ASCII码表
        如果写的第一个字节是负数，那么第一个字节会和第二个字节组成一个中文显示，查询系统默认码表
    2.public void write(byte[] b, int off, int len)：从指定的字节数组写入len字节，从偏移量off开始输出到此输出流
        把字节数组的一部分写入到文件中
        int off：数组的开始索引
        int len：写几个字节

写入字符的方法：可以使用String类中的方法，把字符串转换为字节数组  
UTF-8：3个字节是一个中文  
GBK：2个字节是一个中文  

**七、字节输出流的续写和换行**    
1.续写：使用两个参数的构造方法  

    a.FileOutputStream(String name, boolean append)：创建一个向具有指定name的文件中写入数据的输出文件流
    b.FileOutputStream(File file, boolean append)：创建一个向指定file对象表示的文件中写入数据的输出文件流
    参数：
        String name，File file：写入数据的目的地
        boolean append：追加写开关；如果为true，则创建对象不会覆盖原文件，继续在文件的末尾追加写数据
                                   如果为false，则会创建一个新文件，覆盖原文件

2.写换行：写换行符  
windows：\r\n  
linux：/n  
mac：/r  

**八、字节输入_InputStream类和FileInputStream类**  
java.io.InputStream类：此抽象类是表示字节输入流的所有类的超类；定义了一些子类共性的成员方法  

    1.int read()：从输入流中读取数据的下一个字节
    
    2.int read(byte[] b)：从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中
    
    3.void close()：关闭此输入流并释放与该流关联的所有系统资源

java.io.FileInputStream extends InputStream：文件字节输入流  
作用：把硬盘文件中的数据，读取到内存中使用  
构造方法：  

    FileInputStream(String name)
    FileInputStream(File file)
    参数：读取文件的数据源
        String name：文件的路径
        File file：文件对象

构造方法的作用：  
1.创建一个FileInputString对象  
2.会把FileInputString对象指向构造方法中要读取的文件  

**九、字节输入流读取字节数据**  
1.读取数据的原理（硬盘 -> 内存）：java程序 -> JVM -> OS -> OS调用读取数据的方法 -> 读取文件  
2.字节输入流的使用步骤【重点】：  
a.创建FileInputString对象，构造方法中绑定要读取的数据源  
b.使用FileInputString对象中的方法read，读取文件  
c.释放资源  

**十、字节输入流一次读取一个字节的原理\***  

**十一、字节输入流一次读取多个字节**  
int read(byte[] b)：从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中  
明确两件事情：  
1.方法的参数byte[]的作用：起到缓冲作用，存储每次读取到的多个字节；数组的长度一般定义为1024（1kb）或者1024的整数倍  
2.方法的返回值int是什么：每次读取的有效字节个数  

String类的构造方法：  
String(byte[] bytes)：把字节数组转换为字符串  
String(byte[] bytes, int offset, int length)：把字节数组的一部分转换为字符串；offset--数组的开始索引，length--转换的字节个数  

**十二、练习_文件复制**  

    package stream;
    
    import java.io.File;
    import java.io.FileInputStream;
    import java.io.FileOutputStream;
    import java.io.IOException;
    
    public class CopyImg {
        public static void main(String[] args) throws IOException {
            //1.创建字节输入输出流对象
            FileInputStream fis = new FileInputStream(new File("E:\\IdeaProjects\\basic-code\\day0814-code\\src\\stream\\before\\image.jpg"));
            FileOutputStream fos = new FileOutputStream(new File("E:\\IdeaProjects\\basic-code\\day0814-code\\src\\stream\\after\\image.jpg"));
            //2.将图片从硬盘读取到内存中
            byte[] bytes = new byte[1024];
            int len = 0;
            while (-1 != (len = fis.read(bytes))) {
                //3.将图片从内存读取到硬盘中
                fos.write(bytes);
            }
            fos.close();
            fis.close();
        }
    }

注意：关闭流的时候要先关闭输出流再关闭输入流（因为写入完毕的时候，肯定就读取完毕了）  

**十三、使用字节流读取中文的问题**  
当使用字节流读取文本文件时，可能会有一个小问题，就是遇到中文字符时，可能不会显示完整的字符，那是因为一个中文字符可能占用多个字节存储；因此java提供一些字符流类，以字符为单位读写数据，专门用于处理文本文件  




