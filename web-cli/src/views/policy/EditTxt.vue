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
                            <el-tag
                                    :key="tag"
                                    v-for="tag in post_tags"
                                    closable
                                    :disable-transitions="false"
                                    @close="handleClose(tag)">
                                {{tag.tag_content}}
                            </el-tag>
                            <el-input
                                    class="input-new-tag"
                                    v-if="inputVisible"
                                    v-model="inputValue"
                                    ref="saveTagInput"
                                    size="small"
                                    @keyup.enter.native="handleInputConfirm"
                                    @blur="handleInputConfirm"
                            >
                            </el-input>
                            <el-button v-else class="button-new-tag" size="small" @click="showInput">+ New Tag</el-button>

                    </el-col>
                    <el-col  :span="10" style="text-align: left">
                        <label><strong>发文机构：</strong></label>
                        <el-input v-model="post_agency"
                                  :placeholder="post_agency"
                                    style="width: 200px"></el-input>
                    </el-col>
                </el-row>
                <el-row :gutter="20" style="margin-bottom: 20px">
                    <el-col offset="4" :span="10" style="text-align: left">
                        <label><strong>发文字号：</strong></label>
                        <el-input v-model="issue_number"
                                  :placeholder="issue_number"
                                  style="width: 200px"></el-input>
                    </el-col>
                    <el-col  :span="10" style="text-align: left">
                        <label><strong>发布日期：</strong></label>
                        <el-date-picker type="date" :placeholder="release_date" v-model="release_date" style="width: 200px;"></el-date-picker>
                    </el-col>
                </el-row>
                <el-row :gutter="20" style="margin-bottom: 20px">
                    <el-col :offset="4" :span="10" style="text-align: left">
                        <label><strong>有效性：</strong></label>
                        <el-radio v-model="validity" :label="true">有效</el-radio>
                        <el-radio v-model="validity" :label="false">无效</el-radio>
                    </el-col>
                    <el-col  :span="10" style="text-align: left">
                        <label><strong>成文日期：</strong></label>
                        <el-date-picker type="date" :placeholder="create_date" v-model="create_date" style="width: 200px;"></el-date-picker>
                    </el-col>
                </el-row>
                <el-row :gutter="20" style="margin-bottom: 20px">

                    <el-col  offset="4" :span="20" style="text-align: left">
                        <label><strong>文章标题：</strong></label>
                        <el-input v-model="text_title"
                                  :placeholder="text_title"
                                  style="width: 690px"></el-input>
                    </el-col>
                </el-row>
            </div>
        </el-row>
        <el-row>
            <div class="view_content">
                <div v-html="text_content" class="zw" >{{text_content}}</div>
            </div>
            <div class="view_editor">
                <editor  v-model="text_content" :isClear="isClear" @change="change"></editor>
            </div>
        </el-row>
        <el-row>
            <div class="button_operation">
                <el-button type="primary"
                           icon="el-icon-edit"
                           style="margin-right: 75px"
                           v-show="isEmployee"
                           @click="submit()">完成</el-button>
                <el-button type="danger"
                           icon="el-icon-delete"
                           style="margin-left: 75px"
                           v-show="isEmployee">删除</el-button>
            </div>

        </el-row>
        <BottomBar official="某某省某某市某某镇人民政府办公厅"></BottomBar>
    </div>
</template>

<script>
    import TopBar from "../../components/TopBar";
    import BottomBar from "../../components/BottomBar";
    import editor from "../../components/editor";

    export default {
        name: "EditTxt",
        components: {BottomBar, TopBar,editor },
        data() {
            return {
                text_content:'',
                isClear: false,//清除富文本编辑器内容,
                introduce_visible: true,
                post_tags:[],
                policy_id: 10010,
                location:'公示公告',
                text_title:'',
                post_agency:'',
                issue_number:'',
                create_date:'',
                release_date:'',
                validity: true,
                isEmployee: false,
                post_type:0,

                inputVisible: false,
                inputValue: ''
            }
        },
        created() {
            let policy_id = this.$route.query.post_id;
            console.log(policy_id);
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
                    if(res.data.user.userRole===2) this.isEmployee = true;
                    sessionStorage.setItem("userName",res.data.user.userName);
                    sessionStorage.setItem("userId",res.data.user.userId);
                    //this.isEmployee = res.data.isEmployee;
                    //return this.$message.success('数据正在加载...');
                }
            }).catch(function(res) {
                alert(res);
            });


        },
        methods:{
            handleClose(tag) {
                this.post_tags.splice(this.post_tags.indexOf(tag), 1);
            },

            showInput() {
                this.inputVisible = true;
                this.$nextTick(_ => {
                    this.$refs.saveTagInput.$refs.input.focus();
                });
            },

            handleInputConfirm() {
                let inputValue = this.inputValue;
                if (inputValue) {
                    this.post_tags.push(inputValue);
                }
                this.inputVisible = false;
                this.inputValue = '';
            },

            submit(){
                let post_detail = {
                    policy_id :  this.policy_id,
                    text_title : this.text_title,
                    post_type : this.post_type,
                    text_content : this.text_content,
                    post_tags : this.post_tags,
                    introduce_visible : this.introduce_visible,
                    location : this.locaiton,
                    post_agency : this.post_agency,
                    issue_number : this.issue_number,
                    create_date : this.create_date,
                    release_date : this.release_date,
                    validity : this.validity,


                };
                // let params = Object.assign({}, post_detail)
                this.$api.policy.updatePolicyDetailData(post_detail).then(res =>{
                    // console.log(res);
                    if(res.code !== 200) {
                        return this.$message.error('数据获取失败');
                    }else {

                        this.$router.push("/policyDetail?post_id="+this.policy_id);
                        //this.isEmployee = res.data.isEmployee;
                        return this.$message.success('数据正在更新中...');
                    }
                }).catch(function(res) {
                    alert(res);
                });

            }
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

    .view_editor{
        margin: 20px 160px;
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


    .el-tag + .el-tag {
        margin-left: 10px;
    }
    .button-new-tag {
        margin-left: 10px;
        height: 32px;
        line-height: 30px;
        padding-top: 0;
        padding-bottom: 0;
    }
    .input-new-tag {
        width: 90px;
        margin-left: 10px;
        vertical-align: bottom;
    }

</style>
