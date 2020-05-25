package com.liujinji.OOP.Basic;


import com.liujinji.OOP.Interface.IAD;

public class ADHero extends Hero implements IAD {
    @Override
    public void physicAttack() {
        System.out.println("To physic attack...");
    }
}
