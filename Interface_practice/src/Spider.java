public class Spider extends Animal {
    private static final int legs=8;
    @Override
    public void eat() {
        System.out.println("Spider吃虫子");
    }
    public Spider(){
        super(legs);
    }
}
