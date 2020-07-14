package demo03;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/*
* 1.创建服务器ServerSocket对象，指定端口号；
* 2.使用accept获取socket对象
* 3.使用getinputstream获取到网络输入流
* 4.判断D:\\upload是否存在
* 5.创建本地字节输出流对象，绑定文件夹
* 6.使用网络字节输入流中的read读取客户端上传的文件
* 7.使用本地字节输出流对象write把读取到的文件保存
* 8.使用socket方法回写
* 9.使用write给客户端回写上传成功
* 10.释放资源
* */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server =new ServerSocket(8888);
        while(true){
            Socket socket =server.accept();
//            多线程提高效率
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        InputStream is =socket.getInputStream();
                        File file =new File("C:\\Users\\linziyi\\Desktop\\upload");
                        if(file.exists()){
                            file.mkdirs();
                        }
                        String fileName = System.currentTimeMillis()+new Random().nextInt(999999)+".jpg";
                        FileOutputStream fos = new FileOutputStream(file+"\\"+fileName);
                        int len =0;
                        byte[] bytes =new byte[1024];
                        while((len=is.read(bytes))!=-1){
                            fos.write(bytes,0,len);
                        }
                        socket.getOutputStream().write("上传成功".getBytes());
                        fos.close();
                        socket.close();
                    }catch(IOException e){
                        System.out.println(e);
                    }
                }
            }).start();


        }

        //server.close();
    }
}
