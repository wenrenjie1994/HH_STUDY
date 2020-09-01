package com.cuit;

import com.cuit.corp.CopycatCorp;
import com.cuit.corp.HouseCorp;
import com.cuit.product.Clothes;
import com.cuit.product.House;
import com.cuit.product.IPod;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public class Client {
    public static void main(String[] args) {
        House house = new House();
        System.out.println("-------房地产公司是这样运行的-------");
        //先找到房地产公司
        HouseCorp houseCorp =new HouseCorp(house);
      //看我怎么挣钱
        houseCorp.makeMoney();
        System.out.println("\n");
        //山寨公司生产的产品很多，不过我只要指定产品就成了
        System.out.println("-------山寨公司是这样运行的-------");
        CopycatCorp copycatCorp1 = new CopycatCorp(new IPod());
        copycatCorp1.makeMoney();
        CopycatCorp copycatCorp2 = new CopycatCorp(new Clothes());
        copycatCorp2.makeMoney();
    }
}
