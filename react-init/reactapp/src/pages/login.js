import React, { useState } from 'react'
import { useHistory } from 'react-router-dom'
import { Form, Input, Button } from 'antd'
import axios from 'axios'
import '../pages/app'

const FormItem = Form.Item 

export default function Login() {
    const [username, setname ] = useState('')
    const [password, setpassword] = useState('')
    const history = useHistory()
    return <Form className='login-form'>
        <FormItem>
            <Input placeholder='请输入用户名' maxLength={ 5 } onChange={ (e) => {
                setname(e.target.value)
            }} />

            <br/>
            <Input placeholder='请输入密码'  type='password' maxLength= { 6 } onChange={ (e) => {
                    setpassword(e.target.value)
            }}/>

            <br/>
            <label>{username} -- { password }</label>

            <br/>
            <Button type='primary' htmlType="submit" className="login-form-button" onClick={() => {
                    login(username, password).then((result) => {
                        let res = result.data
                        if (res.code === 0) {
                            history.push('/home')
                        }
                    }).catch((err) => {
                        
                    });
            }}>
                登录
            </Button>
        </FormItem>
    </Form>
}

function login(username, password) {
    return axios.get('/login.json',{
        params: {
            username,password
        }
    });
}