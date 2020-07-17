<template>
  <!--中间主要的界面-->
  <transition>
    <router-view class="content"></router-view>
  </transition>
</template>

<script>
export default {
  data () {
    return {}
  }
}
</script>

<style lang="scss" scoped>
.v-enter,
.v-leave-to {
  opacity: 0;
  transform: translateX(300px);
}
.v-enter-active {
  transition: all 1s ease;
}
</style>
