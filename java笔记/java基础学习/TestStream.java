
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.util.Scanner;

public class TestStream {

    // 建立文件输入流
    // public static void main(String[] args) {
    // try {
    // File f = new File("d:/lol.txt");
    // // 创建基于文件的输入流
    // FileInputStream fis = new FileInputStream(f);
    // // 通过这个输入流，就可以把数据从硬盘，读取到Java的虚拟机中来，也就是读取到内存中

    // } catch (IOException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }

    // 以字节流的形式读取文字内容
    // public static void main(String[] args) {
    // try {
    // File f = new File("F:/JavaWorkplace/lol.txt");
    // // 创建基于文件的输入流
    // FileInputStream fis = new FileInputStream(f);
    // // 创建字节数组，其长度就是文件的长度
    // byte[] all = new byte[(int) f.length()];
    // // 以字节流的形式读取所有内容
    // fis.read(all);
    // for (byte b : all) {
    // System.out.print(b+" ");
    // }

    // //每次使用完流，都应该进行关闭
    // fis.close();
    // } catch (Exception e) {
    // // TODO: handle exception
    // e.printStackTrace();
    // }
    // }

    // 以字节流的形式向文件写入数据
    // public static void main(String[] args) {
    // try {
    // // 准备文件lol2.txt其中的内容是空的
    // File f = new File("F:/JavaWorkplace/lol2.txt");
    // // 准备长度是2的字节数组，用88,89初始化，其对应的字符分别是X,Y
    // byte data[] = { 88, 89 };

    // // 创建基于文件的输出流
    // FileOutputStream fos = new FileOutputStream(f);
    // // 把数据写入到输出流
    // fos.write(data);
    // // 关闭输出流
    // fos.close();

    // } catch (IOException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }

    // 在try的作用域里关闭文件输入流，
    // 在前面的示例中都是使用这种方式，这样做有一个弊端；
    // 如果文件不存在，或者读取的时候出现问题而抛出异常，
    // 那么就不会执行这一行关闭流的代码，存在巨大的资源占用隐患。
    // 不推荐使用

    // 标准的关闭流的方式：使用finally进行关闭
    // public static void main(String[] args) {
    // File f = new File("F:/JavaWorkplace/lol.txt");
    // FileInputStream fis = null;
    // try {
    // fis = new FileInputStream(f);
    // byte[] all = new byte[(int) f.length()];
    // fis.read(all);
    // for (byte b : all) {
    // System.out.println(b);
    // }

    // } catch (IOException e) {
    // e.printStackTrace();
    // } finally {
    // // 在finally 里关闭流
    // if (fis != null)
    // try {
    // fis.close();
    // } catch (IOException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    // }

    // 使用try()进行关闭
    // public static void main(String[] args) {
    // File f = new File("F:/JavaWorkplace/lol.txt");

    // // 把流定义在try()里,try,catch或者finally结束的时候，会自动关闭
    // try (FileInputStream fis = new FileInputStream(f)) {
    // byte[] all = new byte[(int) f.length()];
    // fis.read(all);
    // for (byte b : all) {
    // System.out.println(b);
    // }
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }

    // 使用字符流读取文件
    // public static void main(String[] args) {
    // File f = new File("F:/JavaWorkplace/lol.txt");
    // try (FileReader fr = new FileReader(f)) {
    // char[] all = new char[(int) f.length()];
    // fr.read(all);
    // for (char b : all) {
    // System.out.print(b);
    // }
    // } catch (Exception e) {
    // // TODO: handle exception
    // e.printStackTrace();
    // }
    // }

    // // 使用字符流把字符串写入到文件
    // public static void main(String[] args) {
    // File f = new File("F:/JavaWorkplace/lol2.txt");
    // try(FileWriter fw = new FileWriter(f)) {
    // String data = "abcdefg";
    // char[] cs = data.toCharArray();
    // fw.write(cs);
    // } catch (Exception e) {
    // //TODO: handle exception
    // e.printStackTrace();
    // }
    // }

    // 使用缓存流读取数据，一次读取一行数据
    // public static void main(String[] args) {
    // File f = new File("F:/JavaWorkplace/lol.txt");
    // try (FileReader fr = new FileReader(f); BufferedReader br = new
    // BufferedReader(fr);) {
    // while(true){
    // String line = br.readLine();
    // if(line == null)
    // break;
    // System.out.println(line);
    // }
    // } catch (Exception e) {
    // // TODO: handle exception
    // e.printStackTrace();
    // }
    // }

    // // 使用缓存流写入数据，一次写入一行数据
    // public static void main(String[] args) {
    // File f = new File("F:/JavaWorkplace/lol2.txt");
    // try(FileWriter fw = new FileWriter(f);PrintWriter pw = new PrintWriter(fw);){
    // pw.println("garen kill teemo");
    // pw.println("teemo revive after 1 minutes");
    // pw.println("teemo try to garen, but killed again");
    // }catch(Exception e){
    // e.printStackTrace();
    // }
    // }

    // 有的时候，需要立即把数据写入到硬盘，
    // 而不是等缓存满了才写出去。 这时候就需要用到flush
    // public static void main(String[] args) {
    // // 向文件lol2.txt中写入三行语句
    // File f = new File("F:/JavaWorkplace/lol2.txt");
    // // 创建文件字符流
    // // 缓存流必须建立在一个存在的流的基础上
    // try (FileWriter fr = new FileWriter(f); PrintWriter pw = new
    // PrintWriter(fr);) {
    // pw.println("garen kill teemo");
    // // 强制把缓存中的数据写入硬盘，无论缓存是否已满
    // pw.flush();
    // pw.println("teemo revive after 1 minutes");
    // pw.flush();
    // pw.println("teemo try to garen, but killed again");
    // pw.flush();
    // } catch (IOException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }

    // public static void main(String[] args) {
    // write();
    // read();
    // }

    // private static void read() {
    // File f = new File("F:/JavaWorkplace/lol2.txt");
    // try (FileInputStream fis = new FileInputStream(f); DataInputStream dis = new
    // DataInputStream(fis);) {
    // boolean b = dis.readBoolean();
    // int i = dis.readInt();
    // String str = dis.readUTF();

    // System.out.println("读取到布尔值:" + b);
    // System.out.println("读取到整数:" + i);
    // System.out.println("读取到字符串:" + str);

    // } catch (IOException e) {
    // e.printStackTrace();
    // }

    // }

    // private static void write() {
    // File f = new File("F:/JavaWorkplace/lol2.txt");
    // try (FileOutputStream fos = new FileOutputStream(f); DataOutputStream dos =
    // new DataOutputStream(fos);) {
    // dos.writeBoolean(true);
    // dos.writeInt(300);
    // dos.writeUTF("123 this is gareen");
    // } catch (IOException e) {
    // e.printStackTrace();
    // }

    // }

    // System.in可以从控制台输入数据
    // public static void main(String[] args) {
    // // 控制台输入
    // try (InputStream is = System.in;) {
    // while (true) {
    // // 敲入a,然后敲回车可以看到
    // // 97 13 10
    // // 97是a的ASCII码
    // // 13 10分别对应回车换行
    // int i = is.read();
    // System.out.println(i);
    // }
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }

    // Scanner读取字符串
    // public static void main(String[] args) {

    // Scanner s = new Scanner(System.in);

    // while (true) {
    // String line = s.nextLine();
    // System.out.println(line);
    // }
    // }

    // Scanner从控制台读取整数
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        System.out.println("第一个整数：" + a);
        int b = s.nextInt();
        System.out.println("第二个整数：" + b);
    }
}