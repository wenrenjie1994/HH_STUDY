import { getUserList } from '../../api/hr'
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
    async getUserList () {
      let result = await getUserList()
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
