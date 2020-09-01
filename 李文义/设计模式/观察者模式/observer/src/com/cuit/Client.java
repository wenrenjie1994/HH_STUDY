package com.cuit;

import com.cuit.observable.HanFeiZi;
import com.cuit.observer.LiSi;
import com.cuit.observer.LiuSi;
import com.cuit.observer.Observer;
import com.cuit.observer.WangSi;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        //三个观察者产生出来
        Observer liSi = new LiSi();
        Observer wangSi = new WangSi();
        Observer liuSi = new LiuSi();
        //定义出韩非子
        HanFeiZi hanFeiZi = new HanFeiZi();
        //我们后人根据历史，描述这个场景，有三个人在观察韩非子
        hanFeiZi.addObserver(liSi);
        hanFeiZi.addObserver(wangSi);
        hanFeiZi.addObserver(liuSi);
        //然后这里我们看看韩非子在干什么
        hanFeiZi.haveBreakfast();
    }
}
