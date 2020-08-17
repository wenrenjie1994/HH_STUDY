package demo02;
/*测试含有泛型的方法*/
public class Demo03GenericMethod {
    public static void main(String[] args) {
        GenericMethod gm=new GenericMethod();
        /*调用含有泛型的方法method01
        * 传递什么类型，泛型就是什么类型
        * */
        gm.Method01("mmm");
        gm.Method01(11);
        gm.Method01(8.88);
        gm.Method01(true);

        /*调用含有泛型的静态方法,最好使用类名进行调用*/
        GenericMethod.Method02("3345ttt");

    }
}
