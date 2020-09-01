import React from 'react'
export default class BindInputValue extends React.Component {
    constructor(){
        super()
        this.state = {
            msg: 'Java & Node'
        }
    }

    handleClick = () => {
        this.setState({
            msg: 'Java is the King'
        }, function() {
            console.log(this.state.msg)
        })
    }

    // 每当文本框内容发生变化，必然会调用 textChanged 函数
    textChanged = (e) => {
        // 在 onChange 事件中，获取文本框的值，有两种方案
        // 方案1： 通过事件参数 e 来获取
        console.log(e.target.value)
        //方案2： 通过ref来获取
        console.log(this.refs.txt.value)
        const newVal = e.target.value
        this.setState({
            msg: newVal
        })
    }

    render () {
        return <div>
            <button onClick={ () => { this.handleClick() }}>点我</button>
            <h3>{ this.state.msg }</h3>
            {/*如果我们只是把文本框的 value 属性，绑定到 state 状态， 但是 如果不提供 onChange 处理函数的话， 得到的文本框将会是一个只读的文本框 */}
            {/*当为文本框绑定了 value 后，要么提供一个readOnly 要么提供一个onChange处理函数 */}
            <input type="text" style={{ width: '50%' }} value={ this.state.msg } onChange={ (e) => { this.textChanged(e) }} ref='txt'/>
        </div>
    }
}