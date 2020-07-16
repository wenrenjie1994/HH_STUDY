package demo03.extendsPractice;

public class User {
    private String name;//姓名
    private int money;//余额

    public User() {

    }

    public User(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void show(){
        System.out.println("我叫："+name+",我有："+money+"元");
    }
}
