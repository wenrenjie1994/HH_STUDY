package model;

/**
 * 描述服务器端返回信息
 * @author 杜波
 * @version 创建时间: 2020/7/20 15:48
 */
public class ActionResult {
    /**
     * 是否成功
     */
    private boolean isSuccess;
    /**
     * 失败原因
     */
    private String failReason;
    /**
     * 数据集
     */
    private Object resultData;

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }
}
