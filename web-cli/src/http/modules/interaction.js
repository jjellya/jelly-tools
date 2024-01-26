import axios from '../axios'

/*
 * 平台政民互动模块
 */

// 获取回应关切表格数据
export const getResponseTableData = size => {
    return axios({
        url: 'api/responseTable',
        method: 'get',
        params:{size:size}
    })
};

// 依申请公开请求
export const applyForPublic = data => {
    return axios({
        url: 'api/applyForPublic',
        method: 'post',
        data
    })
};

// 获取依申请公开请求表单
export const getApplyForm = pb_info_id => {
    return axios({
        url: 'api/getApplyForm',
        method: 'get',
        params:{pb_info_id:pb_info_id}
    })
};

// 更新依申请公开请求
export const updateApplyForm = (data) => {
    return axios({
        url: 'api/updateApplyForm',
        method: 'post',
        data:data
    })
};

// 依申请公开请求
export const addOpinion = data => {
    return axios({
        url: 'api/addOpinion',
        method: 'post',
        data
    })
};

//获取该政策的所有意见征集数据
export const getOpinionTableData = policy_id => {
    return axios({
        url: 'api/getOpinionTableData',
        method: 'get',
        params:{policy_id:policy_id}
    })
};

