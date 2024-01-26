<template>
  <div>
    <el-button  type="text" class="button_login" @click="dialogFormVisible=true">登录</el-button>
        <el-dialog :visible.sync="dialogFormVisible" width="380px" center="false">
          <div class="el-dialog_header" >
            <span class="el-dialog_title">账号登录</span>
          </div>

          <div class="el-dialog__body">

            <!--登录表单区-->
            <el-form ref="loginFormRef" :model="loginForm" :rules="loginFormRules" >
              <el-form-item  prop="email">
                <el-input v-model="loginForm.email" placeholder="请输入邮箱" prefix-icon="el-icon-message"></el-input>
              </el-form-item>

              <el-form-item prop="password">
                <el-input v-model="loginForm.password" placeholder="请输入密码" prefix-icon="el-icon-lock" type="password"></el-input>
              </el-form-item>

              <el-form-item  prop="captcha">
                <el-row>
                  <el-image :src="captchaSrc" /><el-button type="text" @click="reloadCaptcha()">换一张</el-button>
                  <el-input v-model="loginForm.captcha"prefix-icon="el-icon-loading" placeholder="请输入验证码"></el-input>
                </el-row>

              </el-form-item>
            </el-form>

          </div>
          <div class="btns-wrap">
            <el-button type="primary" @click="login">登录</el-button>
            <el-button @click="register">注册</el-button>
          </div>
        </el-dialog>
  </div>
</template>

<script>
  import md5 from 'js-md5';
  import Cookies from "js-cookie";
  export default {
    name: "LoginDialog",

    data() {
      return {
        captchaSrc:'http://localhost:8001/api/captcha.jpg',
        dialogTableVisible: false,
        dialogFormVisible: false,
        loginForm: {
          email: '',
          password: '',
          captcha: '',
        },
        //表单验证规则对象
        loginFormRules: {
          //验证用户名是否合法
          email: [
            {required: true, message: '请输入账号', trigger: 'blur'},
            { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] },
          ],
          //验证密码是否合法
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'},
            {min: 6, max: 35, message: '长度在 6 到 35 个字符', trigger: 'blur'}
          ]
        },

        formLabelWidth: '120px'
      };
    },
    methods: {
      login() {
        /**
         *  /async的用法，它作为一个关键字放到函数前面，用于表示函数是一个异步函数
         *  因为async就是异步的意思，异步函数也就意味着该函数的执行不会阻塞后面代码的执行。
         *  参考博客[https://www.cnblogs.com/yuanyingke/p/10280681.html]
         */
        this.loginForm.password = md5(this.loginForm.password+ "{helloSalt}");
        this.$refs.loginFormRef.validate(async (valid) => { //valid为返回值，布尔类型
          if (!valid) return;
          const {data:res}  = await this.$http.post('/api/login',this.loginForm);
          console.log(res);
          if (res.code !== 200) return this.$message.error('登录失败, '+res.message);
          this.$message.success('登录成功');
          /** 1、将登陆成功之后的token, 保存到客户端的sessionStorage中; localStorage中是持久化的保存
           * 1.1 项目中出现了登录之外的其他API接口，必须在登陆之后才能访问
           * 1.2 token 只应在当前网站打开期间生效，所以将token保存在sessionStorage中
           */
          //window.sessionStorage.setItem("token", res.data.token);
          //window.sessionStorage.setItem("userId",res.data.userId);
          //window.sessionStorage.setItem("userName",res.data.userName);
          Cookies.set('token', res.data.token);// 放置token到Cookie
          // sessionStorage.setItem("token", res.data.token);
          sessionStorage.setItem("userId",res.data.userId);
          sessionStorage.setItem("userName",res.data.userName);
          // 2、通过编程式导航跳转到后台主页, 路由地址为：/
          this.dialogFormVisible = false;
          //await this.$router.push('/');
          this.$router.go(0);

        })

      },
      register(){
        this.$router.push({
          path: '/register',
        })
      },
      reloadCaptcha(){
        let num=Math.ceil(Math.random()*10);//生成一个随机数
        this.captchaSrc = 'http://localhost:8001/api/captcha.jpg?num='+num;
      }
    },

    created(){
    },

  }
</script>

<style scoped>
  .button_login{
    color: white;
    font-size: 20px;
  }

  .register-box {
    display: inline-block;
    width: 68px;
    height: 30px;
    border-radius: 18px;
    border: solid 1px #fff;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    line-height: 30px;
    text-align: center;
  }

  .el-dialog_header {
    padding: 0px 10px 10px;

    .el-dialog_title {
      line-height: 24px;
      font-size: 18px;
      color: #303133;
    }

    .login-tips {
      margin: 20px 0px 0px;
      color: #8492a6;
      font-size: 12px;
    }
  }

  .el-dialog__body {
    padding: 20px 20px;
    color: #606266;
    font-size: 14px;
    word-break: break-all;
  }

  .el-form {
    margin: 0 10px;
  }

  .el-form-item {
    margin-bottom: 22px;

    .el-form-item__content {
      width: 100%;

      .el-input {
        max-width: 500px;
      }
    }
  }

  .btns-wrap {
    background-color: transparent;
    margin: 0px 30% 0;
    padding-bottom: 30px;
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
  }
</style>
