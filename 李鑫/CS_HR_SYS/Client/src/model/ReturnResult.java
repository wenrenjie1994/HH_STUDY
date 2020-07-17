package model;

public class ReturnResult {

    // 用来包装解析服务器协议的结果的两个属性
    // 用来包装在数据库中操作得到的结果三个属性信息
    public boolean isSuccess;
    public String failReason;
    public Object resultData;
}
