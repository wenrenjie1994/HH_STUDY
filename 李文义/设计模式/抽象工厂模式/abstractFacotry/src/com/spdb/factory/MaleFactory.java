package com.spdb.factory;

import com.spdb.human.Human;
import com.spdb.human.MaleBlackHuman;
import com.spdb.human.MaleWhiteHuman;
import com.spdb.human.MaleYellowHuman;

/**
 * @author liwenyi
 * @date 2020/7/20
 * desc
 */
public class MaleFactory implements HumanFactory {
    @Override
    public Human createYellowHuman() {
        return new MaleYellowHuman();
    }

    @Override
    public Human createWhiteHuman() {
        return new MaleWhiteHuman();
    }

    @Override
    public Human createBlackHuman() {
        return new MaleBlackHuman();
    }
}
