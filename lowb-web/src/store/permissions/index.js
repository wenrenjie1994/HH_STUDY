import router, { DynamicRoutes } from '../../router/index'
import { recursionRouter, setDefaultRoute } from '../../utils/recursion-router'
import dynamicRouter from '../../router/dynamic-router'
import * as roles from '../../utils/roles'

export default {
  namespaced: true,
  state: {
    routeList: null /** 所有路由 */,
    sidebarMenu: [] /** 导航菜单 */,
    currentMenu: '' /** 当前active导航菜单 */
  },
  getters: {},
  mutations: {
    setPermission (state, routes) {
      state.routeList = routes
    },
    clearPermission (state) {
      state.routeList = null
    },
    setMenu (state, menu) {
      state.sidebarMenu = menu
    },
    clearMenu (state) {
      state.sidebarMenu = []
    },
    setCurrentMenu (state, currentMenu) {
      state.currentMenu = currentMenu
    }
  },
  actions: {
    async fetchRoutes ({ commit }) {
      // let role = window.sessionStorage.getItem('role')
      // let routeList = roles.default[role]
      let routeList = roles.default.all
      /*  根据权限筛选出我们设置好的路由并加入到path=''的children */
      let routes = recursionRouter(routeList, dynamicRouter)
      let MainContainer = DynamicRoutes.find(v => v.path === '')
      let children = MainContainer.children
      children.push(...routes)

      /* 生成左侧导航菜单 */
      commit('setMenu', children)
      setDefaultRoute([MainContainer])

      /*  初始路由 */
      let initialRoutes = router.options.routes

      /*  动态添加路由 */
      router.addRoutes(DynamicRoutes)

      /* 完整的路由表 */
      commit('setPermission', [...initialRoutes, ...DynamicRoutes])
    }
  }
}
