package abs.demo02;

/**
 * @program: TODO
 * @className:User
 * @description:TODO
 * @author: 何文艺
 * @create: 2020/7/31 16:15
 **/
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

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    //显示用户当前余额
    public void show() {
        System.out.println("我叫：" + name + ",我的余额：" + money);
    }
}
