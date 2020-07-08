## 内部类
###一、非静态与静态内部类
###1、非静态
* 实例化必须建立在外部类对象的基础上
* 可直接访问外部类的private实例属性与方法
```java
//非静态内部类
public class Hero {
    private String name; // 姓名
    class BattleScore {
        public void legendary() {
            System.out.println(name + "超神！");
        }
    }
}
```
###2、静态
* 不需要外部类的实例为基础
* 不可以访问外部类的实例属性和方法

###二、匿名类与本地类
### 1、匿名类
* 声明一个类的同时实例化它
* 使用外部局部变量必须修饰为final

### 2、本地类
* 有名字的匿名类

```java
//匿名类&本地类
public abstract class Hero {
    public abstract void attack();
      
    public static void main(String[] args) {
        //匿名类
        Hero h = new Hero(){
            //当场实现attack方法
            public void attack() {
                System.out.println("新的进攻手段");
            }
        };
        //本地类
        class SomeHero extends Hero{
            public void attack() {
                System.out.println( name+ " 新的进攻手段");
            }
        }
}
}
```

