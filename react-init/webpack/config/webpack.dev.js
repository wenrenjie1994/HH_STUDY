// 导入 在内存中自动生成 index 页面的插件
const path = require('path')
const { stylelint, htmlPlugin } = require('./webpack.base') 

module.exports = {
    mode: 'development',
    output: {
        filename: 'bundle.js'
    },
    plugins: [
        ...stylelint,
        htmlPlugin
    ],
    devtool: 'source-map',
    devServer: {
        contentBase: path.resolve(__dirname, '../'),
        compress: true,
        port: 5000,
        open: true,
        historyApiFallback: true,
        proxy: {
            '/s': 'http://localhost:5555'
        }
    }
}