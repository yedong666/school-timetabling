<template>
  <div class="formContainer">
    <div class="headImg">
      <img src="../assets/avater.png">
    </div>
    <div class="dataCon">
      <el-form label-position="left" ref="form" :model="user" class="loginForm" :rules="rules">
        <h2 style="margin-top: 0px; color: white">欢迎访问HFUT601排课系统</h2>
        <el-form-item prop="account">
          <el-input type="text" auto-complete="false" placeholder="账号" v-model="user.account"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input type="password" auto-complete="false" placeholder="密码" v-model="user.password"></el-input>
        </el-form-item>
        <el-tooltip class="item" effect="dark" content="登录后才能获得完整权限" placement="top">
          <el-button @click="login('form')">学生登录</el-button>
        </el-tooltip>
        <el-tooltip class="item" effect="dark" content="点击注册账号" placement="top">
          <el-button @click="reginster">教师登录</el-button>
        </el-tooltip>
        <el-tooltip class="item" effect="dark" content="游客模式下不可以评论和留言哦" placement="top">
          <el-button @click="test">管理员登录</el-button>
        </el-tooltip>
      </el-form>
    </div>


  </div>
</template>

<script>

export default {
  name: 'Login',
  data() {
    return {
      user: {
        account: '',
        password: '',
        code: '',
      },
      rules: {
        account: [
          { required: true, message: '请输入账号', trigger: 'blur' },
          {
            min: 6,
            max: 12,
            message: '长度在 6 到 12 个字符',
            trigger: 'blur',
          },
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'change' },
          { min: 4, max: 8, message: '长度在 4 到 8 个字符', trigger: 'blur' },
        ],
        code: [{ required: true, message: '请输入验证码', trigger: 'change' }],
      },
      codeImgUrl: 'https://img0.baidu.com/it/u=3060508493,2267137751&fm=253&fmt=auto&app=138&f=JPEG?w=400&h=213',
    }
  },
  methods: {
    login(formName) {
      // let that = this
      // let userData = this.user
      let validateFlag = false
      this.$refs[formName].validate((valid) => {
        if (valid) {
           validateFlag = true
        }
      })
      if(validateFlag){
        //表单校验成功
        this.$router.push({
          path: '/manage',
        })
        //发送登录请求

        //跳转到主页
      }
      return false;

    },
  },
}
</script>

<style scoped>
.formContainer {
  display: flex;
  flex-direction: column;
  width: 500px;
  height: 500px;
  margin: 30px auto;
  border: 2px solid #b3d8ff;
  background-image: linear-gradient(141deg,white 0%,#1fc8db 51%,wheat 75%);
  box-shadow: 0 0 10px gray;
  border-radius: 15px;


}

@media screen and (max-width:780px) {
  .formContainer{
    background-image: linear-gradient(141deg,#9fb8ad 0%,#1fc8db 51%,#2cb5e8 75%);
    color: wheat;
  }
}

.formContainer el-input {
  background: linear-gradient(to right, #facabb);
}

.formContainer el-button {
  background: linear-gradient(to right, #facabb);
}

.formContainer .headImg{
  width: 100%;
  margin-top: 30px;
}

.formContainer .headImg img{
  width: 100px;
  height: 100px;
  border-radius: 50%;
}

.dataCon{

  /*background: white;*/
  background-clip: padding-box;
  margin:0px auto;
  width: 350px;
  height: 350px;
  padding: 15px 35px 15px 35px;
}

.apps{
  margin-top: 20px;
  display: flex;
  justify-content: space-around;
}

.apps .thirdPartyApp{
  width: 50px;
  height: 50px;
}

.apps .thirdPartyApp img{
  width: 100%;
  height: 100%;
}

</style>
