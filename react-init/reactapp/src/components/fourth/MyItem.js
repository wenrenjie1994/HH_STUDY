import React from 'react'
import { Route, Link } from 'react-router-dom'

class MyItem extends React.Component {

    state = {
        items: []
    }

    async componentDidMount () {
        let items = [
            {
                id: '1',
                name: 'page one',
                description: '龙先生真可以'
            },
            {
                id: '2',
                name: 'page two',
                description: '龙先生真努力'
            },
            {
                id: '3',
                name: 'page three',
                description: '龙先生加油',
                children: [
                    {
                        id: '3_1',
                        name: 'page 3_1',
                        description: '龙先生真可以'
                    },
                    {
                        id: '3_2',
                        name: 'page 3_2',
                        description: '龙Sir真棒'
                    },
                    {
                        id: '3_3',
                        name: 'page 3_3',
                        description: '龙先生棒棒的'
                    }
                ]
            }
        ]
        this.setState({
            items: this.props.items || items
        })
    }

    render () {
        /**
         * 有children的 需要一个Link和一个Route，没有孩子的，只有一个span
         * 每一级别只显示自己的直接孩子
         * 列表是紧致的，就是列表之间不插入Route，Route在最后
         */
        let { path }  = this.props.match
        // 在Route中，需要将item.children传递给下一层组件，并确保下层组件使用此children
        let items = this.state.items
        return (
            <div>
                <h1>Welcome to my Item!</h1>
                <ul>
                     {items.map( item => {
                      return item.children ? ( <li key={ `link${item.id}` }>
                            <Link to={ path + `/${item.id}` } style={{ textDecoration:"none"}}>{ item.name }</Link>
                        </li>) : (<li key={ `span${item.id}` }><span>{ item.name }: { item.description }</span></li>)
                     })}
                </ul>
                { items.filter( item => item.children).map(item => {
                    //  return <Route key={ `route${item.id}` } path={ path+`/${item.id}` } component={ MyItem }></Route>
                    return <Route key={ `route${item.id}` } path={ path+`/${item.id}` } render= { props => <MyItem { ...props } items={ item.children } />}></Route>
                })}
            </div>
        );
    }
}

export default MyItem