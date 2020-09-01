import React from 'react';
import {View, StyleSheet, TouchableOpacity, Text} from 'react-native';

let myStyle = StyleSheet.create({
    myClass1: {
        fontSize: 30,
        color: 'pink'
    },
    myClass2: {
        color: 'skyblue'
    }
});

class TouchableOpacityComponent extends React.Component{
    constructor(props){
        super(props);
    }

    render() {
        return (
            <TouchableOpacity>
                <Text style={myStyle.myClass1}>点我变化给你看</Text>
            </TouchableOpacity>
        );
    }
}

export default TouchableOpacityComponent;