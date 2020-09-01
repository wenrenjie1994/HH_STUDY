// webpack-dev-server 打包好的 main.js 是托管到了内存中，故在项目目录中看不到
// 1、导入接收的成员名必须符合语法
import React from 'react' // 创建组件 虚拟DOM元素 生命周期
import ReactDOM from 'react-dom' // 把创建好的 组件和虚拟DOM 放到页面上展示

// 2.创建虚拟DOM元素
// 参数1：创建的元素的类型，字符串 表示元素的名称
// 参数2：是一个对象或null 表示当前这个 DOM 元素的属性
// 参数3：子节点(包括 其他虚拟DOM 获取文本子节点)
// 参数n: 其他子节点
// const myh1 = React.createElement('h1',null,'Hello komi')

// const myh1 = React.createElement('h1', {
//     id: 'myh1',
//     title: 'this is a h1'
// }, "Hello Komi")

// const mydiv = React.createElement('div', null, "这是一个div元素", myh1)

// 渲染 页面上的DOM结构 最好的方式，是写HTML代码
// 注意： 在JS文件中 默认不能写类似于HTML的标记
// 可以使用 babel 来转换这些JS中的标签
// 注意：这种在JS中混合写入类似于 HTML的语法 叫做JSX语法
// 注意：JSX 语法的本质 还是在运行的时候，被转换成了React.createElement 形式来执行的
const mydiv = <div id='mydiv' title='div'>
    这是一个div元素
    <h1>这是一个h1</h1>
    </div>


// 3、使用 ReactDOM 把虚拟DOM渲染到页面上
// 参数1：要渲染的那个虚拟容器
// 参数2：指定页面上一个容器 接收DOM元素而不是一个选择器

ReactDOM.render(mydiv, document.getElementById('app'))


