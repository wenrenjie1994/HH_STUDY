package com.spdb.study.design.pattern.proxy.dbroute;

import java.io.Serializable;

/**
 * 订单实体类
 * @author Mr.Longyx
 * @date 2020年06月26日 20:42
 */
public class Order implements Serializable {
    private Object orderInfo;
    /**
     * 根据订单创建时间进行按年分库
     * @author Mr.Longyx
     * @date 2020/6/26 20:53
     */
    private Long createTime;
    private String id;

    public Object getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Object orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderInfo=" + orderInfo +
                ", createTime=" + createTime +
                ", id='" + id + '\'' +
                '}';
    }
}
