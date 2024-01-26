import axios from '../axios'

/*
 * 系统登录模块
 */

// 登录
export const login = data => {
    return axios({
        url: 'login',
        method: 'post',
        data
    })
}

// 登出
export const logout = () => {
    return axios({
        url: 'logout',
        method: 'get'
    })
}

// 注册
export const register = data => {
    return axios({
        url: 'api/register',
        method: 'post',
        data
    })
}

// 检查email是否已注册
export const checkEmail = data => {
    return axios({
        url: 'api/checkEmail',
        method: 'post',
        data
    })
}

// 请求验证码
export const getCaptcha = () => {
    return axios({
        url: 'api/captcha.jpg',
        method: 'get'
    })
}
