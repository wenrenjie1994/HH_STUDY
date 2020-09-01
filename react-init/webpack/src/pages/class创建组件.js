import React from 'react'
import ReactDOM from 'react-dom'
import Movie from '@/second-component'
// import '@/class实例方法和静态方法'

const movieList = {
    movieName: '活着',
    date: '2020-8-6 震撼上映'
}

ReactDOM.render(<Movie 
    { ...movieList }/>, document.getElementById('app'))