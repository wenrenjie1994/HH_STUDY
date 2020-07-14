package demo04.method;

public class Father {
    public void methodF(){
        System.out.println("父类方法执行");
    }

    public void method(){
        System.out.println("父类重名方法执行");
    }

    public Object methodOver(){
        return null;
    }


}
