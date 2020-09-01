const Router = require('koa-router');

let router = new Router();

//内存数据，关闭服务器数据会丢失
let users = [
    {
        id: 's01',
        name: '隔壁小王',
        age: 18
    },
    {
        id: 's02',
        name: '小莉',
        age: 20
    }
]

router.get('/ulist', async ctx => {
    ctx.body = { ok: true, data: users };
});

router.post('/adduser', async ctx => {
    let {id, name, age} = ctx.request.fields;

    if (!id) {
        ctx.body = { ok: false, err: 'invalid id'};
    } else if(users.some((item, index, array) => item.id == id)) {
        ctx.body = { ok: false, err: `user exists: ${ id }`};
    } else {
        users.push({ id, name, age: parseInt(age) });
        ctx.body = { ok: true };
    }
});

router.post('/upload', async ctx => {
    console.log(ctx.request.files);
    ctx.body = { ok: true };
});

module.exports=router.routes();