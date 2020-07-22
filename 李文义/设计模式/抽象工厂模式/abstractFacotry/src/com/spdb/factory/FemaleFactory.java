package com.spdb.factory;

import com.spdb.human.FemaleBlackHuman;
import com.spdb.human.FemaleWhiteHuman;
import com.spdb.human.FemaleYellowHuman;
import com.spdb.human.Human;

/**
 * @author liwenyi
 * @date 2020/7/20
 * desc
 */
public class FemaleFactory implements HumanFactory {
    @Override
    public Human createYellowHuman() {
        return new FemaleYellowHuman();
    }

    @Override
    public Human createWhiteHuman() {
        return new FemaleWhiteHuman();
    }

    @Override
    public Human createBlackHuman() {
        return new FemaleBlackHuman();
    }
}
