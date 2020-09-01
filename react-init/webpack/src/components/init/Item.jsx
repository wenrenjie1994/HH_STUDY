import React from 'react'
import cssobj from '@/css/item.scss'
console.log(cssobj)

// 使用 function 函数定义普通的无状态组件
export default function Item(props) {
    return <div className={ cssobj.cmtbox }>
            {/* <h1 className={ cssobj.title + ' test'}>评论人：{ props.user }</h1> */}
            <h1 className={ [cssobj.title, 'test'].join(' ')}>评论人：{ props.user }</h1>
            <h3 className={ cssobj.content }>评论内容：{ props.content }</h3>
        </div>
}