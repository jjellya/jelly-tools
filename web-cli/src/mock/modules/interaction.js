/*
 * 平台政民互动模块
 */

// 获取回应关切表格接口
export function getResponseTableData() {
    const responseTableData = {
        "code": 200,
        "msg": null,
        "data": [
            {
                id:1,
                response_title:'系统防范化解道路交通安全风险工作专题新闻发布会召开',
                url: 'http://www.gd.gov.cn/hdjl/hygq/content/post_3752949.html',
                date: '2022-11-01'
            },
            {
                id:2,
                response_title:'企业开办已实现全流程电子化',
                url: 'http://www.gd.gov.cn/hdjl/hygq/content/post_3752949.html',
                date: '2022-10-23'
            },
            {
                id:3,
                response_title:'增加市场主体近一成 营商环境优化跑出发展“加速度”',
                url: 'http://www.gd.gov.cn/hdjl/hygq/content/post_3752949.html',
                date: '2022-10-09'
            },
            {
                id:4,
                response_title:'全面推行林长制 设“双总林长”压实主体责任',
                url: 'http://www.gd.gov.cn/hdjl/hygq/content/post_3752949.html',
                date: '2022-09-28'
            },
            {
                id:5,
                response_title:'我镇林业法治宣传活动举行',
                url: 'http://www.gd.gov.cn/hdjl/hygq/content/post_3752949.html',
                date: '2022-07-06'
            },
        ]
    };
    return {
        url: 'api/responseTable',
        type: 'get',
        data: responseTableData
    }
}

// 获取依申请公开表格接口
export function getApplyForm() {
    const applyFormData = {
        "code": 200,
        "msg": "加载表格成功",
        "data": {
            user:{
                userId:3,
                userName:'霹雳无敌测试员',
                userRole:2
            },
            form: {
                name: '林俊杰',
                workplace:'华南农业大学软件学院',
                identicalType:1,
                identicalCode:'441894200000003679',
                phone:'020-85285383',
                postalCode:'508622',
                address:'广州市天河区五山路483号 华南农业大学 软件学院',
                email:'201823250519@info.scau.edu.cn',
                deptId: 1,
                content:'申请人在2022年8月2日将35.5亩土地租赁给某某棉厂使用，租期40年。2022年，棉厂倒闭，按照法律规定某某村可以收回用于耕种，其土地性质仍然属于集体所有制。2022年2019月份，某某村村民不知道的情况下，被申请人却将该土地征用给某某木业，征地前前没有公告，征地批文下来后却隐瞒不让申请人知道，严重侵犯了申请人的财产权和知情权。该土地是某某村集体所有制，申请人作为某某村的村民有权利知道自己土地被征用的详细情况及补偿安置方案。为维护自身合法权益，申请人依据《中华人民共和国政府信息公开条例》有关规定提出申请获取该土地被征用的相关信息，恳请在法定期限内满足申请人的请求。',
                accessWay:3,
                accessType:2,
                date: '2022-03-29',
                reply:'同意批准,请及时查看电子邮箱邮件',
                update_time: new Date(),
            },
            sys_log: {
                id:0,
                title:'依申请公开_林俊杰',
                type:0,
                pb_id:1,
                user_id:3,
                dept_id:1,
                step:2,
                advice:'第三方意见为无',
                affirm:0,
                create_time: new Date(),
                update_time: new Date(),
            }
        }
    };
    return {
        url: 'api/getApplyForm',
        type: 'get',
        data: applyFormData
    }
}
