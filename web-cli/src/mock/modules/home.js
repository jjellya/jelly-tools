/*
 * 平台主页模块
 */

// 获取公告栏接口
export function getBulletinBoardData() {
    const bulletinBoardData = {
        "code": 200,
        "msg": null,
        "data": [{
            date: '2022-05-02',
            title: '“十四五”时期健康我市各区域建设规划发布 到2025年老年友善医疗机构占比将超80%',
            url: '/policyDetail?post_id=1'
        },{
            date: '2022-05-02',
            title: 'xx市委xx镇人民政府关于认真学习贯彻党的十九届六中全会精神 更加奋发有为推动乡村振兴的意见',
            url: 'https://gitee.com/Alvin_J_Lin/graduation-design'
        },{
            date: '2022-05-02',
            title: '市委第四生态环境保护督察组入驻公告',
            url: 'https://gitee.com/Alvin_J_Lin/graduation-design'
        },{
            date: '2022-05-02',
            title: '贯彻落实统计督察反馈意见整改落实情况',
            url: 'https://gitee.com/Alvin_J_Lin/graduation-design'
        },{
            date: '2022-05-02',
            title: '关于确定我镇防范和处置非法集资工作机制的牵头部门的公告',
            url: 'https://gitee.com/Alvin_J_Lin/graduation-design'
        },{
            date: '2022-05-02',
            title: '关于2022年第一季度全市政府网站与政务新媒体检查情况的通报',
            url: 'https://gitee.com/Alvin_J_Lin/graduation-design'
        },
        ]
    };
    return {
        url: 'api/BulletinBoard',
        type: 'get',
        data: bulletinBoardData
    }
}
// 获取公告栏接口
export function getCarouselNavData() {
    const carouselNavData = {
        "code": 200,
        "msg": 'mock.js 拦截',
        "data": [
            {
                index:1,
                array: [
                    {
                        img_src: "https://gitee.com/Alvin_J_Lin/pic-go-cdn/raw/master/Test-PicGo/签字画押.png",
                        title: '依申请公开',
                        content: '免费高效，详细准确，省事省心',
                        url: 'https://element.eleme.cn/#/zh-CN/component/installation'
                    },
                    {
                        img_src: "https://gitee.com/Alvin_J_Lin/pic-go-cdn/raw/master/Test-PicGo/政策解读.png",
                        title: '政策解读',
                        content: '免费高效，详细准确，省事省心',
                        url: 'https://info.scau.edu.cn/'
                    },
                    {
                        img_src: "https://gitee.com/Alvin_J_Lin/pic-go-cdn/raw/master/Test-PicGo/最新政策.png",
                        title: '政策解读',
                        content: '免费高效，详细准确，省事省心',
                        url: 'https://scau.edu.cn/'
                    },
                ],
            },
            {
                index:2,
                array: [
                    {
                        img_src: "https://gitee.com/Alvin_J_Lin/pic-go-cdn/raw/master/Test-PicGo/签字画押.png",
                        title: '依申请公开',
                        content: '免费高效，详细准确，省事省心',
                        url: 'https://element.eleme.cn/#/zh-CN/component/installation'
                    },
                    {
                        img_src: "https://gitee.com/Alvin_J_Lin/pic-go-cdn/raw/master/Test-PicGo/政策解读.png",
                        title: '政策解读',
                        content: '免费高效，详细准确，省事省心',
                        url: 'https://scau.edu.cn/'
                    },
                    {
                        img_src: "https://gitee.com/Alvin_J_Lin/pic-go-cdn/raw/master/Test-PicGo/最新政策.png",
                        title: '政策解读',
                        content: '免费高效，详细准确，省事省心',
                        url: 'https://info.scau.edu.cn/'
                    },
                ],
            },
            {
                index:3,
                array: [
                    {
                        img_src: "https://gitee.com/Alvin_J_Lin/pic-go-cdn/raw/master/Test-PicGo/签字画押.png",
                        title: '依申请公开',
                        content: '免费高效，详细准确，省事省心',
                        url: 'https://element.eleme.cn/#/zh-CN/component/installation'
                    },
                    {
                        img_src: "https://gitee.com/Alvin_J_Lin/pic-go-cdn/raw/master/Test-PicGo/政策解读.png",
                        title: '政策解读',
                        content: '免费高效，详细准确，省事省心',
                        url: 'https://info.scau.edu.cn/'
                    },
                    {
                        img_src: "https://gitee.com/Alvin_J_Lin/pic-go-cdn/raw/master/Test-PicGo/最新政策.png",
                        title: '政策解读',
                        content: '免费高效，详细准确，省事省心',
                        url: 'https://scau.edu.cn/'
                    },
                ],
            }

        ]
    };
    return {
        url: 'api/CarouselNav',
        type: 'get',
        data: carouselNavData
    }
}

// 登出接口
export function logout() {
    const logoutData = {
        "code": 200,
        "msg": null,
        "data": {
        }
    }
    return {
        url: 'logout',
        type: 'get',
        data: logoutData
    }
}
