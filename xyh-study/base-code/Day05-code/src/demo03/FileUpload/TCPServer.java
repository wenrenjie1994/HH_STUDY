package demo03.FileUpload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;


/*
* 文件上传案例的服务器端：读取客户端上传的文件，保存到服务器硬盘，给客户端回写“上传成功”
* 明确：
* 数据源：客户端上传的文件
* 目的地：服务器的硬盘
*
* 实现步骤
1.创建一个服务器对象ServerSocket对象，和系统要指定的端口号
2.使用ServerSocket对象中的方法accept获取到请求的客户端Socket对象
3.使用Socket对象中的方法getInputStream，获取到网络字节输入流InputStream对象
4.判断文件夹是否存在，不存在则创建
5.创建一个本地字节输出流FileOutputStream对象，构造方法中绑定要输出的目的地
6.使用网络字节输入流InputStream对象中的方法read，读取客户端上传的文件
7.使用本地字节输出流FileOutputStream对象中的write，把读取到的文件保存到服务器的硬盘上
8.使用Socket对象中的方法getOutputStream，获取到网络字节输出流OutputStream
9.使用网络字节输出流OutputStream的方法write，给客户端回写上传成功
10.释放资源（FileOutputStream，ServerSocket）
*
* */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1.创建一个服务器对象ServerSocket对象，和系统要指定的端口号
        ServerSocket server = new ServerSocket(8888);
        //2.使用ServerSocket对象中的方法accept获取到请求的客户端Socket对象
        /*
        让服务器一直处于监听状态——死循环accept方法
        有一个客户端上传文件就保存一个文件
        */
        while (true) {
            Socket socket = server.accept();
            /*
            使用多线程技术，提高程序效率。
            有一个客户端上传文件，就开启一个线程，完成文件上传
             */
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //完成文件的上传
                    try {
                        //3.使用Socket对象中的方法getInputStream，获取到网络字节输入流InputStream对象
                        InputStream is = socket.getInputStream();
                        //4.判断文件夹是否存在，不存在则创建
                        File file = new File("E:\\HH_STUDY-xianyuhong59017\\xyh-study\\base-code\\day05-code\\src\\demo02\\FileUpload\\output");
                        if (!file.exists()) {
                            file.mkdir();
                        }
                    /*
                     自定义文件的命名规则，防止同名文件被覆盖
                     规则：毫秒值+随机数
                    */
                        String fileName = System.currentTimeMillis() + new Random().nextInt(99999) + ".txt";
                        //5.创建一个本地字节输出流FileOutputStream对象，构造方法中绑定要输出的目的地
                        FileOutputStream fos = new FileOutputStream(file + "\\" + fileName);
                        //6.使用网络字节输入流InputStream对象中的方法read，读取客户端上传的文件
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        while ((len = is.read(bytes)) != -1) {
                            //7.使用本地字节输出流FileOutputStream对象中的write，把读取到的文件保存到服务器的硬盘上
                            fos.write(bytes, 0, len);
                        }


                        //8.使用Socket对象中的方法getOutputStream，获取到网络字节输出流OutputStream
                        //9.使用网络字节输出流OutputStream的方法write，给客户端回写上传成功
                        socket.getOutputStream().write("上传成功".getBytes());
                        //10.释放资源（FileOutputStream，ServerSocket）
                        fos.close();
                        socket.close();

                    } catch (IOException e) {
                        System.out.println(e);
                    }

                }
            }).start();

        }
        //服务器端不用关闭
        //server.close();
    }

}
