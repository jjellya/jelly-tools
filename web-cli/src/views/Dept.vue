<template>
    <div >
        <TopBar
                title="某某市某某镇人民镇府"
                title_en="People's  Government of xxxxx City xxxxx Town"
                city_town="某某市某某镇"
                active-index="2">
        </TopBar>
        <DividerInjectTxt content_position="center" :txt="title_1"></DividerInjectTxt>
        <el-row >
            <el-row :gutter="20" v-for="rowItem in deptData_1" :key="rowItem.row_index" class="dept_row">
                <el-col :span="7" :push="2" v-for="item in rowItem.dept_array" :key="item.dept_id">
                    <el-button class="button_block" plain size="medium">
                        <a :href="item.dept_url+'?dept_id='+item.dept_id"
                           class="cancel_underline">{{item.dept_name}}</a>
                    </el-button>
                </el-col>
            </el-row>

        </el-row>

        <div style="margin-top: 80px"></div>
        <DividerInjectTxt content_position="center" :txt="title_2"></DividerInjectTxt>
        <el-row >
            <el-row :gutter="20" v-for="rowItem in deptData_2" :key="rowItem.row_index" class="dept_row">
                <el-col :span="7" :push="2" v-for="item in rowItem.dept_array" :key="item.dept_id">
                    <el-button class="button_block" plain size="medium">
                        <a :href="item.dept_url" target="_blank" class="cancel_underline">{{item.dept_name}}</a>
                    </el-button>
                </el-col>
            </el-row>

        </el-row>
        <div style="margin-top: 80px"></div>

        <BottomBar official="某某省某某市某某镇人民政府办公厅"></BottomBar>
    </div>
</template>


<script>
    import GazetteCard from "../components/GazetteCard";
    import TopBar from "../components/TopBar";
    import BottomBar from "../components/BottomBar";
    import ServerRecomBar from "../components/SeverRecomBar";
    import BoardNav from "../components/BoardNav";
    import CarouselNav from "../components/CarouselNav";
    import ModulesBoardNav from "../components/ModulesBoardNav";
    import HelloWorld from "../components/HelloWorld";
    import axios from "axios";
    import DividerInjectTxt from "../components/DividerInjectTxt";

    export default {
        name: "Dept",
        data() {
            return {
                img_src: "https://gitee.com/Alvin_J_Lin/pic-go-cdn/raw/master/Test-PicGo/政府公报.png",
                card_body_style: {
                    padding: '0px',
                },
                title_1: "镇政府部门",
                title_2: "下属单位",
                deptData_1 : [
                    {
                        row_index: 1,
                        dept_array:[
                            {
                                dept_id: 10086,
                                dept_name: '党政综合办公室',
                                dept_url: '/deptIntro'
                            },
                            {
                                dept_id: 2,
                                dept_name: '人大办公室',
                                dept_url: '/deptIntro'
                            },
                            {
                                dept_id: 3,
                                dept_name: '党建工作办公室',
                                dept_url: '/deptIntro'
                            },
                        ]
                    },
                    {
                        row_index: 2,
                        dept_array:[
                            {
                                dept_id: 4,
                                dept_name: '纪检监察办公室',
                                dept_url: '/deptIntro'
                            },
                            {
                                dept_id: 5,
                                dept_name: '公共服务办公室',
                                dept_url: '/deptIntro'
                            },
                            {
                                dept_id: 6,
                                dept_name: '综合治理办公室',
                                dept_url: '/deptIntro'
                            },
                        ]
                    },
                    {
                        row_index: 3,
                        dept_array:[
                            {
                                dept_id: 7,
                                dept_name: '综合执法办公室',
                                dept_url: '/deptIntro'
                            },
                            {
                                dept_id: 8,
                                dept_name: '经济发展局',
                                dept_url: '/deptIntro'
                            },
                            {
                                dept_id: 9,
                                dept_name: '人民武装部',
                                dept_url: '/deptIntro'
                            },
                        ]
                    },

                ],
                deptData_2 : [
                    {
                        row_index: 1,
                        dept_array:[
                            {
                                dept_id: 1,
                                dept_name: '农业服务中心',
                                dept_url: '/deptIntro'
                            },
                            {
                                dept_id: 2,
                                dept_name: '文化服务中心',
                                dept_url: '/deptIntro'
                            },
                            {
                                dept_id: 3,
                                dept_name: '卫生健康局',
                                dept_url: '/deptIntro'
                            },
                        ]
                    },
                    {
                        row_index: 2,
                        dept_array:[
                            {
                                dept_id: 4,
                                dept_name: '安全生产监督管理所',
                                dept_url: '/deptIntro'
                            },
                            {
                                dept_id: 5,
                                dept_name: '水利水电管理站',
                                dept_url: '/deptIntro'
                            },
                            {
                                dept_id: 6,
                                dept_name: '住房和城乡建设局',
                                dept_url: '/deptIntro'
                            },
                        ]
                    },


                ],
            }
        },

        components: {
            DividerInjectTxt,
            GazetteCard,
            HelloWorld,
            TopBar,
            BottomBar,
            ServerRecomBar,
            BoardNav,
            CarouselNav,
            ModulesBoardNav

        },
        methods: {
        }
    }
</script>

<style scoped>
    .dept_row{
        margin-top: 76px;
        width: 100%;  /*解决左右进度条*/
    }
    .cancel_underline{
        text-decoration:none;/*去掉a标签下的下划线*/
        color: black;
        font-size: 28px;
    }
    .button_block{
        width: 288px;
        height:69px;
        margin-top: 15px;
        /*margin-left: 10px*/
    }

</style>
