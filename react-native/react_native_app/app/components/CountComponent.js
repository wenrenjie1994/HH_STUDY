import React from 'react';
import {Text, View, StyleSheet, Button} from 'react-native';

let myStyle = StyleSheet.create({
    myClass1: {
        fontSize: 30,
        color: 'pink'
    }
});

class CountComponent extends React.Component{
    constructor(props){
        super(props);

        this.state = {
            count: 0
        }
    }

    handleClick = () => {
        this.setState({
            count: this.state.count + 1
        });
    }

    render(){
        return (
            <View>
                <Text style={myStyle.myClass1}>点我自加 Count: {this.state.count}</Text>
                <Button title="自增" onPress={this.handleClick}></Button>
            </View>
        );
    }
}

export default CountComponent;