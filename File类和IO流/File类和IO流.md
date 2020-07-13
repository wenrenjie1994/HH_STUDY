##File类
  - 什么是File类<br>
  文件和目录路径名的抽象表示形式，File类的实例不可变
  - File类的三个关键字：
    1) path--路径
    2) file--文件
    3) dir（Directory）--文件夹(目录)

  - 路径:
    1) 绝对路径：固定不可修改的路径。以盘符开头
    2) 相对路径：相对某个参照物，不能以盘符开头

##IO流
  - 什么是I/O流<br>
  用来处理设备之间的数据传输，其相对于内存设备而言。`I:Input`输入流就是将外设中的数据读取到内存中;`O:Output`输出流是将内存的数写入到外设中。`IO流的使用一定要有开有关`
    
  - IO流的分类:
    - 流按流向分为：输入流，输出流
    - 按流的内容来分：字节流，字符流
    ```
    注1：字符和字节
      a、字节是一种计量单位，表示数据量多少，它是计算机信息技术用于计量存储容量的一种计量单位。
      b、字符是指计算机中使用的文字和符号，比如1、2、3、A、B、C、~！·#￥%……—*（）——+、等等。
      根据编码表的不同，字符与字节的对应关系也不同，
    注2：字符流和字节流的关系
      字符流==字节流+编码表
      字节流的两个顶层父类：inputStream,outputStream。
      字符流的两个顶层父类：Reader,Writer。
      这些体系的子类都以父类名为后缀，而子类名的前缀就是该对象的功能：xxxinputStream/outputStream(xxx字节流)xxxReader/Writer(xxx字符流)
    ```
  - IO流的体系结构：
    ```
    四个顶层父类：
      字节输入流：InputStream
      字节输出流：OutputStream
      字符输入流：Reader
      字符输出流：Writer
    常用子类：
      文件字节输入/输出流：
        FileInputStream
        FileOutputStream
      文件字符输入/输出流:
        FileReader
        FileWriter
    ```   
  - 流的操作规律
    - 1、明确目的：<br>
      - 确定目的是字节流(OutputStream)还是字符流(Writer);<br>
      - 根据目的确定源(InputStream)/(Reader)
      ```
      注：
        a、在确定目的后，根据源是否字符流确定是否需要用到转换流
        b、源文件的字符若固定是utf-8则不需要，若是不是utf-8的字符则需要用转换流(eg：windows创建的文本是gbk编码的，读取时需要gbk的方式才能成功读取到需要的字符)                   】
      ```
    - 2、明确缓冲区【给基本字符/字节流添加一个缓冲区，增加读写效率】
      - 根据目的是字节还是字符选择BufferedReader还是BufferedInputStream,保证缓冲区前后一致，通常建立byte[]或者char[]来进行读、写
      ```
      关于缓冲区读数据：
        如果要逐行读取数据，只能采用BufferedReader,
        可以用转换流将字节转换成字符，然后用字符的方式逐行读取】
      关于缓冲区写数据：
        字符流:write(char[] ch,int start, int len);
        字节流:write(byte[] bt,int start, int len);
      注：
         a、若写的对象是字符串
           字符数组char[] == "xxx".toCharArray();
           字节数组byte[] == "xxx".getBytes();
           若是字符流对象，可以直接write(String str);
         b、写换行符：
           write("\r\n".getBytes());
      ```
    - 3、明确操作对象
      ```
      源：
        键盘：File
        硬盘: System.in
        内存: 数组
        网络：Socket流(Socket对象.getIn/OutputStream())
      目的：
        硬盘：File
        控制台：System.out
        内存:数组
        网络：Socket流(Socket对象.getIn/OutputStream())
      注：
        若读取的Socket流，则相当于inputStream=Socket对象.getInputStream()
        该流对象与File等对象不同，其自身没有结束标记。因此其他对象read()该流则会发生阻塞
        因此在写该流对象时，在写完数据后要多写一个结束标记，
        通常是用socket去结束流的传输：即socket对象.shutdownOutput
      ```
##commons_io组件
```
Apache提供的commons_io组件下
 *  FileUtils：操作文件的工具类【参数类型(操作对象)都是File】
 *  static String readFileToString(File file)：读取文件内容，返回String
 *  static void writeStringToFile(File file, String date)：将内容content写入到file中
 *  static void copyFile(File srcFile, File descFile)：文件复制
 *  static void copyDirectoryToDirectory(File srcDir, File descDir)：文件夹复制
```
