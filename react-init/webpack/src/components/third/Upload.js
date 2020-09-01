import React from 'react'
import fetchJson from '../../fetch'

class Upload extends React.Component{
    state = {}

    async submit() {
        let form = new FormData(this.refs.upForm)

        // let form = new FormData();
        // 将其转换为数组
        // Array.from(this.refs.uploading.files).forEach( file => {
        //     form.append('uploading', file);
        // });

        await fetchJson ('/s/upload', {
            method: 'POST',
            body: form
        });
        console.log('成功')
    }

    render() {
        return (
            <div>
                <form ref='upForm'>
                    <input type='file' ref='uploading' />
                    <input type='button' value='上传' onClick={ this.submit.bind(this) } />
                </form>
            </div>
        );
    }
}

export default Upload