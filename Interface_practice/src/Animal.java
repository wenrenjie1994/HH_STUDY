abstract class Animal {
    protected int legs;

    protected Animal(int legs) {
        this.legs = legs;
    }



    public abstract void eat();

    public void walk() {
        System.out.println("有"+legs+"条腿");
    }

}
