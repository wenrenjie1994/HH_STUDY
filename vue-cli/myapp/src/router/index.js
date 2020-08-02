import Vue from 'vue'
import VueRouter from 'vue-router'
import Film from '@/views/Film'
import Cinema from '@/views/Cinema'
import Center from '@/views/Center'
import NowPlaying from '@/views/Film/NowPlaying'
import ComingSoon from '@/views/Film/ComingSoon'
import Detail from '@/views/Detail'
import Login from '@/views/Login'
import City from '@/views/City'

Vue.use(VueRouter)

// const auth = {
//   isLogin () {
//     return false
//   }
// }

const routes = [
  {
    path: '/film',
    component: Film,
    children: [
      {
        path: '/film/nowplaying', // 绝对路径
        component: NowPlaying
      },
      {
        path: 'comingsoon',
        component: ComingSoon
      },
      {
        path: '',
        redirect: '/film/nowplaying'
      }
    ]
  },
  {
    path: '/cinema',
    component: Cinema
  },
  {
    path: '/center',
    alias: '/my',
    component: Center
  },
  {
    // 动态路由
    path: '/detail/:id', // /detail/字段
    name: 'komidetail',
    component: Detail,
    props: true
  },
  {
    path: '/login',
    component: Login
  },
  {
    path: '/city',
    component: City
  },
  {
    path: '*',
    redirect: '/film'
  }

]

const router = new VueRouter({
  // mode: 'history',
  // base: process.env.BASE_URL,
  routes
})

// 全局守卫
// router.beforeEach((to, from, next) => {
//   console.log(to)
//   if (to.path === '/center') {
//     console.log('全局盘查')
//     if (auth.isLogin()) {
//       next()
//     } else {
//       next('/login')
//     }
//   } else {
//     next()
//   }
// })

export default router
