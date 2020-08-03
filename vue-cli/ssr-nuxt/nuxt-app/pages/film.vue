<template>
  <div>
    <el-carousel indicator-position="outside">
        <el-carousel-item v-for="item in looplist" :key="item.id">
            <img :src='item.main_image'/>
        </el-carousel-item>
    </el-carousel>
    <ul>
      <nuxt-link to='/film/nowplaying' tag='li' activeClass='active'>正在热映</nuxt-link>
      <nuxt-link to='/film/comingsoon' tag='li' activeClass='active'>即将上映</nuxt-link>
    </ul>
    <nuxt-child></nuxt-child>
  </div>
</template>
<script>
import axios from 'axios'
export default {
  asyncData() {
    return axios({
      url: 'http://www.mei.com/appapi/home/mktBannerApp/v3?silo_id=',
    }).then((result) => {
      return {
        looplist: result.data.banners
      }
    }).catch((err) => {
      console.log(err)
    });
  }
}
</script>
<style lang="scss" scoped>
  img {
    width: 100%;
  }
</style>
