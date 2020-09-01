package com.cuit.corp;

import com.cuit.product.Product;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public class CopycatCorp extends Corp {
    public CopycatCorp(Product product) {
        super(product);
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("我赚钱呀...");    }
}
