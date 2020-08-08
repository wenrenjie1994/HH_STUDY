## **四大IO抽象类**

InputStream/OutputStream和Reader/writer类是所有IO流类的抽象父类，我们有必要简单了解一下这个四个抽象类的作用。然后，通过它们具体的子类熟悉相关的用法。

**·InputStream**

   此抽象类是表示字节输入流的所有类的父类。InputSteam是一个抽象类，它不可以实例化。 数据的读取需要由它的子类来实现。根据节点的不同，它派生了不同的节点流子类 。

   继承自InputSteam的流都是用于向程序中输入数据，且数据的单位为字节(8 bit)。

   **常用方法：**

   int read()：读取一个字节的数据，并将字节的值作为int类型返回(0-255之间的一个值)。如果未读出字节则返回-1(返回值为-1表示读取结束)。

   void close()：关闭输入流对象，释放相关系统资源。

**· OutputStream**

   此抽象类是表示字节输出流的所有类的父类。输出流接收输出字节并将这些字节发送到某个目的地。

   **常用方法：**

   void write(int n)：向目的地中写入一个字节。

   void close()：关闭输出流对象，释放相关系统资源。

**· Reader**

   Reader用于读取的字符流抽象类，数据单位为字符。

   int read(): 读取一个字符的数据，并将字符的值作为int类型返回(0-65535之间的一个值，即Unicode值)。如果未读出字符则返回-1(返回值为-1表示读取结束)。

   void close() ： 关闭流对象，释放相关系统资源。

**· Writer**

   Writer用于写入的字符流抽象类，数据单位为字符。

   void write(int n)： 向输出流中写入一个字符。

   void close() ： 关闭输出流对象，释放相关系统资源。





## **Java中流的概念细分**

**按流的方向分类：**

   1. 输入流：数据流向是数据源到程序(以InputStream、Reader结尾的流)。

2. 输出流：数据流向是程序到目的地(以OutPutStream、Writer结尾的流)。

![图10-5 输入输出流示意图.png](https://www.sxt.cn/360shop/Public/admin/UEditor/20170525/1495702185421118.png)

输入/输出流示意图

**按处理的数据单元分类：**

1. 字节流：以字节为单位获取数据，命名上以Stream结尾的流一般是字节流，如FileInputStream、FileOutputStream。

2. 字符流：以字符为单位获取数据，命名上以Reader/Writer结尾的流一般是字符流，如FileReader、FileWriter。

**按处理对象不同分类：**

1. 节点流：可以直接从数据源或目的地读写数据，如FileInputStream、FileReader、DataInputStream等。

2. 处理流：不直接连接到数据源或目的地，是”处理流的流”。通过对其他流的处理提高程序的性能，如BufferedInputStream、BufferedReader等。处理流也叫包装流。

   节点流处于IO操作的第一线，所有操作必须通过它们进行;处理流可以对节点流进行包装，提高性能或提高程序的灵活性。

![图10-6 节点流处理流示意图.png](https://www.sxt.cn/360shop/Public/admin/UEditor/20170525/1495702229684292.png)

节点流/处理流示意图 





## 文件字节流

### 代码示例

* 读文件
* 写文件
* 复制一个文件

```java

public static void readFile(){
        try {
            FileInputStream in = new FileInputStream("testIO.txt");
            //定义容器来接收读取的数据
            byte[] b = new byte[1024];
            //定义读取的长度
            int len = 0;
            //in.read会在读取到最后一位后再读一位 然后返回-1
            while ((len = in.read(b))!=-1){
                System.out.println(new String(b,0,len));
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void writeFile(){
        try {
            FileOutputStream out = new FileOutputStream("/Users/lafeier/IdeaProjects/myJava/testIo.txt");
            String s = "test";
            //把数据先写到内存
            out.write(s.getBytes());
            //把内存数据刷到硬盘
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 读取一个文件复制到另一个路径
     * @param inPath 读取的路径
     * @param outPath 复制到的路径
     */
    public static void copyFile(String inPath, String outPath){
        try {
            //读取源文件
            FileInputStream in = new FileInputStream(inPath);
            //写入文件
            FileOutputStream out = new FileOutputStream(outPath);

            //创建储存读取的数据的容器
            byte[] b =new byte[1024];
            //读取数据的长度
            int len = 0;
            //写到内存
            while ((len = in.read(b))!= -1){
                out.write(b,0,len);
            }
            //关闭流 后开的先关
            out.flush();
            out.close();
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```



## 缓冲字节流

是基于内存的IO流，就是先把数据缓冲到内存里，然后在内存中做IO操作，这样就比较快，大概比基于硬盘的IO操作快75000多倍

* BufferedInputStream
* BufferedOutoutStream
* BufferedWriter
* BufferedReader



操作：操作方式一样，但是需要把InputSteam的子类放入BufferedInputStream,其他方式一样

```java
    FileInputStream in = new FileInputStream("testIO.txt");
    BufferedInputStream br = new BufferedInputStream(in);
		//其他操作一样，同FileInputStream
```


## 标准输入和输出流

+ system.in 的类型是InputStream

+ system.out的类型是printStream



```java
/**
 * 将键盘输入的内容写入文件里
 * @param outPath
 */
public static void keyboardInput(String outPath) throws Exception {
    // 读文件
    InputStreamReader is = new InputStreamReader(System.in);
    //把输入流放入缓冲流
    BufferedReader br = new BufferedReader(is);

    //输出流
    BufferedWriter out = new BufferedWriter(new FileWriter(outPath));
    String line = "";
    while ((line = br.readLine())!=null){
        if (line.equals("over")){
            break;
        }
        out.write(line);
    }
    //把内存的数据刷入硬盘
    out.flush();
    out.close();
    br.close();
    is.close();

}
```



## 对象流

1. static属性不参与序列化。

2. 对象中的某些属性如果不想被序列化，不能使用static，而是使用transient修饰。

3. 为了防止读和写的序列化ID不一致，一般指定一个固定的序列化ID。

