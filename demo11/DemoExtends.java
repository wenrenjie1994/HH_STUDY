package fu.day04.demo11;
/*继承
格式：
父类： public class 名称{

}

子类：
public class 名称 extends 父类名{

}

在继承关系当中，如果成员变量重名，则创建子类对象时，访问有两种方式

1。直接通过子类对象访问成员变量
    等号左边是谁就优先用谁，没有则向上查找
    到处都没有，报错
2。间接通过成员方法访问成员变量
    该方法属于谁就优先用谁，没有就向上找

在继承关系中，创建子类对象，访问成员方法的的规则
       创建的对象时谁。就优先用谁，没有就向上找


 */
public class DemoExtends {
    public static void main(String[] args) {
        Teacher teacher =new Teacher();
        teacher.method();//子类对象里什么都没写，但是他继承了父类的方法method

        Emploree emploree=new Emploree();

        System.out.println(teacher.num);//优先子类，20

        teacher.methodzi();//子类中的方法，与参数
        teacher.methodfu();//10父类的参数
        teacher.method1();//30;20;10

    }
}
