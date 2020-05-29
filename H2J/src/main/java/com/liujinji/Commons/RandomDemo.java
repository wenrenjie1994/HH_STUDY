package com.liujinji.Commons;

import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(100 - 40 + 1) + 40);//40-100随机数
        }
    }
}
