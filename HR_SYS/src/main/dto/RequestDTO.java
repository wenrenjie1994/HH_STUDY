package main.dto;

import main.entity.Resume;
import main.enums.RequestEnum;

import java.io.Serializable;

/**
 * @author: hqweay
 * @description: Client 与 Server 交互的传输类
 * Created on 7/15/20 4:36 PM
 */
public class RequestDTO implements Serializable {
  private RequestEnum requestEnum;
  // param
  private Resume[] paramsResume;

  public RequestDTO() {
  }

  public RequestDTO(RequestEnum requestEnum, Resume[] paramsResume) {
    this.requestEnum = requestEnum;
    this.paramsResume = paramsResume;
  }

  public RequestDTO(RequestEnum requestEnum) {
    this.requestEnum = requestEnum;
  }

  public RequestEnum getRequestEnum() {
    return requestEnum;
  }

  public void setRequestEnum(RequestEnum requestEnum) {
    this.requestEnum = requestEnum;
  }

  public Resume[] getParamsResume() {
    return paramsResume;
  }

  public void setParamsResume(Resume[] paramsResume) {
    this.paramsResume = paramsResume;
  }
}
