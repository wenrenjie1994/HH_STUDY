package main.enums;

/**
 * @author: hqweay
 * @description: TODO
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
