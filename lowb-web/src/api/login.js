import axios from '../config/sevice'

/**
 * 登录
 * @param {String} username
 * @param {String} password
 */
export function login (username, password) {
  return axios.post('/user/login', {
    username,
    password
  })
}