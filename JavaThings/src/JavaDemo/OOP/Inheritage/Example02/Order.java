package JavaDemo.OOP.Inheritage.Example02;

public class Order {
    private int orderPrivate;
    int orderDefault;
    protected int orderProtected;
    public int orderPublic;

    private void methodPrivate() {
        orderPrivate = 1;
        orderDefault = 2;
        orderProtected = 3;
        orderPublic = 4;
    }
    void methodDefault() {

    }
    protected void methodProtected() {

    }
    public void methodPublic() {

    }
}
