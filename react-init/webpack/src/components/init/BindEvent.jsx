//#region 绑定事件，并在事件处理函数中 使用this.setState 
import React from 'react'
export default class BindEvent extends React.Component {
    constructor(){
        super()
        this.state = {
            msg: '嘻嘻',
            name: '张三',
            age: 18,
            gender: '男'
        }
    }

    // handleClick (){
    //     console.log('ok')
    // }

    handleClick = (arg1) => {
        console.log('Java is King', arg1)
        // 注意：在 React 中，如果想为 state 中的数据，重新赋值，不要使用this.state.***= 值 而应该调用 this.setState({msg:'Java & Node'})
        // this.state.msg = 'Java & Node'
        // 在 React 中推荐使用 this.setState({}) 修改状态值
        this.setState({
            // 在 setState 中只会把对应的 state 状态更新 而不会覆盖其他的 state状态
            msg: 'Java & Node'
        }, function() {
            console.log(this.state.msg)
        })

        // 注意： this.setState 方法的执行 是异步的 如果在调用 this.setState 之后，又想立即拿到最新的 state 值，需要使用 this.setState({}, callback)
        // console.log(this.state.msg)
    }

    render () {
        return <div>
            {/*React 中有自己的事件绑定机制 事件名是小驼峰命名形式 */}
            {/* <button onClick={ this.handleClick }>点我</button> */}
            {/*注意：onClick 只接受 function 作为处理函数 */}
            {/*注意：箭头函数本身就是一个匿名的 function 函数 */}
            {/* <button onClick={ () => { this.handleClick() } }>点我</button> */}
            <button onClick={ () => this.handleClick('说实话') }>点我</button>
            {/*点击按钮 修改msg的值 */}
            <h3>{ this.state.msg }</h3>
        </div>
    }
}
//#endregion 
