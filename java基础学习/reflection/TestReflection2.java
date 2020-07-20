package reflection;
import java.lang.reflect.Constructor;
/**
 * @Author: QiuhaoRan
 * @Description:
 * @Date: Created in 17:27 2020/5/23
 * @Modified By:
 */
public class TestReflection2 {
    public static void main(String[] args) {
        //传统的使用new的方式创建对象
        Hero h1 =new Hero();
        h1.name = "teemo";
        System.out.println(h1+"//"+h1.name);

        try {
            //使用反射的方式创建对象
            String className = "qiuhaoran_q1_reflection.Hero";
            //类对象
            Class pClass=Class.forName(className);
            //构造器
            Constructor c= pClass.getConstructor();
            //通过构造器实例化
            Hero h2= (Hero) c.newInstance();
            h2.name="gareen";
            System.out.println(h2+"//"+h2.name);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
