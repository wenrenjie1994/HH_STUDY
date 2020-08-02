<template>
    <div class='cinema' :style='mystyle'>
        <ul>
            <li v-for='data in datalist' :key='data.cinemaId'>
                {{ data.name }}
                <p style='font-size:12px'>{{ data.address }}</p>
            </li>
        </ul>
    </div>
</template>

<script>
import axios from 'axios'
import BetterScroll from 'better-scroll'
export default {
  data () {
    return {
      datalist: [],
      // 动态设置内联样式
      mystyle: {
        height: '0px'
      }
    }
  },
  mounted () {
    console.log(document.documentElement.clientHeight)
    console.log(window.innerHeight)
    this.mystyle.height = document.documentElement.clientHeight - 50 + 'px'
    var id = localStorage.getItem('cityId')
    axios({
      url: `https://m.maizuo.com/gateway?cityId=${id}&ticketFlag=1&k=404521`,
      headers: {
        'X-Client-Info': '{"a":"3000","ch":"1002","v":"5.0.4","e":"1596106934239723599626241"}',
        'X-Host': 'mall.film-ticket.cinema.list'
      }
    }).then((result) => {
      console.log(result.data)
      this.datalist = result.data.data.cinemas

      // 待上述节点插入到dom节点中结束了，调用此回调函数
      this.$nextTick(() => {
        /* eslint-disable no-new */
        new BetterScroll('.cinema', {
          scrollbar: {
            fade: true,
            interactive: false
          }
        })
      })
    }).catch((err) => {
      console.log(err)
    })
  }
}
</script>

<style lang="scss" scoped>
    li {
        height: 50px;
    }

    .cinema {
        height: 500px;
        overflow: hidden;
        position: relative;
    }
</style>
