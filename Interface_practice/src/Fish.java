public class Fish extends Animal implements Pet {
    private String name;

    @Override
    public void eat() {
        System.out.println("fish eat");
    }
    //      鱼没有腿
    public Fish() {
        super(0);
    }

    @Override
    public void walk() {
        System.out.println("Fish has no legs");
    }

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
        System.out.println("fish play");
    }
}
