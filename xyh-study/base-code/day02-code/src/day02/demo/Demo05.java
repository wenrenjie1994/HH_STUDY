package day02.demo;
/*总结：方法的注意事项
1.return后面的返回值必须和方法名称前面的返回类型保持一致。
2.方法应该定义在类中，但不能在方法当中再定义方法（不能嵌套）。
3.方法定义的前后顺序无所谓。
4.如果方法有返回值，必须写上“return 返回值”，不能没有。
5.对于void没有返回值的方法，可不写return或只写return本身。
6.一个方法当中可以有多个return语句，但必须保证同时只能有一个被执行，两个return不能连写。
7.方法定义后不会被执行，要执行需要调用该方法。
*/
public class Demo05 {
    public static void main(String[] args) {
        System.out.println(isSame(10,10));
        System.out.println(isSame(10,100));
    }
    //一个方法中可以有多个return语句
    public static boolean isSame(int a,int b){
        if(a==b){
            return true;
        } else{
            return false;
        }
    }
}
