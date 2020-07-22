package com.spdb.observable;

import com.spdb.observer.Observer;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public interface Observable {
    /**
     * 功能描述:
     * 增加一个观察者
     *
     * @param observer 1
     * @return: void
     * @author: liwenyi
     */
    public void addObserver(Observer observer);
    /**
     * 功能描述:
     * 删除一个观察者
     *
     * @param observer 1
     * @return: void
     * @author: liwenyi
     */
    public void deleteObserver(Observer observer);
    /**
     * 功能描述:
     * 既然要观察，我发生改变了他也应该有所动作，通知观察者
     *
     * @param context 1
     * @return: void
     * @author: liwenyi
     */
    public void notifyObservers(String context);
}
