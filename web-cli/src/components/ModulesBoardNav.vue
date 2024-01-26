<template>
    <div class="modulesBoardNav">
        <el-row :gutter="20">

            <el-menu
                    :default-active="activeIndex"
                    class="NavMenu"
                    mode="horizontal"
                    background-color="transparent"
                    text-color="black"
                    active-text-color="#2F6EA2"
            >
                <el-menu-item index="1" class="txtNavItem1">{{title1}}</el-menu-item>
                <el-menu-item index="2" class="txtNavItem2">{{title2}}</el-menu-item>
            </el-menu>
        </el-row>
        <el-row :gutter="24" class="modulesBoard" >
            <div class="modulesBoard" >
                <el-row :gutter="24" v-for="row in subTitles" :key="row.rowIndex" style="height: 200px;left: 100px">
                    <el-col :push="1" :span="7" v-for="block in row.blockArray" :key="block.blockIndex">
                            <el-row :gutter="24" v-for="item in block.titleArray" :key="item.index" :class="{'subTitle_Large':(Number(item.index)%4)===1,'subTitle_Small':(Number(item.index)%4)!==1}">
                                <a :href="item.url" class="cancel_underline">
                                    {{item.title}}
                                </a>
<!--                                <el-button type="text" style="color:black;" @click="$router.push({path: '/informationBoard',query: {info_type: '2',page_index:'1',page_size:'20'}})">-->
<!--                                    {{item.title}}-->
<!--                                </el-button>-->
                            </el-row>
                    </el-col>
                </el-row>


            </div>
        </el-row>
    </div>
</template>

<script>
    export default {
        name: "ModulesBoardNav",
        props: {
            title1:String,
            title2:String,
        },
        //数据==================================================================
        data() {
            return {
                activeIndex: '1',
                subTitles:[
                    {
                        rowIndex:1,
                        blockArray:[
                            {
                                blockIndex: 1,
                                blockIcon: 'el-icon-s-check',
                                titleArray:[
                                    {
                                        index:1,
                                        title: '行政审批信息公开',
                                        url: '/informationBoard?info_type=2&page_index=1&page_size=20',
                                    },
                                    {
                                        index:2,
                                        title: '公共资源配置信息公开',
                                        url: 'https://www.baidu.com/',

                                    },
                                    {
                                        index:3,
                                        title: '乡村振兴信息公开',
                                        url: 'https://www.baidu.com/',
                                    },
                                    {
                                        index:4,
                                        title: '基本医疗卫生信息公开',
                                        url: 'https://www.baidu.com/',
                                    },
                                ]
                            },
                            {
                                blockIndex: 2,
                                blockIcon: 'el-icon-money',
                                titleArray:[
                                    {
                                        index:5,
                                        title: '财政资金信息公开',
                                        url: 'https://www.baidu.com/',
                                    },
                                    {
                                        index:6,
                                        title: '科技管理和项目经费信息公开',
                                        url: 'https://www.baidu.com/',
                                    },
                                    {
                                        index:7,
                                        title: '价格和收费信息公开',
                                        url: 'https://www.baidu.com/',
                                    },
                                    {
                                        index:8,
                                        title: '减税降费信息公开',
                                        url: 'https://www.baidu.com/',
                                    },
                                ]
                            },
                            {
                                blockIndex: 3,
                                blockIcon: 'el-icon-search',
                                titleArray:[
                                    {
                                        index:9,
                                        title: '产品质量监管执法信息公开',
                                        url: 'https://www.baidu.com/',
                                    },
                                    {
                                        index:10,
                                        title: '国有企业信息公开',
                                        url: 'https://www.baidu.com/',
                                    },
                                    {
                                        index:11,
                                        title: '灾害事故救援信息公开',
                                        url: 'https://www.baidu.com/',
                                    },
                                    {
                                        index:12,
                                        title: '科技管理和项目经费信息公开 ',
                                        url: 'https://www.baidu.com/',
                                    },
                                ]
                            },
                        ]

                    },
                    {
                        rowIndex:2,
                        blockArray:[
                            {
                                blockIndex: 4,
                                blockIcon: 'el-icon-s-custom',
                                titleArray:[
                                    {
                                        index:13,
                                        title: '民政信息公开',
                                        url: 'https://www.baidu.com/',
                                    },
                                    {
                                        index:14,
                                        title: '就业创业信息公开',
                                        url: 'https://www.baidu.com/',
                                    },
                                    {
                                        index:15,
                                        title: '国有土地上房屋征收补偿信息公开',
                                        url: 'https://www.baidu.com/',
                                    },
                                    {
                                        index:16,
                                        title: '住房保障信息公开',
                                        url: 'https://www.baidu.com/',
                                    },
                                ]
                            },
                            {
                                blockIndex: 5,
                                blockIcon: 'el-icon-odometer',
                                titleArray:[
                                    {
                                        index:17,
                                        title: '生产安全事故信息公开',
                                        url: 'https://www.baidu.com/',
                                    },
                                    {
                                        index:18,
                                        title: '食品药品安全信息公开',
                                        url: 'https://www.baidu.com/',
                                    },
                                    {
                                        index:19,
                                        title: '灾害事故救援信息公开',
                                        url: 'https://www.baidu.com/',
                                    },
                                    {
                                        index:20,
                                        title: '科技管理和项目经费信息公开 ',
                                        url: 'https://www.baidu.com/',
                                    },
                                ]
                            },
                            {
                                blockIndex: 6,
                                blockIcon: 'el-icon-school',
                                titleArray:[
                                    {
                                        index:21,
                                        title: '公共文化体育信息公开',
                                        url: 'https://www.baidu.com/',
                                    },
                                    {
                                        index:22,
                                        title: '知识产权信息公开',
                                        url: 'https://www.baidu.com/',
                                    },
                                    {
                                        index:23,
                                        title: '环境保护信息公开',
                                        url: 'https://www.baidu.com/',
                                    },
                                    {
                                        index:24,
                                        title: '教育信息公开',
                                        url: 'https://www.baidu.com/',
                                    },
                                ]
                            },
                        ]
                    }







                ]
            }
        },
    }
</script>

<style scoped>
    .modulesBoardNav{
        position: relative;
        overflow: hidden;
        width: 100%;
        height: 500px;
        top: 50px;
        padding-bottom: 25px;
        /*background-color: #F1F2F3;*/


    }
    .txtNavItem1{
        position: relative;
        left:130px;
        width: 200px;
        font-size: 20px;
        text-align: center;
    }

    .txtNavItem2{
        position: relative;
        left:220px;
        width: 200px;
        font-size: 20px;
        text-align: center;
    }
    .modulesBoard{
        background-color: #F1F2F3;
        height: 80%;
    }
    .subTitle_Large{
        position: relative;
        top: 30px;
        font-size: 28px;
        left: 30px;
        text-align: left;
        width: 100%;
        height: 28px;
        margin-bottom:  15px;
    }
    .subTitle_Small{
        position: relative;
        top: 50px;
        left: 30px;
        width: 100%;
        height: 14px;
        font-size: 14px;
        /* 设置元素两端对齐 */
        text-align: left;
        margin-bottom:  20px;

    }
    .cancel_underline{
        text-decoration:none;/*去掉a标签下的下划线*/
        color: black;

    }



</style>
