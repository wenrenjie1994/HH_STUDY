class Person {
    constructor(name, age) {
        this.name = name
        this.age = age
    }
    sayHello() {
        console.log('Hello, nice to meet you!')
    }
}

// 在 class 类中，可以使用 extends 关键字， 实现子类继承父类
class Chinese extends Person{
   // 1、为什么一定要在 constructor 中调用 super
   // 答：如果一个子类， 通过extends 关键字继承了父类，那么，在子类的 conbstructor 构造函数中，必须优先调用 super()
   // 2、super是什么
   // 答：super是一个函数，而且它是父类的构造器，子类中的 super其实就是父类中 constructor 构造器的一个引用
   constructor(name, age, identity){
       super(name, age)
       this.identity = identity
   }
  
}

const a = new Chinese('Michael', 20, '513437xxxxx01118490')
console.log(a)
a.sayHello()


class Janpanese extends Person{
    constructor(name, age){
        super(name, age)
    }
}

const b = new Janpanese('上田', 22)
console.log(b)
b.sayHello()