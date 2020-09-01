// 导入 在内存中自动生成 index 页面的插件
const path = require('path')
const { stylelint, htmlPlugin } = require('./webpack.base') 

// 向外暴露一个打包的配置对象  webpack基于Node构建 -> 支持所有Node API和语法
// webpack 默认只能打包处理 .js 后缀名的文件，像.png .vue webpack无法主动处理，所以要配置第三方的loader规则
module.exports = {
    mode: 'production',
    // entry: '../src/index',
    output: {
        path: path.resolve(__dirname, 'build'),
        filename: 'bundle.min.js'
    },
    // devtool: 'source-map', // 帮助定位错误(用时打开，不用关闭)
    // 在webpack 4.x中，约定大于配置
    plugins: [
        ...stylelint,
        htmlPlugin
    ]
}