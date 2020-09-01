import React from 'react'
import AxiosUsersList from './components/fourth/AxiosUsersList'
import AxiosAddUsers from './components/fourth/AxiosAddUsers'
import AxiosUpload from './components/fourth/AxiosUpload'

//#region redux+路由
// import { connect } from 'react-redux'
// import './css/App.scss'
// import Child1 from './components/first/Child1'
// import Child2 from './components/first/Child2'
// import { Route, Link } from 'react-router-dom'

// class App extends React.Component {
//   state = {

//   }

//   fn () {
//       // 路由，用JS的方法跳到/c2的URL Router把props上放了history
//       this.props.history.push('/c2')
//   }
  
//   render () {
//     console.log('state:', this.state)
//     console.log('props:', this.props)
//     return <div className="App">
//       {/* <p>姓名：{ this.props.name }</p>
//       <p>年龄：{ this.props.age }</p> */}
//       <p>姓名：{ this.props.reducer1.name }</p>
//       <p>年龄：{ this.props.reducer2.age }</p>

//       <Link to='/c1'>Child1</Link><br/>
//       <Link to='/c2'>Child2</Link><br/>
//       <button onClick = { this.fn.bind(this) }>跳转至child2页面</button>

//       <Route path='/c1' component={ Child1 } />
//       <Route path='/c2' component={ Child2 } />
//     </div>
//   }
// }

// // export default App
// export default connect((state, props) => {
//   console.log('in connect', state, props)
//   return Object.assign({}, props, state)
// }, {})(App)
//#endregion

//#region fetch结合async的使用
// class App extends React.Component {
//   state = {
//     data: [],
//     imgUrl: ''
//   }

//   async componentDidMount() {
//     try{
//       let res = await fetch('/public/exist.json')
//       let data = await res.json()

//       console.log(data)
//       this.setState({
//         data
//       })
//     }catch(err) {
//       console.log(err)
//     }

//     try{
//       let res = await fetch('/public/beautiful.png')
//       let img = await res.blob()

//       console.log(img)
//       // createObjectURL在浏览器的内存中生成一个URL,在DOM被销毁以前，浏览器可以访问这个URL
//       let imgUrl = URL.createObjectURL(img)
//       this.setState({
//         img: imgUrl
//       })
//     }catch(err) {
//       console.log(err)
//     }
//   }
//   render () {
//     return (
//       <div>
//         <ul>
//           { this.state.data.map( (item, index) => {
//             return (
//               <li key={ index }>
//                 <div>{ item.name }</div>
//                 <div>{ item.age }</div>
//               </li>
//             );
//           })}
//         </ul>
//         <img src={ this.state.imgUrl } />
//       </div>
//     );
//   }
// }

// export default App
//#endregion

class App extends React.Component {
  state = {}

  render() {
    return (
      <div>
        <AxiosUsersList />
        <AxiosAddUsers />
        <AxiosUpload />
      </div>
    );
  }
}

export default App