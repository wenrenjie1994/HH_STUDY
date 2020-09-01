import React from 'react'
import CommentItem from '@/components/CommentItem'


const listStyle = { color:'pink', fontSize: '30px', zindex:3, fontWeight: 200, textAlign: 'center' }

// 使用 class 关键字 定义父组件
export default class CommentList extends React.Component {
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
            <h1 style={ listStyle }>这是评论列表组件</h1>
            { this.state.list.map(item => <CommentItem { ...item } key={ item.id }/>)}
        </div>
    }
}