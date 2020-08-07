import React from 'react'

// 创建并导出组件
export default function Hello(props) {
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

// 把组件暴露出去
// export default Hello

// 注意：使用 class 关键字创建的组件，有自己的私有数据和生命周期函数
// 注意：使用 function 创建的组件，只有props，没有自己的私有数据和生命周期函数