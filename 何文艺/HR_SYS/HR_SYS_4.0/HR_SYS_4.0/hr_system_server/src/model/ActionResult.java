package model;

/**
 * @program: HR_SYS_4.0（C/S模式）
 * @className:ActionResult
 * @description:包装在数据库操作中得到的三个结果属性信息
 * @author: 何文艺
 * @create: 2020/7/17 11:35
 **/
public class ActionResult {
    public Boolean isSuccess;//数据库操作是否成功标志
    public String failReason;//数据库操作失败原因
    public Object resultData;//数据库查询操作返回的结果数据
}
