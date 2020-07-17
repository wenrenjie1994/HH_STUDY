<template>
  <el-menu
    :collapse="isSidebarNavCollapse"
    background-color="#304156"
    text-color="#eee"
    active-text-color="#4dbcff"
    :default-active="currentMenu"
  >
    <Menu :menuList="sidebarMenu"></Menu>
  </el-menu>
</template>

<script type="text/javascript">

import { mapState } from 'vuex'
import Menu from './menu'

export default {
  name: 'sidebar-page',
  data () {
    return {
    }
  },
  computed: {
    ...mapState(['isSidebarNavCollapse']),
    ...mapState('permissions', ['sidebarMenu', 'currentMenu'])
  },
  components: {
    Menu
  }
}
</script>

<style lang="scss" scoped>
.sidebar-page {
}
</style>
