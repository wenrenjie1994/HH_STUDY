package demo02;

import java.util.ArrayList;
import java.util.Iterator;

/*
* ���ͣ���һ��δ֪���������ͣ������ǲ�֪��ʹ��ʲô�������͵�ʱ�򣬿���ʹ�÷���
* ����Ҳ���Կ�����һ������������������������
* E e��Element
* T t��Type����
* ArrayList�����ڶ����ʱ��֪�����϶���洢ʲô���͵����ݣ���������ʹ���˷���E
* public class ArrayList<E>{
*   public boolean add(E e){}
*   public E get (int index){}
* }
* ע���������϶����ʱ�򣬾ͻ�ȷ�����͵���������
* ArrayList <String> list=new ArrayList<String>();
* public class ArrayList<String>:����String����E
* */
public class Demo01Fanxing {
    public static void main(String[] args) {
        show01();
    }

    private static void show01() {
        /*�������϶��󣬲�ʹ�÷���
        * �ô������ϲ�ʹ�÷��ͣ�Ĭ�ϵ�������Object���ͣ����Դ洢�������͵�����
        * �׶ˣ�
        * ����ȫ���������쳣
        *
        * */
        ArrayList list=new ArrayList();
        list.add("abc");
        list.add(1);
        Iterator it=list.iterator();
        while (it.hasNext()){
            Object obj=it.next();
            System.out.println(obj);
            //��Ҫʹ��String�����еķ�����length��ȡ�ַ����ĳ��ȣ���̬��Object obj="abc";
            //����ת��
            String s=(String)obj;
            //����ȫ�����������쳣
            System.out.println(s.length());//���׳�.ClassCastException:���ܽ�Integer����ת��ΪString����
        }
    }
}
