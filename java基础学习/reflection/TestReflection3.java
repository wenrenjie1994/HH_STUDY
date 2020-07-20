package reflection;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Constructor;

/**
 * @Author: QiuhaoRan
 * @Description:
 * @Date: Created in 17:43 2020/5/23
 * @Modified By:
 */
public class TestReflection3 {
    public static void main(String[] args) throws InterruptedException {
        Hero h = getHero();
        System.out.println(h);
    }

    public static Hero getHero() {

        File f = new File("C:\\Users\\47506\\IdeaProjects\\HH_STUDY\\反射\\qiuhaoran_q1_reflection\\hero.config");

        try (FileReader fr = new FileReader(f)) {
            String className = null;
            char[] all = new char[(int) f.length()];
            fr.read(all);
            className = new String(all);
            //类对象
            Class clazz=Class.forName(className);
            //构造器
            Constructor c= clazz.getConstructor();
            Hero h= (Hero) c.newInstance();
            return h;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
