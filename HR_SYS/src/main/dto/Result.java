package main.dto;

import main.enums.ResultCode;

import java.io.Serializable;

/**
 * @author: hqweay
 * @description: Result DTO
 * Created on 7/3/20 12:05 PM
 */
public class Result<T> implements Serializable {
  private ResultCode resultCode;
  private T data;

  public Result() {
  }

  public Result(ResultCode resultCode, T data) {
    this.resultCode = resultCode;
    this.data = data;
  }

  public ResultCode getResultCode() {
    return resultCode;
  }

  public void setResultCode(ResultCode resultCode) {
    this.resultCode = resultCode;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public static <T> Result<T> successResult() {
    return new Result<T>(ResultCode.SUCCESS, null);
  }

  public static <T> Result<T> successResult(T data) {
    return new Result<T>(ResultCode.SUCCESS, data);
  }

  public static <T> Result<T> errorParamValidResult() {
    return new Result<T>(ResultCode.ERROR_PARAM_VALID, null);
  }

  public static <T> Result<T> errorIsExistResult() {
    return new Result<T>(ResultCode.ERROR_IS_EXIST, null);
  }

  public static <T> Result<T> errorNotFoundResult() {
    return new Result<T>(ResultCode.ERROR_NOT_FOUND, null);
  }

  public static <T> Result<T> errorResult() {
    return new Result<T>(ResultCode.ERROR, null);
  }
}
