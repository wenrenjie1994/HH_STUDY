package cn.itcast;

/**
 * 问题：定义年龄时，无法解决不合理的年龄描述，如负年龄
 *解决方法：用private关键词对需要保护的成员变量进行修饰
 *
 * 一旦使用了private进行修饰，那么本类当中任然可以随意访问，但是超出了本类则不能直接访问
 *
 */
public class Person {
    String name;
    private int age;
    public void show(){
        System.out.println("我的名字是"+name+",年龄是"+age);
    }
    public void setAge(int num){
        if (num<100&&num>=0){
            age=num;
        }else {
            System.out.println("数据不合理");
        }
    }
    public int getAge(){
        return age;
    }
}
