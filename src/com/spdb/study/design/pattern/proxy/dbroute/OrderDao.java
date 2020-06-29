package com.spdb.study.design.pattern.proxy.dbroute;

/**
 * @author Mr.Longyx
 * @date 2020年06月26日 20:45
 */
public class OrderDao {
    /**
     * 模拟与数据库打交道
     * @author Mr.Longyx
     * @date 2020/6/26 20:46
     */
    public int insert(Order order){
        System.out.println("OrderDao创建Order成功！");
        return 1;
    }
}
