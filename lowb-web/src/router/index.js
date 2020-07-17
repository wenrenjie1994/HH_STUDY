import Vue from 'vue'
import Router from 'vue-router'

import Login from '../pages/login/login'
import NotFound from '../pages/error-page/404'
import Forbidden from '../pages/error-page/403'
import Layout from '../pages/layout/index'
import Home from '../pages/home/index'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/',
      redirect: 'home'
    }
  ]
})

/* 准备动态添加的路由 */
export const DynamicRoutes = [
  {
    path: '',
    component: Layout,
    name: 'container',
    redirect: 'home',
    meta: {
      requiresAuth: true,
      name: '首页'
    },
    children: [
      {
        path: 'home',
        component: Home,
        name: 'home',
        meta: {
          name: '首页',
          icon: 'el-icon-s-home'
        }
      }
    ]
  },
  {
    path: '/403',
    component: Forbidden
  },
  {
    path: '*',
    component: NotFound
  }
]
