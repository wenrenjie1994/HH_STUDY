package demo02;

import java.util.ArrayList;
import java.util.Collection;

/*���͵������޶���? extends E ����ʹ�÷���ֻ����E���͵��������E
* ���͵������޶���? super E  ����ʹ�÷���ֻ����E���͵ĸ������E
*
* */
public class Demo06Generic {
    public static void main(String[] args) {
        Collection<Integer> list1=new ArrayList<>();
        Collection<String> list2=new ArrayList<>();
        Collection<Number> list3=new ArrayList<>();
        Collection<Object> list4=new ArrayList<>();

        /*������֮��ļ̳й�ϵ
        * Integer extengds Number
        * Number extends Object
        * String  extengds Object
        * */
        getElement1(list1);
       // getElement1(list2);//����
        getElement1(list3);
       // getElement1(list4);//����

        //getElement2(list1);//����
       // getElement2(list2);//����
        getElement2(list3);
        getElement2(list4);


    }
    //�������ޣ�Number����Number������
    private static void getElement1(Collection<? extends Number> coll) {

    }

    //�������ޣ�Number����Number�ĸ���
    private static void getElement2(Collection<? super Number> coll) {

    }
}
