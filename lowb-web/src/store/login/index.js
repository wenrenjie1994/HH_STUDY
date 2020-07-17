import { login } from '../../api/login'
import { Message } from 'element-ui'

export default {
  namespaced: true,
  state: {
  },
  getters: {
  },
  mutations: {
  },
  actions: {
    async login ({ state }, { username, password }) {
      let result = await login(username, password)
      console.log(result)
      if (result.code === 200) {
        return true
      } else {
        Message.error({
          message: result.msg
        })
        return false
      }
    }
  }
}
