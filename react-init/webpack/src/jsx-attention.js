import React from 'react'
import ReactDOM from 'react-dom'

// 渲染数字
let a = 10

// 渲染字符串
let str = "你好， Java"

// 渲染boolean值
let boo = true

// 为属性绑定值
let title = '职业规划'

// 渲染一个JSX元素
const h2 = <h2>JSX语法糖</h2>

// 渲染JSX元素的数组
const arr = [
    <h2>这是h2</h2>,
    <h3>这是h3</h3>
]

// 将普通字符串数组转换为JSX 数组
const arrStr = ['Java', 'Python', 'Php', 'C++', 'C语言']
// 1、定义一个空数组，将来用来存放名称标签(手动for循环)
const myArr = []
// 注意： React中，需要把key添加给最外层元素
arrStr.forEach(item => {
    const temp = <h5 key={ item }>{ item }</h5>
    myArr.push(temp)
})

// arrStr.map((item) => {
//     const temp = <h5>{ item }</h5>
//     return myArr.push(temp)
// })

// 当我们需要在 jsx 控制的区域内，写JS表达式，则需要将JS代码写到{}中
ReactDOM.render(<h1>
    { a }
    <hr/>
    { str }
    <hr/>
    { boo.toString() }
    <hr/>
    <p title= { title }>这是p标签</p>
    <hr/>
    { h2 }
    <hr/>
    { arr }
    <hr/>
    { myArr }
    <hr/>
    { arrStr.map(item => <h4 key={ item }>{ item }</h4>)}
    </h1>, document.getElementById('app'))