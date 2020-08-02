<template>
    <div>
        <ul>
            <li v-for='item in $store.state.comingList' :key='item.filmId' @click='handleClick(item.isPresale, item.filmId)'>
              <!-- <li v-for='item in $store.getters.comingListFilter' :key='item.filmId'> -->
                <img :src="item.poster"/>
                <h3>{{ item.name }}</h3>
                <p v-if='item.grade'>观众评分：{{ item.grade }}</p>
                <p v-else>暂无评分</p>

                <p v-if='item.actors'>主演：{{ item.actors | actorfilter }}</p>
                <p v-else>暂无主演</p>

                <p>{{ item.nation }} | {{ item.runtime }}分钟</p>
            </li>
        </ul>
    </div>
</template>

<script>
import { mapState } from 'vuex'
import { MessageBox } from 'mint-ui'

export default {
  mounted () {
    if (this.$store.state.comingList.length === 0) {
      // ajax请求
      this.$store.dispatch('getComingListAction')
    } else {
      console.log('使用缓存数据')
    }
  },
  computed: {
    ...mapState(['comingList'])
  },
  methods: {
    handleClick (item, id) {
      if (!item) {
        MessageBox({
          title: '提示',
          message: '该影片还未排期，先看下其他电影哦!',
          showCancelButton: true
        }).then((result) => {
          if (result === 'confirm') {
            // console.log('回到首页')
            this.$router.push('/film/nowplaying')
          }
        }).catch((err) => {
          console.log(err)
        })
      }
      this.$router.push({ name: 'komidetail', params: { id: id } })
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
