import React from 'react'
import { connect } from 'react-redux'
import { addAge } from '../../actions'

class Child1 extends React.Component {
    handleClick() {
        this.props.addAge(1)
    }
    render () {
        return (
            <div>
                <h1>Child1</h1>
                <input type="button" value="增龄" onClick={ this.handleClick.bind(this)} />
            </div>
        );
    }
}

export default connect((state, props) => (Object.assign({}, props, state)),  { addAge })(Child1);