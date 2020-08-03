/**
 * projectName: HRS5.0_sever
 * fileName: ReturnData.java
 * packageName: util
 * date: 2020-07-24 21:19
 * copyright(c) tianyifan
 */
package util;

/**
 * @version: V5.0
 * @author: tianyifan
 * @className: ReturnData
 * @packageName: util
 * @description: 客户端协议字符串解析结果存储类
 * @date: 2020-07-24 21:19
 **/
public class ReturnData {
    private String head;//协议头部信息
    private Object result;//协议结果

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
