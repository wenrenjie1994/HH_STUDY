package demo03;
/*多态访问成员变量的两种方式
* 1.直接通过对象名称访问成员变量，看等号左边是谁，优先用谁，没有则向上找
* 2.间接通过成员方法访问成员变量，看方法属于谁，优先用谁，没有则向上找
* 与继承中访问成员变量的规则相同
* */
public class Demo1MultiField {
    public static void main(String[] args) {

        //使用多态的写法，父类引用指向子类对象
        Fu obj=new Zi();
        System.out.println(obj.num);//父类：10
        //System.out.println(obj.age);//错误写法，不会向下找变量
        System.out.println("====================");
        //子类没有覆盖重写，就是父类：10
        //子类有覆盖重写，就是子类：20
        obj.showNum();
    }
}
