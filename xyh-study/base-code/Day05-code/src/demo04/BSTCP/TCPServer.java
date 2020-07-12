package demo04.BSTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
创建BS版本的服务器
* */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //创建一个服务器ServerSocket和系统指定的端口号
        ServerSocket server=new ServerSocket(8080);
        while(true){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //使用accept方法获取到请求的客户端对象
                        Socket socket=server.accept();
                        //使用Socket对象中的方法getInputStream,获取网络输入流InputStream对象
                        InputStream is=socket.getInputStream();
                        //使用网络字节输入流InputStream对象中的方法read独去客户端的请求信息
/*        byte[] bytes=new byte[1024];
        int len=0;
        while((len=is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }*/
                        //把网络字节输入流转化为字符缓冲输入流
                        BufferedReader br= new BufferedReader(new InputStreamReader(is));
                        String line=br.readLine();
                        //把读取的信息进行切割
                        String []arr=line.split(" ");
                        //day05-code/taobaoweb/index.html
                        String htmlpath=arr[1].substring(1);
                        //创建本地字节流，构造方法中绑定要读取的路径
                        System.out.println(htmlpath);
                        FileInputStream fis=new FileInputStream(htmlpath);
                        //使用Socket中的方法getOutputStream获取网络字节输出流OutputStream
                        OutputStream os=socket.getOutputStream();

                        /*固定写法*/
                        //写入HTTP协议相应头
                        os.write("HTTP/1.1 200 OK\r\n".getBytes());
                        os.write("Content-Type:text/html\r\n".getBytes());
                        //必须写入空行，否则浏览器不解析
                        os.write("\r\n".getBytes());

                        //一读一写 复制文件
                        int len=0;
                        byte[] bytes=new byte[1024];
                        while ((len=fis.read(bytes))!=-1){
                            os.write(bytes,0,len);
                        }
                        //释放资源
                        fis.close();
                        socket.close();
                    }catch (IOException e){
                        System.out.println(e);
                    }
                }
            }).start();
        }


    }
}
