import React from 'react'
// 3、抽离为独立的样式表模块
import styles from '@/components/styles'

// 首层封装
// const itemStyle = { border: '1px dashed #ccc', margin: '10px', padding: '10px', boxShadow: '0 0 10px #ccc'}

// const userStyle = { fontsize: '14px'}

// const contentStyle = { fontSize: '12px'}

// 第二层封装
// const styles = {
//     itemStyle: { border: '1px dashed #ccc', margin: '10px', padding: '10px', boxShadow: '0 0 10px #ccc'},
//     userStyle: { fontsize: '14px'},
//     contentStyle: { fontSize: '12px'}
// }

// 使用 function 函数定义普通的无状态组件
export default function CommentItem(props) {
    return <div style={ styles.itemStyle }>
            <h1 style={ styles.userStyle }>评论人：{ props.user }</h1>
            <h3 style={ styles.contentStyle }>评论内容：{ props.content }</h3>
        </div>
}