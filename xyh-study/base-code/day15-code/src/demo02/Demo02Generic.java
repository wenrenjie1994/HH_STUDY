package demo02;

public class Demo02Generic {
    public static void main(String[] args) {
        //��д����Ĭ��ΪObject����
        GenericClass gc=new GenericClass();
        gc.setName("�ַ���");
        Object obj=gc.getName();
        System.out.println(obj);

        //����GenericClass���󣬷���ʹ��Integre����
        GenericClass<Integer> gc2=new GenericClass();
        gc2.setName(1);
        System.out.println(gc2.getName());

    }
}
