package model;

/**
 * @program: HR_SYS_4.0（C/S模式）
 * @className:ReturnResult
 * @description:包装解析客户端协议的结果的两个属性
 * @author: 何文艺
 * @create: 2020/7/17 15:30
 **/
public class ReturnResult {
    public String head;//数据库操作类型：要进行什么操作
    public Object resultData;//数据库操作数据：操作什么数据
}
