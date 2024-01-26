import Mock from 'mockjs'
import { baseUrl } from '@/utils/global'
import * as login from './modules/login'
import * as home from  './modules/home'
import * as interaction from './modules/interaction'
import * as dept from './modules/dept'
import * as policy from './modules/policy'

// 1. 开启/关闭[所有模块]拦截, 通过调[openMock参数]设置.
// 2. 开启/关闭[业务模块]拦截, 通过调用createMockDemo方法[isOpen参数]设置.
// 3. 开启/关闭[业务模块中某个请求]拦截, 通过函数返回对象中的[isOpen属性]设置.
let openMock = true;    //一键开关
// let openMock = false
//创建模拟返回值Demo----通过调用createMockDemo方法来创建
createMockDemo(login, openMock);
createMockDemo(home, openMock);
createMockDemo(interaction, openMock);
createMockDemo(dept, openMock);
// createMockDemo(policy,openMock);
/**
 * 创建mock模拟数据
 * @param {*} mod 模块
 * @param {*} isOpen 是否开启?
 */
function createMockDemo (mod, isOpen = true) {

    if (isOpen) {
        for (var key in mod) {
            ((res) => {
                if (res.isOpen !== false) {
                    let url = baseUrl;
                    if(!url.endsWith("/")) {//谨防忘记加'/'号
                        url = url + "/"
                    }
                    url = url + res.url;//生成最终需要拦截的URL
                    Mock.mock(new RegExp(url), res.type, (opts) => {
                        opts['data'] = opts.body ? JSON.parse(opts.body) : null;
                        delete opts.body;
                        //控制台打印拦截日志
                        console.log('\n');
                        console.log('%cmock拦截, 请求: ', 'color:blue', opts);
                        console.log('%cmock拦截, 响应: ', 'color:blue', res.data);
                        return res.data
                    })
                }
            })(mod[key]() || {})
        }
    }
}
