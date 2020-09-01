import { createStore } from 'redux'
// import { createStore,applyMiddleware } from 'redux'
import { counter } from './reducers'
import thunk from 'redux-thunk'

//生成一个store对象 applyMiddleware；应用上异步中间件
// const store = createStore(counter, applyMiddleware(thunk))
const store = createStore(counter)

export default store
