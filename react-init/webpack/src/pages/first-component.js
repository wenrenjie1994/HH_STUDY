import React from 'react'
import ReactDOM from 'react-dom'

// 第一种创建组件的方式
function Hello(props) {
    // 如果在一个组件中 return null，则表示此组件是空的，什么都不会渲染
    // return null

    // 在组件中，必须返回一个合法的 JSX 虚拟DOM元素
    console.log(props)
    // 结论：无论是Vue还是React 组件中的props都是只读的
    return <div>
        <p>这是 Hello 组件</p>
        <h3>{ props.name }</h3>
        <h3>{ props.age }</h3>
        <h3>{ props.gender }</h3>
    </div>
}

const user = {
    name: '张三',
    age: 18,
    gender: '男'
}

ReactDOM.render(/*<Hello name= { user.name } age={ user.age } gender={ user.gender }/>*/
    <Hello { ...user }/>, document.getElementById('app'))