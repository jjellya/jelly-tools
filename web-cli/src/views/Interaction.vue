<template>
    <div >
        <TopBar
                title="某某市某某镇人民镇府"
                title_en="People's  Government of xxxxx City xxxxx Town"
                city_town="某某市某某镇"
                active-index="4">
        </TopBar>
        <el-row :gutter="10" style="width: 100%;">
            <el-col :span="5" :push="2">
<!--                <a :href="consult_url" target="_blank">-->
                    <el-button class="button_block_1" @click="$router.push('/consult')">
                        <i class="el-icon-chat-dot-round"></i>
                        {{buttonTxt_1}}
                    </el-button>
<!--                </a>-->

            </el-col>
            <el-col :span="5" offset="4">
                <el-row style="margin-top: 50px">
<!--                    <a :href="complaint_url" target="_blank">-->
                        <el-button class="button_block_2" @click="$router.push('/complaint')">
                            <i class="el-icon-warning"></i>
                            {{buttonTxt_2}}
                        </el-button>
<!--                    </a>-->
                </el-row>
                <el-row style="margin-top: 37px">
<!--                    <a :href="suggestion_url" target="_blank">-->
                        <el-button class="button_block_3" @click="$router.push('/suggestions')">
                            <i class="el-icon-document"></i>
                            {{buttonTxt_3}}
                        </el-button>
<!--                    </a>-->
                </el-row>
            </el-col>
            <el-col :span="8" offset="1">
<!--                <a :href="img_block_right.url" target="_blank">-->
                    <el-button type="text" @click="$router.push({path: '/collectPolicyOpinion', query: {post_id: '2'}})">
                        <el-image class="img_block_4"
                                  :src="img_block_right.img_src">
                        </el-image>
                    </el-button>

<!--                </a>-->
            </el-col>
        </el-row>

        <el-row :gutter="20" style="width: 100%;">
            <el-row style="margin-top: 45px;">
                <el-col :span="6">
                    <span class="txtTitle">回应关切</span>
                    <el-divider class="blue_line"></el-divider>
                </el-col>
            </el-row>
            <el-row style="left: 128px;width: 90%;margin: 0">
                <div class="cancel_el-table_border">
                    <el-table
                            :data="responseData"
                            style="width: 100%">
                        <el-table-column
                                prop="response_title">
                            <template slot-scope="scope">
                                <a class="cancel_underline" :href="scope.row.url" target="_blank">{{scope.row.response_title}}</a>
                            </template>
                        </el-table-column>
                        <el-table-column
                                prop="date"
                                width="150"><!--这里能调整个表的左右宽度,能让这一项拉后-->
                        </el-table-column>
                    </el-table>
                </div>
            </el-row>
        </el-row>
        <div style="margin-top: 20px"></div>

        <BottomBar official="某某省某某市某某镇人民政府办公厅"></BottomBar>
    </div>
</template>

<script>
    import DividerInjectTxt from "../components/DividerInjectTxt";
    import GazetteCard from "../components/GazetteCard";
    import HelloWorld from "../components/HelloWorld";
    import TopBar from "../components/TopBar";
    import BottomBar from "../components/BottomBar";
    import ServerRecomBar from "../components/SeverRecomBar";
    import BoardNav from "../components/BoardNav";
    import CarouselNav from "../components/CarouselNav";
    import ModulesBoardNav from "../components/ModulesBoardNav";
    import axios from "axios";

    export default {
        name: "Interaction",
        data() {
            return {
                img_block_right:{
                    img_src: require("../assets/policalSuggestionsCollection.png"),
                    url: '/404'
                },

                card_body_style: {
                    padding: '0px',
                    width: '560px',
                    height: '259px'

                },
                buttonTxt_1: '我要咨询',
                buttonTxt_2: '我要投诉',
                buttonTxt_3: '我要建议',
                consult_url: '/Test',
                complaint_url: '/Test',
                suggestion_url:'Test',
                responseData:[

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
        },
        created() {
            this.$api.interaction.getResponseTableData(5).then(res =>{
                console.log(res);
                if(res.code !== 200) {
                    return this.$message.error('数据获取失败');
                }else {
                    this.responseData = res.data;
                    //return this.$message.success('数据正在加载...');
                }
            }).catch(function(res) {
                alert(res);
            });
        }
    }
</script>

<style scoped>
    .button_block_1{
        width: 384px;
        height: 271px;
        background-color: #BBD8FB;
        color: white;
        font-size: 36px;
        margin-top: 50px;
    }

    .button_block_2{
        width: 243px;
        height: 117px;
        background-color: #EF715A;
        font-size: 36px;
        color: white;
    }

    .button_block_3{
        width: 243px;
        height: 117px;
        background-color: #FFCE79;
        font-size: 36px;
        color: white;
    }

    .img_block_4{
        width: 485px;
        height: 271px;
        margin-top: 50px;
    }

    .txtTitle{
        position: relative;
        left: 18px;
        color: #3573A6;
        font-size: 36px;
        padding: 0;
        margin: 0;
    }

    .cancel_underline{
        text-decoration:none;/*去掉a标签下的下划线*/
        color: black;
        width: 296px;
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

    .blue_line{
        padding: 0;
        margin-top: 10px;
        position: relative;
        left: 135px;
        width: 145px;
        height: 3px;
        background-color: #4293F4;
    }
</style>
