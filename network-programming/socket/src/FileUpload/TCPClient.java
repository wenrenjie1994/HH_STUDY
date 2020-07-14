package FileUpload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
* 1.创建本地字节输入流FileInputStream对象，构造方法
* 2.创建一个客户端Socket对象，构造方法中绑定服务器ip地址和端口号
* 3.使用socket中的方法getOutputStream，获取网络输出流OutputStream对象
* 4.使用本地字节输入流FileStream的方法read，读取本地文件
* 5.使用write方法，把读取到的文件上传到服务器
* 6.使用inputstream，获取服务器内容
* 7.使用read读取服务器回写的数据
* 8.释放资源（FileStream）
* */
public class TCPClient {
    public static void main(String[] args)throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\linziyi\\Desktop\\林滋宜.jpg");
        Socket socket =new Socket("127.0.0.1",8888);
        OutputStream os =socket.getOutputStream();
        int len=0;
        byte[] bytes =new byte[1024];
        while((len=fis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        socket.shutdownOutput();
        InputStream is =socket.getInputStream();
        while((len=is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        fis.close();
        socket.close();
    }
}
