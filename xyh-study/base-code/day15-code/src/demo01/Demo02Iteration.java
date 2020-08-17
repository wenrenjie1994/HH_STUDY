package demo01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
��������Collection����Ԫ��ͨ�õĻ�ȡ��ʽ��
�ڻ�ȡԪ��֮ǰ��Ҫ�жϼ�������û��Ԫ�ء�����а����Ԫ��ȡ�����������жϣ�
ֱ���������е�Ԫ��ȫ��ȡ����

java.util.Iteration
���������÷�����
1.boolean hasNext() �жϼ����Ƿ�����һ��Ԫ�أ��������Ԫ�ؿ��Ե������򷵻�ture
2.E next() ���ص�����һ��Ԫ��
Iteration����������һ���ӿڣ������޷�ֱ��ʹ�ã���Ҫʹ��Iteration�ӿڵ�ʵ�������
��ȡʵ����ķ�ʽ�Ƚ����⡣Collection�ӿ�����һ����������iterator(),���صľ��ǵ�������ʵ�������

ע��it.next():�����������飬1.ȡ����һ��Ԫ�أ�2.��ָ���ƶ���һλ
ʹ�ò��裺
1.ʹ�ü����еķ���iterrator()��ȡ��������ʵ�������ʹ��Iterator�ӿڽ���
2.ʹ��Iterator�ӿ��еķ���hasNext�жϻ���û����һ��Ԫ��
3.ʹ��Iterator�ӿ��еķ���nextȡ�������е���һ��Ԫ��
*/
public class Demo02Iteration {
    public static void main(String[] args) {
        Collection <String> coll=new ArrayList<>();
        coll.add("Dora");
        coll.add("Marry");
        coll.add("Tom");
        coll.add("Tonny");
        /*
         1.ʹ�ü����еķ���iterator()��ȡ��������ʵ�������ʹ��Iterator�ӿڽ��գ���̬��
         ע�⣺
         Iterator<E>�ӿ�Ҳ�з��ͣ��������ķ��͸��ż����ߣ�����ʲô���ͣ�����������ʲô����
        */
        Iterator<String> it=coll.iterator();
        //2.ʹ��Iterator�ӿ��еķ���hasNext�жϻ���û����һ��Ԫ��
        boolean b=it.hasNext();
        System.out.println(b);
        String s=it.next();
        System.out.println(s);
        System.out.println("====================");
        while(it.hasNext()){
            String  e=it.next();
            System.out.println(e);
        }
        System.out.println("====================");
        for (Iterator<String> it2=coll.iterator();it2.hasNext();){
            String  e=it2.next();
            System.out.println(e);
        }

    }
}
