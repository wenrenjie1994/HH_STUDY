package demo04.Interface;

/*
接口中的私有方法
问题描述：
我们需要抽取一个共有的方法，用来解决两个默认方法之间重复代码的问题
但是这个共有方法不应该让实现类使用，因此需要私有化

解决方案：
1.普通私有方法，解决多个默认方法之间重复代码问题
格式：
private 返回值类型 方法名称(参数列表){
//方法体
}
2.静态私有方法，解决多个静态方法之间重复代码问题
private static 返回值类型 方法名称(参数列表){
//方法体
}
*/
public interface MyInterfacePrivateA {
    public default void methodDefault1() {

        System.out.println("默认方法1");
/*        System.out.println("AAA");
        System.out.println("BBB");
        System.out.println("CCC");*/
        common();
    }

    public default void methodDefault2() {

        System.out.println("默认方法2");
        common();
       /* System.out.println("AAA");
        System.out.println("BBB");
        System.out.println("CCC");*/

    }
    private void common(){
        System.out.println("AAA");
        System.out.println("BBB");
        System.out.println("CCC");
    }

}

