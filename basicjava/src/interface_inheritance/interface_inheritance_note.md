# 接口与继承

## 一、接口(myinterface)

## 二、对象转型

## 三、重写（override）

## 四、多态（polymorphic）

## 五、隐藏

## 六、super

## 七、继承Object类

## 八、final
### 1、 FINAL修饰符
| final修饰符 | 效果                 |
| ----------- | -------------------- |
| 类          | 不能被继承           |
| 方法        | 不能被重写           |
| 变量        | 不能改变赋值         |
| 引用        | 不能改变所指向的对象 |

## 九、抽象类（abstractclass）
### 1、基本条件
* 继承抽象类的子类必须实现抽象方法
* 抽象类不能被实例化
* 抽象类可不提供抽象方法
### 2、抽象类与接口区别
| 区别         | 抽象类                           | 接口        |
| ------------ | -------------------------------- | ----------- |
| 子类继承个数 | 一个                             | 多个        |
| 类的作用范围 | public/protected/package/private | public      |
| 属性类别     | 静态/非静态，final/非final       | 静态，final |
| 子类方法实现     | 所有抽象方法       | 所有方法 |

## 十、内部类
### 1、非静态内部类
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
### 2、静态内部类
* 不需要外部类的实例为基础
* 不可以访问外部类的实例属性和方法
### 3、匿名类
* 声明一个类的同时实例化它
* 使用外部局部变量必须修饰为final
### 4、本地类
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

## 十一、默认方法