import React from 'react'
import { connect } from 'react-redux'
import { getUsers } from '../../actions'
import fetchJson from '../../fetch'

class UsersList extends React.Component {
    state = {

    }

    async componentDidMount () {
        let data = await fetchJson('/s/ulist');
        // 通过dispatch抛出
        this.props.getUsers(data);
    }

    render () {
        return (
            <div>
                <table border='1' cellSpacing='0'>
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>姓名</th>
                            <th>年龄</th>
                        </tr>
                    </thead>
                    <tbody>
                        { this.props.users.map(({id, name, age}, index) => (
                            <tr key={ index }>
                                <td>{ id }</td>
                                <td>{ name }</td>
                                <td>{ age }</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        );
    }
}

export default connect((state, props) => Object.assign({}, props, state)
  , { getUsers })(UsersList)

