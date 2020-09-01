package com.cuit;

import com.cuit.factory.AbstractHumanFactory;
import com.cuit.factory.HumanFactory;
import com.cuit.human.BlackHuman;
import com.cuit.human.Human;
import com.cuit.human.WhiteHuman;
import com.cuit.human.YellowHuman;

/**
 * @author liwenyi
 * @date 2020/7/20
 * desc
 */
public class NvWa {
    public static void main(String[] args) {
        //声明阴阳八卦炉
        AbstractHumanFactory factory = new HumanFactory();
        //女娲第一次造人，火候不足，于是白人产生了
        System.out.println("--造出的第一批人是白色人种--");
        Human whiteHuman = factory.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.talk();
        //女娲第二次造人，火候过足，于是黑人产生了
        System.out.println("\n--造出的第二批人是黑色人种--");
        Human blackHuman = factory.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();
        //第三次造人，火候刚刚好，于是黄色人种产生了
        System.out.println("\n--造出的第三批人是黄色人种--");
        Human yellowHuman = factory.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();
    }
}
