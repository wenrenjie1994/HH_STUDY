package Thread.DemoTest;

public class BankTest {
    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();

        System.out.println(bank1);
        System.out.println(bank2);

    }
}

//单例模式之懒汉式
class Bank {
    private Bank() {

    }

    private static Bank instance  = null;

    public static Bank getInstance() {
        //1.
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }
        //2.
        if (instance == null) {
            synchronized (Bank.class) {
                instance = new Bank();
            }
        }
        return instance;
    }
}