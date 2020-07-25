package JavaDemo.OOP.Keywords;

public class StaticTest {
    public static void main(String[] args) {
        Chinese.nation = "中国";

        Chinese c1 = new Chinese();
        c1.name = "Yao";
        c1.age = 38;

        Chinese c2 = new Chinese();
        c2.name = "Lin";
        c2.age = 30;

        c1.nation = "CHN";
        System.out.println(c2.nation);
        c2.nation = "CHINA";

        c1.daily();
    }

}

class Chinese {
    static String nation;
    String name;
    int age;

    public static void show() {
        System.out.println("nation: " + nation);
    }

    public static void walk() {
        System.out.println("High speed train!!");
    }

    public void daily() {
        System.out.println("Chinese food!!");
        info();
        System.out.println("name: " + name);

        walk();
        System.out.println("nation: " + nation);
    }

    public void info() {
        System.out.println("name: " + name + ", age: " + age);
    }

}
