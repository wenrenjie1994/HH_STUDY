package com.spdb.study.design.pattern.strategy.pay;

/**
 * @author Mr.Longyx
 * @date 2020年06月28日 23:08
 */
public class MsgResult {
    private int code;
    private String msg;
    private Object data;

    public MsgResult(int code,String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "支付状态：["+code+"]" +
                ", 交易详情：'" + msg + '\'' +
                ", 交易数据：'" + data + '\'';
    }
}
