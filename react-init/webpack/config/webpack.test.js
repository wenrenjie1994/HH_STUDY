// 导入 在内存中自动生成 index 页面的插件
const path = require('path')
const { stylelint } = require('./webpack.base') 

module.exports = {
    mode: 'development',
    plugins: [
        ...stylelint
    ]
}