import React from 'react'

class Item extends React.Component {
    state = {
        itemInfo: {}
    }

    async componentDidMount() {
        this.setState({
            itemInfo: {
                    id: this.props.match.params.id,
                    name: 'Java is the King',
                    description: 'Java万古长青',
                    comments: 'Java is nice'
                }
        })
    }

    async componentDidUpdate(nextProps, nextState) {
        this.setState({
            itemInfo: {
                    id: this.props.match.params.id,
                    name: 'Java',
                    description: 'Language King',
                    comments: 'Java well down'
                }
        })
    }

    shouldComponentUpdate (nextProps, nextState) {
        if (this.props.match.params.id !== nextProps.match.params.id) {
            return true
        }
        if (this.state.itemInfo.id !== nextState.itemInfo.id) {
            return true
        }
        return false
    }

    render () {
        let itemInfo = this.state.itemInfo
        return (
            <div>
                <p>I'm Item</p>
                <p>id: { itemInfo.id }</p>
                <p>name: { itemInfo.name }</p>
                <p>description: { itemInfo.description }</p>
                <p>comments: { itemInfo.comments }</p>
            </div>
        );
    }
}

export default Item