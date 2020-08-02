<template>
    <div>
      <v-touch v-on:swipeleft="onSwipeLeft" @swiperight='onSwipeRight'>
        <div style='background:pink;height:100px;'>center</div>
      </v-touch>
      <mt-button type='default'>default</mt-button>
      <mt-button type='primary'>primary</mt-button>
      <mt-button type='danger'>danger</mt-button>

      <mt-swipe :auto='4000' id='mint-swipe' :showIndicators='false'>
        <mt-swipe-item>1</mt-swipe-item>
        <mt-swipe-item>2</mt-swipe-item>
        <mt-swipe-item>3</mt-swipe-item>
        <mt-swipe-item>4</mt-swipe-item>
      </mt-swipe>
      </div>
</template>

<script>
import Vue from 'vue'
var VueTouch = require('vue-touch')
Vue.use(VueTouch, { name: 'v-touch' })
// const auth = {
//   isLogin () {
//     return false
//   }
// }

export default {
  data () {
    return {

    }
  },
  methods: {
    onSwipeLeft () {
      console.log('swipe left')
    },
    onSwipeRight () {
      console.log('swipe right')
    }
  },
  beforeRouteEnter (to, from, next) {
    // console.log('局部盘查')
    // if (auth.isLogin()) {
    //   next()
    // } else {
    //   next('/login')
    // }
    // 在渲染该组件的对应路由被 confirm 前调用
    // 不！能！获取组件实例 `this`
    // 因为当守卫执行前，组件实例还没被创建
    next()
  }
}
</script>

<style lang="scss" scoped>
  #mint-swipe {
    height: 200px;
    .mint-swipe-indicator.is-active {
      background: red;
    }
  }
</style>
