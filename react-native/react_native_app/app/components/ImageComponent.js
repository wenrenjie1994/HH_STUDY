import React from 'react';
import {View, StyleSheet, Image} from 'react-native';

let myStyle = StyleSheet.create({
    myClass1: {
        width: 100,
        height: 100
    },

    myClass2: {
        width: 300,
        height: 100
    }

});

class ImageComponent extends React.Component{
    constructor(props){
        super(props);
    }

    render(){
        return (
            <View>
                <Image style={myStyle.myClass1} source={require('../../img/beautiful.png')} />
                <Image style={myStyle.myClass2} source={{uri: 'http://www.bb-kj.com/common/img/logo.png'}} />
            </View>
        );
    }
}

export default ImageComponent;