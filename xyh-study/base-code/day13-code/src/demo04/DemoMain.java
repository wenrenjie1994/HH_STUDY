package demo04;
/*
*如果接口的实现类，或者是父类的子类，只需要使用唯一的一次，
* 那么这种情况下就可以省略掉该类的定义，而使用【匿名内部类】
* 匿名内部类的定义格式：
* 接口名称 对象名=new 接口名称(){
*   //覆盖重写接口中所有抽象方法
* };
*
* 对格式进行解析“new 接口名称(){......}”
* 1.new 代表创建对象的动作
* 2. 接口名称就是匿名内部类需要实现哪个接口
* 3.{......}这才是匿名内部类的内容
*
* 注意：
* 1.匿名内部类，在创建对象的时候，只能使用唯一的一次,
* 如果需要多次创建对象，且实现内容一样，则需要单独定义类
* 2.匿名对象与匿名内部类的区别（匿名对象和匿名内部类不是一回事）
* 匿名对象，在调用方法的时候，只能调用唯一的一次，
* 如果希望同一个对象调用多个方法，必须给对象起名字
* 匿名内部类是省略了【实现类/子类名称】，但是匿名对象是省略了【对象名称】
* */
public class DemoMain {
    public static void main(String[] args) {
        //MyInterface impl=new MyInterfaceImpl();
        //impl.method();

        //使用匿名内部类,对象名为ObjA，类是匿名的，对象没有匿名
        MyInterface objA=new MyInterface() {
            @Override
            public  void  method(){
                System.out.println("实现类覆盖重写了方法");
            }
            public  void  method2(){
                System.out.println("实现类覆盖重写了方法2");
            }
        };
        System.out.println("===============objA===========");
        objA.method();
        objA.method2();
        MyInterface objB=new MyInterface() {
            @Override
            public  void  method(){
                System.out.println("实现类覆盖重写了方法");
            }
            public  void  method2(){
                System.out.println("实现类覆盖重写了方法2");
            }
        };
        System.out.println("================objB=============");
        objB.method();
        objB.method2();
        //使用了匿名内部类，而且省略了对象名称，也是匿名对象
        System.out.println("================匿名对象=============");
        new MyInterface() {
            @Override
            public  void  method(){
                System.out.println("实现类覆盖重写了方法");
            }
            public  void  method2(){
                System.out.println("实现类覆盖重写了方法2");
            }
        }.method();
        //因为匿名对象无法调用第二次，所以需要再创建一个匿名内部类的匿名对象
        new MyInterface() {
            @Override
            public  void  method(){
                System.out.println("实现类覆盖重写了方法");
            }
            public  void  method2(){
                System.out.println("实现类覆盖重写了方法2");
            }
        }.method2();
    }
}
