<template>
    <el-row :gutter="20" class="dividerInjectTxt">
        <el-col :span="15" :push="5">
            <el-divider :content-position="content_position">
                <span class="txtTitle">{{txt}}</span>
            </el-divider>
        </el-col>
    </el-row>
</template>

<script>
    export default {
        name: "DividerInjectTxt",
        props:{
            txt:String,
            content_position:String,
        }
    }
</script>

<style scoped>
    .dividerInjectTxt{
        overflow: hidden;
        margin-top: 45px;
        margin-left:0;
        margin-right: 0;
        padding:0;
        width: 100%;
    }
    .txtTitle{
        overflow: hidden;
        padding:0;
        margin: 0;
        font-size: 36px;
        color: #09294D;
    }
</style>
