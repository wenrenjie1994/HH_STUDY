package main.view.interfaces;

import main.dto.Result;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/15/20 5:09 PM
 */
public interface View {
  void saveResume(Result result);

  void removeResume(Result result);

  void updateResume(Result result);

  void getResumeByID(Result result);

  void listResume(Result result);
}
