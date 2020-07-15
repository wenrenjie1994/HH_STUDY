export default {
  LOGIN_IN (state, token) {
    state.UserToken = token
  },
  LOGIN_OUT (state) {
    state.UserToken = ''
  },
  toggleNavCollapse (state) {
    state.isSidebarNavCollapse = !state.isSidebarNavCollapse
  },
  setCrumbList (state, list) {
    state.crumbList = list
  },
  toggleEditInfo (state) {
    state.isEditInfo = !state.isEditInfo
  },
  toggleSettingPass (state) {
    state.isSetting = !state.isSetting
  }
}
