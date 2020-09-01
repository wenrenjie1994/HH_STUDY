package com.cuit;

import com.cuit.model.HummerH1Model;
import com.cuit.model.HummerH2Model;
import com.cuit.model.HummerModel;

/**
 * @author liwenyi
 * @date 2020/7/20
 * desc
 */
public class Client {
    public static void main(String[] args) {
        HummerModel h1 = new HummerH1Model();
        h1.run();
        System.out.println("--------------");
        HummerModel h2 = new HummerH2Model();
        h2.run();
    }
}
