package demo02;

import java.util.ArrayList;
import java.util.Iterator;

/*���͵�ͨ���
* ����֪��ʹ��ʲô���������յ�ʱ�򣬴�ʱ����ʹ��?,?��ʾδ֪ͨ���
* ��ʱֻ�ܽ������ݣ������������д洢����
* ʹ�÷�����
* 1.���ܴ�������ʱʹ��
* 2.ֻ����Ϊ�����Ĳ���ʹ��
*
* */
public class Demo05Generic {
    public static void main(String[] args) {
        ArrayList<Integer> list01=new ArrayList<>();
        list01.add(1);
        list01.add(2);

        ArrayList<String> list02=new ArrayList<>();
        list02.add("a");
        list02.add("b");

        /*����һ���������ܱ����������͵�ArrayList���ϣ�
        * ��ʱ�����ǲ�֪��ArrayList����ʹ��ʲô���ͣ������÷���ͨ�������������������
        * ע�⣺����û�м̳еĸ���
        *
        * */

    }
    public static void printArray(ArrayList<?> list){
        Iterator<?> it=list.iterator();
        //it.next()����ȡ����Ԫ����Object,���Խ����������������
        while(it.hasNext()){
            Object o=it.next();
            System.out.println(o);
        }

    }
}
