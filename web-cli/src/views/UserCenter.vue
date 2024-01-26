<template>
    <div>
        <TopBar
                title="某某市某某镇人民镇府"
                title_en="People's  Government of xxxxx City xxxxx Town"
                city_town="某某市某某镇"
                active-index="1">
        </TopBar>
        <div style="margin-top: 50px"></div>

        <el-row>
            <el-col :push="3" :span="4">
                <el-menu
                        default-active="2"
                        class="el-menu-vertical-demo"
                        @open="handleOpen"
                        @close="handleClose"
                        style="height: 1000px">
                    <el-submenu index="1">
                        <template slot="title">
                            <i class="el-icon-location"></i>
                            <span>事务</span>
                        </template>
                        <el-menu-item-group>
<!--                            <template slot="title">分组一</template>-->
                            <el-menu-item index="1-1">待办事项</el-menu-item>
                            <el-menu-item index="1-2">待审核事项</el-menu-item>
                            <el-menu-item index="1-3">进行中事项</el-menu-item>
                            <el-menu-item index="1-4">已完成事项</el-menu-item>
                        </el-menu-item-group>
                    </el-submenu>
                    <el-menu-item index="2">
                        <i class="el-icon-menu"></i>
                        <span slot="title">导航二</span>
                    </el-menu-item>
                    <el-menu-item index="3" disabled>
                        <i class="el-icon-document"></i>
                        <span slot="title">导航三</span>
                    </el-menu-item>
                    <el-menu-item index="4">
                        <i class="el-icon-setting"></i>
                        <span slot="title">导航四</span>
                    </el-menu-item>
                </el-menu>
            </el-col>

            <el-col :push="4" :span="16">
                <div class="affairForm" v-if="formVisible">
                    <el-page-header @back="fold()" :content="unfoldAffair.title"></el-page-header>
                    <el-steps :active="getActiveStep()" finish-status="success" simple style="width: 72%;margin-top: 50px">
                        <el-step title="待办理" ></el-step>
                        <el-step title="待审核" ></el-step>
                        <el-step title="进行中" ></el-step>
                        <el-step title="已完成" ></el-step>
                    </el-steps>
                    <div class="applyForm" v-if="applyFormVisible">
                        <div style="margin-top: 30px"></div>
                        <div style="margin-top: 50px"></div>
                        <el-form ref="form" :model="form" label-width="80px">
                            <el-row :gutter="16">
                                <el-col span="10">
                                    <el-form-item label="姓名" style="width: 280px">
                                        <el-input v-model="form.name" disabled></el-input>
                                    </el-form-item>
                                </el-col>
                                <el-col span="10">
                                    <el-form-item label="工作单位" style="width: 350px">
                                        <el-input v-model="form.workplace" :disabled="sys_log.step!==3"></el-input>
                                    </el-form-item>
                                </el-col>
                            </el-row>

                            <el-row :gutter="16">
                                <el-col span="10">
                                    <el-form-item label="证件名称" style="width: 280px">
                                        <el-select v-model="form.identicalType" placeholder="请选择证件类型" disabled>
                                            <el-option v-for="item in identicalTypeOptions"
                                                       :key="item.value"
                                                       :label="item.label"
                                                       :value="item.value"></el-option>
                                        </el-select>
                                    </el-form-item>
                                </el-col>
                                <el-col span="10">
                                    <el-form-item label="证件号码" style="width: 350px">
                                        <el-input v-model="form.identicalCode" disabled></el-input>
                                    </el-form-item>
                                </el-col>
                            </el-row>

                            <el-row :gutter="16">
                                <el-col span="10">
                                    <el-form-item label="联系电话" style="width: 280px">
                                        <el-input v-model="form.phone" :disabled="sys_log.step!==3"></el-input>
                                    </el-form-item>
                                </el-col>
                                <el-col span="10">
                                    <el-form-item label="邮政编码" style="width: 350px">
                                        <el-input v-model="form.postalCode" :disabled="sys_log.step!==3"></el-input>
                                    </el-form-item>
                                </el-col>
                            </el-row>

                            <el-row :gutter="16">
                                <el-col span="20">
                                    <el-form-item label="联系地址" style="width: 97%" >
                                        <el-input v-model="form.address" :disabled="sys_log.step!==3"></el-input>
                                    </el-form-item>
                                </el-col>
                            </el-row>

                            <el-row :gutter="16">
                                <el-col span="20">
                                    <el-form-item label="电子邮箱" style="width: 97%" >
                                        <el-input v-model="form.email" :disabled="sys_log.step!==3"></el-input>
                                    </el-form-item>
                                </el-col>
                            </el-row>

                            <el-row :gutter="16">
                                <el-col span="20">
                                    <el-form-item label="政府信息公开义务机关(机构名称)" style="width: 430px"  label-width="230px">
                                        <el-select v-model="form.deptId" placeholder="请选择政府单位" style="width: 505px" disabled>
                                            <el-option v-for="item in deptOptions"
                                                       :key="item.value"
                                                       :label="item.label"
                                                       :value="item.value"></el-option>
                                        </el-select>
                                    </el-form-item>
                                </el-col>
                            </el-row>
                            <el-row :gutter="16">
                                <el-col span="20">
                                    <el-form-item label="所需信息的内容描述(名称、文号或其他特征描述)" style="width: 97%" label-width="228px">
                                        <el-input
                                                type="textarea"
                                                autosize
                                                placeholder="请输入内容"
                                                v-model="form.content"
                                                maxlength="512"
                                                show-word-limit
                                                :disabled="sys_log.step!==3"
                                        >
                                        </el-input>
                                    </el-form-item>
                                </el-col>
                            </el-row>

                            <el-row :gutter="16">
                                <el-col span="20">
                                    <el-form-item label="获取政府信息的方式" style="width: 97%" label-width="150px">
                                        <el-radio-group v-model="form.accessWay" :disabled="sys_log.step!==3">
                                            <el-radio :label="1">邮寄</el-radio>
                                            <el-radio :label="2">当面领取</el-radio>
                                            <el-radio :label="3">现场查阅</el-radio>
                                            <el-radio :label="4">电子邮件</el-radio>
                                            <el-radio :label="5">传真</el-radio>
                                        </el-radio-group>
                                    </el-form-item>
                                </el-col>
                            </el-row>

                            <el-row :gutter="16">
                                <el-col span="12">
                                    <el-form-item label="政府信息的载体形式" style="width: 97%" label-width="150px">
                                        <el-radio-group v-model="form.accessType" :disabled="sys_log.step!==3">
                                            <el-radio :label="1">纸质</el-radio>
                                            <el-radio :label="2">数据电文</el-radio>
                                        </el-radio-group>
                                    </el-form-item>
                                </el-col>
                            </el-row>

                            <el-row :gutter="16">
                                <el-form-item label="申请日期" style="width: 97%" label-width="90px">
                                    <el-col :span="5">
                                        <el-date-picker
                                                disabled
                                                type="date"
                                                placeholder="选择日期"
                                                v-model="form.date"
                                                value-format="yyyy-MM-dd HH:mm:ss"
                                                style="width: 100%;"></el-date-picker>
                                    </el-col>
                                </el-form-item>
                            </el-row>

                            <el-row :gutter="16">
                                <el-col span="20">
                                    <el-form-item label="第三方意见" style="width: 97%" label-width="90px">
                                        <el-input
                                                type="textarea"
                                                autosize
                                                placeholder="请输入内容"
                                                v-model="sys_log.advice"
                                                maxlength="512"
                                                show-word-limit
                                                :disabled="isEmployee!==true"
                                        >
                                        </el-input>
                                    </el-form-item>
                                </el-col>
                            </el-row>

                            <el-row :gutter="16">
                                <el-col span="20">
                                    <el-form-item label="部门答复" style="width: 97%" label-width="90px">
                                        <el-input
                                                type="textarea"
                                                autosize
                                                placeholder="请输入内容"
                                                v-model="form.reply"
                                                maxlength="1024"
                                                show-word-limit
                                                :disabled="isEmployee!==true"
                                        >
                                        </el-input>
                                    </el-form-item>
                                </el-col>
                            </el-row>



                            <el-row :gutter="16">
                                <el-form-item label="答复日期" style="width: 97%" label-width="90px">
                                    <el-col :span="5">
                                        <el-date-picker
                                                disabled
                                                type="date"
                                                placeholder="选择日期"
                                                v-model="form.update_time"
                                                value-format="yyyy-MM-dd HH:mm:ss"
                                                style="width: 100%;"></el-date-picker>
                                    </el-col>
                                </el-form-item>
                            </el-row>
                            <el-row :gutter="16" style="margin-top: 50px">
                                <el-col span="18">
                                    <el-form-item>
                                        <el-button type="primary" @click="submitApplyFormReply()">回复</el-button>
                                        <el-button style="margin-left: 150px" type="danger" @click="fold()">取消</el-button>
                                    </el-form-item>
                                </el-col>
                            </el-row>


                        </el-form>
                    </div>
                </div>
                <div v-if="tableVisible">
                    <el-table
                            :data="affairData"
                            stripe
                            style="width: 90%">
                        <el-table-column
                                prop="title"
                                label="事项"
                                width="350">
                            <template slot-scope="scope">
                                <el-button
                                        type="text"
                                        @click="unfold(scope.row)"
                                        class="affairTitle"
                                >{{scope.row.title}}</el-button>
                            </template>
                        </el-table-column>
                        <el-table-column
                                prop="affairId"
                                label="流水号"
                                width="180">
                        </el-table-column>
                        <el-table-column
                                prop="step"
                                label="步骤"
                                width="180">
                        </el-table-column>
                        <el-table-column
                                prop="date"
                                label="申请日期"
                                width="180">
                        </el-table-column>
                    </el-table>
                </div>



            </el-col>
        </el-row>
        <BottomBar official="某某省某某市某某镇人民政府办公厅"></BottomBar>
    </div>
</template>

<script>
    import BottomBar from "../components/BottomBar";
    import TopBar from "../components/TopBar";
    import editor from "../components/editor";

    export default {
        name: "UserCenter",
        components: {BottomBar, TopBar,editor },
        data() {
            return {
                form: {
                    name: '',
                    workplace:'',
                    identicalType:0,
                    identicalCode:'',
                    phone:'',
                    postalCode:'',
                    address:'',
                    email:'',
                    deptId: 1,
                    content:'',
                    accessWay:1,
                    accessType:1,
                    create_time: new Date(),
                    reply:'',
                    update_time: new Date(),
                },
                sys_log:{
                    id:0,
                    title:'',
                    type:0,
                    pb_id:0,
                    user_id:null,
                    dept_id:0,
                    step:1,
                    advice:'第三方意见为无',
                    affirm:0,
                    create_time: new Date(),
                    update_time: new Date(),
                },
                identicalTypeOptions: [
                    {
                        value: 0,
                        label: '中国人民共和国居民身份证'
                    },
                    {
                        value: 1,
                        label: '台湾居民往来大陆通行证'
                    },
                    {
                        value: 2,
                        label: '港澳居民往来内地通行证'
                    },
                    {
                        value: 3,
                        label: '护照'
                    },
                    {
                        value: 4,
                        label: '香港身份证'
                    },
                    {
                        value: 5,
                        label: '澳门身份证'
                    },
                    {
                        value: 6,
                        label: '港澳居民居住证'
                    },
                    {
                        value: 7,
                        label: '台湾居民居住证'
                    },
                ],
                deptOptions: [
                    {
                        value: 1,
                        label: '党政综合办公室'
                    },
                    {
                        value: 2,
                        label: '党政综合办公室'
                    },
                    {
                        value: 3,
                        label: '党建工作办公室'
                    },
                    {
                        value: 4,
                        label: '纪检监察办公室'
                    },
                    {
                        value: 5,
                        label: '公共服务办公室'
                    },
                    {
                        value: 6,
                        label: '综合治理办公室'
                    },
                    {
                        value: 7,
                        label: '综合执法办公室'
                    },
                ],
                affairData: [{
                    date: '2018-05-02',
                    title: '在校学生临时出入校园报批_林俊杰',
                    step: '相关单位审核中',
                    affairId: 'E180502',
                    type:0,
                }, {
                    date: '2017-05-04',
                    title: '学生校园网开户/缴费_林俊杰',
                    step: '材料送审入库',
                    affairId: 'S170504',
                    type:1,

                }, {
                    date: '2016-05-01',
                    title: '学生返校申请（含新生）_林俊杰',
                    step: '已完成',
                    affairId: 'R160501',
                    type:0,
                }, {
                    date: '2015-05-03',
                    title: '学生离穗报批（学生假期去向审核）_林俊杰',
                    step: '已完成',
                    affairId: 'E150503',
                    type:1,
                }],
                formVisible:false,
                tableVisible:true,
                unfoldAffair:{
                    date: '2015-05-03',
                    title: '学生离穗报批（学生假期去向审核）_林俊杰',
                    step: '已完成',
                    affairId: 'E150503'
                },
                applyFormVisible:false,
                isEmployee:false,
                activeStep:1,

            }
        },
        methods:{
            unfold(affair){
                this.formVisible = true;
                this.applyFormVisible =true;
                this.tableVisible = false;
                this.unfoldAffair = affair;
                if(affair.type===0){
                    this.$api.interaction.getApplyForm(affair.affairId).then(res =>{
                        // console.log(res);
                        if(res.code !== 200) {
                            return this.$message.error('依申请公开表单获取失败');
                        }else {
                            this.form = res.data.form;
                            this.sys_log = res.data.sys_log;
                            if(res.data.user.userRole === 2)
                                this.isEmployee = true;
                            sessionStorage.setItem("userName",res.data.user.userName);
                            sessionStorage.setItem("userId",res.data.user.userId);
                            return this.$message.success('数据正在加载...');
                        }
                    }).catch(function(res) {
                        alert(res);
                    });
                }
                else if(affair.type===1){
                    //TODO
                }

            },
            fold(){
                this.formVisible = false;
                this.tableVisible = true;
                this.applyFormVisible =false;
            },
            submitApplyFormReply(){
                let params ={
                    form:this.form,
                    sys_log:this.sys_log
                };
                this.$api.interaction.updateApplyForm(params).then(res =>{
                    // console.log(res);
                    if(res.code !== 200) {
                        return this.$message.error('依申请公开表单更新失败');
                    }else {
                        this.form = res.data.form;
                        if(res.data.user.userRole === 2)
                            this.isEmployee = true;
                        sessionStorage.setItem("userName",res.data.user.userName);
                        sessionStorage.setItem("userId",res.data.user.userId);
                        return this.$message.success('数据正在加载...');
                    }
                }).catch(function(res) {
                    alert(res);
                });
            },
            getActiveStep(){
                if(this.sys_log.affirm === 1) return 4;
                if(this.sys_log.step === 5) return 2;
                else if(this.sys_log.step>5) return 3;
                else return 1;
            }
        }
    }
</script>

<style scoped>
    .affairTitle{
        color: black;
    }

</style>
