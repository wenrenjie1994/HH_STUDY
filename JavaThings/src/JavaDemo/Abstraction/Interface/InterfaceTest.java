package JavaDemo.Abstraction.Interface;

public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);
//        Flyable.MIN_SPEED = 2;        //error

        Plane plane = new Plane();
        plane.fly();
        plane.stop();

    }
}

interface Flyable {
    //全局常量
    public static final int MAX_SPEED = 7900;
    int MIN_SPEED = 1;

    //抽象方法
    public abstract void fly();
    void stop();
}

interface Attack {
    //抽象方法
    void attack();
}

interface Weapon extends Flyable, Attack {
    //抽象方法
    void lethality();
}

//实现接口
class Plane implements Flyable {
    @Override
    public void fly() {
        System.out.println("KongKe A123");
    }

    @Override
    public void stop() {
        System.out.println("Land!!");
    }
}

abstract class Kite implements Flyable {
    @Override
    public void fly() {
        System.out.println("Run");
    }
}

class Bullet extends Object implements Flyable, Attack {
    @Override
    public void fly() {
        System.out.println("fast!!");
    }

    @Override
    public void stop() {
        System.out.println("hit!!");
    }

    @Override
    public void attack() {
        System.out.println("kill!!");
    }
}


