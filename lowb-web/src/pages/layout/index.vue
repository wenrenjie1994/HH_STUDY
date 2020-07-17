<template>
  <div class="layout-page" :class="{navCollapsed:isSidebarNavCollapse}">
    <sidebar class="sidebar"></sidebar>
    <main-content></main-content>
  </div>
</template>

<script type="text/javascript">

import { mapState } from 'vuex'
import sidebar from './components/sidebar'
import mainContent from './components/main-content'

export default {
  name: 'layout-page',
  data () {
    return {

    }
  },
  components: {
    sidebar,
    mainContent
  },
  computed: {
    ...mapState(['isSidebarNavCollapse'])
  }
}
</script>

<style lang="scss" scoped>
.layout-page {
  height: 100%;
}
</style>
