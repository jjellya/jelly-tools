<template>
  <div >
    <TopBar
            title="某某市某某镇人民镇府"
            title_en="People's  Government of xxxxx City xxxxx Town"
            city_town="某某市某某镇"
            active-index="1">
    </TopBar>
      <ServerRecomBar></ServerRecomBar>

      <el-row>
            <el-col :span="8" :push="2" style="top: 50px">
                <GazetteCard
                        :img_src="img_src"
                        :body_style="card_body_style"
                        >
                </GazetteCard>
            </el-col>
            <el-col :span="16">
                <BoardNav title1="公示公告" title2="人事信息"></BoardNav>
            </el-col>
        </el-row>

        <el-row>
            <CarouselNav></CarouselNav>
        </el-row>
        <el-row>
            <ModulesBoardNav
                    title1="重点领域信息公开"
                    title2="回应关切" >

            </ModulesBoardNav>
        </el-row>

<!--      <HelloWorld msg="这是内容部分"/>-->
<!--      <el-button type="primary" @click="testAxios()">测试Axios调用</el-button>-->
<!--      <el-button type="primary" @click="getUser()">获取用户信息</el-button>-->
<!--      <el-button type="primary" @click="getMenu()">获取菜单信息</el-button>-->
    <BottomBar official="某某省某某市某某镇人民政府办公厅"></BottomBar>



  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import TopBar from "../components/TopBar";
import BottomBar from "../components/BottomBar";
import ServerRecomBar from "../components/SeverRecomBar";
import BoardNav from "../components/BoardNav";
import CarouselNav from "../components/CarouselNav";
import GazetteCard from "../components/GazetteCard";
import ModulesBoardNav from "../components/ModulesBoardNav";

import axios from 'axios'
import mock from '../mock/mock.js'


export default {
  name: 'Home',

    data() {
        return {
            img_src: "https://gitee.com/Alvin_J_Lin/pic-go-cdn/raw/master/Test-PicGo/政府公报.png",
            card_body_style: {
                padding: '0px',
            },
        }
    },

  components: {
      GazetteCard,
    HelloWorld,
    TopBar,
    BottomBar,
    ServerRecomBar,
      BoardNav,
      CarouselNav,
      ModulesBoardNav

  },
  methods: {
    testAxios() {
      axios.get('http://172.18.218.197:8083').then(res => { alert(res.data) })
    },
    getUser() {
      axios.get('http://172.18.218.197:8083/user').then(res => { alert(JSON.stringify(res.data)) })
    },
    getMenu() {
      axios.get('http://172.18.218.197:8083/menu').then(res => { alert(JSON.stringify(res.data)) })
    }
  }
}
</script>
