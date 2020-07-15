export default {
  get UserToken () {
    return sessionStorage.getItem('token')
  },
  set UserToken (value) {
    sessionStorage.setItem('token', value)
  },
  // 导航菜单是否折叠
  isSidebarNavCollapse: false,
  // 面包屑导航列表
  crumbList: []
}
