import React from 'react'
import { Route, Link } from 'react-router-dom';
import FirstContainer from './FirstContainer';
import SecondContainer from './SecondContainer';
import ThirdContainer from './ThirdContainer';

class RouteContainer extends React.Component {
    render () {
        // console.log(this.props.match)
        let { path } = this.props.match
        return (
            <div>
                <Link to={ path + `/${ FirstContainer }`} style={{ textDecoration:"none"}}>First Container</Link><br/>
                <Link to={ path + `/${ SecondContainer }`} style={{ textDecoration:"none"}}>Second Container</Link><br/>
                <Link to={ path + `/${ ThirdContainer }`} style={{ textDecoration:"none"}}>Third Container</Link>

                <Route path={ path + `/${ FirstContainer }`} component={ FirstContainer }></Route>
                <Route path={ path + `/${ SecondContainer }`} component={ SecondContainer }></Route>
                <Route path={ path + `/${ ThirdContainer }`} component={ ThirdContainer }></Route>
            </div>
        );
    }
}

export default RouteContainer