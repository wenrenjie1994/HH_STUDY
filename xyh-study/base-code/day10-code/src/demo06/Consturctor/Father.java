package demo06.Consturctor;

public class Father {
    //父类无参构造
    public Father(){
        System.out.println("父类无参数的构造方法");
    }
    //父类有参数构造
    public Father(int num){
        System.out.println("父类有参数的构造函数,参数为"+num);
    }
}
