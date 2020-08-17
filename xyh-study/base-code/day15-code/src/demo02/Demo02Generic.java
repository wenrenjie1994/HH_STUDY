package demo02;

public class Demo02Generic {
    public static void main(String[] args) {
        //不写泛型默认为Object类型
        GenericClass gc=new GenericClass();
        gc.setName("字符串");
        Object obj=gc.getName();
        System.out.println(obj);

        //创建GenericClass对象，泛型使用Integre类型
        GenericClass<Integer> gc2=new GenericClass();
        gc2.setName(1);
        System.out.println(gc2.getName());

    }
}
