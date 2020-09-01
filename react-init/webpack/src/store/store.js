
// function reducer(state, action) {
//     console.log("calling reducer()", action)

//     state = state || {name: 'michael', age: 22}
//     switch(action.type) {
//       case CHANGE_NAME:
//         return {
//           ...state,
//           name: action.value
//         }
//       case ADD_AGE:
//         return {
//           ...state,
//           age: state.age + action.value
//         }
//       default:
//         return state;
//     }
// }

//#region redux拆分多个reducer
// import { createStore,combineReducers } from 'redux';
// import { CHANGE_NAME, ADD_AGE } from '../actions';
// // 可以生成多个reducer，然后将这些reducer合并成一个
// // 如果一个action来了，哪个reducer响应？全都响应

// function reducer1(state={name: 'michael'}, action) {
//   console.log('calling reducer1()', action)

//     switch(action.type) {
//       case CHANGE_NAME:
//         return {
//           ...state,
//           name: action.value
//         }
//       default:
//         return state
//     }
// }

// function reducer2(state={age:22}, action) {
//   console.log('calling reducer2()', action)
//   switch (action.type) {
//     case ADD_AGE:
//       return {
//         ...state,
//         age: state.age + action.value
//       }
//     default:
//       return state
//   }
// }

// let reducer = combineReducers({reducer1, reducer2})

// let store = createStore(reducer, window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__());

// export default store;
//#endregion

//#region 
import { createStore,combineReducers } from 'redux'
import { GET_USERS, ADD_USERS } from '../actions'

// 创建store
function users(state = [], action) {
  console.log('calling reducer()', action)

  switch(action.type) {
    case GET_USERS:
      return action.users;
    case ADD_USERS:
      return [
        ...state,
        action.user
      ]
    default:
      return state;
  }
}

let store = createStore(combineReducers({users}), window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__());

export default store;
//#endregion
