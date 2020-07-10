package com.pan.java;

/**
 * @author zhaopan@163.com
 * @creat 2020-04-18 13:42
 */
public class Goods implements Comparable{
    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    //指明商品排序的方式：价格从低到高
    @Override
    public int compareTo(Object o) {
        //1.判断是否为商品
    if(o instanceof Goods){
        //2.是商品就强转
        Goods goods = (Goods) o;
        //3.判断价格
        //方式一：
        if(this.price > goods.price){
            return 1;
        }else if(this.price <goods.price){
            return -1;
        }else{
            return 0;
        }
        //方式二：
//       return Double.compare(this.price,goods.price);
    }
    //不是商品，则抛出一个异常
        throw new RuntimeException("传入的数据类型不一致！");
    }
}
