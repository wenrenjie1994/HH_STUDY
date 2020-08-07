import React from 'react'
import { useParams,useHistory } from 'react-router-dom'
// import { Button } from 'antd'
import 'antd/dist/antd.css'
import './app.scss'
import { Button } from 'antd'

export default function Detail() {
    const params = useParams()
    const history = useHistory()
    return <div className='container'>
        <h1>This is detail</h1>
        { JSON.stringify(params.id)}
        <p>当前参数值为： { params.id }</p>
        <Button onClick={ () => {
            history.push('/')
        }}>跳转到首页</Button>
    </div>
}

// export default class Detail extends React.Component {
//     handleJump = () => {
//         this.props.history.push('/login')
//     }

//     render () {
//         return <div className='container'>
//             <h1>Welcome to my App!</h1>
//             <p>当前的参数Id值为：{ this.props.match.params.id }</p>
//         </div>
//     }
// }