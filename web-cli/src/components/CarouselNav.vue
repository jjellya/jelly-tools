<template>
    <div class="carouseNav">
        <el-carousel :interval="4000"  height="360px" >
            <el-carousel-item v-for="itemOfArray in carouselData" :key="itemOfArray.index">
                <el-col :span="7" :push="3" style="top: 40px" v-for="item in itemOfArray.array" :key="item.url">
                    <VerticalCard
                            :body_style="card_body_style"
                            :data="item">
                    </VerticalCard>
                </el-col>
            </el-carousel-item>

        </el-carousel>
    </div>

</template>

<script>

    import VerticalCard from "./VerticalCard";
    export default {
        name: "CarouselNav",
        components:{
            VerticalCard
        },
        data() {
            return {
                card_body_style: {
                    padding: '0px',
                },
                carouselData:[
                    {
                        index:1,
                        array:[
                            {
                                img_src: require("../assets/signature.png"),
                                title: '依申请公开',
                                content: '免费高效，详细准确，省事省心',
                                url: 'https://element.eleme.cn/#/zh-CN/component/installation'
                            },
                            {
                                img_src: "https://gitee.com/Alvin_J_Lin/pic-go-cdn/raw/master/Test-PicGo/政策解读.png",
                                title: '政策解读',
                                content: '免费高效，详细准确，省事省心',
                                url: 'https://info.scau.edu.cn/'
                            },
                            {
                                img_src: "https://gitee.com/Alvin_J_Lin/pic-go-cdn/raw/master/Test-PicGo/最新政策.png",
                                title: '政策解读',
                                content: '免费高效，详细准确，省事省心',
                                url: 'https://scau.edu.cn/'
                            },
                        ],
                    },
                    {
                        index:2,
                        array:[
                            {
                                img_src: "https://.com/Alvin_J_Lin/pic-go-cdn/raw/master/Test-PicGo/签字画押.png",
                                title: '依申请公开',
                                content: '免费高效，详细准确，省事省心',
                                url: 'https://element.eleme.cn/#/zh-CN/component/installation'
                            },
                            {
                                img_src: "https://gitee.com/Alvin_J_Lin/pic-go-cdn/raw/master/Test-PicGo/政策解读.png",
                                title: '政策解读',
                                content: '免费高效，详细准确，省事省心',
                                url: 'https://info.scau.edu.cn/'
                            },
                            {
                                img_src: "https://gitee.com/Alvin_J_Lin/pic-go-cdn/raw/master/Test-PicGo/最新政策.png",
                                title: '政策解读',
                                content: '免费高效，详细准确，省事省心',
                                url: 'https://scau.edu.cn/'
                            },
                        ],
                    },
                    {
                        index:3,
                        array:[
                            {
                                img_src: "https://.com/Alvin_J_Lin/pic-go-cdn/raw/master/Test-PicGo/签字画押.png",
                                title: '依申请公开',
                                content: '免费高效，详细准确，省事省心',
                                url: 'https://element.eleme.cn/#/zh-CN/component/installation'
                            },
                            {
                                img_src: "https://gitee.com/Alvin_J_Lin/pic-go-cdn/raw/master/Test-PicGo/政策解读.png",
                                title: '政策解读',
                                content: '免费高效，详细准确，省事省心',
                                url: 'https://info.scau.edu.cn/'
                            },
                            {
                                img_src: "https://gitee.com/Alvin_J_Lin/pic-go-cdn/raw/master/Test-PicGo/最新政策.png",
                                title: '政策解读',
                                content: '免费高效，详细准确，省事省心',
                                url: 'https://scau.edu.cn/'
                            },
                        ],
                    },

                ],
            }
        },
        //创建时拉取的数据=======================================================
        created() {
            this.$api.home.getCarouselNavData(9).then(res =>{
                console.log(res);
                if(res.code !== 200) {
                    return this.$message.error('数据获取失败');
                }else {
                    this.carouselData = res.data;
                    //return this.$message.success('数据加载完成');
                }
            }).catch(function(res) {
                alert(res);
            });
        }
    }
</script>

<style scoped>
    .carouseNav{
        position: relative;
        top: 50px;
        height: 400px;
        width: 85%;
        left: 7%;
        color: transparent;
    }
    .el-carousel__item h3 {
        color: transparent;
        font-size: 14px;
        opacity: 0.75;
        line-height: 200px;
        margin: 0;
    }

    .el-carousel__item:nth-child(2n) {
        background-color: transparent;
    }

    .el-carousel__item:nth-child(2n+1) {
        background-color: transparent;
    }
</style>
