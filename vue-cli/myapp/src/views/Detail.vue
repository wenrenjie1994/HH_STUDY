<template>
    <div v-if='filminfo'>
        <img :src='filminfo.poster' class='poster'/>
        <h2>{{ filminfo.name }}</h2>

        <h3>演职人员</h3>
        <swiper preview='4' class='actorswiper' myclassname='actorswiper'>
          <div class='swiper-slide' v-for='item in filminfo.actors' :key='item.name'>
            <img :src='item.avatarAddress'/>
            <p>{{ item.name }}</p>
          </div>
        </swiper>

         <h3>剧照</h3>
         <swiper preview='3' class='photoswiper' myclassname='photoswiper'>
           <div class='swiper-slide' v-for='(item,index) in filminfo.photos' :key='index'>
            <img :src='item'/>
          </div>
         </swiper>
    </div>
</template>

<script>
import axios from 'axios'
import swiper from '@/views/Detail/DetailSwiper'
import { HIDE_TABBAR_MUTATION, SHOW_TABBAR_MUTATION } from '@/type'
// import bus from '@/bus'
export default {
  props: ['id'],
  data () {
    return {
      filminfo: null
    }
  },
  components: {
    swiper
  },
  // beforeMount () {
  //   console.log('hide tabbar', '发文章了')
  //   bus.$emit('maizuo', false)
  // },
  beforeMount () {
    console.log('hide tabbar', '发糖了')
    // this.$store.state.isTabbarShow = false

    // this.$store.commit('hideMaizuoTabbar', false) // 第一个参数就是mutation的名字
    this.$store.commit(HIDE_TABBAR_MUTATION, false)
  },
  mounted () {
    console.log('根据id获取详情信息', this.$route.params.id, this.id)
    axios({
      url: `https://m.maizuo.com/gateway?filmId=${this.id}&k=9309253`,
      headers: {
        'X-Client-Info': '{"a":"3000","ch":"1002","v":"5.0.4","e":"1596106934239723599626241","bc":"440100"}',
        'X-Host': 'mall.film-ticket.film.info'
      }
    }).then((result) => {
      console.log(result.data.data.film)
      this.filminfo = result.data.data.film
    }).catch((err) => {
      console.log(err)
    })
  },
  beforeDestroy () {
    console.log('show tabbar')
    // bus.$emit('maizuo', true)
    // this.$store.state.isTabbarShow = true
    // this.$store.commit('showMaizuoTabbar', true)
    this.$store.commit(SHOW_TABBAR_MUTATION, true)
  }
}
</script>

<style lang="scss" scoped>
  .poster {
    width: 100%;
  }
</style>
