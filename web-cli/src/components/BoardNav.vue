<template>
    <div class="board" >
        <el-row :gutter="16">

                <el-menu
                        :default-active="activeIndex"
                        class="NavMenu"
                        mode="horizontal"
                        background-color="transparent"
                        text-color="black"
                        active-text-color="#2F6EA2"
                >
                    <el-menu-item index="1" class="txtNavItem1">{{title1}}</el-menu-item>
                    <el-menu-item index="2" class="txtNavItem2">{{title2}}</el-menu-item>
                </el-menu>


        </el-row>
        <el-row :gutter="8">
            <div class="cancel_el-table_border">
                <el-table
                        :data="tableData"
                        style="width: 100%"
                        >

                    <el-table-column
                            prop="title"
                            >
                        <template slot-scope="scope">
                            <a class="cancel_underline" :href="scope.row.url">{{scope.row.title}}</a>
                        </template>
                    </el-table-column>
                    <el-table-column
                            prop="date"
                            width="180">
                    </el-table-column>
                </el-table>
            </div>
        </el-row>
        <div class="line"></div>

    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "BoardNav",
        props: {
            title1:String,
            title2:String,
        },
        //数据==================================================================
        data() {
            return {
                activeIndex: '1',
                tableData: []
            }
        },

        //创建时拉取的数据=======================================================
        created() {
            this.$api.home.getBulletinBoardData(6).then(res =>{
                    console.log(res);
                    if(res.code !== 200) {
                        return this.$message.error('数据获取失败');
                    }else {
                        this.tableData = res.data;
                        //return this.$message.success('数据正在加载...');
                    }
                }).catch(function(res) {
                alert(res);
            });
        }
    }
</script>

<style scoped>
    .board{
        position:relative;
        /*overflow:hidden;*/
        left:20px;
        top:21px;
        width: 90%;
        padding: 0px;

    }
    .txtNavItem1{
        position: relative;
        left:30px;
        width: 120px;
        font-size: 18px;
        text-align: center;
    }
    .txtNavItem2{
        position: relative;
        left:100px;
        width: 120px;
        font-size: 18px;
        text-align: center;
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
    .cancel_underline{
        text-decoration:none;/*去掉a标签下的下划线*/
        color: black;

    }


</style>
