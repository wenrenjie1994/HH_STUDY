package demo03;

/*
 * 局部内部类
 * 定义：如果一个类是定义在一个方法内部的，那么这个类就是局部内部类
 * 【局部】：只有当前所属方法才能使用它。
 * 定义格式：
 * 修饰符 class 外部类名称{
 *    修饰符 返回值类型 外部方法名称(参数列表){
 *       class 局部内部类名称{
 *           //.....
 *       }
 *     }
 * }
 * 小结一下：
 * 权限修饰符
 * public>protected>(dafault)>private
 * 1.外部类：可以用public/default权限修饰符
 * 2.成员内部类：可以用 public、protected、(dafault)、private权限修饰符
 * 3.局部内部类：没有权限修饰符
 * */
public class Outer {
    public void methodOuter() {
        class Inner {
            int num = 10;
            public void methodInner() {
                System.out.println(num);
            }

        }
        Inner inner=new Inner();
        inner.methodInner();

    }

}


