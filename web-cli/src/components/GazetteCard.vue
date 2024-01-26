<template>
    <div >
        <el-card :body-style=body_style shadow="hover" class="card_style" >
            <el-row>
                <img :src=img_src class="image">
            </el-row>
            <el-row>
                <div style="padding: 14px;">
                <div class="bottom clearfix">
                    <el-row>
                        <el-button plain class="first_button" @click="skip2PublicPaper(latestPaperURL)">最新：{{ latestPaperTitle }}</el-button>
                    </el-row>
                    <el-row>
                        <el-button plain class="second_button">历史公报：( {{ earlyYear }} 年 - {{ latestYear }}年)</el-button>
                    </el-row>


                </div>
            </div>
            </el-row>
        </el-card>
    </div>
</template>

<script>
    import axios from "axios";
    import router from "../router";

    export default {
        name: "GazetteCard",
        props: {
            img_src: String,
            body_style: Object,

        },
        data() {
            return {
                latestPaperTitle: '2022年  第13期',
                latestPaperURL: 'test',
                earlyYear: 2000,
                latestYear: new Date().getFullYear()
            };
        },
        methods: {
            skip2PublicPaper(url) {
                axios.get(url).then(res => { alert(res.data) })
            },
        }
    }
</script>

<style scoped>
    .card_style{
        width: 320px;
        height: 310px;
        background-color: #BBBBBB;

    }

    .image {
        width: 100%;
        display: block;
    }
    .first_button{
        width: 80%;
        height: 10%;
    }
    .second_button{
        margin-top: 13px;
        width: 80%;
        height: 10%;
    }
    .bottom {
        margin-top: 13px;
        line-height: 12px;
    }
    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }

    .clearfix:after {
        clear: both
    }

</style>
