package basic.method.demo1.day15;

public class Demo {
    public static void main(String[] args) {
        Baozi bz = new Baozi();
        new BaoziPu(bz).start();
        new ChiHuo(bz).start();
    }
}
