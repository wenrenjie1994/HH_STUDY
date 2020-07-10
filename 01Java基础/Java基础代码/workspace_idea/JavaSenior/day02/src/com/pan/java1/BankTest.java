package com.pan.java1;

/**
 * @author zhaopan@163.com
 * @creat 2020-04-16 8:48
 */
public class BankTest {

}

class Bank {
    private Bank() {
    }


    //    public static synchronized Bank getInstance(){
    public static Bank getInstance() {
        //方式一：效率稍差
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }
        //方式二：效率稍高
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }

    private static Bank instance = null;
}
