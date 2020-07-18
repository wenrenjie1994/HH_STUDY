package Lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Lambda.Hero;
//把方法作为参数进行传递的编程思想
public class TestLambda {
    static Integer flag=0;//开启表示采用匿名类
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        //随机参数hero对象存入list
        for (int i = 0; i < 10; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);
        //0:直接方法筛选，1：匿名类筛选，2lambda筛选
        switch(flag){
            case 0:
                System.out.println("筛选出 hp>100 && damange<50的英雄");
                filter(heros);
            case 1:
                System.out.println("使用匿名类的方式，筛选出 hp>100 && damange<50的英雄");
                //匿名类实现接口，某个局部类只需要用一次，那么就可以使用匿名内部类
                HeroChecker checker = new HeroChecker() {
                    @Override
                    //实现test方法
                    public boolean test(Hero h) {
                        return (h.hp>100 && h.damage<50);
                    }
                };
                filter(heros,checker);
            case 2:
                //常见应用：替代匿名内部类
                System.out.println("使用Lamdba的方式，筛选出 hp>100 && damange<50的英雄");
                filter(heros,h->h.hp>100 && h.damage<50);
        }
    }
    //循环判断是否满足条件
    private static void filter(List<Hero> heros) {
        for (Hero hero : heros) {
            if(hero.hp>100 && hero.damage<50)
                System.out.print(hero);
        }
    }
    private static void filter(List<Hero> heros,HeroChecker checker) {
        for (Hero hero : heros) {
            if(checker.test(hero))
                System.out.print(hero);
        }
    }
}