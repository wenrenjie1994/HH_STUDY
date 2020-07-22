package com.spdb;

import com.spdb.facade.ModenPostOffice;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class Client {
    public static void main(String[] args) {
        ModenPostOffice hellRoadPostOffice = new ModenPostOffice();
        //开始写信
        String address="Hello,It's me,do you know who I am?";
        String context="Happy Road No. 666,God Province,Heaven";
        //你给我发送吧
        hellRoadPostOffice.sendLetter(context, address);
    }
}
