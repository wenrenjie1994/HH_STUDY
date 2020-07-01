package com.spdb.study.design.pattern.proxy.dbroute.proxy;
import	java.text.SimpleDateFormat;
import java.util.Date;

import com.spdb.study.design.pattern.proxy.dbroute.Order;
import com.spdb.study.design.pattern.proxy.dbroute.OrderService;
import com.spdb.study.design.pattern.proxy.dbroute.OrderServiceImpl;

/**
 * 演示通过静态(动态)代理实现动态数据源的切换
 * @author Mr.Longyx
 * @date 2020年06月26日 21:13
 */
public class DbRouteProxyTest {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    public static void main(String[] args) {
        try {
            Order order = new Order();
            /**
             * new Date().getTime() 等价于 System.currentTimeMills()
             * @author Mr.Longyx
             * @date 2020/6/26 21:17
             */
           // order.setCreateTime(System.currentTimeMillis());
            Date date = sdf.parse("2019/05/20");
            order.setCreateTime(date.getTime());

  //          OrderService orderService = new OrderServiceStaticProxy(new OrderServiceImpl());
            OrderService orderService = (OrderService)new OrderServiceDynamicProxy().getInstance(new OrderServiceImpl());
            orderService.createOrder(order);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
