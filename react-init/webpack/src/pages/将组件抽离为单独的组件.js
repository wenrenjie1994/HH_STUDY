import React from 'react'
import ReactDOM from 'react-dom'

// 导入自定义组件 默认如果不做单独的配置 不能省略.jsx后缀名
import Hello from '@/components/Hello'

const user = {
    name: '张三',
    age: 18,
    gender: '男'
}

ReactDOM.render(/*<Hello name= { user.name } age={ user.age } gender={ user.gender }/>*/
    <Hello { ...user }/>, document.getElementById('app'))