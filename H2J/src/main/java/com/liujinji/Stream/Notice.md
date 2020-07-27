# IOStream
## 分类
1. 按照流向分
- 输入流：硬盘->内存，读
- 输出流：硬盘<-内存，写

2. 按照流方式
- 字节流：按照字节方式读取数据，一次读1byte，遇到中文字符一次读不完，可读任何文件。
- 字符流：按照字符读，一次读一个字符（中/英），仅可读文本文件。

3. 四大家族（Stream结尾为字节流，Reader/Writer结尾为字符流）
- java.io.InputStream
- java.io.OutputStream
- java.io.Reader
- java.io.Writer

tips:
- 所有的流都实现了`java.io.closeable`，所以用完流后要及时关闭。
- 所有的输出流都实现了`java.io.flushable`，输出流在输出完毕后应调用`flush()`方法强制输出管道中剩余的数据，避免写时不完整。

4. `java.io.*`下常用的流
- 文件类流：
    - `java.io.InputStream`
    - `java.io.OutputStream`
    - `java.io.FileReader`
    - `java.io.FileWriter`
- 转换流（字节流转换成字符流）：  
    - `java.io.InputStreamReader`
    - `java.io.OutputStreamWriter`
- 缓冲流：
    - `java.io.BufferedReader`
    - `java.io.BufferedWriter`
    - `java.io.BufferedInputStream`
    - `java.io.BufferedOuputStream`
- 数据流：
    - `java.io.DataInputStream`
    - `java.io.DataOutputStream`
    - `java.io.PrintWriter`
    - `java.io.PrintStream`
- 对象流：
    - `java.io.ObjectInputStream`
    - `java.io.ObjectOutputStream`