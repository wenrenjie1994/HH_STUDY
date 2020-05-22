package qiuhaoran_q1_reflection; /**
 * @Author: QiuhaoRan
 * @Description:
 * @Date: Created in 16:07 2020/5/22
 * @Modified By:
 */
import qiuhaoran_q1_reflection.Hero;
public class TestReflection {

    public static void main(String[] args) {
        String className = "qiuhaoran_q1_reflection.Hero";
        try {
            //获取类对象的3种方式
            Class pClass1=Class.forName(className);
            Class pClass2=Hero.class;
            Class pClass3=new Hero().getClass();

            System.out.println(pClass1==pClass2);
            System.out.println(pClass1==pClass3);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}