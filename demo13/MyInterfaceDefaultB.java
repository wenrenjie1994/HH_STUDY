package fu.day04.demo13;

public class MyInterfaceDefaultB implements MyInterfaceDefault {
    @Override
    public void methodAbs() {
        System.out.println("实现抽象方法，BBB");
    }

    @Override
    public void methodAbaA() {
        System.out.println("实现类B重写了默认方法");
    }
}
