package main.enums;

/**
 * @author: hqweay
 * @description: Client 与 Server 交互的可用链接
 * Created on 7/15/20 3:26 PM
 */
public enum RequestEnum {

  SAVE_RESUME("saveResume/"),

  REMOVE_RESUME("removeResume/"),

  UPDATE_RESUME("updateResume/"),

  GET_RESUME_BY_ID("getResumeByID/"),

  LIST_RESUME("listResume/");

  private String root = "/api/";
  private String path;

  RequestEnum(String path) {
    this.path = path;
  }

  RequestEnum() {
  }

  public String getPath() {
    return root + path;
  }

  public void setPath(String path) {
    this.path = path;
  }
}
