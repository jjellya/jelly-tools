<template>
    <div>
        <TopBar
                title="某某市某某镇人民镇府"
                title_en="People's  Government of xxxxx City xxxxx Town"
                city_town="某某市某某镇"
                active-index="3">
        </TopBar>
        <div class="board" >
            <el-breadcrumb separator-class="el-icon-arrow-right" style="height: 30px;">
                <el-breadcrumb-item :to="{ path: '/' }" class="breadcrumb-item_center">首页</el-breadcrumb-item>
                <el-breadcrumb-item class="breadcrumb-item_center">政策性文件征集</el-breadcrumb-item>
                <el-button type="success" size="mini" class="newInfoButton" icon="el-icon-plus" v-if="isEmployee">新建</el-button>
            </el-breadcrumb>

            <el-row :gutter="16">
                <div class="cancel_el-table_border">
                    <el-table
                            :data="informationBoardData"
                            style="width: 100%"
                    >

                        <el-table-column
                                prop="title"
                        >
                            <template slot-scope="scope">
                                <a class="cancel_underline" :href="scope.row.url" target="_blank">{{scope.row.title}}</a>
                            </template>
                        </el-table-column>
                        <el-table-column
                                prop="date"
                                width="180">
                        </el-table-column>
                    </el-table>
                </div>
            </el-row>
            <div style="margin-top: 30px;"></div>
            <el-row :gutter="16">
                <el-pagination
                        :page-size="10"
                        :pager-count="6"
                        layout="prev, pager, next"
                        :total= dataTotal
                        @current-change="changePage">
                </el-pagination>
            </el-row>

        </div>
        <div style="margin-top: 30px;"></div>
        <BottomBar official="某某省某某市某某镇人民政府办公厅"></BottomBar>
    </div>

</template>

<script>
    import BottomBar from "../../components/BottomBar";
    import TopBar from "../../components/TopBar";

    export default {
        name: "InformationBoard",
        components: {BottomBar, TopBar},
        data() {
            return {
                isEmployee: false,
                dataTotal:1,
                itemTitle:'行政审批信息公开',
                informationBoardData:[
                    {
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
                    },{
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
                    },{
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
                    },
                ],
            }
        },
        created() {
            let policy_type = this.$route.query.info_type;
            let index = this.$route.query.page_index;
            let size = this.$route.query.page_size;
            this.$api.policy.getInformationBoardData(policy_type,index,size).then(res =>{
                // console.log(res);
                if(res.code !== 200) {
                    return this.$message.error('数据获取失败');
                }else {
                    this.informationBoardData = res.data.infoDataList;
                    this.dataTotal = res.data.total;
                    if(res.data.user.userRole === 2)
                        this.isEmployee = true;
                    sessionStorage.setItem("userName",res.data.user.userName);
                    sessionStorage.setItem("userId",res.data.user.userId);
                    for (let i = 0; i <this.informationBoardData.length ; i++) {
                        this.informationBoardData[i].url='/policyDetail?post_id='+this.informationBoardData[i].policy_id;
                    }
                    return this.$message.success('数据正在加载...');
                }
            }).catch(function(res) {
                alert(res);
            });
        },
        methods:{
            changePage(currentPage){
                //alert(currentPage);
                let policy_type = this.$route.query.info_type;
                let index = currentPage;
                let size = this.$route.query.page_size;
                this.$api.policy.getInformationBoardData(policy_type,index,size).then(res =>{
                    // console.log(res);
                    if(res.code !== 200) {
                        return this.$message.error('数据获取失败');
                    }else {
                        this.informationBoardData = res.data.infoDataList;
                        this.dataTotal = res.data.total;
                        if(res.data.userRole === 2)
                            this.isEmployee = true;
                        for (let i = 0; i <this.informationBoardData.length ; i++) {
                            this.informationBoardData[i].url='/policyDetail?post_id='+this.informationBoardData[i].policy_id;
                        }
                        //return this.$message.success('数据正在加载...');
                    }
                }).catch(function(res) {
                    alert(res);
                });
            }
        },
    }
</script>

<style scoped>
    .board{
        position:relative;
        /*overflow:hidden;*/
        left:10%;
        top:21px;
        width: 80%;
        padding: 20px;

    }

    .breadcrumb-item_center{
        margin-top: 5px;
    }

    .newInfoButton{
        position: relative;
        left: 415px;
    }

    .cancel_el-table_border >>> .el-table__row>td{
        border: none;   /*强制去掉表格的下划线*/
    }
    .cancel_el-table_border >>> .el-table th.is-leaf{
        border: none;   /*强制去掉表格的上边框*/
        padding: 0;
    }
    .cancel_el-table_border >>> .el-table::before {
        height: 0px;    /*强制去掉表格的下边框*/
    }
    .cancel_underline{
        text-decoration:none;/*去掉a标签下的下划线*/
        color: black;

    }
</style>
