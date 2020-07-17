<template>
  <aside class="aside-top-page">
    <div class="left">
      <span
        class="el-icon-menu toggleNavCollapse"
        :class="{active: isSidebarNavCollapse}"
        @click="toggleNavCollapse"
      ></span>
      <el-breadcrumb separator="/">
        <transition-group name="breadcrumb">
          <el-breadcrumb-item
            v-for="(route, i) in crumbList"
            :key="route.name"
            :to="{name: route.name}"
            v-show="route.name !== 'home'"
            :class="{'is-last-link': i === crumbList.length - 1}"
          >{{route.meta.name}}</el-breadcrumb-item>
        </transition-group>
      </el-breadcrumb>
    </div>
    <div class="right">
      <div class="quit-system" @click="loginOut" title="退出登录">
        <i class="iconfont el-icon-switch-button"></i>
      </div>
    </div>
  </aside>
</template>

<script>
import { mapState, mapMutations } from 'vuex'

export default {
  data () {
    return {}
  },
  computed: {
    ...mapState(['isSidebarNavCollapse', 'crumbList'])
  },
  methods: {
    ...mapMutations(['LOGIN_OUT']),
    toggleNavCollapse () {
      this.$store.commit('toggleNavCollapse')
    },
    loginOut () {
      this.LOGIN_OUT()
      this.$router.replace('/login')
    }
  }
}
</script>

<style lang="scss" scoped>
.aside-top-page {
  border-bottom: 1px solid #e5e5e5;
  height: 50px;
  position: fixed;
  // left: 200px;
  top: 0;
  width: 100%;
  // right: 0;
  background: #eff;
  z-index: 100;
  transition: left 0.25s;
  display: flex;
  justify-content: space-between;
  align-items: center;
  .toggleNavCollapse {
    display: inline-block;
    margin-left: 8px;
    padding: 0 10px;
    font-size: 26px;
    vertical-align: middle;
    color: #333;
    cursor: pointer;
    transition: all 0.5s;
    &.active {
      transform: rotate(90deg);
    }
  }
  .breadcrumb-enter,
  .breadcrumb-leave-active {
    opacity: 0;
    transform: translateX(20px);
  }

  .breadcrumb-enter-active,
  .breadcrumb-leave-active {
    transition: all 0.6s;
  }

  .breadcrumb-leave-active {
    position: absolute;
  }
  .right {
    position: absolute;
    right: 250px;
    bottom: 10px;
    i {
      font-size: 25px;
      cursor: pointer;
    }
  }
}
</style>
