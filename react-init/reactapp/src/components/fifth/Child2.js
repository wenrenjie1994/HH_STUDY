import React from 'react'
import { connect } from 'react-redux'
import { changeName } from '../../actions'

class Child2 extends React.Component {
    handleClick() {
        this.props.changeName(this.refs.name.value)
        this.refs.name.value = ''
    }
    render () {
        return (
            <div>
                <h1>Child2</h1>
                <input type="text" ref="name" style={{ backgroundColor: "skyblue" }} />
                <input type="button" value="修改姓名" onClick={ this.handleClick.bind(this) } />
            </div>
        );
    }
}

export default connect((state, props) => Object.assign({}, props, state),  { changeName })(Child2);