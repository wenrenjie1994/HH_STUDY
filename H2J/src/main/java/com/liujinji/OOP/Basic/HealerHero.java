package com.liujinji.OOP.Basic;

import com.liujinji.OOP.Interface.IHealer;

public class HealerHero extends Hero implements IHealer {
    @Override
    public void heal() {
        System.out.println("To cure hero.");
    }
}
