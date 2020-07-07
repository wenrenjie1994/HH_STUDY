public class Cat extends Animal implements Pet {
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("猫玩耍");
    }

    public Cat(String name) {
        super(4);
        this.name = name;
    }
    public Cat(){
        this("");
    }

    @Override
    public void eat() {
        System.out.println("猫吃猫粮");
    }

}
