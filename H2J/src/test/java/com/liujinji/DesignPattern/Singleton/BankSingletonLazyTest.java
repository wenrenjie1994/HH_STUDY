package com.liujinji.DesignPattern.Singleton;

import org.junit.Test;

public class BankSingletonLazyTest {
    @Test
    public void BankSingletonHungry(){
        BankSingletonHungry bankSingleton1 = BankSingletonHungry.getInstance();
        BankSingletonHungry bankSingleton2 = BankSingletonHungry.getInstance();
        System.out.println(bankSingleton1==bankSingleton2);
    }
    @Test
    public void BankSingletonLazy(){
        BankSingletonLazy bankSingleton1 = BankSingletonLazy.getInstance();
        BankSingletonLazy bankSingleton2 = BankSingletonLazy.getInstance();
        System.out.println(bankSingleton1==bankSingleton2);
    }
}