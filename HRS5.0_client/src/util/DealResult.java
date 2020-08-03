/**
 * projectName: HRS5.0_client
 * fileName: DealResult.java
 * packageName: util
 * date: 2020-08-03 15:32
 * copyright(c) tianyifan
 */
package util;

/**
 * @version: V5.0
 * @author: tianyifan
 * @className: DealResult
 * @packageName: util
 * @description: 服务器端操作结果解析存储类
 * @date: 2020-08-03 15:32
 **/
public class DealResult {
    private boolean isSuccess;//处理结果：success/fail
    private String failReason;//失败原因
    private Object resultData;//结果数据

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
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
