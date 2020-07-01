package com.spdb.study.design.pattern.proxy.dbroute.proxy;
import	java.text.SimpleDateFormat;
import java.util.Date;

import com.spdb.study.design.pattern.proxy.dbroute.Order;
import com.spdb.study.design.pattern.proxy.dbroute.OrderService;
import com.spdb.study.design.pattern.proxy.dbroute.db.DynamicDataSource;

/**
 * 代理数据源切换的逻辑
 * @author Mr.Longyx
 * @date 2020年06月26日 21:05
 */
public class OrderServiceStaticProxy implements OrderService {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

    private OrderService orderService;

    public OrderServiceStaticProxy(OrderService orderService){
        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {
        Long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(sdf.format(new Date(time)));
        System.out.println("静态代理类自动分配到【DB_"+dbRouter+"】数据源处理数据");
        DynamicDataSource.set(dbRouter);

        this.orderService.createOrder(order);
        /**
         * 还原数据源 切换至默认的数据源
         * @author Mr.Longyx
         * @date 2020/6/27 21:08
         * @param order
         * @return int
         */
        DynamicDataSource.restore();
        return 0;
    }
}
