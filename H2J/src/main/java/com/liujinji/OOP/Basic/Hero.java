package com.liujinji.OOP.Basic;

public class Hero {
    private String name;
    private int Health;
    private int level;

    public Hero() {
    }

    public Hero(String name, int health, int level) {
        this.name = name;
        Health = health;
        this.level = level;
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
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getLevel() {
        return level;
    }

}
