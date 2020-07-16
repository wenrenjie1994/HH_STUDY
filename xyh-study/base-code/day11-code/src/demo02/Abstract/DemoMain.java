package demo02.Abstract;

public class DemoMain {
    public static void main(String[] args) {
        //Animal animal=new Animal(); ´íÎóÐ´·¨
        //Dog dog=new Dog(); ´íÎóÐ´·¨

        Dog2Ha dog2Ha=new Dog2Ha();
        dog2Ha.sleep();
        dog2Ha.eat();
        System.out.println("==================");

        DogGolden dogGolden=new DogGolden();
        dogGolden.sleep();
        dogGolden.eat();

    }
}
