export default async function (url, options) {
    try {
        let res = await fetch(url, options)

        let { ok, e, data } = await res.json();

        if ( ok ) {
            return data;
        } else {
            console.error('出错啦', e)
            throw new Error(e)
        }

    }catch(e) {
        console.log(e)
        throw e
    }
}