package com.spdb.factory;

import com.spdb.human.Human;

/**
 * @author liwenyi
 * @date 2020/7/20
 * desc
 */
public interface HumanFactory {
    /**
     * 功能描述: 
     * 制造一个黄色人种
     * 
     * @return: com.spdb.human.Human
     * @author: liwenyi
     */
    public Human createYellowHuman();

    /**
     * 功能描述:
     * 制造一个白色人种
     *
     * @return: com.spdb.human.Human
     * @author: liwenyi
     */
    public Human createWhiteHuman();

    /**
     * 功能描述:
     * 制造一个黑色人种
     *
     * @return: com.spdb.human.Human
     * @author: liwenyi
     */
    public Human createBlackHuman();
}
