package com.cuit.factory;

import com.cuit.human.Human;
import com.cuit.human.MaleBlackHuman;
import com.cuit.human.MaleWhiteHuman;
import com.cuit.human.MaleYellowHuman;

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
