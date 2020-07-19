package JavaDemo.OOP.encapsulation;

public class CustomerTest {
    public static void main(String[] args) {
        Customer customer = new Customer();

        customer.eat();
        customer.setCost(5.0);
    }
}

class Customer {
    //filed
    String name;
    String nation;
    public int age;
    boolean isStudent;
    double cost;

    //method
    public String getName() {
        return name;
    }
    public String getNation() {
        return nation;
    }
    public void setCost(double cost) {
        this.cost = cost;
        System.out.println("cost " + cost + "$");
        eat();
    }
    public void eat() {
        System.out.println("eat meat!");
    }
    public void sleep(int hour) {
        System.out.println("should rest " + hour + " hour!");
    }
}
