<template>
  <div class="login-page">
    <h1 class="title">low b</h1>
    <div class="inreoduce">low b hr sys</div>
    <div class="main-form">
      <el-form :model="ruleForm" status-icon :rules="rule" ref="ruleForm" class="login-form">
        <!-- 账号 -->
        <el-form-item prop="username">
          <el-input
            ref="username"
            v-model="ruleForm.username"
            autocomplete="on"
            placeholder="请输入账号"
          ></el-input>
        </el-form-item>
        <!-- 密码 -->
        <el-form-item prop="password">
          <el-input
            ref="password"
            :type="passwordType"
            v-model="ruleForm.password"
            auto-complete="on"
            placeholder="请输入密码"
            show-password
            @keyup.enter="handleLogin"
          ></el-input>
        </el-form-item>
        <!-- 提交 重置 -->
        <el-form-item>
          <el-button type="primary" @click="handleLogin()">登录</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>
<script>

import { mapMutations, mapActions } from 'vuex'

export default {
  name: 'login-page',
  created () {
  },
  data () {
    return {
      ruleForm: {
        username: '',
        password: ''
      },
      passwordType: 'password',
      rule: {
        username: [
          { required: true, trigger: 'blur' }
        ],
        password: [
          { required: true, trigger: 'blur' }
        ]
      }
    }
  },
  mounted () {
    this.getUserList()
  },
  methods: {
    ...mapMutations(['LOGIN_IN']),
    ...mapActions('login', ['login']),
    ...mapActions('hr', ['getUserList']),
    handleLogin () {
      this.loading = true
      this.$refs.ruleForm.validate(async valid => {
        if (valid) {
          let result = await this.login({
            username: this.ruleForm.username,
            password: this.ruleForm.password
          })
          console.log(result)
          setTimeout(() => {
            this.loading = false
          }, 1000)
          if (result) {
            this.LOGIN_IN(this.ruleForm.username)
            this.$router.replace('/home')
          }
        } else {
          console.error('error submit!!')
          setTimeout(() => {
            this.loading = false
          }, 1000)
          this.$message({
            showClose: true,
            message: '登录失败!!!',
            type: 'error'
          })
          return false
        }
      })
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    }
  }
}
</script>
<style lang="scss" scoped>
.login-page {
  margin: 200px;
  .title {
    font-size: 30px;
    text-align: center;
    font-weight: bold;
    margin-bottom: 20px;
  }
  .inreoduce {
    text-align: center;
    color: gray;
    margin-bottom: 60px;
  }
  .main-form {
    padding: 10px 100px;
    text-align: center;
    .login-form {
      width: 320px;
      margin: auto;
    }
  }
}
</style>
