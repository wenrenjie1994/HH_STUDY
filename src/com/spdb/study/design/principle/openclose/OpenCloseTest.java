package com.spdb.study.design.principle.openclose;

import java.math.BigDecimal;

/**
 * 开发封闭原则：一个软件实体如类、模块和函数 对扩展开放 修改封闭
 * @author Mr.Longyx
 * @date 2020年06月16日 22:57
 */
public class OpenCloseTest {
    public static void main(String[] args) {
        /**
         * 打折前的实现
         * @author Mr.Longyx
         * @date 2020/6/16 23:24
         */
//        IProduct iProduct = new ShoeProduct(1,"运动鞋",new BigDecimal(998.98));
        /**
         * 打折后的实现
         * @author Mr.Longyx
         * @date 2020/6/16 23:25
         */
        IProduct iProduct = new ShoeDisCountProduct(1,"运动鞋",new BigDecimal(998.98));
        ShoeDisCountProduct disCountProduct = (ShoeDisCountProduct) iProduct;

        System.out.println("鞋ID: "+disCountProduct.getId() +
                "\n鞋种类: "+disCountProduct.getName() +
                "\n原价： " +disCountProduct.getPrice() +
                "\n售价： "+disCountProduct.getDiscountPrice());
    }
}
