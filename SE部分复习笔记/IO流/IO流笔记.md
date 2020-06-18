**IO流：**

**数据源（data
source，提供数据的原始媒介。常见的数据源有：数据库、文件、其他程序、内存、网络连接、IO设备**

**      数据源分为：源设备、目标设备。**

**      1. 源设备：为程序提供数据，一般对应输入流。**

**      2.
目标设备：程序数据的目的地，一般对应输出流。输入/输出流的划分是相对程序而言的，并不是相对数据源**

![IMG_256](media/33044baa6d28f9191266a8425bb995b9.png)

**）**

**、目的地**

输入(Input)指的是：可以让程序从外部系统获得数据(核心含义是“读”，读取外部数据)

输出(Output)指的是：程序输出数据给外部系统从而可以操作外部系统(核心含义是“写”，将数据写出到外部系统)。

流：

1.  输入流：数据流向是数据源到程序(以InputStream、Reader结尾的流)。

 2. 输出流：数据流向是程序到目的地(以OutPutStream、Writer结尾的流)。

标准步骤：

1.创建源

2.选择流

3.操作

4.释放资源

![IMG_256](media/159fc5564675e470c843aff634b4c612.png)

1.  InputStream

    1.  FileInputStream

    2.  ByteArrayInputStream（数据源和目的地是数组）

    3.  ObjectInputStream

    4.  DataInputStream（操纵基本数据类型）

    5.  BufferedInputStream

2.  OutputStream

    1.  FileoutputStream

    2.  ByteArrayOutputStream

    3.  ObjectOutputStream

    4.  DataOutputStream

    5.  PrintStream

    6.  BufferedOutputStream

3.  Reader

    1.  FileReader

    2.  InputStreamReader：转换流：将字节流转化成字符流

    3.  BufferedReader（用的多 readline）

4.  Writer

    1.  FileWriter

    2.  OutputStream Writer：转换流：将字节流转化成字符流

    3.  Buffered Writer

按处理的数据单元分类：

1.字节流：以字节为单位获取数据，命名上以Stream结尾的流一般是字节流

2.字符流：以字符为单位获取数据，命名上以Reader/Writer结尾的流一般是字符流

按处理对象不同分类：

1.节点流：可以直接从数据源或目的地读写数据File/ByteArray 系统OS释放

2. 处理流（包装流）：不直接连接到数据源或目的地，是”处理流的流”。通过对其他流的处理提高程序的性能。JVM释放

![IMG_256](media/cd459644c7949a9cb8471a0ea4cbe112.png)

节点流处于IO操作的第一线，所有操作必须通过它们进行;处理流可以对节点流进行包装，提高性能或提高程序的灵活性。

  1. InputStream/OutputStream

        字节（8 bit）流的抽象类（不可以实例化）

方法：   void close()：关闭流对象，释放相关系统资源。

  InputStream： int
read()：读取一个字节的数据，并将字节的值作为int类型返回(0-255之间的一个值)。如果未读出字节则返回-1(返回值为-1表示读取结束))

OutputStream：void write(int n)：向目的地中写入一个字节

     2. Reader/Writer

        字符流的抽象类

方法：Reader： int
read()：读取一个字符的数据，并将字节的值作为int类型返回(0-65535之间的一个值，即Unicode值)。如果未读出字节则返回-1(返回值为-1表示读取结束))

 Write： void write(int n)： 向输出流中写入一个字符。

     3.
FileInputStream/FileOutputStream（适合读取所有类型的文件(图像、视频、文本文件等）

        节点流：以字节为单位直接操作“文件（”把文件当做数据源）。

方法：int read()用while循环

 void write(int n)变为void write(byte[ ] b)/void write(byte[ ] b, int off, int
length)其中字节数组byte[] b为String.getBytes();

**import** java.io.\*;

//读

public class IOTest {

public static void main(String[] args) {

//1、创建源

File src = new File("abc.txt");// 内容是：abc//FileNotFound

//2、选择流

InputStream is =null;//异常外部声明异常内部new //IO

try {

is =new FileInputStream(src);

//3、操作 (分段读取)

byte[] flush = new byte[1024\*10];
//缓冲容器 //为了提高效率，设置缓存数组！（读取的字节数据会暂存放到该字节数组中

int len = -1; //接收长度
//len指的是本次读取的真实长度//当len等于-1时，表示已经到了文件结尾，停止读取

while((len=is.read(flush))!=-1)
{//在实际开发中通常我们根本不知道文件的内容，因此我们在读取的时候需要配合while循环使用。//若没有缓冲容器，read输出的是int类型，len表示顺序读取的每一个数据，需强制转型为char输出。//

//字节数组--\>字符串 (解码)

String str = new String(flush,0,len);//读容器

System.out.println(str);

}

} catch (Exception e) {

e.printStackTrace();

finally {

//4、释放资源 //这种写法，保证了即使遇到异常情况，也会关闭流对象。

try {

if(null!=is) {

is.close();

}

} catch (IOException e) {

e.printStackTrace();

}

}

}

}

**import** java.io.\*;

//写

public class IOTest04 {

public static void main(String[] args) {

//1、创建源

File dest = new File("dest.txt");

//2、选择流

OutputStream os =null;

try {

os = new
FileOutputStream(dest,true); // true表示内容会追加到文件末尾；false表示重写整个文件内容。

//3、操作(写出)

String msg ="IO is so easy\\r\\n";

byte[] datas =msg.getBytes(); // 字符串--\>字节数组(编码)

  /\*将缓存数组中的数据写入文件中，注意：写入的是读取的真实长度；

                 \*如果使用fos.write(datas)方法，那么写入的长度将会是1024，即缓存

                 \*数组的长度\*/

os.write(datas,0,datas.length);//容器写//datas。length等同于len

os.flush();//输出/写特有刷新

}catch(Exception e) {

e.printStackTrace();

finally{

//4、释放资源

try {

if (null != os) {

os.close();

}

} catch (IOException e) {

e.printStackTrace();

}

}

}

}

     4.
ByteArrayInputStream/ByteArrayOutputStream：内存中的”某个字节数组对象”当做数据源

        节点流：以字节为单位直接操作“字节数组对象”。

//1、创建源(读字节数组源)

**byte**[] src = "talk is cheap show me the code".getBytes();

//1、创建源（写字节数组源）

**byte**[] dest =**null**;

**byte**[] datas =msg.getBytes(); // 字符串--\>字节数组(编码)

baos.write(datas,0,datas.length);

baos.flush();

dest = baos.toByteArray();//！！！！！！！！！！！！！

1.  图片读取到字节数组

2.  、图片到程序 FileInputStream

2)、程序到字节数组 ByteArrayOutputStream

2、 字节数组写出到文件

1)、字节数组到程序 ByteArrayInputStream

2)、程序到文件 FileOutputStream

     5.
ObjectInputStream/ObjectOutputStream//读取顺序一致//读成员的时候可以instanceof

     
  处理流：以字节为单位直接操作“对象(字符串除外//可以了)”。必须将传输的对象进行序列化(把Java对象转换为字节序列的过程)与反序列化操作(把字节序列恢复为Java对象的过程)。

1. 对象流不仅可以读写对象，还可以读写基本数据类型。 oos.writeInt(12);

      2. 使用对象流读写对象时，该对象必须序列化与反序列化。

      3.
系统提供的类(如Date等)已经实现了序列化接口oos.writeObject(**new** Date());，自定义类必须手动实现序列化接口（**implements**
java.io.Serializable）。

 os = **new** FileOutputStream(**new** File("d:/bjsxt.txt"));

            bos = **new** BufferedOutputStream(os);

            oos = **new** ObjectOutputStream(bos);//Object在Buffered外边

writeObject(Object
obj)方法可对参数指定的obj对象进行序列化，把得到的字节序列写到一个目标输出流中。

readObject()方法从一个源输入流中读取字节序列，再把它们反序列化为一个对象，并将其返回。

持久化：hibernate将对象持久化实现

  只有实现了Serializable接口的类的对象才能被序列化。
Serializable接口是一个空接口，只起到标记作用。

  1. static属性不参与序列化。

      2.
对象中的某些属性如果不想被序列化，不能使用static，而是使用transient修饰。

      3. 为了防止读和写的序列化ID不一致，一般指定一个固定的序列化ID。

     6.
DataInputStream/DataOutputStream//读取顺序一致//读成员的时候可以instanceof

     
  处理流：以字节为单位直接操作（从而允许程序以与机器无关的方式从底层输入输出流中操作Java基本数据类型与字符串类型。）“基本数据类型与字符串类型”（数据源）。

dos.writeChar('a');

            dos.writeInt(10);

            dos.writeDouble(Math.random());

            dos.writeBoolean(**true**);

            dos.writeUTF("北京尚学堂");

/直接读取数据：读取的顺序要与写入的顺序一致，否则不能正确读取数据。

System.out.println("char: " + dis.readChar());

            System.out.println("int: " + dis.readInt());

            System.out.println("double: " + dis.readDouble());

            System.out.println("boolean: " + dis.readBoolean());

            System.out.println("String: " + dis.readUTF());

 7. BufferedInputStream/BufferedOutputStream

     
（缓冲流大小默认是8192字节：本身并不具有IO流的读取与写入功能） 处理流：将InputStream/OutputStream对象进行包装，增加缓存功能，提高读写效率。（缓冲流是先将数据缓存起来，然后当缓存区存满后或者手动刷新时再一次性的读取到程序或写入目的地。）

在关闭流时，应该先关闭最外层的包装流，即“后开的先关闭”

File src = **new** File("abc.txt");

InputStream is =**null**;

is =**new** BufferedInputStream(**new** FileInputStream(src));

8. PrintStream/ PrintWriter

        处理流：将OutputStream进行包装，可以方便地输出字符，更加灵活。

PrintStream ps=System.out;

ps.println(“xx”)；

>   ps1=new PrintStream (new BufferOutputStream(new
>   FileOutputStream(“print.txt”,true)));//true相当于flush

ps1.println(“yy”)；

//重定向输出端

>   System.SetOut（ps1）；

>   System.out.println（“zz”）；

>   //重定向会控制台

>   System.SetOut（new PrintStream (new BufferOutputStream(new
>   FileOutputStream(FileDescriptor.out,true))）；

8. FileReader/FileWriter

        节点流：以字符为单位直接操作“文本文件”(注意：只能读写文本文件)。

**char**[] flush = **new char**[1024]; //缓冲容器

读：

String str = **new** String(flush,0,len);////字符数组--\>字符串

写：

**1.char**[] datas =*msg*.toCharArray(); // 字符串--\>字符数组

2.writer.write(msg); writer.write("add");

3.writer.append("IO is so easy\\r\\n").append("尚学堂欢迎你");

 9. InputStreamReader/OutputStreamWriter

       （ 转换流）处理流：将字节流对象转化成字符流对象。

  System.in是字节流对象，代表键盘的输入，如果我们想按行接收用户的输入时，就必须用到缓冲字符流BufferedReader特有的方法readLine()，但是经过观察会发现在创建BufferedReader的构造方法的参数必须是一个Reader对象，这时候我们的转换流InputStreamReader就派上用场了。

 
 而System.out也是字节流对象，代表输出到显示器，按行读取用户的输入后，并且要将读取的一行字符串直接显示到控制台，就需要用到字符流的write(String
str)方法，所以我们要使用OutputStreamWriter将字节流转化为字符流。

BufferedReader reader = **new** BufferedReader(**new**
InputStreamReader(System.*in*));

BufferedWriter writer =**new** BufferedWriter(**new**
OutputStreamWriter(System.*out*));

String str = reader.readLine();

            // 一直读取，直到用户输入了exit为止

            **while** (!"exit".equals(str)) {

                // 写到控制台

                writer.write(str);

               writer.newLine();// 写一行后换行

               writer.flush();// 手动刷新

                // 再读一行 不读会重复你好

                str = br.readLine();

String msg ="";

while(!msg.equals("exit")) {

msg = reader.readLine(); //循环读取

writer.write(msg); //循环写出

writer.newLine();

writer.flush(); //强制刷新

}

     10. BufferedReader/BufferedWriter

        处理流：将Reader/Writer对象进行包装，增加缓存功能，提高读写效率。

BufferedReader提供了更方便的readLine()方法，直接按行读取文本   

BufferedWrite在复制write()完要newLine()//下次写入之前先换行，否则会在上一行后边继续追加，而不是另起一行

 String temp = "";

            **while** ((temp = br.readLine()) != **null**) {

                             bw.write(temp); 

                 bw.newLine();

}
