<template>
    <div>
        <el-container height="300px">
            <el-header height="300px">
                <div class="BackGround">
                    <img src="../assets/TopBar_background.jpg" style="width:100%;overflow:hidden;" height="300" >
                </div>
                <div>
                    <div>
                        <div class="NationalEmblem">
                            <img alt="national emblem" src="../assets/national_emblem_transparent.png" height="73" width="68">
                        </div>

                        <div class="txtTitle">
                            <h1 >{{ title }}</h1>
                        </div>


                        <div class="txtTitle_en">
                            <h4 >{{ title_en }}</h4>
                        </div>
                    </div>
                    <el-divider direction="vertical" class="verticalDivider"></el-divider>
                    <div>
<!--                        <span class="txtArea_city">-->
<!--                            {{city_town}} <i class="el-icon-arrow-down" @click="cascaderPanelVisible=true"></i>-->
<!--                        </span>-->
<!--                        <el-dialog :visible.sync="cascaderPanelVisible" :modal="false" class="dialog_Area_city">-->
<!--                            <el-cascader-panel  :options="options" class="cascader_panel_Area_city"></el-cascader-panel>-->
<!--                        </el-dialog>-->

                        <el-dropdown class="dropdown_Area_city">
                            <span class="el-dropdown-link">
                                <span class="txtArea_city">
                                    {{city_town}}
                                    <i class="el-icon-arrow-down"></i>
                                </span>
                            </span>
                            <el-dropdown-menu slot="dropdown">
                                <el-cascader-panel :props="{ expandTrigger: 'hover' }" :options="options" class="cascader_panel_Area_city"></el-cascader-panel>
                            </el-dropdown-menu>
                        </el-dropdown>

                    </div>

                </div>
                <div>
                    <span class="txtLogin"><LoginDialog v-if="isLogin()===false"></LoginDialog>
                        <el-row>
                            <el-col :span="2">
                                <el-button v-if="isLogin()"
                                           @click="$router.push('/userCenter')"
                                           size="mini"
                                           type="text"
                                class="userName">{{userName}}</el-button>
                            </el-col>
                            <el-col :push="15" :span="3">
                                <el-button v-if="isLogin()"
                                           @click="logout()"
                                           size="mini"
                                           style="background-color: transparent;color: white">退出</el-button>
                            </el-col>
                        </el-row>


                    </span>
                </div>
                <div class="NavMenu" >
                    <el-menu
                            :default-active="activeIndex"
                            class="NavMenu"
                            mode="horizontal"
                            background-color="transparent"
                            text-color="white"
                            active-text-color="white">
                        <el-menu-item index="1" class="txtHome" @click="$router.push('/')">首页</el-menu-item>
                        <el-menu-item index="2" class="txtNavItem1" @click="$router.push('/dept')">机构职能</el-menu-item>
                        <el-menu-item index="3" class="txtNavItem2" @click="$router.push('/policy')">政策公开</el-menu-item>
                        <el-menu-item index="4" class="txtNavItem3" @click="$router.push('/interact')">政民互动</el-menu-item>
                        <el-menu-item index="5" class="txtNavItem4">信息展示</el-menu-item>
                        </el-menu>
                    <div class="line"></div>

                </div>
                <div>
                    <span class="txtIntroductionTitle">基层政务公开监督管理平台</span>
                    <div class="txtIntroductionContent">
                        <span>聚焦基层群众办事痛点、堵点、难点，创新探索事权下放、基层服务</span>
                        <span>网点全覆盖、自助机就近办、加快推动政务服务向基层延伸，打造普</span>
                        <span>惠均等、便民高效的政务服务体系。</span>
                    </div>

                </div>

            </el-header>
        </el-container>

    </div>
</template>

<script>
    import LoginDialog from "./loginAndRegister/LoginDialog";
    import Cookies from "js-cookie";
    export default {
        name: "TopBar",
        components: {LoginDialog},
        props: {
            title: String,
            title_en: String,
            city_town: String,
            activeIndex: Number,
        },

        //数据==================================================================
        data() {
            return {
                userName: '',
                isNotLogin: true,
                value: [],
                options: [{
                    value: 'zhinan',
                    label: '指南',
                    children: [{
                        value: 'shejiyuanze',
                        label: '设计原则',
                        children: [{
                            value: 'yizhi',
                            label: '一致'
                        }, {
                            value: 'fankui',
                            label: '反馈'
                        }, {
                            value: 'xiaolv',
                            label: '效率'
                        }, {
                            value: 'kekong',
                            label: '可控'
                        }]
                    }, {
                        value: 'daohang',
                        label: '导航',
                        children: [{
                            value: 'cexiangdaohang',
                            label: '侧向导航'
                        }, {
                            value: 'dingbudaohang',
                            label: '顶部导航'
                        }]
                    }]
                }, {
                    value: 'zujian',
                    label: '组件',
                    children: [{
                        value: 'basic',
                        label: 'Basic',
                        children: [{
                            value: 'layout',
                            label: 'Layout 布局'
                        }, {
                            value: 'color',
                            label: 'Color 色彩'
                        }, {
                            value: 'typography',
                            label: 'Typography 字体'
                        }, {
                            value: 'icon',
                            label: 'Icon 图标'
                        }, {
                            value: 'button',
                            label: 'Button 按钮'
                        }]
                    }, {
                        value: 'form',
                        label: 'Form',
                        children: [{
                            value: 'radio',
                            label: 'Radio 单选框'
                        }, {
                            value: 'checkbox',
                            label: 'Checkbox 多选框'
                        }, {
                            value: 'input',
                            label: 'Input 输入框'
                        }, {
                            value: 'input-number',
                            label: 'InputNumber 计数器'
                        }, {
                            value: 'select',
                            label: 'Select 选择器'
                        }, {
                            value: 'cascader',
                            label: 'Cascader 级联选择器'
                        }, {
                            value: 'switch',
                            label: 'Switch 开关'
                        }, {
                            value: 'slider',
                            label: 'Slider 滑块'
                        }, {
                            value: 'time-picker',
                            label: 'TimePicker 时间选择器'
                        }, {
                            value: 'date-picker',
                            label: 'DatePicker 日期选择器'
                        }, {
                            value: 'datetime-picker',
                            label: 'DateTimePicker 日期时间选择器'
                        }, {
                            value: 'upload',
                            label: 'Upload 上传'
                        }, {
                            value: 'rate',
                            label: 'Rate 评分'
                        }, {
                            value: 'form',
                            label: 'Form 表单'
                        }]
                    }, {
                        value: 'data',
                        label: 'Data',
                        children: [{
                            value: 'table',
                            label: 'Table 表格'
                        }, {
                            value: 'tag',
                            label: 'Tag 标签'
                        }, {
                            value: 'progress',
                            label: 'Progress 进度条'
                        }, {
                            value: 'tree',
                            label: 'Tree 树形控件'
                        }, {
                            value: 'pagination',
                            label: 'Pagination 分页'
                        }, {
                            value: 'badge',
                            label: 'Badge 标记'
                        }]
                    }, {
                        value: 'notice',
                        label: 'Notice',
                        children: [{
                            value: 'alert',
                            label: 'Alert 警告'
                        }, {
                            value: 'loading',
                            label: 'Loading 加载'
                        }, {
                            value: 'message',
                            label: 'Message 消息提示'
                        }, {
                            value: 'message-box',
                            label: 'MessageBox 弹框'
                        }, {
                            value: 'notification',
                            label: 'Notification 通知'
                        }]
                    }, {
                        value: 'navigation',
                        label: 'Navigation',
                        children: [{
                            value: 'menu',
                            label: 'NavMenu 导航菜单'
                        }, {
                            value: 'tabs',
                            label: 'Tabs 标签页'
                        }, {
                            value: 'breadcrumb',
                            label: 'Breadcrumb 面包屑'
                        }, {
                            value: 'dropdown',
                            label: 'Dropdown 下拉菜单'
                        }, {
                            value: 'steps',
                            label: 'Steps 步骤条'
                        }]
                    }, {
                        value: 'others',
                        label: 'Others',
                        children: [{
                            value: 'dialog',
                            label: 'Dialog 对话框'
                        }, {
                            value: 'tooltip',
                            label: 'Tooltip 文字提示'
                        }, {
                            value: 'popover',
                            label: 'Popover 弹出框'
                        }, {
                            value: 'card',
                            label: 'Card 卡片'
                        }, {
                            value: 'carousel',
                            label: 'Carousel 走马灯'
                        }, {
                            value: 'collapse',
                            label: 'Collapse 折叠面板'
                        }]
                    }]
                }, {
                    value: 'ziyuan',
                    label: '资源',
                    children: [{
                        value: 'axure',
                        label: 'Axure Components'
                    }, {
                        value: 'sketch',
                        label: 'Sketch Templates'
                    }, {
                        value: 'jiaohu',
                        label: '组件交互文档'
                    }]
                }]
            };
        },
        //方法==========================================================
        methods: {
            isLogin(){
                if (sessionStorage.getItem("userName")!==null){
                    this.userName = window.sessionStorage.getItem("userName");
                    return true;
                }
                return false;
            },

            handleChange(value) {
                console.log(value);
            },

            logout(){
                sessionStorage.removeItem("userName");
                sessionStorage.removeItem("userId");
                Cookies.remove("token");
                this.$router.go(0);
            }
        },
        mounted() {
            let userName = sessionStorage.getItem("userName");
            if (userName) {
                this.userName = userName;
                this.isNotLogin = false;
            }
        }
    }
</script>

<style scoped>
    .BackGround{
        position:absolute;
        overflow:hidden;
        left:0px;
        width: 100%;
        top:0px;
        padding: 0px;
    }

    .NationalEmblem{
        position:absolute;
        overflow:hidden;
        left:39px;
        top:20px;
        padding: 0px;
    }

    .txtTitle{
        position:absolute;
        left:122px;
        top:0;
        color: white;
        font-size: 24px;
        padding: 0px;
    }

    .txtTitle_en{
        position:absolute;
        left:122px;
        top:60px;
        color: white;
        font-size: 14px;
        padding: 0px;
    }
    .verticalDivider{
        position:absolute;
        left:490px;
        top:40px;
        color: white;
        height: 45px;
        width: 3px;
        padding: 0px;
    }

    .txtArea_city{
        position:absolute;
        left:0px;
        top:0px;
        width: 200px;
        color: white;
        font-size: 26px;
        padding: 0px;
    }
    .dropdown_Area_city{
        position:absolute;
        left:510px;
        top:45px;
    }
    .cascader_panel_Area_city{
        position:absolute;
        left: 0px;
        top: 50px;
        border-style: none;
        background-color: white;

    }
    .txtLogin{
        position:absolute;
        right:15px;
        top:45px;
        width: 200px;
        color: white;
        font-size: 20px;
    }
    .NavMenu{
        position:absolute;
        /*overflow:hidden;*/
        left:0px;
        top:48px;
        width: 100%;
        padding: 0px;
    }
    .txtHome{
        position:relative;
        left:170px;
        width: 100px;
        font-size: 18px;
    }
    .txtNavItem1{
        position: relative;
        left:330px;
        width: 100px;
        font-size: 18px;
    }
    .txtNavItem2{
        position: relative;
        left:490px;
        width: 100px;
        font-size: 18px;
    }
    .txtNavItem3{
        position: relative;
        left:630px;
        width: 100px;
        font-size: 18px;
    }
    .txtNavItem4{
        position: relative;
        left:790px;
        width: 100px;
        font-size: 18px;
    }
    .txtIntroductionTitle{
        position:absolute;
        left:160px;
        top:170px;
        width: 350px;
        color: white;
        font-size: 24px;
        padding: 0px;
    }
    .txtIntroductionContent{
        position:absolute;
        left:190px;
        top:205px;
        width: 450px;
        color: white;
        font-size: 15px;
        text-align: left;
        padding: 0px;
    }
    .userName{
        position:absolute;
        right:85px;
        width: 200px;
        color: white;
        font-size: 20px;
    }

</style>
