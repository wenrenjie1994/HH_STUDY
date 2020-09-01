function Person(name, age) {
    this.name = name
    this.age = age
}

Person.info = 'python'

Person.prototype.say = function () {
    console.log('这是 Person 的实例方法')
}

// 静态方法
Person.show = function () {
    console.log('这是 Person 的静态方法')
}

const p = new Person('许多多', 18)
console.log(p)

p.say()

Person.show()

console.log("================================")

// 注意：在 class 的 {} 区间内，只能写构造器、静态方法、静态属性、实例方法
// 注意：class 关键字内部还是用原来的配方实现的(构造函数),所以把 class 关键字，称作语法糖
class Animal {
    constructor(name, age) {
        this.name = name
        this.age = age
    }

    static info = 'Python'

    // 此处为实例方法
    scream() {
        console.log('这是 Animal 的实例方法')
    }

    // 这是 Animal 类的静态方法·
    static show() {
        console.log('这是 Animal 的静态方法')
    }
}

const a = new Animal('Coco', 3)
console.log(a)
console.log(Animal.info)
Animal.show()

