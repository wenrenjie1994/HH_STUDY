package com.spdb.observable;

import com.spdb.observer.Observer;

import java.util.ArrayList;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class HanFeiZi implements IHanFeiZi, Observable {
    /**
     * 功能描述:
     * 定义个变长数组，存放所有的观察者
     *
     * @author: liwenyi
     */
    private ArrayList<Observer> observerList = new ArrayList<Observer>();

    /**
     * 功能描述:
     * 韩非子是否在吃饭，作为监控的判断标准
     *
     * @author: liwenyi
     */
    private boolean isHavingBreakfast = false;
    /**
     * 功能描述:
     * 韩非子是否在娱乐
     *
     * @author: liwenyi
     */
    private boolean isHavingFun = false;

    @Override
    public void haveBreakfast() {
        System.out.println("韩非子:开始吃饭了...");
        this.notifyObservers("韩非子在吃饭");
    }

    @Override
    public void haveFun() {
        System.out.println("韩非子:开始娱乐了...");
        this.notifyObservers("韩非子在娱乐");
    }

    public boolean isHavingBreakfast() {
        return isHavingBreakfast;
    }

    public void setHavingBreakfast(boolean isHavingBreakfast) {
        this.isHavingBreakfast = isHavingBreakfast;
    }

    public boolean isHavingFun() {
        return isHavingFun;
    }

    public void setHavingFun(boolean isHavingFun) {
        this.isHavingFun = isHavingFun;
    }

    @Override
    public void addObserver(Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void notifyObservers(String context) {
        for(Observer observer:observerList){
            observer.update(context);
        }
    }
}
