package main.sys.client.request;

import main.sys.client.Client;
import main.sys.client.request.interfaces.Request;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/15/20 2:22 PM
 */
public abstract class AbstractRequest implements Request {

  Client client = new Client();

  ObjectInputStream in = client.getIn();
  ObjectOutputStream out = client.getOut();


  public AbstractRequest() {
  }


}
