package main.service.interfaces;

/**
 * @author: hqweay
 * @description: 通过 ResumeServie 获取参数
 * Created on 7/4/20 11:48 AM
 */
public interface TerminalResumeService {
  void saveResume();

  void removeResume();

  void updateResume();

  void getResumeByID();

  void listResume();
}
