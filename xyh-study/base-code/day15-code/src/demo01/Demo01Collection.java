package demo01;
import java.util.ArrayList;
import java.util.Collection;

/*
һ��Collection:������java���ṩ��һ������������������Ŷ�����ݡ�
���������������
1.����ĳ����ǹ̶��ģ����ϵĳ����ǿɱ��
2.�����д洢����ͬһ���͵�Ԫ�أ�����ʹ������������ֵ��
���ϴ洢�Ķ��Ƕ��󣬶��Ҷ�������Ϳ��Բ�һ�¡�

����ѧϰ���ϵ�Ŀ�꣬1.��ʹ�ü��ϴ洢���ݣ�2.��������ϣ�3.����ÿһ�ּ��ϵ�����
���ϵĿ�ܣ�
List�ӿڣ�1.����ļ��ϡ�2.����洢�ظ�Ԫ�ء�3.������������ʹ����ͨ��forѭ������
�����У�Vector���ϡ�ArrayList���ϡ�LinkedList����
Set�ӿڣ�1.������洢�ظ�Ԫ�ء�2.û������������ʹ����ͨ��forѭ������
�����У�TreeSet���ϣ����򣩡�HashSet����(����)��LinkedHashSet���ϣ�����
List�ӿ���Set�ӿھ��̳���Collection�ӿڡ�
Collection�ӿڣ��������������е��м����й��Է��������е��м��϶�����ʹ�ù��Եķ�����
û�������ķ�����
���Ͽ�ܵ�ѧϰ��ʽ��
1.ѧϰ���㣺ѧϰ����ӿ�/�������й��Եķ������������඼����ʹ��
2.ʹ�õײ㣺���㲻�ǽӿھ��ǳ����࣬�޷���������ʹ�ã���Ҫʹ�õײ����ഴ������ʹ��
����Collection���ϵĳ��÷���
�κε��м��϶�����ʹ��Collection�ӿ��еķ���
���Է�����
public boolean add(E e)���Ѹ����Ķ�����ӵ���ǰ������
public void clear():��ռ��������е�Ԫ��
public boolean remove(E e):�Ѹ����Ķ����ڵ�ǰ������ɾ��
public boolean contains(E e):�жϵ�ǰ�������Ƿ���������Ķ���
public int size():���ؼ�����Ԫ�صĸ���
public Object[] toArray():�Ѽ����е�Ԫ�أ��洢��������
* */
public class Demo01Collection {
    public static void main(String[] args) {
        //��������Ԫ�أ�����ʹ�ö�̬
        Collection<String> coll=new ArrayList<>();
        System.out.println(coll);//��д��toString��������ӡ�ǵ�ַ
        boolean b1=coll.add("����");
        coll.add("����");
        coll.add("����");
        System.out.println("b1="+b1);//true
        System.out.println(coll);
        System.out.println("=======================");

        boolean b2=coll.remove("����");
        System.out.println("b2="+b2);
        System.out.println(coll);
        boolean b3=coll.remove("С��");
        System.out.println("b3="+b3);
        System.out.println(coll);

        System.out.println("=======================");
        boolean b4=coll.contains("С��");
        boolean b5=coll.contains("����");
        System.out.println("b4="+b4);
        System.out.println("b5="+b5);

        System.out.println("=======================");
        boolean b6=coll.isEmpty();
        System.out.println("b6="+b6);

        System.out.println("=======================");
        int size=coll.size();
        System.out.println("size="+size);
        System.out.println("=======================");
        Object[] arr=coll.toArray();
        for (int i = 0; i <arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("=======================");
        coll.clear();
        System.out.println(coll);
        System.out.println(coll.isEmpty());



    }
}
