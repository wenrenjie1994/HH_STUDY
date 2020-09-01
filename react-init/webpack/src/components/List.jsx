import React from 'react'
import CommentItem from '@/components/Item'
// 如果在引用某个包的时候， 这个包被安装到了 node_modules目录中 则可以直接已报名开始引入自己的 模块或样式表
// 规定：第三方样式表，都以.css结尾 而自己的样式表，都要以.scss 或 .less结尾，只为.scss和.less文件启动模块化
import 'bootstrap/dist/css/bootstrap.css'

// 思考： Vue 组件中的样式表， 有没有冲突的问题
// 答： Vue 组件中的样式表，也有冲突的问题 但是可以使用<style scoped></style>
import cssobj from '@/css/list.scss'
console.log(cssobj)

// 使用 class 关键字 定义父组件
export default class List extends React.Component {
    constructor(){
        super()
        this.state = {
            list: [
                {"id":1, user: '张三', content: '哈哈，沙发'},
                {"id":2, user: '李四', content: '哈哈，板凳'},
                {"id":3, user: '王五', content: '哈哈，凉鞋'},
                {"id":4, user: '赵六', content: '哈哈，砖头'},
                {"id":5, user: '田七', content: '哈哈，楼下山炮'}
            ]
        }
    }
    render () {
        return <div>
            {/*注意： 在 JSX中，如果想写 行内样式， 不能为 style 设置字符串的值 */}
            {/*在行内样式中， 如果是数值类型的样式，则可以不用引号包裹，如果是字符串类型的样式值，必须使用引号包裹 */}
            {/* <h1 className={ cssobj.title + " test" }>这是评论列表组件</h1> */}
            {/* <button className={ [bootcss.btn, bootcss['btn-primary']].join(' ') }>点我</button> */}
            <h1 className={ [cssobj.title, 'test'].join(' ') }>这是评论列表组件</h1>
            {/* <button className={[bootcss.btn, bootcss['btn-primary']].join(' ')}>点我</button> */}
            <button className="btn btn-primary">点我</button>
            <div className="panel panel-primary">我在这儿呢</div>
            { this.state.list.map(item => <CommentItem { ...item } key={ item.id }/>)}
        </div>
    }
}