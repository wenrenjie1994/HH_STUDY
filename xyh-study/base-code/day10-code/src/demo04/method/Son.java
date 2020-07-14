package demo04.method;

public class Son extends Father{
    public void methodS(){
        System.out.println("子类方法执行");
    }
    public void method(){
        System.out.println("子类重名方法执行");
    }

    @Override//(检测是否为有效地方法重写)
    //若不写public，即default，修饰符权限小于父类public将报错
    public String methodOver(){
        return null;
    }
}
