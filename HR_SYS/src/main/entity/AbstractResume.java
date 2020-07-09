package main.entity;

import main.enums.ProcessEnum;

/**
 * @author: hqweay
 * @description: 简历信息
 * Created on 7/2/20 10:53 AM
 */
public abstract class AbstractResume {
  // 姓名
  private String name;
  // 身份证号
  private String id;
  // 学校
  private String school;
  /*
   * 默认为 ProcessEnum.PASS_APPLICATION
   * * 0：已申请
   * 1：简历通过
   * 2：笔试通过
   * 3：体检通过
   * 4：背调通过
   * 5：已签约
   * 6：已入职
   *
   **/
  private ProcessEnum process = ProcessEnum.PASS_APPLICATION;
  /**
   * 逻辑删除
   * 0 删除了-不展示
   * 1 展示
   * 默认为 1
   */
  private boolean deleteStatus = false;

  public AbstractResume(String name, String id, String school, ProcessEnum process, boolean deleteStatus) {
    this.name = name;
    this.id = id;
    this.school = school;
    this.process = process;
    this.deleteStatus = deleteStatus;
  }

  public AbstractResume() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public ProcessEnum getProcess() {
    return process;
  }

  public void setProcess(ProcessEnum process) {
    this.process = process;
  }

  public boolean getDeleteStatus() {
    return deleteStatus;
  }

  public void setDeleteStatus(boolean deleteStatus) {
    this.deleteStatus = deleteStatus;
  }

  @Override
  public String toString() {
    // return "姓名: " + this.name + "\n"
    //         + "身份证号: " + this.id + "\n"
    //         + "学校: " + this.school + "\n"
    //         + "应聘流程: " + this.process.toString() + "\n";
    return this.name + "  " + this.id + "  " + this.school + "  " + this.process.toString();
  }

  public String toSaveString() {
    return this.name + "," + this.id + "," + this.school + "," + this.process.getCode();
  }
}
