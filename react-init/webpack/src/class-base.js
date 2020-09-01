// ES6 中 class 关键字，是实现面向对象编程的体现
function Person(name, age) {
    // 实例属性
    this.name = name
    this.age = age
}

// 通过 new 出来的实例 访问到的属性称为实例属性
const p = new Person('许多多', 18)
console.log(p)

// 静态属性：通过构造函数直接访问的属性
Person.info = 'python'

console.log("================================")

// 创建一个DOM类
class Animal {
    // 每一个类中都有一个构造器 如果没有手动指定构造器 那么可以认为类内部有个隐形的空构造器
    // 构造器的作用：初始化参数
    constructor(name, age) {
        this.name = name
        this.age = age
    }

    // 在class 内部通过static 修饰的属性，就是静态属性
    static info = 'Python'
}

const a = new Animal('Coco', 3)
console.log(a)
console.log(Animal.info) // info 是Animal的静态属性


