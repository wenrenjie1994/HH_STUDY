import React from 'react';
// import React, { Children } from 'react';
import ReactDOM from 'react-dom';
import Router from './router/router'

// import App from './App'
// import './map.css'

//#region 原生部分
// import './index.css';
// import App from './App';
// import * as serviceWorker from './serviceWorker';

// ReactDOM.render(
//   <React.StrictMode>
//     <App />
//   </React.StrictMode>,
//   document.getElementById('root')
// );

// // If you want your app to work offline and load faster, you can change
// // unregister() to register() below. Note this comes with some pitfalls.
// // Learn more about service workers: https://bit.ly/CRA-PWA
// serviceWorker.unregister();
//#endregion

//#region 数组
// let arr = [1,2,3,4,5,6,7,8,9]
// // 没有返回值
// arr.forEach((item,index) => {
//   console.log(item)
//   console.log(index)
// })

// let array = ['香蕉', '苹果', '雪梨', '葡萄']
// // map 对数组的每一项进行加工，加工完成后返回一个新的数组
// let result = array.map((item, index) => {
//   let str = index + item
//   return str
// })
// console.log(result)

// let digit = [1,2,3,4,5,6,7,8,9]
// // filter 过滤 将想要的内容进行筛选，返回想要的内容
// let res = digit.filter((item, index) => {
//   return item %2 == 0? true : false
// })
// console.log(res)

// let dig =  [1,2,3,4,5,6,7,8,9]
// // reduce 是对整个数组进行整合，将数组中的每一项内容整合后，返回一个内容
// let rest = dig.reduce((prev, next, index) => {
//   return prev + next
// }, 0)
// console.log(rest)

// // for...in... 主要用于遍历对象 不适用于遍历数组
// // for...of... 可以用来遍历数组 类数组对象，字符串 set/map,generator
// let obj = {
//   name: '张三',
//   age: 18
// }

// for (const key in obj) {
//   console.log(obj[key])
// }

// let as = ['范冰冰', '李晨', '鹿晗']
// for (const item of as) {
//   console.log(item)
// }
//#endregion

//#region 动态渲染显示当前时间写法1
// function showLocalDateTime() {
//   let nowTime = new Date().toLocaleTimeString()
//   let ele = <div>
//       <h1>现在的时间是: { nowTime }</h1>
//     </div>
//   let root = document.querySelector('#root')
//   ReactDOM.render(ele, root)
// }


// showLocalDateTime()

// setInterval(showLocalDateTime, 1000)
//#endregion

//#region 动态渲染显示当前时间写法2
// const localTime = new Date().toLocaleTimeString()

// function ShowClock(props) {
//   return <div>
//     <h1>现在时间：{ props.time }</h1>
//     <h2>这是函数式组件开发</h2>
//   </div>
// }

// ReactDOM.render(<ShowClock time={ localTime }/>, document.getElementById('root'))
//#endregion

//#region 动态渲染显示系统时间写法3
// class ShowSecondlyTime extends React.Component {
//   constructor(props){
//     super(props)
//     this.state = {
//       time: new Date().toLocaleTimeString()
//     }
//   }
//   render () {
//     return <div>
//       <h2>当前系统时间：{ this.state.time } </h2>
//     </div>
//   }

//   componentDidMount() {
//     setInterval(() => {
//       this.setState({
//         time: new Date().toLocaleTimeString()
//       }, function () {
//         console.log(this.state.time)
//       })
//     }, 1000)
//   }
// }

// ReactDOM.render(<ShowSecondlyTime/>, document.querySelector('#root'))
//#endregion

//#region 父传子实现
// import './props.css'
// class ParentComponent extends React.Component {
//   constructor (props) {
//     super(props)
//     this.state = {
//       isShow: true
//     }
//     this.handleClick = this.handleClick.bind(this)
//   }
//   render () {
//     return <div>
//       <button onClick={ this.handleClick }>点我你就变脸</button>
//       <ChildComponent isShow={ this.state.isShow }/>
//     </div>
//   }

//   handleClick() {
//     this.setState({
//       isShow: !this.state.isShow
//     })
//   }

// }

// class ChildComponent extends React.Component {

//   render () {
//     let strClass = this.props.isShow ? ' active' : ''
//     return <div className={ 'content' + strClass }>
//       <h1>我是子元素</h1>
//     </div>
//   }
// }

// ReactDOM.render(<ParentComponent />, document.querySelector('#root'))
//#endregion

//#region 子传父实现
  // class ParentComponent extends React.Component {
  //   constructor(props) {
  //     super(props)
  //     this.state = {
  //       childData: null
  //     }
  //   }
  //   render () {
  //     return <div>
  //       <h1>子元素传递给父元素的数据：{ this.state.childData }</h1>
  //       <ChildComponent setChildData={ this.setChildData }/>
  //     </div>
  //   }
  
  //   setChildData = (data) => {
  //     this.setState({
  //       childData: data
  //     })
  //   }
  // }
  
  
  // class ChildComponent extends React.Component {
  //   constructor(props) {
  //     super(props)
  //     this.state = {
  //       msg: 'Nice to meet you!'
  //     }
  //   }
  //   render () {
  //     return <div>
  //       <button onClick={ this.handleClick }>点我传数据</button>
  //       <button onClick={ () => this.props.setChildData('Hello React') }>点我传数据</button>
  //     </div>
  //   }
  
  //   handleClick = () => {
  //     this.props.setChildData(this.state.msg)
  //   }
  // }
  
  
  // ReactDOM.render(<ParentComponent />, document.getElementById('root'))
//#endregion

//#region React事件传参
// class ParentComponent extends React.Component {
//   constructor(props) {
//     super(props)
//     this.state = {

//     }
//   }
//   render () {
//     return <div>
//       <form action="http://www.baidu.com">
//       <div className="child">
//         <h1>这是父元素</h1>
//         <button onClick= { this.parentEvent }>提交</button>
//       </div>
//       </form>
//       <button onClick= { () => { this.parEvent('Java & Node') }}>点我</button>
//       {/*不使用ES6*/}
//       <button onClick= { function(e) {this.parEvent('不使用ES6')}.bind(this)}>点我</button>
//     </div>
//   }
//   parentEvent = (e) => {
//     console.log(e.preventDefault)
//     e.preventDefault()
//   }

//   parEvent = (msg) => {
//     console.log(msg)
//   }
// }


// ReactDOM.render(<ParentComponent/>, document.getElementById('root'))
//#endregion

//#region React条件渲染
// function UserGreet(props) {
//   return <h1>Welcome to my home!</h1>
// }

// function UserLogin(props) {
//   return <h1>请先登录</h1>
// }

// class ParentComponent extends React.Component {
//   constructor(props) {
//     super(props)
//     this.state = {
//       isLogin: false
//     }
//   }

//   render () {
//     let element = this.state.isLogin ? <UserGreet/> : <UserLogin/>
//     return <div>
//       { element }
//     </div>
//   }
// }

// ReactDOM.render(
//   <ParentComponent/>, document.getElementById('root')
// )
//#endregion

//#region 列表渲染
// let arr = [
//   '小明', '小黑', '小白'
// ]

// 将普通对象转换为JSX对象
// let arrHtml = [<li>小明</li>,<li>小黑</li>,<li>小白</li>]
// function ListItem(props) {
//   return <div>
//           <ul>
//             <li>
//               <h3>姓名：{ props.name }</h3>
//               <p>年龄：{ props.age }</p>
//             </li>
//           </ul>
//         </div>
// }

// class Item extends React.Component {
//   constructor(props) {
//     super(props)
//   }
//   render () {
//     return <div>
//       <ul>
//         <li onClick={(e)=> {this.handleClick(this.props.index, this.props.data.name, this.props.data.age, e)} }>
//           <h3>姓名：{ this.props.data.name }</h3>
//           <p>年龄：{ this.props.data.age }</p>
//         </li>
//       </ul>
//     </div>
//   }

//   handleClick = (index, name, age, e) => {
//       alert((index+1)+' '+name+" "+age)
//       console.log(e.target)
//   }
// }

// class Welcome extends React.Component {
//   constructor(props) {
//     super(props)
//     this.state = {
//       list: [
//         {
//           name: '张三',
//           age: 18
//         },
//         {
//           name: '李四',
//           age: 20
//         },
//         {
//           name: '王五',
//           age: 19
//         },
//         {
//           name: '赵六',
//           age: 22
//         },
//         {
//           name: '田七',
//           age: 21
//         }
//       ]
//     }
//   }
//   render () {
//     // let listArr = []
//     // for (let i=0; i<this.state.list.length; i++) {
//     //   let item = <li>
//     //     <h3>姓名：{ this.state.list[i].name }</h3>
//     //     <p>年龄：{ this.state.list[i].age }</p>
//     //   </li>
//     //   listArr.push(item)
//     // }

//     let listArr = this.state.list.map((item, index) => {
//       return <div key={ index }>
//         <Item data={ item } index={ index }/>
//       </div>
//     })
//     return <div>
//       <h1>今日内容</h1>
//       <ul>
//         {/* { arrHtml } */}
//         { listArr }
//       </ul>
//     </div>
//   }
// }

// ReactDOM.render(
//   <Welcome />, document.getElementById('root')
// )
//#endregion

//#region 组件生命周期
// class ParentComponent extends React.Component {
//   constructor(props) {
//     super(props)
//     this.state = {
//       isShow: true
//     }
//   }
//   render () {
//    return this.state.isShow ? <div>
//      <button onClick={ this.handleRemove }>移除组件</button>
//      <ComponentLife/>
//      </div>: <div>将ComponentLife移除</div>
//   }

//   handleRemove = () => {
//     this.setState({
//       isShow: false
//     })
//   }
// }

// class ComponentLife extends React.Component {
//   constructor(props) {
//     super(props)
//     this.state = {
//       msg: 'Hello komi'
//     }
//     console.log('constructor构造函数')
//   }

//   componentWillMount() {
//     console.log('componentWillMount将要渲染')
//   }

//   componentDidMount() {
//     console.log('componentDisMount组件渲染完毕')
//   }

//   componentWillReceiveProps() {
//     console.log('componentWillReceiveProps组件将要接受新的state或props')
//   }

//   shouldComponentUpdate() {
//     return true
//   }

//   componentWillUpdate () {
//     console.log('componentWillUpdate组件将要更新')
//   }
//   componentDidUpdate () {
//     console.log('componentDidUpdate组件更新完成')
//   }

//   componentWillUnmount() {
//     console.log('componentWillUnmount将要被销毁')
//   }

//   render () {
//     return <div>
//       <h1>{ this.state.msg }</h1>
//       <div onClick={ this.handleClick }>组件更新</div>
//     </div>
//   }

//   handleClick = () => {
//     this.setState({
//       msg: 'Hello Java'
//     })
//   }
// }

// ReactDOM.render(<ParentComponent/>, document.querySelector('#root'))
//#endregion

//#region
ReactDOM.render(<Router />, document.getElementById('root') )
//#endregion
