package Method;

/*
题目要求：
定义一个方法：用来判断两个数字是否相同。
 */

public class DemoMethodSame {
    public static void main(String[] args) {
        System.out.println(isSame(10,20));
        System.out.println(isSame(20,20));
    }
    public static boolean isSame(int a, int b){
/*        boolean same;
        if(a==b){
            same = true;
        }else {
            same = false;
        }*/

        //boolean same = a ==b ? true:false;

        boolean same = a==b;

        return a==b;
    }
}
