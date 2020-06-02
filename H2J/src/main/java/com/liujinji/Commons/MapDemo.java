package com.liujinji.Commons;

import com.liujinji.OOP.Basic.Hero;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapDemo {
    public Map<String, Hero> heroes;

    public MapDemo() {
        // 承装Hero对象
        this.heroes = new HashMap<String, Hero>();
    }

    public void put() {
        // 创建Scanner用来获取name
        Scanner console = new Scanner(System.in);
        // 一次添加3个
        for (int i = 0; i < 3; i++) {
            // 获得英雄名字
            System.out.println("Input hero name: ");
            String name = console.next();
            // 暂存name用来判断是否存在
            Hero hero = heroes.get(name);
            if (hero == null) {
                System.out.println("Input hero health: ");
                int health = console.nextInt();
                // 创建新的英雄对象并添加到集合
                Hero newHero = new Hero(name, health);
                heroes.put(name,newHero);
                System.out.println("Add successful! name: "+name);
            }else {
                System.out.println("Hero already exists.");
            }
        }
    }

    public static void main(String[] args) {
        MapDemo md=new MapDemo();
        md.put();
    }
}
