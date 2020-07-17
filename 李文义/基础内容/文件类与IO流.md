File类被定义为“文件和目录路径名的抽象表示形式”，这是因为File类既可以表示“文件”也可以表示“目录”，他们都通过对应的路径来描述。通过构造函数创建一个File类对象，则该对象就是指定文件的引用，可以通过该对象对文件操作。通过File对象，可以获取文件的属性值（文件大小，能否读写，最后修改时间等）。File对象不能对文件进行读取和写入的操作，如果想要对文件进行读写，那么要使用IO流。

java.io.File常用方法：
public String getAbsolutePath(): 返回此 File 的绝对路径
public String getPath(): 将此 File 转换为路径 (构造方法中的路径)
public String getName(): 返回由此 File 表示的文件或目录的名称
public long length(): 返回由此 File 表示的文件长度 (字节长度, Unicode, 中文占两个字节)
public boolean exists(): 判断此 File 表示的文件或路径是否存在
public boolean isDirectory(): 判断构造方法中的路径是否以目录结尾
public boolean isFile(): 判断构造方法中的路径是否以文件结尾
public boolean createNewFile(): 当且仅当该名称的文件不存在时, 才创建新文件 (路径错误会报错)
public boolean delete(): 删除由此 File 表示的文件或目录 (文件或目录不存在时返回 false)。直接在硬盘上刷数据, 不走回收站, 谨慎删除
public boolean mkdir(): 创建由此 File 表示的目录 (父目录不存在返回 false)
public boolean mkdirs(): 递归创建

IO流：
字节流：
InputStream常用方法：
abstract int read() // 从输入流中读取数据的下一个字节
int read(byte[] b) // 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b中
int read(byte[] b, int off, int len) // 将输入流中最多 len 个数据字节读入 byte 数组
long skip(long n) // 跳过和丢弃此输入流中数据的 n个字节
void close()	   // 关闭此输入流并释放与该流关联的所有系统资源
OutputStream常用方法：
void write(byte[] b) // 将 b.length 个字节从指定的 byte 数组写入此输出流
void write(byte[] b, int off, int len)    // 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流
abstract void write(int b)    // 将指定的字节写入此输出流
void close()    // 关闭此输出流并释放与此流有关的所有系统资源
void flush()    // 刷新此输出流并强制写出所有缓冲的输出字节

字符流：
Reader常用方法：
int read()  // 读取单个字符
int read(char[] cbuf)    // 将字符读入数组
abstract int read(char[] cbuf, int off, int len)    // 将字符读入数组的某一部分
long skip(long n)    // 跳过字符
abstract void close()    // 关闭该流并释放与之关联的所有资源
Writer常用方法：
void write(char[] cbuf)// 写入字符数组
abstract void write(char[] cbuf, int off, int len)    // 写入字符数组的某一部分
void write(int c)    // 写入单个字符
void write(String str)    // 写入字符串
void write(String str, int off, int len)    // 写入字符串的某一部分
Writer append(char c)    // 将指定字符添加到此 writer
Writer append(CharSequence csq)    // 将指定字符序列添加到此 writer
Writer append(CharSequence csq, int start, int end)    // 将指定字符序列的子序列添加到此 writer.Appendable
abstract void close()    // 关闭此流，但要先刷新它
abstract void flush()    // 刷新该流的缓冲

