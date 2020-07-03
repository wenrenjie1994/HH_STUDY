package main.entity;

import main.enums.ProcessEnum;

/**
 * @author: hqweay
 * @description: 应聘者的简历信息
 * Created on 7/2/20 10:52 AM
 */
public class Resume extends AbstractResume {
  public Resume(String name, String id, String school, ProcessEnum process, boolean deleteStatus) {
    super(name, id, school, process, deleteStatus);
  }

  public Resume() {
  }
}
