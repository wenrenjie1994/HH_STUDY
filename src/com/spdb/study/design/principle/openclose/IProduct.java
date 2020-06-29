package com.spdb.study.design.principle.openclose;

import java.math.BigDecimal;

/**
 * @author Mr.Longyx
 * @date 2020年06月16日 22:43
 */
public interface IProduct {
    Integer getId();
    String getName();
    BigDecimal getPrice();
}
