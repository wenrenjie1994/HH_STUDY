package demo02;
/*���Ժ��з��͵ķ���*/
public class Demo03GenericMethod {
    public static void main(String[] args) {
        GenericMethod gm=new GenericMethod();
        /*���ú��з��͵ķ���method01
        * ����ʲô���ͣ����;���ʲô����
        * */
        gm.Method01("mmm");
        gm.Method01(11);
        gm.Method01(8.88);
        gm.Method01(true);

        /*���ú��з��͵ľ�̬����,���ʹ���������е���*/
        GenericMethod.Method02("3345ttt");

    }
}
