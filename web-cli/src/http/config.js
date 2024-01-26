import {baseUrl} from '../utils/global.js'

export default {
    method: 'get',
    //配置 请求的 根路径
    baseUrl: baseUrl,
    //请求头信息
    headers: {
        'Content-Type': 'application/json;charset = UTF-8',
        // 'token':window.sessionStorage.getItem('token')
    },
    //参数
    data:{},
    //设置超时时间
    timeout: 10000,
    //携带凭证
    withCredentials: true,
    //返回数据类型
    responseType: 'json'

}
