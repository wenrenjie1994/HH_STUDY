import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestLambda {

    // 使用普通方法筛选数据
    // public static void main(String[] args) {
    // Random r = new Random();
    // List<MyHero> heros = new ArrayList<MyHero>();
    // for (int i = 0; i < 10; i++) {
    // heros.add(new MyHero("hero " + i, r.nextInt(1000), r.nextInt(100)));
    // }
    // System.out.println("初始化后的集合：");
    // System.out.println(heros);
    // System.out.println("筛选出 hp>100 && damange<50的英雄");
    // filter(heros);
    // }

    // private static void filter(List<MyHero> heros) {
    // for (MyHero hero : heros) {
    // if (hero.hp > 100 && hero.damage < 50)
    // System.out.println(hero);
    // }
    // }

    // 通过匿名类的方式，首先需要准备一个接口HeroCheck
    // public static void main(String[] args) {
    // Random r = new Random();
    // List<MyHero> heros = new ArrayList<MyHero>();
    // for (int i = 0; i < 10; i++) {
    // heros.add(new MyHero("hero " + i, r.nextInt(1000), r.nextInt(100)));
    // }
    // System.out.println("初始化后的集合：");
    // System.out.println(heros);
    // System.out.println("使用匿名类筛选出 hp>100 && damange<50的英雄");
    // //传递匿名对象
    // HeroChecker checker = new HeroChecker(){
    // public boolean test(MyHero h){
    // return(h.hp>100 && h.damage<50);
    // }
    // };
    // filter(heros, checker);
    // //使用Lambda方式筛选出数据,同样是调用filter方法
    // //引入Lambda表达式，会使代码更加紧凑，缺点是可读性差
    // System.out.println("使用Lambda筛选出 hp>100 && damange<50的英雄");
    // filter(heros, h->h.hp>100 && h.damage<50);
    // }

    // private static void filter(List<MyHero> heros,HeroChecker checker){
    // for(MyHero hero:heros){
    // if(checker.test(hero))
    // System.out.println(hero);
    // }
    // }

    // 引用静态方法
    // filter(heros, TestLambda::testHero);

    // 引用对象方法
    // TestLambda testLambda = new TestLambda();
    // filter(heros, testLambda::testHero);

    // 引用容器中的对象的方法
    // filter(heros, Hero::matched);

    // 引用构造器
    // 第一种
    // Supplier<List> s = new Supplier<List>() {
    // public List get() {
    // return new ArrayList();
    // }
    // };
    // List list1 = getList(s);
    // 第二种
    // List list2 = getList(()->new ArrayList());
    // 第三种
    // List list3 = getList(ArrayList::new);

    // 通过聚合操作方式遍历数据
    public static void main(String[] args) {
        Random r = new Random();
        List<MyHero> heros = new ArrayList<MyHero>();
        for (int i = 0; i < 10; i++) {
            heros.add(new MyHero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }

        System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("查询条件：hp>100 && damage<50");
        System.out.println("通过传统操作方式找出满足条件的数据：");

        for (MyHero h : heros) {
            if (h.hp > 100 && h.damage < 50)
                System.out.println(h.name);
        }

        // 聚合操作
        System.out.println("通过聚合操作方式找出满足条件的数据：");
        heros
                // 管道源：对于集合Collection而言，调用stream()切换成管道源
                .stream()
                // 中间操作：又返回一个Stream
                .filter(h -> h.hp > 100 && h.damage < 50)
                // 结束操作：流的最后一个操作，什么都不返回
                .forEach(h -> System.out.println(h.name));

        // 当管道源是数组的情况下，需要调用Arrays.stream(xxx)
        System.out.println("数组通过聚合操作方式遍历所有数据：");
        MyHero mh[] = heros.toArray(new MyHero[heros.size()]);
        Arrays.stream(mh).forEach(h -> System.out.println(h.name));

        // 其他中间操作
        // 对元素进行筛选：
        // distinct 去除重复(根据equals判断)
        System.out.println("去除重复的数据，去除标准是看equals");
        heros.stream().distinct().forEach(h -> System.out.print(h));
        // sorted 自然排序
        // sorted(Comparator<T>) 指定排序
        System.out.println("按照血量排序");
        heros.stream().sorted((h1, h2) -> h1.hp >= h2.hp ? 1 : -1).forEach(h -> System.out.print(h));
        // limit 保留
        System.out.println("保留3个");
        heros.stream().limit(3).forEach(h -> System.out.print(h));
        // skip 忽略
        System.out.println("忽略前3个");
        heros.stream().skip(3).forEach(h -> System.out.print(h));

        // 转换为其他形式的流：
        // mapToDouble 转换为double的流
        System.out.println("转换为double的Stream");
        heros.stream().mapToDouble(MyHero::getHp).forEach(h -> System.out.println(h));
        // map 转换为任意类型的流
        System.out.println("转换任意类型的Stream");
        heros.stream().map((h) -> h.name + " - " + h.hp + " - " + h.damage).forEach(h -> System.out.println(h));

        // 其他结束操作
        // toArray() 转换为数组
        System.out.println("返回一个数组");
        Object[] hs= heros
            .stream()
            .toArray();
        System.out.println(Arrays.toString(hs));
        // min(Comparator<T>) 取最小的元素
        System.out.println("返回伤害最低的那个英雄");
        MyHero minDamageHero =
        heros
            .stream()
            .min((h1,h2)->h1.damage-h2.damage)
            .get();
        System.out.print(minDamageHero);
        // max(Comparator<T>) 取最大的元素
        System.out.println("返回伤害最高的那个英雄");
        MyHero mxnDamageHero =
                heros
                .stream()
                .max((h1,h2)->h1.damage-h2.damage)
                .get();
        System.out.print(mxnDamageHero);  
        // count() 总数
        System.out.println("流中数据的总数");
        long count = heros
                .stream()
                .count();
        System.out.println(count);
        // findFirst() 第一个元素
        System.out.println("第一个英雄");
        MyHero firstHero =
                heros
                .stream()
                .findFirst()
                .get();       
        System.out.println(firstHero);
    }
}