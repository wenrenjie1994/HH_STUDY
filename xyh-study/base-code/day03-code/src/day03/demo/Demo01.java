package day03.demo;
/*方法的重载：多个方法的名称一样，但参数列表不一样
方法重载与下列因素相关：
1.参数个数不同
2.参数类型不同
3.参数的多类型顺序不同

方法重载与下列因素无关：
1.与参数的名称无关
2.与方法的返回值类型无关
3.与修饰符无关（public、static）
*/
public class Demo01 {
    public static void main(String[] args) {

        System.out.println(sum(10,20));
        System.out.println(sum(10,20,30));
        System.out.println(sum(10,20,30,40));


    }

    public static int sum(int x,int y){
        return x+y;
    }

    public static int sum(int a,int b,int c){
        return a+b+c;
    }

    public static int sum(int a,int b,int c,int d){
        return a+b+c+d;
    }


}
