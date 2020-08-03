<template>
    <div>
        nowplaying
        <ul>
            <li v-for='item in datalist' :key='item.filmId' @click="handleClick(item.filmId)">
                <img :src='item.poster'/>
                <p>{{ item.name }}</p>
            </li>
        </ul>
    </div>
</template>
<script>
import axios from 'axios'
export default {
    data() {
        return {
            datalist: ['111','222','333']
        }
    },
    asyncData(item) {
        console.log(item)
        return axios({
            url: 'https://m.maizuo.com/gateway?cityId=500100&pageNum=1&pageSize=10&type=1&k=2104086',
            headers: {
                'X-Client-Info': '{"a":"3000","ch":"1002","v":"5.0.4","e":"1596106934239723599626241","bc":"500100"}',
                'X-Host': 'mall.film-ticket.film.list'
            }
        }).then((result) => {
            console.log(result.data)
            return {
                datalist: result.data.data.films
            }
        }).catch((err) => {
            console.log(err)
        });
    },
    methods: {
        handleClick(id) {
            this.$router.push(`/detail/${id}`)
        }
    }
}
</script>
<style lang="scss" scoped>

</style>
