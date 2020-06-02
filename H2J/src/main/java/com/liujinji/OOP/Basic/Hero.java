package com.liujinji.OOP.Basic;

public class Hero {
    private String name;
    private int health;
    private int level;

    public Hero() {
    }

    public Hero(String name, int health, int level) {
        this.name = name;
        this.health = health;
        this.level = level;
    }
    public Hero(String name ,int health){
        this.name=name;
        this.health=health;
        this.setDefaultLevel();
    }

    private void setDefaultLevel() {
        this.level = 1;
    }

    public void upgrade() {
        this.level += 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

}
