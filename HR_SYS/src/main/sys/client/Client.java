package main.sys.client;

import main.entity.Resume;
import main.enums.ProcessEnum;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/15/20 12:52 PM
 */
public class Client {
  ObjectInputStream in;
  ObjectOutputStream out;
  Socket tcpConnection;
  private String ip = "localhost";
  private int port = 8309;

  public ObjectInputStream getIn() {
    return in;
  }

  public ObjectOutputStream getOut() {
    return out;
  }

  public Client() {
    try {
      tcpConnection = new Socket(ip, port);
      System.out.print("client start...");

      // Client out, in 的顺序需要与 Server 相反
      out = new ObjectOutputStream(tcpConnection.getOutputStream());
      in = new ObjectInputStream(tcpConnection.getInputStream());
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public void test() {
    try {
      out.writeObject(new Resume("sss", "ff", "ss", ProcessEnum.PASS_APPLICATION, false));
      Object ss = in.readObject();
      System.out.println(ss.toString());
      out.flush();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new Client().test();
  }
}
