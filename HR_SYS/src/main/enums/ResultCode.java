package main.enums;

/**
 * @author: hqweay
 * @description: 统一返回数据，定义状态码
 * Created on 7/3/20 12:07 PM
 */
public enum ResultCode {
  SUCCESS(200, "SUCESS"),
  ERROR(500, "ERROR"),
  ERROR_PARAM_VALID(501, "参数验证出错"),
  ERROR_IS_EXIST(502, "数据重复"),
  ERROR_NOT_FOUND(503, "数据不存在"),
  WARN(700, "WARN");

  private int code;
  private String msg;

  ResultCode(int code, String desc) {
    this.code = code;
    this.msg = desc;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
