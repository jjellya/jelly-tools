import axios from '../axios'

/*
 * 平台机构职能模块
 */

// 获取回应关切表格数据
export const getDeptDescIntroductionData = dept_id => {
    return axios({
        url: 'api/DeptDescIntroduction',
        method: 'get',
        params:{dept_id:dept_id}
    })
};


