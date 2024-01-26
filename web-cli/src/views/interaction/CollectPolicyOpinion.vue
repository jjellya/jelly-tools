<template>
    <div>
        <TopBar
                title="某某市某某镇人民镇府"
                title_en="People's  Government of xxxxx City xxxxx Town"
                city_town="某某市某某镇"
                active-index="3">
        </TopBar>

        <el-row>
            <el-page-header @back="goBack" :content="location" class="page_header">
            </el-page-header>
            <div class="view_introduce" v-show="introduce_visible" >
                <el-row :gutter="20" style="margin-bottom: 20px">
                    <el-col offset="4" :span="10" style="text-align: left">
                        <label><strong>分类：</strong></label>
                            <span v-for="item in post_tags" :key="item.tag_id">
                                <el-divider
                                        direction="vertical"
                                        v-if="item.tag_id===post_tags[0].tag_id?false:true"></el-divider>
                                {{item.tag_content}}
                            </span>
                    </el-col>
                    <el-col  :span="10" style="text-align: left">
                        <label><strong>发文机构：</strong></label>
                        <span>{{post_agency}}</span>
                    </el-col>
                </el-row>
                <el-row :gutter="20" style="margin-bottom: 20px">
                    <el-col offset="4" :span="10" style="text-align: left">
                        <label><strong>发文字号：</strong></label>
                        <span>{{issue_number}}</span>
                    </el-col>
                    <el-col  :span="10" style="text-align: left">
                        <label><strong>发布日期：</strong></label>
                        <span>{{release_date}}</span>
                    </el-col>
                </el-row>
                <el-row :gutter="20" style="margin-bottom: 20px">
                    <el-col :offset="4" :span="10" style="text-align: left">
                        <label><strong>有效性：</strong></label>
                        <span>{{validity===true?'有效':'无效'}}</span>
                    </el-col>
                    <el-col  :span="10" style="text-align: left">
                        <label><strong>成文日期：</strong></label>
                        <span>{{create_date}}</span>
                    </el-col>
                </el-row>
            </div>
        </el-row>
        <el-row>
            <div class="view_content">
<!--                <editor v-model="text_content" :isClear="isClear" @change="change"></editor>-->
                <div v-html="text_content" class="zw" >{{text_content}}</div>
            </div>
        </el-row>
        <el-row>
            <div class="button_operation">
                <el-button type="primary"
                           icon="el-icon-edit"
                           style="margin-right: 75px"
                           v-show="isEmployee"
                            @click="editTxt()">编辑</el-button>
                <el-button type="danger" icon="el-icon-delete" style="margin-left: 75px" v-show="isEmployee">删除</el-button>
            </div>

        </el-row>

        <el-row style="text-align: left" v-if="isEmployee">
            <div class="view_introduce" >
                <el-table
                        :data="opinionTableData"
                        style="width: 100%"
                        height="550">
                    <el-table-column
                            prop="date"
                            label="日期"
                            width="180">
                    </el-table-column>
                    <el-table-column
                            prop="name"
                            label="姓名"
                            width="180">
                    </el-table-column>
                    <el-table-column
                            prop="phone"
                            label="联系方式">
                    </el-table-column>
                    <el-table-column
                            prop="content"
                            label="意见内容">
                    </el-table-column>
                </el-table>
            </div>

        </el-row>

        <el-row style="text-align: left" v-if="validity&&isEmployee===false" >
            <h1 style="margin-left: 160px" >我要提意见:</h1>
            <div class="view_introduce" >
                <el-form :model="opinionForm" :rules="rules" ref="ruleForm" label-width="100px" style="margin-left: 90px">
                    <el-row :gutter="16" style="margin-top: 30px">
                        <el-col :span="10">
                            <el-form-item label="姓名或单位" prop="name" >
                                <el-input v-model="opinionForm.name"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="手机号码" prop="phone">
                                <el-input v-model="opinionForm.phone"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-form-item label="发表意见" prop="content" style="width: 888px">
                        <el-input
                                type="textarea"
                                :autosize="{ minRows: 8, maxRows: 10}"
                                placeholder="请输入内容"
                                v-model="opinionForm.content"
                                maxlength="2048"
                                show-word-limit
                        >
                        </el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="submitOpinion('ruleForm')">提交</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </el-row>

        <BottomBar official="某某省某某市某某镇人民政府办公厅"></BottomBar>
    </div>
</template>

<script>
    import TopBar from "../../components/TopBar";
    import BottomBar from "../../components/BottomBar";
    import editor from "../../components/editor";
    import Cookies from "js-cookie";

    export default {
        name: "CollectPolicyOpinion",
        components: {BottomBar, TopBar,editor },
        data() {
            return {
                text_content:'',
                isClear: false,//清除富文本编辑器内容,
                introduce_visible: true,
                post_tags:[],
                policy_id: 10010,
                location:'政策性文件意见征集',
                text_title:'',
                post_type:0,
                post_agency:'',
                issue_number:'',
                create_date:'',
                release_date:'',
                validity:true,
                isEmployee: false,
                opinionForm:{
                    name:'',
                    phone:'',
                    content:'',
                    policy_id: 1,
                },
                rules: {
                    name: [
                        { required: true, message: '请输入姓名或单位名称', trigger: 'blur' },
                        { min: 1, max: 100, message: '长度在 1 到 100 个字符', trigger: 'blur' }
                    ],
                    phone: [
                        { required: true, message: '请输入电话号码', trigger: 'blur' },
                        { min: 7, max: 11, message: '长度在 7 到 11 个字符', trigger: 'blur' }
                    ],
                },
                opinionTableData: [{
                    date: '2016-05-02',
                    name: '王小虎',
                    phone: '19927596723',
                    content: '三、备案办理（二）建议修改为“已经取得食品经营许可证的食品经营者，在食品经营许可证有效期届满前无需要办理备案；需办理仅销售预包装食品备案的，应当在办理备案后15个工作日内申请注销食品经营许可证。”理由：如先注销食品经营许可证再办理备案，企业可能存在既无经营许可证，也未完成备案的情况。建议参考《保健食品备案工作指南（试行）》关于注册转备案的相关规定，在取得备案号后再注销原注册证书和批准文号。'
                }, {
                    date: '2016-05-04',
                    name: '王小虎',
                    phone: '19927596723',
                    content: '三、备案办理（二）建议修改为“已经取得食品经营许可证的食品经营者，在食品经营许可证有效期届满前无需要办理备案；需办理仅销售预包装食品备案的，应当在办理备案后15个工作日内申请注销食品经营许可证。”理由：如先注销食品经营许可证再办理备案，企业可能存在既无经营许可证，也未完成备案的情况。建议参考《保健食品备案工作指南（试行）》关于注册转备案的相关规定，在取得备案号后再注销原注册证书和批准文号。'
                }, {
                    date: '2016-05-01',
                    name: '王小虎',
                    phone: '19927596723',
                    content: '三、备案办理（二）建议修改为“已经取得食品经营许可证的食品经营者，在食品经营许可证有效期届满前无需要办理备案；需办理仅销售预包装食品备案的，应当在办理备案后15个工作日内申请注销食品经营许可证。”理由：如先注销食品经营许可证再办理备案，企业可能存在既无经营许可证，也未完成备案的情况。建议参考《保健食品备案工作指南（试行）》关于注册转备案的相关规定，在取得备案号后再注销原注册证书和批准文号。'
                }, {
                    date: '2016-05-03',
                    name: '王小虎',
                    phone: '19927596723',
                    content: '三、备案办理（二）建议修改为“已经取得食品经营许可证的食品经营者，在食品经营许可证有效期届满前无需要办理备案；需办理仅销售预包装食品备案的，应当在办理备案后15个工作日内申请注销食品经营许可证。”理由：如先注销食品经营许可证再办理备案，企业可能存在既无经营许可证，也未完成备案的情况。建议参考《保健食品备案工作指南（试行）》关于注册转备案的相关规定，在取得备案号后再注销原注册证书和批准文号。'
                }],
            }
        },
        methods:{
            goBack(){
                if (window.history.length <= 1) {
                    this.$router.push({ path: "/" });
                    return false;
                } else {
                    this.$router.go(-1);
                }
            },
            editTxt(){
                let post_id = this.policy_id;
                this.$router.push({ path:'/editTxt',query:{post_id: post_id.toString()}});
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            submitOpinion(formName){
                this.opinionForm.policy_id = this.policy_id;
                this.$api.interaction.addOpinion(this.opinionForm).then(res =>{
                    // console.log(res);
                    if(res.code !== 200) {
                        return this.$message.error('数据获取失败');
                    }else {
                        this.$refs[formName].resetFields();
                        return this.$message.success('意见发表成功');
                    }
                }).catch(function(res) {
                    alert(res);
                });
            },


        },
        created() {
            let policy_id = this.$route.query.post_id;
             console.log("policy_id ="+policy_id);
            this.$api.policy.getPolicyDetailData(policy_id).then(res =>{
                // console.log(res);
                if(res.code !== 200) {
                    return this.$message.error('数据获取失败');
                }else {
                    this.text_title = res.data.policy.text_title;
                    this.text_content = res.data.policy.text_content;
                    this.post_type = res.data.policy.post_type;
                    this.introduce_visible = res.data.policy.introduce_visible;
                    this.post_tags = res.data.policy.post_tags;
                    this.policy_id = res.data.policy.policy_id;
                    this.locaiton = res.data.policy.locaiton;
                    this.post_agency=res.data.policy.post_agency;
                    this.issue_number=res.data.policy.issue_number;
                    this.create_date=res.data.policy.create_date;
                    this.release_date=res.data.policy.release_date;
                    this.validity=res.data.policy.validity;
                    if(res.data.user.userRole===2) {
                        this.isEmployee = true;
                        this.$api.interaction.getOpinionTableData(this.policy_id).then(res2 =>{
                            // console.log(res);
                            if(res2.code !== 200) {
                                return this.$message.error('数据获取失败');
                            }else {
                               this.opinionTableData = res2.data;
                                return this.$message.success('数据获取成功');
                            }
                        }).catch(function(res2) {
                            alert(res2);
                        });
                    }
                    if(res.data.user.userRole>0){
                        sessionStorage.setItem("userName",res.data.user.userName);
                        sessionStorage.setItem("userId",res.data.user.userId);
                    }else if(res.data.user.userRole===0){
                        sessionStorage.removeItem("userName");
                        sessionStorage.removeItem("userId");
                    }

                     //return this.$message.success('数据正在加载...');
                }
            }).catch(function(res) {
                alert(res);
            });
        }
    }
</script>

<style scoped>
    .page_header{
        width: 1200px;
        height: 20px;
        line-height: 20px;
        margin: 20px auto;
        padding-left: 24px;
        font-size: 14px;
        color: #454545;
    }


    .view_content{
        margin: 20px 160px;
        /*上面margin语句相当于下面语句
        margin: 20px auto;
        margin-left: 160px;
        margin-right: 160px;
        */
        width: 1200px;
        border: solid 1px #aed4f5;
        border-radius: 4px;
        background: #ffffff;
    }
    .view_introduce{
        width: 1200px;
        margin: 20px auto;
        background: #ffffff;
        border: solid 1px #aed4f5;
        box-sizing: border-box;
        padding: 20px;
        border-radius: 4px;
    }

    /*正文*/
    .zw{
        width: 834px;
        margin: 15px auto 50px auto;
        font-size: 18px;
        line-height: 36px;
        color: #424242;
        text-align: left
    }

    .button_operation{
        margin: 15px auto 50px auto;
    }
</style>
