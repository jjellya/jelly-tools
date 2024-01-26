<template>
    <div >
        <TopBar
                title="某某市某某镇人民镇府"
                title_en="People's  Government of xxxxx City xxxxx Town"
                city_town="某某市某某镇"
                active-index= "2" >
        </TopBar>
        <el-row :gutter="10" style="width: 100%;">
            <div class="dept_head">
                <span>{{dept_name}}</span>
            </div>

            <el-divider></el-divider>
        </el-row>
        <el-row>
            <el-col :push="5" :span="15">
                <div class="tab_size">
                    <el-tabs tab-position="left">
                        <el-tab-pane label="部门简介"  style="text-align: left;margin-left: 50px">
                            <div v-if="text_content_visible">
                                <span v-html="text_content" >{{text_content}}</span>
                                <el-row>
                                    <div class="button_operation">
                                        <el-button type="primary"
                                                   icon="el-icon-edit"
                                                   style="margin-right: 75px"
                                                   v-if="isEmployee"
                                                   @click="editTxt()">编辑</el-button>
                                        <el-button type="danger" icon="el-icon-delete" style="margin-left: 75px" v-show="isEmployee">删除</el-button>
                                    </div>
                                </el-row>
                            </div>
                            <div v-if="text_content_visible===false">
                                <div v-html="text_content" class="zw" >{{text_content}}</div>
                                <div class="view_editor">
                                    <editor v-model="text_content" :isClear="isClear" @change="change"></editor>
                                </div>
                            </div>
                        </el-tab-pane>
                        <el-tab-pane label="领导简介" style="text-align: left;margin-left: 50px">
                            <div>
                                <ul>
                                    <li v-for="item in leaderData" :key="item.id" style="list-style: none; ">
                                        <img :src="item.image" style="width: 110px;height: 134px;">
                                        <h3>{{item.name}}</h3>
                                        <div v-html="item.description">{{item.description}}</div>
                                        <el-row style="margin-top: 30px">
                                            <el-button type="primary"
                                                       icon="el-icon-edit"
                                                       style="margin-right: 75px"
                                                       v-if="isEmployee"
                                                       @click="editTxt()"
                                                        size="mini">编辑</el-button>
                                            <el-button size="mini" type="danger" icon="el-icon-delete" style="margin-left: 75px" v-show="isEmployee">删除</el-button>
                                        </el-row>
                                        <el-divider></el-divider>
                                    </li>
                                </ul>
                            </div>
                        </el-tab-pane>

                        <el-tab-pane label="机构设置" style="text-align: left;margin-left: 50px">
                            <div v-if="dept_setting_desc_visible" >
                                <span v-html="dept_setting_desc" >{{dept_setting_desc}}</span>
                                <el-row>
                                    <div class="button_operation">
                                        <el-button type="primary"
                                                   icon="el-icon-edit"
                                                   style="margin-right: 75px"
                                                   v-if="isEmployee"
                                                   @click="editTxt()">编辑</el-button>
                                        <el-button type="danger" icon="el-icon-delete" style="margin-left: 75px" v-show="isEmployee">删除</el-button>
                                    </div>
                                </el-row>
                            </div>
                        </el-tab-pane>
                    </el-tabs>
                </div>

            </el-col>
<!--            <el-col :span="10" :offset="1">-->
<!--                <editor v-model="text_content" :isClear="isClear" @change="change"></editor>-->
<!--                <div v-html="text_content" style="text-align: left" >{{text_content}}</div>-->
<!--            </el-col>-->
        </el-row>

        <BottomBar official="某某省某某市某某镇人民政府办公厅"></BottomBar>
    </div>
</template>

<script>
    import DividerInjectTxt from "../../components/DividerInjectTxt";
    import GazetteCard from "../../components/GazetteCard";
    import HelloWorld from "../../components/HelloWorld";
    import TopBar from "../../components/TopBar";
    import BottomBar from "../../components/BottomBar";
    import ServerRecomBar from "../../components/SeverRecomBar";
    import BoardNav from "../../components/BoardNav";
    import CarouselNav from "../../components/CarouselNav";
    import ModulesBoardNav from "../../components/ModulesBoardNav";
    import editor from "../../components/editor";

    import E from "wangeditor";

    export default {
        name: "DeptIntroduction",
        data() {
            return {
                img_block_right:{
                    img_src: require("/src/assets/policalSuggestionsCollection.png"),
                    url: '/404'
                },

                card_body_style: {
                    padding: '0px',
                    width: '560px',
                    height: '259px'

                },
                dept_name:'',
                text_content: '',
                txt_content:'<h1 style="text-align: center;"><span style="color: rgb(28, 72, 127);">某某镇党政综合办公室机构职责</span></h1><div><p><strong>【主要职责】</strong></p><p>(一)贯彻执行党的路线、方针、政策以及省委、省政府和肇庆市委、市政府的决策和决定,贯彻落实市委、市政府的工作部署。</p><p>(二)检查和督促落实市政府各项决议、决定、重要工作部署和市政府领导同志重要批示,向市政府领导报告工作的落实情况。</p><p>(三)处理各级政府、各部门报送市政府和市政府办公室的文电,审核、草拟和制发以市政府和市政府办公室名义发布的文件,报送信息资料。</p><p>(四)组织或参与全市经济社会发展重大问题调查研究，负责市政府工作情况汇报材料、重要会议的会议材料和市政府重大活动的组织安排。</p><p>(五)根据市政府领导同志批示,组织协调市政府有关部门以及省和肇庆市驻我市单位的关系。</p><p>(六)负责市政府政务信息、网络问政和重大措施及重要政务活动宣传等工作。</p><p>(七)承担市政府总值班室工作，办理向肇庆市政府报送的紧急重要事项，指导全市政府系统值班工作；协助市政府领导同志组织处理需由市政府组织处理的突发事件和重大事故,协调、督促相关处置工作。</p><p>(八)负责统筹推进转变政府职能及放管服相关工作。</p><p>(九)组织办理人大代表议案、建议及政协提案。</p><p><br></p><p><br></p><p><br></p><p>某某镇党政综合办公室联系电话：020-3141592</p></div>',
                leader_info: '',
                leaderData:[],
                isClear: false,//清除富文本编辑器内容
                // editorContent: '',
                dept_setting_desc:'',
                isEmployee:false,
                text_content_visible:true,
                dept_setting_desc_visible:true,
            }
        },

        components: {
            editor,
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
            change(val) {
                console.log(val)
            },
            editTxt(){
                this.text_content_visible=false;
            }

        },
        created() {
            let dept_id = this.$route.query.dept_id;
            // console.log(dept_id);
            this.$api.dept.getDeptDescIntroductionData(dept_id).then(res =>{
                // console.log(res);
                if(res.code !== 200) {
                    return this.$message.error('数据获取失败');
                }else {
                    this.dept_name = res.data.dept_name;
                    this.text_content = res.data.introduction_content;
                    this.leaderData = res.data.leaderData;
                    this.dept_setting_desc = res.data.dept_setting_desc;
                    if(res.data.user.userRole===2) this.isEmployee = true;

                    // return this.$message.success('数据正在加载...');
                }
            }).catch(function(res) {
                alert(res);
            });
        },

    }
</script>

<style scoped>
    .dept_head{
        position: relative;
        left: 200px;
        text-align: left;
        margin-top: 25px;
        font-size: 56px;
        font-weight: bold;
    }

    .tab_size{
        min-height: 500px;
    }
    .tab_size >>> .el-tabs__item {
        padding-top: 10px;
        padding-right: 30px;
        font-size: 26px;
        text-align: left;
        height: 65px;
        width: 165px;

    }

    .tab_size >>> .el-tabs__nav{
        min-height: 800px;
    }

    .button_operation{
        margin: 45px auto 50px 200px;
    }

    .view_editor{
        width: 700px;
        margin-bottom: 80px;
        border: solid 1px #aed4f5;
        border-radius: 4px;
        background: #ffffff;
    }
</style>
