<template>
  <div >
    <TopBar
        title="某某市某某镇人民镇府"
        title_en="People's  Government of xxxxx City xxxxx Town"
        city_town="某某市某某镇"
        active-index="3">
    </TopBar>
    <el-row :gutter="20" style="width: 100%;">
      <el-col :span="10" :pull="1">
        <el-row style="margin-top: 130px;margin-left: 0;">
          <span class="txtTitle">政府文件库</span>
        </el-row>
        <el-row>
          <el-card :body-style=card_body_style shadow="hover" class="card_style" >
            <el-row :gutter="10" style="width: 560px;height: 259px;">
              <el-col :span="4">
                <div class="card_left">
                  <el-row >
                    <img :src=img_src class="image">
                  </el-row>
                  <el-row class="latest_file_title">
                    <span>{{latest_file_link.file_title}}</span>
                  </el-row>
                </div>
              </el-col>
              <el-col :span="6" :push="5" style="width: 352px;height: 259px">
                <div class="latest_file_url">
                  <a class="cancel_underline" target="_blank" :href="latest_file_link.url">
                    {{latest_file_link.file_title}}
                  </a>
                </div>
                <div>
                  <span class="bottom_date">{{latest_file_link.date}}</span>
                </div>

              </el-col>

            </el-row>

          </el-card>
        </el-row>
        <el-row style="left: 215px">
          <div class="cancel_el-table_border">
            <el-table
                :data="fileLinkData"
                style="width: 95%"
            >

              <el-table-column
                  prop="file_title"
              >
                <template slot-scope="scope">
                  <a class="cancel_underline" :href="scope.row.url" target="_blank">{{scope.row.file_title}}</a>
                </template>
              </el-table-column>
              <el-table-column
                  prop="date"
                  width="100">
              </el-table-column>
            </el-table>
          </div>
        </el-row>
        <el-row style="width: 100%;margin-top: 15px">

          <!--                    <el-select v-model="options_value" class="select_frame">-->
          <!--                        <el-option-->
          <!--                                v-for="item in options"-->
          <!--                                :key="item.value"-->
          <!--                                :label="item.label"-->
          <!--                                :value="item.value">-->
          <!--                        </el-option>-->
          <!--                    </el-select>-->
          <!--                    <el-input-->
          <!--                            placeholder="请输入需要查找的内容"-->
          <!--                            v-model="search_input"-->
          <!--                            clearable-->
          <!--                            class="search_input"-->
          <!--                            >-->
          <!--                        <el-button-->
          <!--                                slot="append"-->
          <!--                                @click="toSearch()">查找-->
          <!--                            <i class="el-icon-search"></i>-->
          <!--                        </el-button>-->
          <!--                    </el-input>-->
          <el-input placeholder="请输入需要查找的内容" v-model="search_input" class="search_input input-with-select">
            <el-select v-model="options_value" slot="prepend" class="select_frame">
              <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
            <el-button slot="append" icon="el-icon-search" @click="toSearch()"></el-button>
          </el-input>

        </el-row>
      </el-col>

      <el-col :span="8">
        <el-row style="margin-top: 130px">
          <span class="txtTitle">政策解读</span>
        </el-row>
        <el-row :gutter="10">
          <el-col :span="10" :push="4">
            <a :href=policyInterpretationData[0].url target="_blank" class="img_url">
              <el-image
                  :src="policyInterpretationData[0].imageSrc"
                  class="left_image"
                  @click="this.router.push('/image')"></el-image>
            </a>
          </el-col>
          <el-col :span="10" :push="6" >
            <a :href=policyInterpretationData[1].url target="_blank" class="img_url">
              <el-image
                  :src="policyInterpretationData[1].imageSrc"
                  class="right_image"
                  @click="this.router.push('/image')"></el-image>
            </a>
          </el-col>
        </el-row>
        <el-row style="margin-top: 45px">
          <span class="txtTitle">最新政策</span>
        </el-row>
        <el-row style="left: 160px;width: 650px">
          <div class="cancel_el-table_border">
            <el-table
                :data="policyLinkData"
                style="width: 100%">
              <el-table-column
                  prop="policy_title">
                <template slot-scope="scope">
                  <a class="cancel_underline" :href="scope.row.url" target="_blank">{{scope.row.policy_title}}</a>
                </template>
              </el-table-column>
              <el-table-column
                  prop="date"
                  width="95"><!--这里能调整个表的左右宽度,能让这一项拉后-->
              </el-table-column>
            </el-table>
          </div>
        </el-row>

      </el-col>
    </el-row>

    <div style="margin-top: 20px"></div>

    <BottomBar official="某某省某某市某某镇人民政府办公厅"></BottomBar>
  </div>
</template>

<script>
import GazetteCard from "../components/GazetteCard";
import TopBar from "../components/TopBar";
import BottomBar from "../components/BottomBar";
import ServerRecomBar from "../components/SeverRecomBar";
import BoardNav from "../components/BoardNav";
import CarouselNav from "../components/CarouselNav";
import ModulesBoardNav from "../components/ModulesBoardNav";
import HelloWorld from "../components/HelloWorld";
import axios from "axios";
import DividerInjectTxt from "../components/DividerInjectTxt";

export default {
  name: "Policy",
  data() {
    return {
      img_src: require("../assets/national_emblem_transparent.png"),
      card_body_style: {
        padding: '0px',
        width: '560px',
        height: '259px'

      },
      latest_file_link:{
        id:1,
        file_title:'镇人民政府办公室关于印发防返贫家庭特别扶助办法的通知',
        url: 'https://gitee.com/Alvin_J_Lin/graduation-design',
        date:'2022-12-01'
      },
      fileLinkData:[
        {
          id: 2,
          file_title:'某某镇公安机关警务辅助人员管理办法',
          url: 'https://gitee.com/Alvin_J_Lin/graduation-design',
          date:'2022-11-02'
        },
        {
          id: 3,
          file_title:'某某镇人民政府关于甲同志任职的通知',
          url: 'https://gitee.com/Alvin_J_Lin/graduation-design',
          date:'2022-10-23'
        },
        {
          id: 4,
          file_title:'某某镇关于秸秆燃放区域及周边火灾...',
          url: 'https://gitee.com/Alvin_J_Lin/graduation-design',
          date: '2022-09-12'
        }
      ],
      policyInterpretationData:[
        {
          id:1,
          imageSrc:'https://gitee.com/Alvin_J_Lin/pic-go-cdn/raw/master/Test-PicGo/政策解读2.png',
          url:'https://gitee.com/Alvin_J_Lin/pic-go-cdn/raw/master/Test-PicGo/政策解读2.png/'
        },
        {
          id:2,
          imageSrc:'https://gitee.com/Alvin_J_Lin/pic-go-cdn/raw/master/Test-PicGo/政策解读3.png',
          url:'https://gitee.com/Alvin_J_Lin/pic-go-cdn/raw/master/Test-PicGo/政策解读3.png/'
        }
      ],
      policyLinkData:[
        {
          id: 1,
          policy_title:'我镇关于认真学习贯彻党的十九届六中全..',
          url: 'https://gitee.com/Alvin_J_Lin/graduation-design',
          date:'2022-11-02'
        },
        {
          id: 2,
          policy_title:'住房和城乡建设委员会关于进一步规范住..',
          url: 'https://gitee.com/Alvin_J_Lin/graduation-design',
          date:'2022-10-23'
        },
        {
          id: 3,
          policy_title:'卫健委关于对医疗器械产品公共支出预算..',
          url: 'https://gitee.com/Alvin_J_Lin/graduation-design',
          date: '2022-09-12'
        }
      ],

      options: [{
        value: 1,
        label: '文件名'
      }, {
        value: 2,
        label: '文件内容'
      }],
      options_value: 1,
      search_input: '',
    }
  },

  components: {
    DividerInjectTxt,
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
    skip2PublicPaper(url) {
      axios.get(url).then(res => { alert(res.data) })
    },
    toSearch(){
      let url = '/search';
      axios.get(url,{params:{search_type:this.options_value,search_input:this.search_input}}).then(res => { alert(res.data) })
    }
  }
}

</script>

<style scoped>
.txtTitle{
  color: #3573A6;
  font-size: 36px;
  padding: 0;
  margin: 0;
}

.card_style{

  position: relative;
  margin-top: 17px;
  left: 215px;
  width: 560px;
  height: 259px;
  background-color: transparent;
  margin-bottom: 30px;
}

.image {
  position: relative;
  top: 50px;
  left: 30%;
  width: 73px;
  display: block;
}

.card_left{
  background-color: #F1F2F3;
  width: 208px;
  height: 259px;
}
.latest_file_title{
  position: relative;
  top: 80px;
  left: 10%;
  font-size: 14px;
  height: 65px;
  width: 172px;
}

.bottom_date{
  position: relative;
  top: 30px;
  left: 20%;
  font-size: 20px;
  color: #C0C0C0;
}

.latest_file_url{
  position: relative;
  top: 65px;
  left: 25px;
  font-size: 25px;
  text-align: left;
  height: 189px;
  width: 296px;

}

.cancel_underline{
  text-decoration:none;/*去掉a标签下的下划线*/
  color: black;
  width: 296px;
}

.cancel_el-table_border >>> .el-table__row>td{
  border: none;   /*强制去掉表格的下划线*/
}
.cancel_el-table_border >>> .el-table th.is-leaf{
  border: none;   /*强制去掉表格的上边框*/
  padding: 0;
}
.cancel_el-table_border >>> .el-table::before {
  height: 0px;    /*强制去掉表格的下边框*/
}

.left_image{
  margin-top: 17px;
  position: relative;
  width: 100%;
  left: 75px;
  width: 293px;
  height: 259px;
}

.img_url{
  width: 293px;
  height: 259px;
}

.right_image{
  margin-top: 17px;
  position: relative;
  width: 100%;
  left: 175px;
  width: 293px;
  height: 259px;
}

.select_frame{
  width: 142px;

}

.search_input{
  position: relative;
  left: 190px;
  border-left: none;
  width: 568px;
}

.search_button{
  width: 35px;
  padding: 0;
  margin: 0;
}

.el-select .el-input {
  width: 130px;
}
.input-with-select .el-input-group__prepend {
  background-color: #F2F9FF;
}


</style>
