class Person {
    constructor(name, age) {
        this.name = name
        this.age = age
    }
}

// 在 class 类中，可以使用 extends 关键字， 实现子类继承父类
class Chinese extends Person{
   constructor(name, age){
       super(name, age)
   }
}

const a = new Chinese('Michael', 20)
console.log(a)


class Janpanese extends Person{
    constructor(name, age){
        super(name, age)
    }
}

const b = new Janpanese('上田', 22)
console.log(b)