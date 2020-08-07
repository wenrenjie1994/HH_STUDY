import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
// import { HashRouter as Router, Route, Switch } from 'react-router-dom'
import React from 'react'
import Detail from '../pages/detail'
import App from '../pages/app'
import Login from '../pages/login'
import Home from '../pages/home'
import NotMatch from '../pages/404'

export default function MyRouter() {
    return <Router>
        <Switch >
            <Route exact path='/' component={ App }></Route>
            <Route path='/login' component={ Login }></Route>
            <Route path='/home' component={ Home }>
                {/* <Redirect to='/login'></Redirect> */}
            </Route>
            <Route path='/detail/:id' component={ Detail }></Route>
            <Route path='*' component={ NotMatch }></Route>
        </Switch>
    </Router>
}