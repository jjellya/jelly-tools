<template>
    <div >
        <a :href=data.url target="_blank" class="cancel_underline">
        <el-card :body-style=body_style shadow="hover" class="card_style" >
            <el-row>
                    <img :src=data.img_src class="image" :lazy="true" >
            </el-row>
            <el-row>
                <div style="padding: 14px;">
                    <div class="bottom clearfix">
                        <el-row>
                            <span class="txtTitle" >{{data.title}}</span>
                        </el-row>
                        <el-row>
                            <span class="txtContent" >{{data.content}}</span>
                        </el-row>


                    </div>
                </div>
            </el-row>
        </el-card>
        </a>
    </div>
</template>

<script>
    import axios from "axios";
    import router from "../router";

    export default {
        name: "VerticalCard",
        props: {
            body_style: Object,
            data: Object
        },
        data() {
            return {

            };
        },
        methods: {
            skip2Page(url){
                this.$router.push('/test');
            },
        }
    }



</script>

<style scoped>
    .cancel_underline{
        text-decoration:none;/*去掉a标签下的下划线*/
        color: black;

    }
    .card_style{
        width: 270px;
        height: 290px;
        background-color: white;

    }

    .image {
        width: 100%;
        height: 160px;
        display: block;
    }
    .txtTitle{
        position: relative;
        right: 20%;
        width: 80%;
        height: 10%;
        font-size: 20px;
        font-weight: bold;

    }
    .txtContent{
        margin-top: 13px;
        position: relative;
        top: 30px;
        width: 80%;
        height: 10%;
        font-size: 14px;
        padding: 0;
        margin-left: 0;
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
