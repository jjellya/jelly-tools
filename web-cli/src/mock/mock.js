import Mock from 'mockjs'
Mock.mock('http://172.18.218.197:8083/user', {
    'name': '@name', // 随机生成姓名
    'name': '@email', // 随机生成邮箱
    'age|1-10': 5, // 年龄1-10之间
})
Mock.mock('http://172.18.218.197:8083/menu', {
    'id': '@increment', // id自增
    'name': 'menu', // 名称为menu
    'order|1-20': 5, // 排序1-20之间
})
// Mock.mock('http://172.18.218.197:8083/login', {
//     'token': '332fr3e3rfsdfd', // 令牌
//     'name': 'login', // 名称为login
//     'order|1-20': 5, // 排序1-20之间
// })
