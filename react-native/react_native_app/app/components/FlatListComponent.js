import React from 'react';
import {View, StyleSheet, FlatList, Text} from 'react-native';

let myStyle = StyleSheet.create({
    myClass1: {
        fontSize: 30,
        color: 'pink'
    },
    myClass2: {
        color: 'red'
    }
});

class FlatListComponent extends React.Component{
    constructor(props){
        super(props);

        this.state = {
            myList: [100, 200, 300]
        }
    }

    // data: 数组
    // renderItem: 适用于渲染的函数

    showItem = (info) => {
        return <Text style={myStyle.myClass1}>{info.item}</Text>;
    }

    render(){
        return (
            <View style={{height: 150}}>
               <FlatList data={this.state.myList} renderItem={this.showItem}></FlatList>
            </View>
        );
    }
}

export default FlatListComponent;