package com.cuit.corp;

import com.cuit.product.House;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public class HouseCorp extends Corp {

    public HouseCorp(House house) {
        super(house);
    }

    @Override
    public void makeMoney(){
        super.makeMoney();
        System.out.println("房地产公司赚大钱了...");
    }
}
