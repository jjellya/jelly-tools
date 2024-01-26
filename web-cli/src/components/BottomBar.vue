<template>
    <div class="footer">
        <el-row :gutter="10">
            <el-col :span="16" style="padding-top: 50px" :push="2">
                <el-row :gutter="8" >
                    <el-col :span="8" align="left"><p style="font-size: 14px">主办：{{official}}</p></el-col>
                    <el-col :span="6"><p style="font-size: 14px">运行管理:某某省某某市某某镇人民政府</p></el-col>
                    <el-col :span="8" push="2"><p style="font-size: 14px">承办： 仅用于毕业设计原型图展示</p></el-col>
                </el-row>
                <el-row :gutter="8">
                    <el-col :span="8" align="left"><p style="font-size: 14px">版权所有： 仅用于毕业设计原型图展示</p></el-col>
                    <el-col :span="8" align="left"><a href="https://gitee.com/Alvin_J_Lin/graduation-design" target="_blank"><p style="font-size: 14px">某ICP备：并非官方网站_仅用于毕业设计Demo展示</p></a></el-col>
                    <el-col :span="6" push="1" ><p style="font-size: 14px">网站标识码:   null_null_null</p></el-col>

                </el-row>
            </el-col>
            <el-col :span="8" :push="2">
                <el-row :gutter="50">
                    <el-col :span="4">
                        <a href="https://zfwzgl.www.gov.cn/exposure/jiucuo.html?site_code=4400000131&url=http%3A%2F%2Fwww.gd.gov.cn%2Fzwgk%2Findex.html" target="_blank">
                            <img src="../assets/error_reflection.jpg" style="alignment: left;padding-top: 80px" height="40">
                        </a>
                    </el-col>
                    <el-col :span="1">
                        <el-divider direction="vertical" class="verticalDivider"></el-divider>
                    </el-col>
                    <el-col :span="4" >
                        <a href="http://biaozhi.conac.cn/" target="_blank">
                            <img src="../assets/official_logo.png" style="alignment: left;padding-top: 60px">
                        </a>
                    </el-col>
                </el-row>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    export default {
        name: "BottomBar",
        props: {
            official: String,

        },
    }
</script>

<style scoped>

    .footer{
        position: relative;
        bottom: 0;
        overflow:hidden;
        height: 200px;
        background-color: #F1F2F3;
        margin:0;
        padding:0;

    }
    .official{
        position:relative;
        left:100px;
        top:0px;
        width: 200px;
        height: 300px;
        background-color: transparent;
        font-size: 14px;
        text-align: left;
        color: black;
    }
    .verticalDivider{
        position: relative;
        left: 20px;
        top: 80px;
        color: #BBBBBB;
        height: 45px;
        width: 3px;
        padding: 0px;
    }
</style>
