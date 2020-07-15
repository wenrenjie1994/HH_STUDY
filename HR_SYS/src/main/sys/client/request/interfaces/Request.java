package main.sys.client.request.interfaces;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/15/20 2:55 PM
 */
public interface Request {
  void saveResume();

  void removeResume();

  void updateResume();

  void getResumeByID();

  void listResume();
}
