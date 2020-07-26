package demo03;
/*在多态的代码中，成员方法的访问规则是：
*看new的是谁（右边），就优先用谁，没有则向上找。
* 口诀：编译看左边，运行看右边
* 对比访问成员变量：编译看左边，运行还是看左边
*
* */
public class Demo2MultiMethod {
    public static void main(String[] args) {
        Fu obj=new Zi();
        obj.method();//父子都有，优先看子（运行看右边）
        obj.methodFu();//子类没有，父类有，向上找到父类
       // obj.methodZi();//编译出错，编译看右边，父类没有子类特有的方法，
    }
}
