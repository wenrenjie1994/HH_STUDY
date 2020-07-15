// import router from '../../router/index'
// import { routeList } from '../../router/routes'
// import { setDefaultRoute } from '../../utils/route'

// export default {
//   namespaced: true,
//   state: {
//     // 所有路由
//     routes: null,
//     // 导航菜单
//     sidebarMenu: [],
//     // 当前active导航菜单
//     currentMenu: ''
//   },
//   getters: {

//   },
//   mutations: {
//     setRoutes (state, routes) {
//       state.routes = routes
//     },
//     setSidebarMenu (state, menu) {
//       state.sidebarMenu = menu
//     },
//     setCurrentMenu (state, currentMenu) {
//       state.currentMenu = currentMenu
//     }
//   },
//   actions: {
//     fetchRoutes ({ commit, state }) {
//       // 得到路由
//       let mainContainer = routeList.find(v => v.path === '')
//       // 生成导航菜单
//       commit('setSidebarMenu', mainContainer.children)
//       // 有children的路由设置第一个children为默认路由
//       setDefaultRoute([mainContainer])
//       // 初始路由
//       let initialRoutes = router.options.routes
//       // 加入所有的路由
//       router.addRoutes(routeList)
//       // 设置完整的路由表
//       commit('setRoutes', [...initialRoutes, ...routeList])
//     }
//   }
// }
