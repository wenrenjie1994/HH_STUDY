package demo02.FileUpload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * 文件上传案例的客户端：读取本低文件，上传到服务器，读取服务器回写数据
 * 明确：
 * 数据源：路径
 * 目的地：服务器
 * 实现步骤：
 * 1.创建一个本地字节输入流FileInputStream对象，构造方法中绑定要读取数据
 * 2.创建一个客户端Soket对象，构造方法中绑定服务器的IP地址和端口号
 * 3.使用Soket中的方法getOutputStream，获取网络字节输出流OutputStream对象
 * 4.使用本地字节输入流FileInputStream对象中的方法read，读取文件
 * 5.使用网络字节输出流OutputStream对象中的方法write，把读取到的文件上传到服务器
 * 6.使用Soket中的getInputStream,获取网络字节输入流InputStream对象
 * 7.使用网络字节输入流InputStream对象的方法read读取服务器写回的数据
 * 8.释放资源（FileInputStream，Socket）
 * */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1.创建一个本地字节输入流FileInputStream对象，构造方法中绑定要读取数据
        FileInputStream fis = new FileInputStream("E:/HH_STUDY-xianyuhong59017/xyh-study/base-code/day05-code/src/demo02/FileUpload/input/hello.txt");
        //2.创建一个客户端Soket对象，构造方法中绑定服务器的IP地址和端口号
        Socket socket = new Socket("127.0.0.1", 8888);
        //3.使用Soket中的方法getOutputStream，获取网络字节输出流OutputStream对象
        OutputStream os = socket.getOutputStream();
        //4.使用本地字节输入流FileInputStream对象中的方法read，读取文件
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1) {
            //5.使用网络字节输出流OutputStream对象中的方法write，把读取到的文件上传到服务器
            os.write(bytes, 0, len);
        }
        /*上传完文件需要给文件写一个结束标记，否则while将进入死循环*/
        socket.shutdownOutput();
        //6.使用Soket中的getInputStream,获取网络字节输入流InputStream对象
        InputStream is = socket.getInputStream();
        //7.使用网络字节输入流InputStream对象的方法read读取服务器写回的数据
        while ((len = is.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }

        //8.释放资源（FileInputStream，Socket）
        fis.close();
        socket.close();


    }
}
