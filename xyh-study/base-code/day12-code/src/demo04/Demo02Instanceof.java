package demo04;
/*如何才能知道一个父类引用的对象，本来是什么子类
* 格式：
*对象 instanceof 类名称
* 返回一个boolean值，也就是判断前面的对象能不能当作后面类型的实例
*
*
* */


public class Demo02Instanceof {
    public static void main(String[] args) {
        Animal animal=new Cat();
        animal.eat();//猫吃鱼

        //安全向下转型
        //判断父类引用animal本来是不是Dog
        if(animal instanceof Dog){
            Dog dog=(Dog) animal;
            dog.watchHouse();
        }
        if(animal instanceof Cat){
            Cat cat=(Cat) animal;
            cat.catchMouse();
        }
    }

    public static void giveMyPet(Animal animal){
        if(animal instanceof Dog){
            Dog dog=(Dog) animal;
            dog.watchHouse();
        }
        if(animal instanceof Cat){
            Cat cat=(Cat) animal;
            cat.catchMouse();
        }
    }
}
