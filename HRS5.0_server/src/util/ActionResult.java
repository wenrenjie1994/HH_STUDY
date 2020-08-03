/**
 * projectName: HRS5.0_sever
 * fileName: ActionResult.java
 * packageName: util
 * date: 2020-07-24 21:29
 * copyright(c) tianyifan
 */
package util;

/**
 * @version: V5.0
 * @author: tianyifan
 * @className: ActionResult
 * @packageName: util
 * @description: 处理结果类
 * @date: 2020-07-24 21:29
 **/
public class ActionResult {
    private String isSuccess;//处理结果：success/fail
    private String failReason;//失败原因
    private Object resultData;//结果数据

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
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
