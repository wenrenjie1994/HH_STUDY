function GetRequest() {

        var url = location.search; //获取url中"?"符后的字串

    console.log("url++"+url);
        var theRequest = new Object();
        if (url.indexOf("?") != -1) {
                var str = url.substr(1);
                strs = str.split("&");
                for(var i = 0; i < strs.length; i ++) {
                        //theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
                    //theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
                    theRequest[strs[i].split("=")[0]]=decodeURI(strs[i].split("=")[1]);//这个可以解决中文乱码的问题；
                }
        }
        return theRequest;
}
