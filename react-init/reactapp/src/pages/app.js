
import { Link } from 'react-router-dom'
import React from 'react'
import 'antd/dist/antd.css'
import './app.scss'

//#region 路由、重定向以及React Hooks的使用
// import React, { useState, useEffect } from 'react'
// import { Button } from 'antd'
// export default function App() {
//     const [count, setCount] = useState(0)
//     // 组件加载和组件数据发生变化都会加载 当第二个参数为空数组时，只会加载一次
//     useEffect(() => {
//         console.log('执行了useEffect')
//     }, [])
//     return <div className='container'>
//         <h1>Welcome to my App!</h1>
//         <p>This is app</p>
//         <Link to='/login'> 
//           点击跳转到登录页面
//         </Link>
//         <br/>
//         <Link to='/home'>
//             点击跳转至主页面
//         </Link>
//         <br/>
//         <p>当前Count次数： { count }</p>
//         <Button onClick={ () => { setCount(count+1)} }>更新次数</Button>
//     </div>
// }

// export default class App extends React.Component {
//     handleJump = () => {
//         this.props.history.push('/login')
//     }

//     render () {
//         return <div>
//             <h1>Welcome to my App!</h1>
//             <p>This is app</p>
//             <Link to='/login'> 
//             点击跳转到登录页面
//             </Link>
//             <br/>
//             <Link to='/home'>
//                 点击跳转至主页面
//             </Link>
//             <br/>
//             <Button onClick={ this.handleJump }>点我跳转</Button>

//         </div>
//     }
// }
//#endregion

export default function App() {
    return <div className='container'>
        <h1>Welcome to my App!</h1>
        <Link to='/login'> 
          去登录
        </Link>
        <br/>
        <Link to='/home'>
            去主页
        </Link>
        <br/>
    </div>
}