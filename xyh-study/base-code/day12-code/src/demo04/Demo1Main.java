package demo04;
/*对象的向上转型，其实就是多态写法
* 格式：父类名称 对象名=new 子类名称();
* 含义：右侧创建一个子类对象，把它当作父类来看待使用
* 注意事项：向上转型一定是安全的，从小范围转向大范围。
* 类似于：
* double num=100;//正确的，int-->double,自动转换类型
* 问题：但是子类特有方法不能被调用
* 解决方案：对象的向下转型（还原）
* 格式：子类名称 对象名=（子类名称）父类对象
* 含义：将父类对象，【还原】成为【本来】的子类对象
*
* */
public class Demo1Main {
    public static void main(String[] args) {
        //创建了一只猫，把猫当作动物来看待使用
        Animal animal=new Cat();
        animal.eat();
       // animal.catMouse();//错误
        Cat cat =(Cat)animal;
        //向下转型，还原为猫（本来是猫，还原成猫，可以还原成功）
        cat.catchMouse();
        //向下转型,本来是猫，还原成狗，运行报错
        //Dog dog=(Dog) animal;//编译不报错，运行异常，classcastexception
    }
}
