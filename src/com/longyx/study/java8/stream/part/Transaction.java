package com.spdb.study.java8.stream.part;

import java.io.Serializable;

/**
 * @author Mr.Longyx
 * @date 2020年07月07日 21:45
 */
public class Transaction implements Serializable {
    private static final long serialVersionUID = -1429295988299505331L;
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
