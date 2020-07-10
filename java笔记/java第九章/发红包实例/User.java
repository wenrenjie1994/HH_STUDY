package basic.method.demo1.day5;

public class User {
    private String name;
    private  int money;

    public String getName() {
        return name;
    }
    public void show(){
        System.out.println("我叫"+name+",我有"+money);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public User(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public User() {
    }
}
