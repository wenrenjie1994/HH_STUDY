<template>
  <div v-if='filminfo'>
    detail--{{ $route.params.myid }}

    <img :src='filminfo.poster'/>
  </div>
</template>
<script>
import axios from 'axios'
export default {
  layout: 'detailtemplate',
  data() {
    return {
      filminfo: null
    }
  },
  asyncData(item) {
    console.log(item.params)
    return axios({
      url: `https://m.maizuo.com/gateway?filmId=${item.params.myid}&k=6980984`,
      headers: {
        'X-Client-Info': '{"a":"3000","ch":"1002","v":"5.0.4","e":"1596106934239723599626241","bc":"310100"}',
        'X-Host': 'mall.film-ticket.film.info'
      }
    }).then((result) => {
      return {
        filminfo: result.data.data.film
      }
    }).catch((err) => {
      console.log(err)
    });
  }
}
</script>
<style lang="scss" scoped>

</style>
