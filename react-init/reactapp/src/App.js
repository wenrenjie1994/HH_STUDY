import React from 'react';

//#region antd组件简单应用
// import { Input, Button, Select} from 'antd';
// import 'antd/dist/antd.css';
// import './App.scss';

// const Search = Input.Search
// const Option = Select.Option

// class App extends React.Component {
//   state = {
//     list: [],
//     val: ''
//   }

//   handleChange = (event) => {
//     let val = event.target.value
//     this.setState({
//       val
//     })
//   }

//   handleAdd = () => {
//     let { val, list } = this.state
//     list.push(val)
//     this.setState({
//       list
//     })
//   }

//   handleSearch = (value) => {
//     let { list } = this.state
//     list.push(value)
//     this.setState({
//       list
//     })
//   }

//   render() {
//     const {val, list} = this.state
//     const options = []

//     return (
//       <div>
//         <p>Welcome to my home!</p>
//         <h1>Hello komi</h1>
//         <Input type='text' onChange={this.handleChange } value={ val } style={{ width: 290 }}/>
//         <Button type='primary' onClick={ this.handleAdd }>添加</Button>
//         <ul>
//           {
//             list.map((item, index) => {
//               options.push(<Option>{ item }</Option>)
//               return <li key={ index }>{ item }</li>
//             })
//           }
//         </ul>
//         <div>
//           <Search style={{ width: 350 }} enterButton='添加' onSearch={ this.handleSearch }></Search>
//           <br/>
//           <Select>
//             {options}
//           </Select>
//         </div>
//       </div>
//     );
//   }
  
// }

// export default App;
//#endregion

function App() {
  return <div>
    <h1>Hello React</h1>
  </div>
}

export default App

