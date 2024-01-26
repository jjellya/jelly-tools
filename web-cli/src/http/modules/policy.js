import axios from '../axios'

/*
 * 平台政策公开模块
 */

// 获取政策详情数据
export const getPolicyDetailData = policy_id => {
    return axios({
        url: 'api/getPolicyDetailData',
        method: 'get',
        params:{policy_id:policy_id}
    })
};

// 发送更改文章数据请求
export const updatePolicyDetailData = (post_detail) => {
    return axios({
        url: 'api/updatePolicyDetailData',
        method: 'post',
        // params:{policy_id:policy_id,post_detail:post_detail}
        data: post_detail
    })
};

// 发送更改文章数据请求
export const getInformationBoardData = (policy_type,index,size) => {
    return axios({
        url: 'api/getInformationBoardData',
        method: 'get',
        params:{policy_type:policy_type,index:index,size:size}
    })
};





