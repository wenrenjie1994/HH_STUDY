import React from 'react'
import { Link } from 'react-router-dom'

class ItemList extends React.Component {
    state = {
        items: []
    }

    async componentDidMount () {
        this.setState({
            items: [
                {
                    id: 1,
                    name: '张三'
                },
                {
                    id: 2,
                    name: '李四'
                },
                {
                    id: 3,
                    name: '隔壁小王'
                },
                {
                    id: 4,
                    name: '田七'
                }
            ]
        });
    }

    render () {
        return (
            <div>
                <p>I'm ItemList Page!</p>
                <ul>
                    { this.state.items.map(item => 
                        <li key={ item.id }>
                             <Link to={ `/item/${item.id}` } style={{ color:"pink", textDecoration:'none'}} >{ item.name }</Link>
                         </li>
                   )}
                </ul>
            </div>
        );
    }
}

export default ItemList