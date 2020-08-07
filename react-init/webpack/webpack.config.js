// 导入 在内存中自动生成 index 页面的插件
const path = require('path')
const HtmlWebPackPlugin = require('html-webpack-plugin')

// 创建一个插件的实例对象
const htmlPlugin = new HtmlWebPackPlugin({
    template: path.join(__dirname, './src/index.html'), //源文件
    filename: 'index.html' //生成的内存中首页的名称
})

// 向外暴露一个打包的配置对象  webpack基于Node构建 -> 支持所有Node API和语法
// webpack 默认只能打包处理 .js 后缀名的文件，像.png .vue webpack无法主动处理，所以要配置第三方的loader规则
module.exports = {
    mode: 'development',
    // 在webpack 4.x中，约定大于配置
    plugins: [
        htmlPlugin
    ],
    module: { // 所有第三方模块的配置规则
        rules: [ // 第三方匹配规则
            { test: /\.js|jsx$/, use: ['babel-loader'], exclude: /node_modules/ },
            // 可以在 css.loader 之后，通过 ? 追加参数，其中有个固定的参数 modules 表示为普通的css样式表启用模块化
            { test: /\.css$/, use: ['style-loader', 'css-loader'] },
            // {
            //     test: /\.css$/, use: [
            //         'style-loader',
            //         {
            //             loader: 'css-loader',
            //             options: {
            //                 modules: {
            //                     localIdentName: '[path][name]-[local]-[hash:5]'
            //                 },
            //             }
            //         }
            //     ]
            // },
            { test: /\.ttf|woff|woff2|eot|svg$/, use: 'url-loader'}, // 打包处理 字体文件的 loader
            { test: /\.scss$/, use: ['style-loader', 'css-loader', 'sass-loader'] } // 打包处理 .scss文件的loader
        ]
    },
    resolve: {
        extensions: ['.js','.jsx','.json' ], //表示 这几个文件的后缀名可以省略不写
        alias: {
            '@': path.join(__dirname, './src') //这样，@符号就表示项目根目录中 src的这一层路径
        }
    }
}