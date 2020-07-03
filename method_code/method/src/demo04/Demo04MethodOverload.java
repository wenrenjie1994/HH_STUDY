package demo04;
/*
重载：overload，多个方法的名称一样，参数列表不一样
1.参数个数不同
2.参数类型不同
3.多类型顺序不同
重载与什么无关：
1.与参数名称无关
2.与方法返回值类型无关

*/
public class Demo04MethodOverload {
    public static void main(String[] args) {
        System.out.println(sum(10,20));
        System.out.println(sum(10,20,30));
        System.out.println(sum(10,20,30,40));
    }
    public static  int sum(int a,int b){
        return a+b;
    }
    public static  int sum(int a,int b,int c){
        return a+b+c;
    }
    public static  int sum(int a,int b,int c,int d){
        return a+b+c+d;
    }
    public static int sum(double a,double b){
        return (int)(a+b);
    }
}

