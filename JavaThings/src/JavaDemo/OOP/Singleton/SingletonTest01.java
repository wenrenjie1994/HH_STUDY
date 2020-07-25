package JavaDemo.OOP.Singleton;

/**
 * 只存在一个对象实例
 */

public class SingletonTest01 {
    public static void main(String[] args) {
        Bank bank = Bank.getInstance();
        Bank bank1 = Bank.getInstance();

        System.out.println(bank == bank1);
    }
}

//饿汉式单例模式
class Bank {
    //私有化构造器
    private Bank() {

    }

    //内部创建类的对象，此对象申明为static
    private static Bank instance = new Bank();

    //提供公共的方法，返回类的对象
    public static Bank getInstance() {
        return instance;
    }
}
