let axios = require('axios');

(async function(){
  let httpUrl = 'https://c.m.163.com/ug/api/wuhan/app/data/list-total?t='+new Date().getTime()
  let result = await axios.get(httpUrl)
  console.log(result.data)
})()