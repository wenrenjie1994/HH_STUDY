package main.service.interfaces;

/**
 * @author: hqweay
 * @description: 定义 Resume 在 Service 的操作
 * Created on 7/4/20 11:48 AM
 */
public interface ResumeService {
  void saveResume();

  void removeResume();

  void updateResume();

  void getResumeByID();

  void listResume();
}
