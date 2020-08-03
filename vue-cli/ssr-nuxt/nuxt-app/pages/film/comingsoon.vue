<template>
    <div>
        comingsoon
        <ul>
            <li v-for='item in datalist' :key='item.id'>
                <p>{{ item.nm }}</p>
            </li>
        </ul>
    </div>
</template>
<script>
import axios from 'axios'
export default {
    asyncData(item) {
        console.log(process.server) // 标识此方法是否在服务端运行(true:服务端 false：其他)
        return axios({
            url:process.server?'http://m.maoyan.com/ajax/movieOnInfoList?token=':'/ajax/movieOnInfoList?token='
        }).then((result) => {
            console.log(result.data)
            return {
                datalist: result.data.movieList
            } //状态
        }).catch((err) => {
            console.log(err)
        });
    }
}
</script>
<style lang="scss" scoped>

</style>