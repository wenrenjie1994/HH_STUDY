package demo02;
/*
����һ�����з��͵��࣬ģ��ArrayList����
���������ʱ��ȷ����������
*
* */
public class GenericClass <E>{
    private E name;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}
