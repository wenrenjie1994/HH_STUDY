package demo02;
/*���з��ͽӿڵĵ�һ��ʹ�÷�ʽ������ӿ�ʵ���࣬ʵ�ֽӿڣ�ָ���ӿڵķ���
* public interface Iterator<E>
*Sanner��ʵ����Iterator�ӿڣ���ָ���ӿڵķ���ΪString��
* ������д��next��������Ĭ�Ͼ����ַ���
* public final calss Scanner implements Iterrator<String>{
*    public String next();
* }
* */
public class GenericInterfaceImpl implements GenericInterface <String>{
    @Override
    public void method(String s){
        System.out.println(s);
    }



}
