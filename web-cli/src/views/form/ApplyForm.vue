<template>
    <div>
        <TopBar
                title="某某市某某镇人民镇府"
                title_en="People's  Government of xxxxx City xxxxx Town"
                city_town="某某市某某镇"
                active-index="3">
        </TopBar>

        <div class="applyForm">
            <el-page-header @back="goBack()" content="依申请公开"></el-page-header>
            <div style="margin-top: 30px"></div>
            <div><h1 style="text-align: left;color: #4293F4">·填写申请表格:</h1></div>
            <div style="margin-top: 50px"></div>
            <el-form ref="form" :model="form" label-width="80px">
                <el-row :gutter="16">
                    <el-col span="10">
                        <el-form-item label="姓名" style="width: 280px">
                            <el-input v-model="form.name"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col span="10">
                        <el-form-item label="工作单位" style="width: 350px">
                            <el-input v-model="form.workplace"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>

                <el-row :gutter="16">
                    <el-col span="10">
                        <el-form-item label="证件名称" style="width: 280px">
                            <el-select v-model="form.identicalType" placeholder="请选择证件类型">
                                <el-option v-for="item in identicalTypeOptions"
                                           :key="item.value"
                                           :label="item.label"
                                           :value="item.value"></el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col span="10">
                        <el-form-item label="证件号码" style="width: 350px">
                            <el-input v-model="form.identicalCode"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>

                <el-row :gutter="16">
                    <el-col span="10">
                        <el-form-item label="联系电话" style="width: 280px">
                            <el-input v-model="form.phone"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col span="10">
                        <el-form-item label="邮政编码" style="width: 350px">
                            <el-input v-model="form.postalCode"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>

                <el-row :gutter="16">
                    <el-col span="20">
                        <el-form-item label="联系地址" style="width: 97%" >
                            <el-input v-model="form.address"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>

                <el-row :gutter="16">
                    <el-col span="20">
                        <el-form-item label="电子邮箱" style="width: 97%" >
                            <el-input v-model="form.email"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>

                <el-row :gutter="16">
                    <el-col span="20">
                        <el-form-item label="政府信息公开义务机关(机构名称)" style="width: 430px"  label-width="230px">
                            <el-select v-model="form.deptId" placeholder="请选择政府单位" style="width: 505px">
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
                                    placeholder="请输入内容"
                                    v-model="form.content"
                                    maxlength="512"
                                    show-word-limit
                                    autosize
                            >
                            </el-input>
                        </el-form-item>
                    </el-col>
                </el-row>

                <el-row :gutter="16">
                    <el-col span="20">
                        <el-form-item label="获取政府信息的方式" style="width: 97%" label-width="150px">
                            <el-radio-group v-model="form.accessWay">
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
                            <el-radio-group v-model="form.accessType">
                                <el-radio :label="1">纸质</el-radio>
                                <el-radio :label="2">数据电文</el-radio>
                            </el-radio-group>
                        </el-form-item>
                    </el-col>
                </el-row>



                <el-row :gutter="16">
                    <el-form-item label="申请日期">
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
                <el-row :gutter="16" style="margin-top: 50px">
                    <el-col span="18">
                        <el-form-item>
                            <el-button type="primary" @click="onSubmit">立即创建</el-button>
                            <el-button style="margin-left: 150px" type="danger">取消</el-button>
                        </el-form-item>
                    </el-col>
                </el-row>

            </el-form>
        </div>
        <BottomBar official="某某省某某市某某镇人民政府办公厅"></BottomBar>
    </div>
</template>

<script>
    import BottomBar from "../../components/BottomBar";
    import TopBar from "../../components/TopBar";

    export default {
        name: "ApplyForm",
        components: {BottomBar, TopBar},
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
                    date: new Date(),
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
            }
        },

        methods:{
            onSubmit(){
                this.$api.interaction.applyForPublic(this.form).then(res =>{
                    if(res.code!== 200) {
                        return this.$message.error('申请失败');
                    }else {
                        this.$router.push('/');
                        return this.$message.success('申请成功');
                    }
                });
            },

            goBack(){
                if (window.history.length <= 1) {
                    this.$router.push({ path: "/" });
                    return false;
                } else {
                    this.$router.go(-1);
                }
            },
        }
    }
</script>

<style scoped>

    .applyForm{
        position:relative;
        /*overflow:hidden;*/
        left:25%;
        top:21px;
        width: 60%;
        padding: 20px;
    }


</style>
