package model;

/**
 * @program: HR_SYS_4.0（C/S模式）
 * @className:ReturnResult
 * @description:包装解析服务器端协议的结果的三个属性
 * @author: 何文艺
 * @create: 2020/7/19 9:54
 **/
public class ReturnResult {
    public boolean isSuccess;//数据库操作是否成功标志
    public String failReason;//数据库操作失败原因
    public Object resultData;//数据库查询操作返回的结果数据
}
