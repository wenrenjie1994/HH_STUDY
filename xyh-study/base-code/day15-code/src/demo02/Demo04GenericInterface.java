package demo02;

public class Demo04GenericInterface {
    public static void main(String[] args) {
        //����GenericInterfaceImpl����
        GenericInterfaceImpl gil =new GenericInterfaceImpl();
        gil.method("�ַ���");

        //����GernericInterfaceImpl2����
        GenericInterfaceImpl2<Integer> gi2=new GenericInterfaceImpl2<>();
        gi2.method(10);

        GenericInterfaceImpl2<Double> gi3=new GenericInterfaceImpl2<>();
        gi3.method(8.888);


    }
}
