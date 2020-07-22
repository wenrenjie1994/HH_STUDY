const http = require('http')

http.createServer((Request,Response)=>{
    console.log(Request)
    // Response.writeHead(200,{'content-type':'text/plain','Access-Control-Allow-Origin':'*'})
    Response.end('HelloWorld!')
}).listen(8000)