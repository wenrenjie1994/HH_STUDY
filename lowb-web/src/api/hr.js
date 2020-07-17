import axios from '../service/index'

/**
 * 获取所有用户
 */
export function getUserList () {
  return axios.get('/user/list')
}
