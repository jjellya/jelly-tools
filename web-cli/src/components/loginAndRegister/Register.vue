<template>
  <div>

    <TopBar  title="某某市某某镇人民镇府"
             title_en="People's  Government of xxxxx City xxxxx Town"
             city_town="某某市某某镇"
             active-index="1"></TopBar>
    <div class="myElStep">
      <el-steps :active="active" finish-status="success" simple style="margin-top: 20px;margin-left: 20%;" >
        <el-step title="填写信息" >
        </el-step>
        <el-step title="完成注册" ></el-step>
      </el-steps>

      <el-form v-show="active == 0" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm registerForm">
        <el-form-item prop="email" label="邮箱">
          <el-input v-model="ruleForm.email" placeholder="请输入邮箱地址"></el-input>
        </el-form-item>

        <el-form-item prop="userName" label="用户名">
          <el-input v-model="ruleForm.userName" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item prop="password" label="密码">
          <el-input type="password" v-model="ruleForm.password" placeholder="请输入密码"></el-input>
        </el-form-item>
        <el-form-item prop="passwordAgain" label="确认密码">
          <el-input type="password" v-model="ruleForm.passwordAgain" placeholder="请确认密码"></el-input>
        </el-form-item>

        <el-form-item style="margin-top: 10%;margin-right: 15%">
          <el-button type="primary" @click="submitForm()">下一步</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>

      <div v-show="active == 2" style="margin-left: 25%;margin-top: 10%">
        <el-button type="success" icon="el-icon-check" circle></el-button> <h1>账号注册成功！</h1>
          <div style="margin-top: 200px"></div>
      </div>

      <div v-show="active == 1" style="margin-left: 25%;margin-top: 10%">
        <el-button type="danger" icon="el-icon-error" circle></el-button> <h1>账号注册失败</h1>
        <div style="margin-top: 200px"></div>
      </div>

    </div>
    <BottomBar official="某某省某某市某某镇人民政府办公厅"></BottomBar>
  </div>
</template>

<script>


    import TopBar from "../TopBar";
    import BottomBar from "../BottomBar";
    import LoginDialog from "./LoginDialog";



    export default {
        name: "Register",
        components: {LoginDialog, BottomBar, TopBar,},
        props:[],
        data() {
          //检查邮箱是否已被注册
          const isExist = (rule, value, callback) => {
            if(!value) {
              return callback(new Error('邮箱不能为空'));
            }
            setTimeout(() => {
              let email = {email:value};
              const res = this.$api.login.checkEmail(email);
              res.then(result =>{
                if(result.code !== 200) {
                    callback(new Error('连接服务端失败'));
                }
              });
            }, 1000);
          };

          //确认密码是否一致
          const confirmPwd = (rule, value, callback) => {
            if (this.ruleForm.password !== value) {
              callback(new Error('确认密码与新密码不一致！'))
            } else {
              callback()
            }
          };

          return {
            active: 0,

            fullscreenLoading: false,

            //表单区域
            ruleForm: {
              email: 'jj1426280370@163.com',
              userName: 'user1',
              password: '123456',
              passwordAgain:'123456',
            },
            rules: {
              email: [
                { required: true, message: '请输入邮箱地址', trigger: 'blur' },
                { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] },
                { validator: isExist, message: '该邮箱已被注册', trigger: 'blur'},//检查邮箱是否已被注册
              ],
              userName: [
                { required: true, message: '请输入用户名', trigger: 'blur' },
                {min: 1, max: 15, message: '长度在 1 到 15 个字符', trigger: ['blur','change']}
              ],

              password: [
                { required: true, message: '请输入密码', trigger: 'blur' },
                {min: 6, max: 15, message: '长度在 6 到 15 个字符', trigger: ['blur','change']}
              ],
              passwordAgain: [
                { required: true, message: '请确认密码', trigger: 'blur' },
                { validator: confirmPwd, message: '密码不一致', trigger: ['blur']},//确认密码是否一致
              ],
            }
          };
        },
      methods: {

          //表单区域
          next(formName) {

            this.active ++;
            console.log(this.active);
            if (this.active > 2) this.active = 0;

          },

          submitForm(){
              // const res2  =this.$http.post('/api/register',this.ruleForm);
            // let userInfo ={
            //   email: this.ruleForm.email,
            //   userName: this.ruleForm.userName,
            //   password: this.ruleForm.password,
            //   passwordAgain: this.ruleForm.passwordAgain,
            // };
            const res2  = this.$api.login.register(this.ruleForm);
              res2.then(result2 =>{
                if(result2.code!== 200) {
                  this.active--;
                  return this.$message.error('注册失败');
                }else {
                  this.$router.push('/');
                  return this.$message.success('注册成功');


                }
              });
              this.active = this.active+2;
            console.log('active='+this.active);
            if (this.active > 2) this.active = 0;
          },

          resetForm(formName) {
            this.$refs[formName].resetFields();
          },

        }
    }
</script>

<style scoped>
.leftLine{
  position: absolute;
  left: 0%;
  right: 0%;
  top: 100%;
  bottom: -100%;

  background: #FF5A5F;
  border: 1px solid #E3E3E3;
  box-sizing: border-box;
  border-radius: 4px;
  transform: matrix(1, 0, 0, -1, 0, 0);
}

.myElStep{
    width: 80%;
}

.registerForm{
  margin-top: 20px;
  margin-left: 20%;
  padding: 0 10%;
}


</style>
