package basic.method.demo1;

public class DemoParam {
    public static void main(String[] args) {
        Student one = new Student();
        one.name = "梁";
        one.age = 18;
        method(one);
    }
    public static void method (Student param){
        System.out.println(param.name);
        System.out.println(param.age);

    }

}

