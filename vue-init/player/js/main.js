/*
  1:歌曲搜索接口
    请求地址:https://autumnfish.cn/search
    请求方法:get
    请求参数:keywords(查询关键字)
    响应内容:歌曲搜索结果

  2:歌曲url获取接口
    请求地址:https://autumnfish.cn/song/url
    请求方法:get
    请求参数:id(歌曲id)
    响应内容:歌曲url地址
  3.歌曲详情获取
    请求地址:https://autumnfish.cn/song/detail
    请求方法:get
    请求参数:ids(歌曲id)
    响应内容:歌曲详情(包括封面信息)
  4.热门评论获取
    请求地址:https://autumnfish.cn/comment/hot?type=0
    请求方法:get
    请求参数:id(歌曲id,地址中的type固定为0)
    响应内容:歌曲的热门评论
  5.mv地址获取
    请求地址:https://autumnfish.cn/mv/url
    请求方法:get
    请求参数:id(mvid,为0表示没有mv)
    响应内容:mv的地址
*/
var app = new Vue({
  el: "#player",
  data: {
    query: "",
    //歌曲列表
    musicList: [],
    //歌曲url
    musicUrl:"",
    //封面
    musicCover:"",
    //歌曲评论
    hotComments:[],
    //动画播放状态
    isPlaying: false,
    //遮罩层的显示状态
    isShow:false,
    //mv地址
    mvUrl:""
  },
  methods: {
    //搜索歌曲
    searchMusic: function(){
      var that = this
      axios.get("https://autumnfish.cn/search?keywords="+this.query)
      .then(function (response){
          console.log(response)
          that.musicList = response.data.result.songs
          console.log(response.data.result.songs)
      },function (err) {
          console.log(err)
      });
    },
    playMusic(musicId){
      var that = this
      // console.log(musicId)
      axios.get("https://autumnfish.cn/song/url?id="+musicId)
      .then((result) => {
         console.log(result)
         console.log(result.data.data[0].url)
         that.musicUrl = result.data.data[0].url
      }).catch((err) => {
         console.log(err)
      });

      //获取歌曲详情信息
      axios.get("https://autumnfish.cn/song/detail?ids="+musicId)
      .then(function (response){
          console.log(response)
          console.log(response.data.songs[0].al.picUrl)
          that.musicCover = response.data.songs[0].al.picUrl
      },function (err){
          console.log(err)
      });

      //获取歌曲评论列表
      axios.get("https://autumnfish.cn/comment/hot?type=0&id="+musicId)
      .then(function (response){
         console.log(response)
         console.log(response.data.hotComments)
         that.hotComments = response.data.hotComments
      },function(err){
         console.log(err)
      })
    },
    play(){
      //  console.log("play")
      this.isPlaying = true
    },
    pause(){
      //  console.log("pause")
      this.isPlaying = false
    },
    playMv(mvid){
      var that = this
      axios.get("https://autumnfish.cn/mv/url?id="+mvid)
      .then(function(response){
          // console.log(response)
          console.log(response.data.data.url)
          that.isShow = true
          that.mvUrl = response.data.data.url
      },function (err){
          console,log(err)
      });
    },
    hide:function(){
      this.isShow = false
    }
  },
});