package concurrent;

import bean.Operation;
import bean.ResponseTemplate;
import bean.Resume;
import controller.ResumeController;
import util.Parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;

/**
 * 新开的Socket线程中要执行的工作，
 * 包括从inputstream中获取数据，
 * 解析数据并执行操作，
 * 返回数据至outputstream中
 */
public class SocketThread extends Thread {

    private final Socket socket;
    private final int MAX_BUFFER_SIZE = 1024;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();
        InputStream inputStream;
        OutputStream outputStream;
        //服务器持续接受数据
        while (true) {
            try {
                inputStream = socket.getInputStream();
                byte[] bytes = new byte[MAX_BUFFER_SIZE];
                inputStream.read(bytes);

                String message = new String(bytes).trim();
                System.out.println("Message received: " + message);

                Parser parser = new Parser();

                Operation<Resume> resumeOperation = parser.parseOperation(message);
                if (!resumeOperation.getOperation().equals("quit")) {
                    ResumeController resumeController = new ResumeController(resumeOperation);
                    ResponseTemplate<Resume> responseTemplate = resumeController.executeOperation();

                    StringBuilder builder = new StringBuilder();
                    List<Resume> resumeList = responseTemplate.getList();
                    if (resumeList != null && resumeList.size() != 0) {
                        for (Resume r :
                                resumeList) {
                            builder.append(r.toString()).append("\n");
                        }
                    } else {
                        builder.append(responseTemplate.getRows());
                    }

                    String response = builder.toString().trim();
                    outputStream = socket.getOutputStream();
                    bytes = response.getBytes();
                    outputStream.write(bytes);
                    System.out.println("Response message sent: " + response);
                } else {
                    socket.close();
                    System.out.println("Current socket is closed, thread id is  " + getId());
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}