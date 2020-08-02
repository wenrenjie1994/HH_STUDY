<template>
    <div>
        <swiper :key="looplist.length" ref='myswiper'>
            <div class="swiper-slide" v-for='item in looplist' :key='item.id'>
              <img :src='item.main_image'/>
            </div>
        </swiper>
        <filmheader :class="isFixed?'fixed':''"></filmheader>
        <router-view></router-view>
    </div>
</template>

<script>
import swiper from '@/views/Film/Swiper'
import axios from 'axios'
import filmheader from '@/views/Film/FilmHeader'
import { Indicator } from 'mint-ui'
export default {
  data () {
    return {
      looplist: [],
      isFixed: false
    }
  },
  components: {
    swiper,
    filmheader
  },
  mounted () {
    // axios({
    //   url: 'https://m.maizuo.com/gateway?type=2&cityId=110100&k=5553387',
    //   headers: {
    //     'X-Client-Info': '{"a":"3000","ch":"1002","v":"5.0.4","e":"15610855429195524981146"}',
    //     'X-Host': 'mall.cfg.common-banner'
    //   }
    // }).then(res => {
    //   console.log(res.data)
    // })

    // axios.get('img').then((result) => {
    //   console.log(result.data)
    //   this.looplist = result.data
    // }).catch((err) => {
    //   console.log(err)
    // })

    Indicator.open({
      text: '数据加载中...',
      spinnerType: 'fading-cicle'
    })

    axios.get('http://www.mei.com/appapi/home/mktBannerApp/v3?silo_id=').then((result) => {
      console.log(result.data)
      this.looplist = result.data.banners
      Indicator.close()
    }).catch((err) => {
      console.log(err)
    })

    // axios.get('/ajax/movieOnInfoList?token=').then((result) => {
    //   console.log(result.data)
    //   this.looplist = result.data.movieList
    // }).catch((err) => {
    //   console.log(err)
    // })

    window.onscroll = this.handleScroll
  },
  beforeDestroy () {
    console.log('beforeDestroy')
    window.onscroll = null
  },
  methods: {
    handleScroll () {
      // console.log(document.documentElement.scrollTop, this.$refs.myswiper.$el.offsetHeight)
      if (document.documentElement.scrollTop >= this.$refs.myswiper.$el.offsetHeight) {
        // console.log('fixed')
        this.isFixed = true
      } else {
        // console.log('unfixed')
        this.isFixed = false
      }
    }
  }
}
</script>
