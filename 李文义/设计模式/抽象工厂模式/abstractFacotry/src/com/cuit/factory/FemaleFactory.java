package com.cuit.factory;

import com.cuit.human.FemaleBlackHuman;
import com.cuit.human.FemaleWhiteHuman;
import com.cuit.human.FemaleYellowHuman;
import com.cuit.human.Human;

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
