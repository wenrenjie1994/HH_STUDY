<template>
  <div>
    <!-- <input type='text' ref='mydata'/>
    <button @click='handleAdd()'>add</button>
    <ul>
      <li v-for='item in dataList' :key='item'>
        {{ item }}
      </li>
    </ul>

    <navbar>
      <button @click='isShow=!isShow'>点我</button>
    </navbar>
    <sidebar v-show='isShow'></sidebar> -->

    <!-- <tabbar v-show='isShow'></tabbar> -->
    <!-- <tabbar v-show='$store.state.isTabbarShow'></tabbar> -->
    <!-- <tabbar v-show='isShow'></tabbar> -->
    <tabbar v-show='isTabbarShow'></tabbar>
    <!--路由容器-->
    <section>
      <router-view></router-view>
    </section>
  </div>
</template>

<script>
// import navbar from './components/navbar'
// import sidebar from './components/sidebar'
// import axios from 'axios'
import tabbar from '@/components/tabbar'
import { mapState } from 'vuex' // ES6导出
// import bus from '@/bus'
/**
 * 全局组件
 */
// import Vue from 'vue'
// Vue.component('navbar', navbar)
// Vue.component('sidebar', sidebar)
// commonJs module.exports
// ES6 导出
export default {
  data () {
    return {
      // dataList: [],
      // isShow: false
      // isShow: true
    }
  },
  methods: {
    // handleAdd () {
    //   console.log('add', this.$refs.mydata.value)
    //   this.dataList.push(this.$refs.mydata.value)
    // }
  },

  components: {
    // navbar: navbar,
    // sidebar: sidebar,
    tabbar
  },
  // 计算属性
  // computed: {
  //   isShow () {
  //     return this.$store.state.isTabbarShow
  //   }
  // },
  // computed: mapState(['isTabbarShow']),
  computed: {
    ...mapState(['isTabbarShow']) // Es6中展开合并运算符
  },
  // beforeMount () {
  //   console.log('从这里开始订阅消息了')
  //   bus.$on('maizuo', (item) => {
  //     // console.log('被通知了maizuo', item)
  //     this.isShow = item
  //   })
  // },
  mounted () {
    // axios.get('/ajax/movieOnInfoList?token=').then((result) => {
    //   console.log(result.data)
    // }).catch((err) => {
    //   console.log(err)
    // })
  }
}

</script>

<style lang="scss">
  * {
    margin: 0;
    padding: 0;
  }
  html {
    height: 100%
  }

  li {
    list-style: none;
  }
  // ul {
  //   list-style: none;
  //   li {
  //     background: pink;
  //   }
  // }
</style>
