package main.entity;

import main.enums.ProcessEnum;

/**
 * @author: hqweay
 * @description: 应聘者的简历信息
 * Created on 7/2/20 10:52 AM
 */
public class Resume extends AbstractResume{
  public Resume(String name, String id, String school, ProcessEnum process, int deleteStatus) {
    super(name, id, school, process, deleteStatus);
  }

  public Resume() {
  }

  @Override
  public String getName() {
    return super.getName();
  }

  @Override
  public void setName(String name) {
    super.setName(name);
  }

  @Override
  public String getId() {
    return super.getId();
  }

  @Override
  public void setId(String id) {
    super.setId(id);
  }

  @Override
  public String getSchool() {
    return super.getSchool();
  }

  @Override
  public void setSchool(String school) {
    super.setSchool(school);
  }

  @Override
  public ProcessEnum getProcess() {
    return super.getProcess();
  }

  @Override
  public void setProcess(ProcessEnum process) {
    super.setProcess(process);
  }

  @Override
  public int getDeleteStatus() {
    return super.getDeleteStatus();
  }

  @Override
  public void setDeleteStatus(int deleteStatus) {
    super.setDeleteStatus(deleteStatus);
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
