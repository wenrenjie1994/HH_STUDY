package com.liujinji.OOP.Basic;

import com.liujinji.OOP.Interface.IAP;

public class APHero extends Hero implements IAP {
    @Override
    public void magicAttack() {
        System.out.println("To physic attack...");
    }
}
