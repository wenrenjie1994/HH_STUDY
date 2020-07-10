package com.pan.exer;

/**
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打 印账户余额。
 * 问题：
 * 1.是否是多线程问题？是，两个储蓄线程
 * 2.是否有共享数据？ 有
 * 3.该程序是否有安全问题，如果有，如何解决？ 同步机制，三种方式
 *
 * @author zhaopan@163.com
 * @creat 2020-04-16 9:42
 */

class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    //存钱
    public synchronized void deposite(double amt) {
        if (amt > 0) {
            balance += amt;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"存钱成功，余额为：" + balance);
        }
    }

}

class Customer extends Thread {
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {

            acct.deposite(1000);
        }

    }
}

public class AccountTest {
    public static void main(String[] args) {

        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}
