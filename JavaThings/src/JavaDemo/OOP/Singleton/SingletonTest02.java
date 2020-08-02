package JavaDemo.OOP.Singleton;

/**
 * @Description 懒汉式的线程安全问题
 * @author liuclo
 * @date 2020/8/2 15:40
 */

public class SingletonTest02 {
    public static void main(String[] args) {
        Customer customer = Customer.getInstance();
        Customer customer1 = Customer.getInstance();

        System.out.println(customer == customer1);
    }
}

//懒汉式单例模式
class Customer {
    //构造器私有化
    private Customer() {

    }

    //声明当前类对象，且为static
    private static Customer instance = null;

    //声明public、static的返回当前对象的方法，此处存在线程不安全问题
    public static Customer getInstance() {
        if (instance == null) {
            instance = new Customer();
        }
        return instance;
    }
}
