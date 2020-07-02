package class_object.singleton;

//使用饿汉式单例模式, 把Hero类改造成为单例模式

public class Hero {
    private Hero(){}
    private static Hero instance = new Hero();
    public static Hero getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        Hero h1 = Hero.getInstance();
        Hero h2 = Hero.getInstance();
        Hero h3 = Hero.getInstance();

        System.out.println(h1==h2);
        System.out.println(h1==h3);
    }
}
