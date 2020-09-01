// 导入 在内存中自动生成 index 页面的插件
const path = require('path');
const StyleLintPlugin = require('stylelint-webpack-plugin')
const HtmlWebPackPlugin = require('html-webpack-plugin')

const STYLELINT_SWITCH = false
const ESLINT_SWITCH = false

// 向外暴露一个打包的配置对象  webpack基于Node构建 -> 支持所有Node API和语法
// webpack 默认只能打包处理 .js 后缀名的文件，像.png .vue webpack无法主动处理，所以要配置第三方的loader规则
module.exports = {
    ESLINT_SWITCH,
    stylelint: STYLELINT_SWITCH ? new StyleLintPlugin({
        files: ['**/*.css', '**/*.less', '**/*.html', '**/*.scss']
    }) : [],
    htmlPlugin: new HtmlWebPackPlugin({
        template: path.join(__dirname, '../index.html'), //源文件
        filename: 'index.html' //生成的内存中首页的名称
    })
}