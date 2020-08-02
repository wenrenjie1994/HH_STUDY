package Thread.DemoTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 两个储蓄用户分别向同一个账户存3000￥，每次存1000￥，分3次存。存完后打印余额
 * @author liuclo
 * @date 2020.8.2 16:50
 */

//3. 线程安全：lock
public class AccountTest {
    public static void main(String[] args) {
        //如此，两个用户共用一个账户
        Account account = new Account(0);
        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);

        c1.setName("路人甲");
        c2.setName("路人乙");

        c1.start();
        c2.start();
    }
}

class Account {
    private double balance;

    //instantiate ReentrantLock
//    private ReentrantLock lock = new ReentrantLock();

    public Account(double balance) {
        this.balance = balance;
    }

    //存钱
    public void deposit(double amt) {
 //       try {
            //call lock()
 //           lock.lock();

            if (amt > 0) {
                balance += amt;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "存钱成功！余额为: " + balance);
            }
//        } finally {
//            lock.unlock();
//        }
    }
}

class Customer extends Thread {
    private Account account;

    //定义为static的
    private static ReentrantLock lock = new ReentrantLock();

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i=0; i<3; i++) {
            try {
                lock.lock();
                account.deposit(1000);
            } finally {
                lock.unlock();
            }
        }
    }
}

/*
//2. 线程安全：synchronized
public class AccountTest {
    public static void main(String[] args) {
        //如此，两个用户共用一个账户
        Account account = new Account(0);
        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);

        c1.setName("路人甲");
        c2.setName("路人乙");

        c1.start();
        c2.start();
    }
}

class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    //存钱
    public synchronized void deposit(double amt) {
        if (amt > 0) {
            balance += amt;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "存钱成功！余额为: " + balance);
        }
    }
}

class Customer extends Thread {
    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i=0; i<3; i++) {
            account.deposit(1000);
        }
    }
}
 */


/*
//1. 线程不安全
public class AccountTest {
    public static void main(String[] args) {
        //如此，两个用户共用一个账户
        Account account = new Account(0);
        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);

        c1.setName("路人甲");
        c2.setName("路人乙");

        c1.start();
        c2.start();
    }
}

class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    //存钱
    public void deposit(double amt) {
        if (amt > 0) {
            balance += amt;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "存钱成功！余额为: " + balance);
        }
    }
}

class Customer extends Thread {
    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i=0; i<3; i++) {
            account.deposit(1000);
        }
    }
}
 */
