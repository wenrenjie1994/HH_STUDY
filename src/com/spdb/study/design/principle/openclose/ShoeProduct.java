package com.spdb.study.design.principle.openclose;

import java.math.BigDecimal;

/**
 * @author Mr.Longyx
 * @date 2020年06月16日 22:49
 */
public class ShoeProduct implements IProduct {

    private Integer id;
    private String name;
    private BigDecimal price;


    ShoeProduct(Integer id, String name, BigDecimal price){
        this.id = id;
        this.name = name;
        this.price = price;
    }


    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }
}
