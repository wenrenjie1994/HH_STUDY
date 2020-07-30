package demo01;

import java.util.Objects;

public class Person /*extends Object*/ {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    /*一般都是返回false值，所以没有意义，需要重写equals方法,比较两个对象的属性
    隐含一个多态的问题：无法使用子类特有的内容（属性和方法）
    Object object=new Person("Dora",18);
    解决方法：可以使用向下转型（强制转型，把obj的类型转化为Person）*/
/*    @Override
    public boolean equals(Object object){
        //增加一个判断，传递参数为自身，直接返回ture，提高程序的效率
        if(object.equals(this)){
            return true;
        }
        //增加一个判断，传递参数为空，直接返回false,提高程序效率
        if(object==null){
            return false;
        }
        //增加一个判断，防止类型转换异常
        if(object instanceof Person){
            //使用向下转型
            Person p=(Person)object;
            //比较两个对象的属性
            boolean b=(this.name.equals(p.name))&&(this.age==p.age);
            return b;
        }
        return false;

    }*/
    //使用快捷键也可以重写eaquals方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() &&
                Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //直接打印Object类的toString方法没有意义，需要重写
    /*@Override
   public String toString(){

        return "Person(name="+name+",age="+age+")";
    }*/

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }




}
