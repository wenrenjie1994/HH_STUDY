package demo02;

public class Demo04GenericInterface {
    public static void main(String[] args) {
        //创建GenericInterfaceImpl对象
        GenericInterfaceImpl gil =new GenericInterfaceImpl();
        gil.method("字符串");

        //创建GernericInterfaceImpl2对象
        GenericInterfaceImpl2<Integer> gi2=new GenericInterfaceImpl2<>();
        gi2.method(10);

        GenericInterfaceImpl2<Double> gi3=new GenericInterfaceImpl2<>();
        gi3.method(8.888);


    }
}
