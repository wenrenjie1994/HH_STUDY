import React from 'react'
import axios from 'axios'
import { connect } from 'react-redux'
import { addUser } from '../../actions'

class AxiosAddUsers extends React.Component {
    state = {}

    async submit() {
        // 创建form
        let form = new FormData(this.refs.theForm)
        
        // let form = new FormData();
        // form.append('id', this.refs.id.value);
        // form.append('name', this.refs.name.value);
        // form.append('age', this.refs.age.value);

        // await fetchJson('/s/adduser', {
        //     method: 'POST',
        //     body: form
        // });

        await axios({
            url: '/s/adduser',
            method: 'POST',
            data: form
        });

        this.props.addUser({
            id: this.refs.id.value,
            name: this.refs.name.value,
            age: this.refs.age.value
        });

        this.refs.id.vaue = '';
        this.refs.name.vaue = '';
        this.refs.age.vaue = '';
    }

    //  如果使用html的form，那么需要设定name属性
    render () {
        return (
            <div>
                <form ref='theForm'>
                    <p style={{ textAlign: 'left' }}>
                        id: <input type="text" ref='id' name='id' style={{ backgroundColor:'pink' }}/><br/>
                    </p>
                    <p style={{ textAlign: 'left' }}>
                        姓名：<input type='text' ref="name" name='name' style={{ backgroundColor:'pink' }}/><br/>
                    </p>
                    <p style={{ textAlign: 'left' }}>
                        年龄： <input type="text" ref="age" name='age' style={{ backgroundColor:'pink' }}/><br/>
                    </p>
                    <p style={{ textAlign: 'left' }}>
                        <input type='button' value='添加用户' onClick={ this.submit.bind(this) } style={{ backgroundColor:'pink' }}/>
                    </p>
                </form>
            </div>
        );
    }
}

export default connect((state, props) => Object.assign({}, props, state), { addUser })(AxiosAddUsers)