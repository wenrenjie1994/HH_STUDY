package com.cuit;

import com.cuit.factory.FemaleFactory;
import com.cuit.factory.HumanFactory;
import com.cuit.factory.MaleFactory;
import com.cuit.human.Human;

/**
 * @author liwenyi
 * @date 2020/7/20
 * desc
 */
public class NvWa {
    public static void main(String[] args) {
        //第一条生产线，男性生产线
        HumanFactory maleHumanFactory = new MaleFactory();
        //第二条生产线，女性生产线
        HumanFactory femaleHumanFactory = new FemaleFactory();
        //生产线建立完毕，开始生产人了:
        Human maleYellowHuman = maleHumanFactory.createYellowHuman();
        Human femaleYellowHuman = femaleHumanFactory.createYellowHuman();
        System.out.println("---生产一个黄色女性---");
        femaleYellowHuman.getColor();
        femaleYellowHuman.talk();
        femaleYellowHuman.getSex();
        System.out.println("\n---生产一个黄色男性---");
        maleYellowHuman.getColor();
        maleYellowHuman.talk();
        maleYellowHuman.getSex();
        Human maleBlackHuman = maleHumanFactory.createBlackHuman();
        Human femaleBlackHuman = femaleHumanFactory.createBlackHuman();
        System.out.println("\n---生产一个黑色女性---");
        femaleBlackHuman.getColor();
        femaleBlackHuman.talk();
        femaleBlackHuman.getSex();
        System.out.println("\n---生产一个黑色男性---");
        maleBlackHuman.getColor();
        maleBlackHuman.talk();
        maleBlackHuman.getSex();
        Human maleWhiteHuman = maleHumanFactory.createWhiteHuman();
        Human femaleWhiteHuman = femaleHumanFactory.createWhiteHuman();
        System.out.println("\n---生产一个白色女性---");
        femaleWhiteHuman.getColor();
        femaleWhiteHuman.talk();
        femaleWhiteHuman.getSex();
        System.out.println("\n---生产一个白色男性---");
        maleWhiteHuman.getColor();
        maleWhiteHuman.talk();
        maleWhiteHuman.getSex();
    }
}
