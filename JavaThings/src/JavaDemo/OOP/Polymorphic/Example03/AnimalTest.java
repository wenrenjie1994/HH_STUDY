package JavaDemo.OOP.Polymorphic.Example03;

public class AnimalTest {
    public static void main(String[] args) {
        AnimalTest test = new AnimalTest();
        test.func(new cat());
        func(new dog());

        Animal test1 = new dog();
        test1.eat();

    }

    public static void func(Animal animal) {
        animal.eat();
        animal.shot();
    }

}

class Animal {
    public void eat() {
        System.out.println("raw!!");
    }

    public void shot() {
        System.out.println("loud!!");
    }
}

class cat extends Animal {
    @Override
    public void eat() {
        System.out.println("fish!!");
    }

    @Override
    public void shot() {
        System.out.println("miao!!");
    }
}

class dog extends Animal {
    @Override
    public void eat() {
        System.out.println("bone!!");
    }

    @Override
    public void shot() {
        System.out.println("wang!!");
    }
}