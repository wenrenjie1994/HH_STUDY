package main.sys.server;

import main.dto.RequestDTO;
import main.dto.Result;
import main.mapper.DBResumeMapper;
import main.service.ResumeServiceImpl;
import main.service.interfaces.ResumeService;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author: hqweay
 * @description: Server 线程
 * Created on 7/15/20 12:48 PM
 */
public class ServerThread implements Runnable {
  ResumeService resumeService = new ResumeServiceImpl(new DBResumeMapper()) {};
  Socket tcpConnection;
  static ObjectInputStream in = null;
  static ObjectOutputStream out = null;
  static RequestDTO requestDTO;

  public ServerThread(Socket tcpConnection) {
    this.tcpConnection = tcpConnection;
  }

  @Override
  public void run() {
    while (true) {
      try {
        if (in == null) {
          in = new ObjectInputStream(tcpConnection.getInputStream());
        }
        if (out == null) {
          out = new ObjectOutputStream(tcpConnection.getOutputStream());
        }

        requestDTO = (RequestDTO) in.readObject();
      } catch (IOException e) {
        e.printStackTrace();
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }

      if (requestDTO == null) {
        continue;
      }
      Result result = null;

      switch (requestDTO.getRequestEnum()) {
        case LIST_RESUME:
          result = resumeService.listResume();
          break;
        case SAVE_RESUME:
          result = resumeService.saveResume(requestDTO.getParamsResume()[0]);
          break;
        case REMOVE_RESUME:
          result = resumeService.removeResume(requestDTO.getParamsResume()[0]);
          break;
        case GET_RESUME_BY_ID:
          result = resumeService.getResumeByID(requestDTO.getParamsResume()[0]);
          break;
        case UPDATE_RESUME:
          result = resumeService.updateResume(requestDTO.getParamsResume()[0], requestDTO.getParamsResume()[1]);
          break;
        default:
          break;
      }
      //
      if (result != null) {
        try {
          out.writeUnshared(result);
          // out.reset();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

    }
  }

  public static void main(String[] args) {
    new Server().run();
  }
}
