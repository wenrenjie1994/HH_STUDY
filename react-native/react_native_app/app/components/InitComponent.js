import React from 'react';
import {Text, View, StyleSheet} from 'react-native';

let myStyle = StyleSheet.create({
    myClass1: {
        fontSize: 30,
        color: 'pink'
    },

    myClass2: {
        color: 'red'
    }

});

class InitComponent extends React.Component{
    constructor(props){
        super(props);
    }

    render(){
        return (
            <View>
                <Text style={myStyle.myClass1}>Hello, 我是可可爱爱的Komi</Text>
                <Text style={myStyle.myClass2}>I'm Here!</Text>
            </View>
        );
    }
}

export default InitComponent;