package service;

import model.Request;
import model.Response;
import model.Resume;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: chenlei
 * @Date: 2020/7/17 18:37
 */
public class ServerService {
    private static Logger logger = LogManager.getLogger(ServerService.class);
    public void run(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port,5);
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("服务端正在" + address.getHostAddress() + ":" + port + "运行");
            while (true) {
                Socket socket = serverSocket.accept();
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                ResumeService resumeService = new ResumeService();
                Response response = null;
                Object request = inputStream.readObject();
                Request r = (Request) request;
                if(r != null) {
                    logger.info("服务端收到请求，参数为：" + request.toString());
                    if(r.getOperationCode() >=1 && r.getOperationCode() <=5) {
                        switch (r.getOperationCode()) {
                            case 1:
                                response = resumeService.addResume((Resume)r.getInfo());
                                outputStream.writeObject(response);
                                outputStream.flush();
                                break;
                            case 2:
                                response = resumeService.deleteResume(String.valueOf(r.getInfo()));
                                outputStream.writeObject(response);
                                outputStream.flush();
                                break;
                            case 3:
                                response = resumeService.updateResume((Resume) (r.getInfo()));
                                outputStream.writeObject(response);
                                outputStream.flush();
                                break;
                            case 4:
                                response = resumeService.searchResume(String.valueOf(r.getInfo()));
                                outputStream.writeObject(response);
                                outputStream.flush();
                                break;
                            case 5:
                                response = resumeService.showAllResume();
                                outputStream.writeObject(response);
                                outputStream.flush();
                                break;
                            default:
                        }
                    }
                }
            }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
