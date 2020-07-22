package com.spdb;

import com.spdb.model.HummerH1Model;
import com.spdb.model.HummerH2Model;
import com.spdb.model.HummerModel;

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
