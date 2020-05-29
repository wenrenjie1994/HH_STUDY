package reflection;

import java.lang.reflect.Method;

import Hero;

public class GetMethodDemo {

    public static void main(String[] args) {
        Hero h = new Hero();

      /*  try {
            // 获取这个名字叫做setName，参数类型是String的方法
            Method m = h.getClass().getMethod("setName", String.class);
            // 对h对象，调用这个方法
            m.invoke(h, "盖伦");
            // 使用传统的方式，调用getName方法
            System.out.println(h.getName());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        File f = new File("hero.config");

        try (FileReader fr = new FileReader(f)) {
            String fileContent = null;
            char[] all = new char[(int) f.length()];
            fr.read(all);
            fileContent = new String(all);
            String[] cs = fileContent.split("\r\n");
            String hero1className = cs[0];
            String hero1Name = cs[1];
            String hero2className = cs[2];
            String hero2Name = cs[3];

            //根据反射，获取hero1，并且给hero1的name字段赋值
            Class hero1Class = Class.forName(hero1className);
            Constructor hero1Constructor = hero1Class.getConstructor();
            Object hero1 = hero1Constructor.newInstance();
            Field hero1NameField = hero1Class.getField("name");
            hero1NameField.set(hero1, hero1Name);

            //根据反射，获取hero2,并且给hero2的name字段赋值
            Class hero2Class = Class.forName(hero2className);
            Constructor hero2Constructor = hero2Class.getConstructor();
            Object hero2 = hero2Constructor.newInstance();
            Field hero2NameField = hero2Class.getField("name");
            hero2NameField.set(hero2, hero2Name);

            //根据反射，获取attackHero方法，并且调用hero1的这个方法，参数是hero2
            Method attackHeroMethod = hero1Class.getMethod("attackHero", Hero.class);
            attackHeroMethod.invoke(hero1, hero2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    }
}