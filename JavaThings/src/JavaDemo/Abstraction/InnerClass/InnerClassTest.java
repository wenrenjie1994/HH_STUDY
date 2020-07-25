package JavaDemo.Abstraction.InnerClass;

public class InnerClassTest {
    public static void main(String[] args) {
        //创建Body实例（static）
        Person.Body body = new Person.Body();
        body.show();

        //创建Brain实例（非static）
        Person person = new Person();
        Person.Brain brain = person.new Brain();
        brain.think();

        brain.display("feature");

    }
}

class Person {
    String feature = "Person.feature";
    String name;
    int age;

    public void work() {
        System.out.println("Code!!");
    }

    //非静态成员内部类
    class Brain {
        String feature = "Brain.feature";
        int IQ;

        public Brain() {

        }

        public void think() {
            //Person.this.work();
            work();

            System.out.println("thought!!");
        }

        public void display(String feature) {
            System.out.println(feature);
            System.out.println(this.feature);
            System.out.println(Person.this.feature);
        }
    }

    //静态成员内部类
    static class Body {
        String status;

        public void show() {
            System.out.println("healthy!!");
        }
    }

    //返回一个实现了Comparable接口的类的对象
    public Comparable getComparable() {

        //创建一个实现了Comparable接口的类：局部内部类
        class MyComparable implements Comparable {

            @Override
            public int compareTo(Object o) {
                return 0;
            }
        }

        return new MyComparable();

        /*
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
         */

    }

    public Person() {
        //局部内部类
        class C {

        }
    }

    public void method() {
        //局部内部类
        class A {

        }
    }

    {
        //局部内部类
        class B {

        }
    }
}