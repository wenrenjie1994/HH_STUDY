package com.liujinji.OOP.Basic;

public class Item {
    private String name;
    private int price;
    private int level;

    // 无参构造器
    public Item() {
        // 在构造器中设置默认level
        this.setDefaultLevel();
    }

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
        this.setDefaultLevel();
    }

    private void setDefaultLevel() {
        this.level = 1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public int getLevel() {
        return this.level;
    }

    public void upgrade() {
        this.level += 1;
    }

    public String toString() {
        return "ClassName: " + this.getClass() +
                "\nItemName: " + this.getName() +
                "\nPrice: " + this.getPrice() +
                "\nLevel: " + this.getLevel();
    }
}
