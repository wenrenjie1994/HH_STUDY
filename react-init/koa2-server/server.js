const koa = require('koa');
const Router = require('koa-router');
const body = require('koa-better-body');
const convert = require('koa-convert');

let server = new koa();
server.listen(5555);
console.log('server running at port 5555')

server.use(convert(body({
    uploadDir: './up'
})));

server.use(async (ctx, next) => {
    try{
        await next();
    }catch(err) {
        ctx.body = {ok: false, err: 'internal server error'};
    }
});

let router = new Router();
router.use('/s', require('./router'));

server.use(router.routes());
