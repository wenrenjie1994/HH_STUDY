<template>
    <div class="swiper-container filmswiper">
        <div class="swiper-wrapper">
            <slot></slot>
        </div>
        <!--分页器-->
        <div class="swiper-pagination film-pagination"></div>
    </div>
</template>

<script>
import Swiper from 'swiper'
import 'swiper/swiper-bundle.css'
export default {
  props: ['preview', 'myclassname'],
  data () {
    return {

    }
  },
  mounted () {
    console.log(this.myclassname)
    /* eslint-disable no-new */
    new Swiper('.' + this.myclassname, {
      slidesPerView: this.preview,
      spaceBetween: this.myclassname === 'actorswiper' ? 20 : 10,
      freeMode: true
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
</style>
