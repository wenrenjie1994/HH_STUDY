<template>
    <div>
        nowplaying
        <ul v-infinite-scroll="loadMore"
        infinite-scroll-distance="0"
        infinite-scroll-disable="loading"
        infinite-scroll-immediate-check="false">
            <li v-for='item in dataList' :key='item.filmId' @click='handleChangePage(item.filmId)'>
                <img :src="item.poster"/>
                <h3>{{ item.name }}</h3>
                <p v-if='item.grade'>观众评分：{{ item.grade }}</p>
                <p v-else>暂无评分</p>

                <p v-if='item.actors'>主演：{{ item.actors | actorfilter }}</p>
                <p v-else>暂无主演</p>

                <p>{{ item.nation }} | {{ item.runtime }}分钟</p>
            </li>
        </ul>
        <div v-show='isShow'>正在加载中......</div>
    </div>
</template>

<script>
import axios from 'axios'
import Vue from 'vue'
Vue.filter('actorfilter', function (item) {
  // var list = ['1', '2', '3']
  // console.log(list.map(list => `java${list}`))
  if (item !== null && item !== undefined) {
    var newlist = item.map(data => data.name)
    // console.log(newlist)
    return newlist.join(' ')
  }
})

export default {
  data () {
    return {
      dataList: [],
      loading: false,
      current: 1,
      total: 0,
      isShow: true
    }
  },
  mounted () {
    // axios.get('https://m.maizuo.com/gateway?cityId=110100&pageNum=1&pageSize=10&type=1&k=2197307').then((result) => {
    //   console.log(result.data)
    // }).catch((err) => {
    //     console.log(err)
    // });
    // $.ajax $.get

    axios({
      url: 'https://m.maizuo.com/gateway?cityId=440100&pageNum=1&pageSize=10&type=1&k=5320617',
      headers: {
        'X-Client-Info': '{"a":"3000","ch":"1002","v":"5.0.4","e":"1596106934239723599626241","bc":"440100"}',
        'X-Host': 'mall.film-ticket.film.list'
      }
    }).then((result) => {
      console.log(result.data)
      this.dataList = result.data.data.films
      this.total = result.data.data.total
    }).catch((err) => {
      console.log(err)
    })
  },
  methods: {
    handleChangePage (id) {
      console.log(id)
      // 编程式导航 - 路径跳转
      //   this.$router.push(`/detail/${id}`)

      // 编程式导航-名字跳转
      this.$router.push({ name: 'komidetail', params: { id: id } })
    },
    loadMore () {
      console.log('到底啦!!!')
      this.loading = true // 禁用

      this.current++

      if (this.dataList.length === this.total) {
        this.isShow = false
        return
      }
      axios({
        url: `https://m.maizuo.com/gateway?cityId=440100&pageNum=${this.current}&pageSize=10&type=1&k=5320617`,
        headers: {
          'X-Client-Info': '{"a":"3000","ch":"1002","v":"5.0.4","e":"1596106934239723599626241","bc":"440100"}',
          'X-Host': 'mall.film-ticket.film.list'
        }
      }).then((result) => {
      // console.log(result.data)
        this.dataList = [...this.dataList, ...result.data.data.films]
        this.loading = false
      }).catch((err) => {
        console.log(err)
      })
    }
  }
}
</script>

<style lang="scss" scoped>
  ul {
    li {
      padding: 10px;
      overflow: hidden;
      img {
        float: left;
        width:100px;
      }
    }
  }
</style>
