package demo02;

public class Demo2InnerClass {
    public static void main(String[] args) {
        Outer.Inner obj=new Outer().new Inner();
        obj.methodInner();
    }
}
