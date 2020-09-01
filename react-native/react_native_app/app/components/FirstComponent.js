import React from 'react';
import {Text, View, StyleSheet} from 'react-native';

let myStyle = StyleSheet.create({
    myClass1: {
        fontSize: 30,
        color: 'pink'
    }
});

class FirstComponent extends React.Component{
    constructor(props){
        super(props);

        this.state = {
            myValue: '隔壁小王',
            count: 0
        }
    }

    componentDidMount(){
        setInterval((() => {
            this.setState({
                count: this.state.count + 1
            });
        }).bind(this), 1000);
    }

    render(){
        return (
            <View>
                <Text style={myStyle.myClass1}>Hello, 我是{this.state.myValue}</Text>
                <Text style={myStyle.myClass1}>{this.state.count == 0 ? '现在是0' : this.state.count}</Text>
            </View>
        );
    }
}

export default FirstComponent;