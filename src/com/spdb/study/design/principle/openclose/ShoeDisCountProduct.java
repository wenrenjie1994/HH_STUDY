package com.spdb.study.design.principle.openclose;

import java.math.BigDecimal;

/**
 * @author Mr.Longyx
 * @date 2020年06月16日 23:11
 * 在不修改原代码的基础上，实现价格的动态变更
 */
public class ShoeDisCountProduct extends ShoeProduct{

    ShoeDisCountProduct(Integer id, String name, BigDecimal price) {
        super(id, name, price);
    }

    public BigDecimal getDiscountPrice() {
        return new BigDecimal(new Double(String.valueOf(super.getPrice())) * 0.6);
    }
}
