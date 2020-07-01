package com.spdb.study.design.pattern.proxy.dbroute;

/**
 * @author Mr.Longyx
 * @date 2020年06月26日 20:49
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;

    public OrderServiceImpl(){
        orderDao = new OrderDao();
    }
    @Override
    public int createOrder(Order order) {
        System.out.println("OrderService调用orderDao创建订单");

        return orderDao.insert(order);
    }
}
