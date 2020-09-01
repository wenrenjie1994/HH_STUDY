import React from 'react'

export default class Movie extends React.Component {
    // 在class关键字创建的组件中，如果需要使用 外界传递过来的 props 参数，不需要接受，直接通过this.props.** 获取即可
    // 注意：在 class 组件内部， this表示当前组件的实例对象
    constructor() {
        super()
        // 只有调用了 super() 后，才能使用 this 关键字
        // 这个this.state = {} 就相当于 Vue 中的data(){return {}}
        this.state = {
            msg: '大家好，我是class创建的Movie组件'
        }
    }
    render () {
        // 在 class 创建的组件中 this.state上的数据都是可读可写的
        // this.state.msg = 'msg的值被修改了'
        // 注意：不论是 class 还是普通 function 创建的组件 它们的props都是只读的
        // this.props.movieName = '生化危机'
        return <div>
           <h1>这是 Movie 组件</h1>
           <h2>{ this.state.msg }</h2>
           <p>{ this.props.movieName }</p>
           <p>{ this.props.date }</p>
        </div>
    }
}

// 注意：使用 class 关键字创建的组件，有自己的私有数据和生命周期函数
// 注意：使用 function 创建的组件，只有props，没有自己的私有数据和生命周期函数