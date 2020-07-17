<template>
  <div class="oa_main">
    <el-row class="oa_main_card">
      <el-col :span="24">
        <el-card style="background:#409EFF;">
          <div class="date_l">
            <el-row>
              <el-col :span="12" class="tl">
                <p>{{dateList.date}}</p>
                <p>{{dateList.weekday}}</p>
              </el-col>
              <el-col :span="12" class="tr">{{dateList.time}}</el-col>
            </el-row>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>
<script>
export default {
  name: 'Main',
  mounted () {
    this.showTime()
  },
  created () {},
  data () {
    return {
      dateList: {
        date: '',
        weekday: '',
        time: ''
      }
    }
  },
  methods: {
    showTime () {
      let showDay = [
        '星期日',
        '星期一',
        '星期二',
        '星期三',
        '星期四',
        '星期五',
        '星期六'
      ]
      let time = new Date()
      let year = time.getFullYear()
      let month = time.getMonth() + 1
      let date = time.getDate()
      let day = time.getDay()
      let hour = time.getHours()
      let minutes = time.getMinutes()
      let second = time.getSeconds()
      month = month < 10 ? ('0' + month) : month
      hour = hour < 10 ? ('0' + hour) : hour
      minutes = minutes < 10 ? ('0' + minutes) : minutes
      second = second < 10 ? ('0' + second) : second
      this.dateList.date = year + '年' + month + '月' + date + '日'
      this.dateList.weekday = showDay[day]
      this.dateList.time = hour + ':' + minutes + ':' + second
      setTimeout(this.showTime, 1000)
    },
    handleGoUrl (url) {
      this.$router.push({ path: url })
    }
  }
}
</script>
<style lang="scss" scoped>
.oa_main_card {
  .el-card {
    margin: 6px;
  }
  .todo_l {
    line-height: 75px;
    color: #fff;
    .tl {
      font-size: 25px;
      font-weight: 500;
      text-align: center;
    }
    .tr {
      .el-button--text {
        font-size: 60px;
        font-weight: 500;
        color: #fff;
        padding: 0;
        line-height: 75px;
      }
      .el-button--text:hover {
        font-size: 62px;
        transition: 0.5;
        text-shadow: 2px 2px 1px #666;
      }
    }
  }
  .date_l {
    color: #fff;
    .tl {
      font-size: 22px;
      font-weight: bold;
    }
    .tr {
      line-height: 75px;
      font-size: 35px;
      text-align: center;
    }
  }
}
.oa_doc {
  margin: 25px 0px;
  .el-card {
    margin: 0 6px;
    .title {
      font-size: 25px;
      font-weight: bold;
      color: #409eff;
      background-color: white;
    }
    .el-icon-more-outline:hover {
      cursor: pointer;
      color: #409eff;
    }
    .el-icon-search {
      font-weight: bold;
    }
  }
}
</style>
