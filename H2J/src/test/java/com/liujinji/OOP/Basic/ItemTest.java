package com.liujinji.OOP.Basic;

import com.liujinji.OOP.Basic.Item;
import org.junit.Test;

public class ItemTest {
    @Test
    public void genItem(){
        Item shoes=new Item("shoes",300);
        Item sword = new Item();
        sword.setName("sword");
        sword.setPrice(100);
        System.out.println(sword.toString());
        sword.upgrade();
        System.out.println(sword.toString());
    }
}
