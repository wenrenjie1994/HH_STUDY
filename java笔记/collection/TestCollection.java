import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class TestCollection {
    // public static void main(String[] args) {
    // //容器类ArrayList，用于存放对象
    // ArrayList heros = new ArrayList<>();
    // heros.add(new Hero("盖伦"));
    // System.out.println(heros.size());

    // //容器的容量"capacity"会随着对象的增加，自动增长
    // //不需要想数组一样担心边界的问题
    // heros.add(new Hero("提莫"));
    // System.out.println(heros.size());
    // }

    // 使用add增加对象
    // public static void main(String[] args) {
    // ArrayList heros = new ArrayList<>();

    // // 把5个对象加入到ArrayList中
    // for (int i = 0; i < 5; i++) {
    // heros.add(new Hero("hero" + i));
    // }
    // System.out.println(heros);

    // // 在指定位置增加对象
    // Hero specialHero = new Hero("specialhero");
    // heros.add(3, specialHero);
    // System.out.println(heros.toString());
    // System.out.println(heros);

    // // 使用contains判断对象是否在集合中，而不是名字
    // System.out.println(heros.contains(new Hero("hero1")));// false
    // System.out.println(heros.contains(specialHero));// true

    // // 使用get获取指定位置的对象
    // System.out.println(heros.get(5));

    // // 使用indexOf获取对象所在的位置
    // System.out.println("specialHero所处的位置:" + heros.indexOf(specialHero));
    // // 不在集合中会是-1
    // System.out.println("新的英雄，但是名字是\"hero 1\"所处的位置:" + heros.indexOf(new
    // Hero("hero1")));

    // // 使用remove删除对象，可以根据下标和对象删除
    // heros.remove(2);
    // System.out.println("删除下标是2的对象");
    // System.out.println(heros);
    // System.out.println("删除special hero");
    // heros.remove(specialHero);
    // System.out.println(heros);

    // // 使用set替换指定位置的元素
    // heros.set(3, new Hero("specialhero"));
    // System.out.println(heros);

    // // size用来获取当前集合的大小
    // System.out.println(heros.size());

    // // toArray可以把集合变成数组，需要数组对象来接收
    // // Hero hs[] = (Hero[])heros.toArray(new Hero[]{});
    // // System.out.println(hs);

    // // addAll把另一个容器所有对象都加进来
    // ArrayList anotherHeros = new ArrayList();
    // anotherHeros.add(new Hero("hero a"));
    // anotherHeros.add(new Hero("hero b"));
    // anotherHeros.add(new Hero("hero c"));
    // System.out.println("anotherHeros heros: " + anotherHeros);
    // heros.addAll(anotherHeros);
    // System.out.println("把另一个ArrayList的元素都加入到当前ArrayList:");
    // System.out.println("ArrayList heros: " + heros);

    // //clear可以清空集合
    // anotherHeros.clear();
    // System.out.println(anotherHeros);

    // //ArrayList实现了接口List
    // List heros1 = new ArrayList();//接口引用指向子类对象（多态）
    // heros1.add( new Hero("盖伦"));
    // System.out.println(heros1.size());

    // //泛型Generic
    // List<Hero> genericheros = new ArrayList<Hero>();
    // List<Hero> genericheros2 = new ArrayList<>();

    // }

    public static void main(String[] args) {
        // 集合遍历
        List<MyHero> heros = new ArrayList<MyHero>();

        // 放5个Hero进入容器
        for (int i = 0; i < 5; i++) {
            heros.add(new MyHero("hero name " + i));
        }

        // 第一种遍历 for循环
        System.out.println("--------for 循环-------");
        for (int i = 0; i < heros.size(); i++) {
            MyHero h = heros.get(i);
            System.out.println(h);
        }

        // 第二种使用迭代器
        System.out.println("--------使用for的iterator-------");
        for(Iterator<MyHero> it = heros.iterator();it.hasNext();){
            MyHero hero = (MyHero)it.next();
            System.out.println(hero);
        }

        // 第三种，增强型for循环:不能进行初始化，只能遍历
        System.out.println("--------增强型for循环-------");
        for (MyHero h : heros) {
            System.out.println(h);
        }
    }

}