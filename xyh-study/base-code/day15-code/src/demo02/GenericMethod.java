package demo02;
/*���庬�з��͵ķ�����
���Ͷ����ڷ��������η��ͷ���ֵ֮��
��ʽ��
���η� <����> ����ֵ���� ������(�����б�(ʹ�÷���)){
        ������
}
���з��͵ķ������ڵ��÷�����ʱ��ȷ�����͵���������
����ʲô���͵Ĳ��������;���ʲô����

*/
public class GenericMethod {
    //����һ�����з��͵ķ���
    public <M> void Method01(M m){

        System.out.println(m);

    }

    public static <M> void Method02(M m){

        System.out.println(m);

    }


}
