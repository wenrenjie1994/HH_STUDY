<template>
    <div class="swiper-container filmswiper">
        <div class="swiper-wrapper">
            <slot></slot>
        </div>
        <!--分页器-->
        <div class="swiper-pagination film-pagination"></div>
        <!-- <div class="swiper-button-prev"></div>
        <div class="swiper-button-next"></div> -->
    </div>
</template>

<script>
import Swiper, { Navigation, Pagination } from 'swiper'
import 'swiper/swiper-bundle.css'
Swiper.use([Navigation, Pagination])
export default {
  data () {
    return {

    }
  },
  mounted () {
    /* eslint-disable no-new */
    new Swiper('.filmswiper', {
      loop: true,
      autoplay: {
        delay: 2000
      },
      pagination: {
        el: '.swiper-pagination'
      }
      // navigation: {
      //   nextEl: '.swiper-button-next',
      //   prevEl: '.swiper-button-prev'
      // }
    })
  }
}
</script>

<style lang="scss" scoped>
  .swiper-wrapper {
    img {
      width: 100%;
    }
  }
  .film-pagination {
    text-align: right;
    --swiper-theme-color: #ffffff;
  }
</style>
