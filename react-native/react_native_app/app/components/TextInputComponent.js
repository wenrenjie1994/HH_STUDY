import React from 'react';
import {View, StyleSheet, TextInput} from 'react-native';

let myStyle = StyleSheet.create({
    myClass1: {
        fontSize: 30,
        color: 'pink'
    },
    myClass2: {
        color: 'red'
    }
});

class TextInputComponent extends React.Component{
    constructor(props){
        super(props);

        this.state = {
            myValue: '123'
        }
    }

    onClick = (myInput) => {
        console.log(myInput);
    }

    click = (myInput) => {
        this.setState({
            myValue: myInput
        });
    }

    render() {
        return (
            <View>
                <TextInput onChange={this.onClick} placeholder="请输入"></TextInput>
                <TextInput onChange={this.click} value={this.state.myValue} />
            </View>
        );
    }
}

export default TextInputComponent;