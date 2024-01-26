<template>
    <div class="SNavBar">
        <el-row :gutter="0">
            <el-col :span="10" style="padding-top: 20px" :pull="1">
                <h1 >
                    <i class="el-icon-document-checked"></i>服务推荐
                </h1>
            </el-col>
            <el-col :span="2" style="padding-top: 45px"><el-button plain @click="$router.push('/404')">权责清单</el-button></el-col>
            <el-col :offset="1" :span="2" style="padding-top: 45px"><el-button plain @click="$router.push('/404')">意见征集</el-button></el-col>
            <el-col :offset="1" :span="2" style="padding-top: 45px"><el-button plain @click="$router.push('/applyForm')">依申请公开</el-button></el-col>
            <el-col :offset="1" :span="2" style="padding-top: 45px"><el-button plain @click="$router.push('/test')">举报投诉</el-button></el-col>
        </el-row>


    </div>
</template>

<script>
    export default {
        name: "ServerRecomBar"
    }
</script>

<style scoped>
    .SNavBar{
        height: 120px;
        background-color: #F1F2F3;
        overflow: hidden;
        padding: 0;
        margin: 0;
    }
</style>
