package demo02.MemberVariable;

public class Son  extends Father{
    int numSon=20;
    int num=40;
    public void methodSon(){
        //因为子类有num变量，所以该方法用的是子类自身的num=40
        System.out.println(num);
    }
}
