import axios from '../axios'

/*
 * 系统首页模块
 */

// 获取公告栏数据
export const getBulletinBoardData = size => {
    return axios({
        url: 'api/BulletinBoard',
        method: 'get',
        params:{size:size}
    })
};

// 获取走马灯数据
export const getCarouselNavData = size => {
    return axios({
        url: 'api/CarouselNav',
        method: 'get',
        params:{size:size}
    })
};
