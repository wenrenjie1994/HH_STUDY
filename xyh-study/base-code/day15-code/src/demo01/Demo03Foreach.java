package demo01;

import java.util.ArrayList;

/*
* ��ǿforѭ������������
 * �ײ�ʹ�õ�Ҳ�ǵ�������ʹ��forѭ���ĸ�ʽ�����˵���������д
 * Collection<E>extends Iterable<E>:���еĵ��м��϶�����ʹ����ǿforѭ��
 * public interface Iterable<T>ʵ�ֽӿ���������Ϊ��foreach�����Ŀ��
 *
 * ��ǿforѭ���������������Ϻ�����
 * ��ʽ��
 * for(����/������������� ������:��������/��������){
 *          sout(i);
 * }
 * ע��Ŀ��ֻ����Collection�������顣
* */
public class Demo03Foreach {
    public static void main(String[] args) {
        demo01();
        demo02();

    }

    private static void demo02() {
        ArrayList<String> list=new ArrayList<>();
        list.add("Dora");
        list.add("Tom");
        list.add("Timmy");
        for(String s:list){
            System.out.println(s);
        }
    }

    private static void demo01() {
        int [] arr={1,2,3,6,9};
        for(int i:arr){
            System.out.println(i);
        }
    }
}
