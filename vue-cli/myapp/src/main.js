import Vue from 'vue' // ES6 模块导入方式 commJs var Vue = require('Vue')
import App from './App.vue' // var app = require('App.vue')
import router from './router'
import store from './store'
import All from './module/moduleA' // 导入所有的接口
import { java, python } from './module/moduleB' // 导入指定接口
// 引入element UI
// import ElementUI from 'element-ui'
// import 'element-ui/lib/theme-chalk/index.css'

// 引入Mint UI
import Mint from 'mint-ui'
import 'mint-ui/lib/style.css'

console.log(All)
console.log(java, python)

Vue.config.productionTip = false

// Vue.use(ElementUI)

Vue.use(Mint)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
