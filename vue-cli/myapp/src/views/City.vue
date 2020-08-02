<template>
    <div>
        city
        <mt-index-list ref='mylist'>
            <mt-index-section :index='data.index' v-for='data in datalist' :key='data.index'>
                <div @click='handleClick(city.cityId)' v-for='city in data.list' :key='city.cityId'>
                    <mt-cell :title='city.name'></mt-cell>
                </div>
            </mt-index-section>
        </mt-index-list>
    </div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      datalist: []
    }
  },
  mounted () {
    console.log(this.$refs.mylist.$el)
    this.$refs.mylist.$el.style.height = window.innerHeight - 50 + 'px'

    axios({
      url: 'https://m.maizuo.com/gateway?k=5786758',
      headers: {
        'X-Client-Info': '{"a":"3000","ch":"1002","v":"5.0.4","e":"1596106934239723599626241","bc":"110100"}',
        'X-Host': 'mall.film-ticket.city.list'
      }
    }).then((result) => {
      console.log(result.data)
      this.datalist = this.handleCity(result.data.data.cities)
    }).catch((err) => {
      console.log(err)
    })
  },
  methods: {
    handleCity (datalist) {
      var letterArr = []
      for (var i = 65; i < 91; i++) {
        letterArr.push(String.fromCharCode(i))
      }

      console.log(letterArr)

      var newlist = []
      for (var j = 0; j < letterArr.length; j++) {
        var arr = datalist.filter(item => item.pinyin.substring(0, 1) === letterArr[j].toLowerCase())
        if (arr.length > 0) {
          newlist.push({
            index: letterArr[j],
            list: arr
          })
        }
      }
      console.log(newlist)
      return newlist
    },
    handleClick (id) {
      console.log(id)
      localStorage.setItem('cityId', id)
      this.$router.push('/cinema')
    }
  }
}
</script>

<style lang="scss" scoped>
    * {
        touch-action: pan-y;
    }
</style>
