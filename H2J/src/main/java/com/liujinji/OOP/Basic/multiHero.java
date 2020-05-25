package com.liujinji.OOP.Basic;

import com.liujinji.OOP.Interface.IAD;
import com.liujinji.OOP.Interface.IAP;

public class multiHero implements IAD, IAP {
    @Override
    public void physicAttack() {
        System.out.println("To physic attack");
    }

    @Override
    public void magicAttack() {
        System.out.println("To magic attack");
    }
}
