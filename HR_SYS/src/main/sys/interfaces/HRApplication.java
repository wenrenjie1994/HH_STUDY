package main.sys.interfaces;

import main.entity.AbstractResume;
import main.entity.ResumeList;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/2/20 1:12 PM
 */
public interface HRApplication {
  void saveResume();
  void removeResume();
  void updateResume();
  void getResume();
  void listResume();
}
